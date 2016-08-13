package function.tool;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mapper.HistoryDataMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.DatePack;
import po.StockInf;
import tool.LinearRegressionTool;
import tool.MMSTool;
import vo.StockPair;

public class PairStrategy {
	public static List<StockPair> recommend(List<StockInf> sidlist,int num,Date enddate,double alpha) throws Exception
	{
		List<StockPair> recList=new ArrayList<StockPair>();
//		List<StockInf> sidlist=new DataServiceImpl().getStockList();
		for(int i=0;i<sidlist.size();i++)
		{
			for(int j=i+1;j<sidlist.size();j++)
			{
				double correlation=getPair(sidlist.get(i).getSid(),sidlist.get(j).getSid(),num,enddate,alpha);
				if(correlation>0)
				{
					StockPair stockPair=new StockPair(sidlist.get(i),sidlist.get(j),correlation);
//					System.out.println(stockPair);
					recList.add(stockPair);
				}	
			}
		}
		return recList;
	}
	public static List<StockPair> getPair(StockInf sid,List<StockInf> sidlist) throws Exception
	{
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		HistoryDataMapper historyDataMapper=(HistoryDataMapper)applicationContext.getBean("historyDataMapper");
		List<StockPair> recList=new ArrayList<StockPair>();
		DatePack datePack=new DatePack();
		datePack.setDate1(new Date(Calendar.getInstance().getInstance().getTimeInMillis()));
		datePack.setNum(100);
		datePack.setSiid(sid.getSid());
		List<Double> hiscloselist1=historyDataMapper.selectHistoryDataClose_num_date(datePack);
		for(int j=0;j<sidlist.size();j=j+20)
		{
			double correlation=getPair(hiscloselist1,sidlist.get(j).getSid(),100,new Date(Calendar.getInstance().getTimeInMillis()),0.05);
			if(correlation>0)
			{
				StockPair stockPair=new StockPair(sid,sidlist.get(j),correlation);
//					System.out.println(stockPair);
				recList.add(stockPair);
			}
		}
		return recList;
	}
	public static double getPair(String sid1,String sid2,int num,Date enddate,double alpha) throws Exception
	{
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		HistoryDataMapper historyDataMapper=(HistoryDataMapper)applicationContext.getBean("historyDataMapper");
		DatePack datePack=new DatePack();
		datePack.setDate1(enddate);
		datePack.setNum(num);
		datePack.setSiid(sid1);
		List<Double> hiscloselist1=historyDataMapper.selectHistoryDataClose_num_date(datePack);
		datePack.setSiid(sid2);
		List<Double> hiscloselist2=historyDataMapper.selectHistoryDataClose_num_date(datePack);
		
		//相关系数
		double cov=MMSTool.cov(hiscloselist1, hiscloselist2);
		double v1=MMSTool.variance(hiscloselist1);
		double v2=MMSTool.variance(hiscloselist2);
		double correlation=cov/Math.sqrt(v1)/Math.sqrt(v2);
		
		//协整检验
		double coefficient[]={0,0};
		double dT[]={0,0,0,0,0,0};
		LinearRegressionTool.SPT1(hiscloselist1,hiscloselist2,Math.min(hiscloselist1.size(),hiscloselist2.size()),coefficient,dT);
//				y=a[1]*x+a[0];
		List<Double> residual=new ArrayList<Double>();
		List<Double> diff=new ArrayList<Double>();
		//残差序列
		residual.add(hiscloselist2.get(0)-(coefficient[1]*hiscloselist1.get(0)+coefficient[0]));
		for(int i=1;i<hiscloselist1.size();i++)
		{
			residual.add(hiscloselist2.get(i)-(coefficient[1]*hiscloselist1.get(i)+coefficient[0]));
			diff.add(residual.get(i)-residual.get(i-1));
		}
		LinearRegressionTool.SPT1(residual.subList(0, residual.size()-1), diff,diff.size(),coefficient,dT);
		if(coefficient[1]<0)
		{
			//t检验
			double t=(MMSTool.mean(diff)-0)/MMSTool.variance(diff)*Math.sqrt(diff.size());
			if(compare(t,alpha,diff.size()))
			{
				return correlation;
			}
		}
		return -1;
	}
	public static double getPair(List<Double> hiscloselist1,String sid2,int num,Date enddate,double alpha) throws Exception
	{
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		HistoryDataMapper historyDataMapper=(HistoryDataMapper)applicationContext.getBean("historyDataMapper");
		DatePack datePack=new DatePack();
		datePack.setDate1(enddate);
		datePack.setNum(num);
		datePack.setSiid(sid2);
		List<Double> hiscloselist2=historyDataMapper.selectHistoryDataClose_num_date(datePack);
		
		//相关系数
		double cov=MMSTool.cov(hiscloselist1, hiscloselist2);
		double v1=MMSTool.variance(hiscloselist1);
		double v2=MMSTool.variance(hiscloselist1);
		double correlation=cov/Math.sqrt(v1)/Math.sqrt(v2);
		
		//协整检验
		double coefficient[]={0,0};
		double dT[]={0,0,0,0,0,0};
		LinearRegressionTool.SPT1(hiscloselist1,hiscloselist2,Math.min(hiscloselist1.size(),hiscloselist2.size()),coefficient,dT);
//				y=a[1]*x+a[0];
		List<Double> residual=new ArrayList<Double>();
		List<Double> diff=new ArrayList<Double>();
		//残差序列
		residual.add(hiscloselist2.get(0)-(coefficient[1]*hiscloselist1.get(0)+coefficient[0]));
		for(int i=1;i<Math.min(hiscloselist1.size(),hiscloselist2.size());i++)
		{
			residual.add(hiscloselist2.get(i)-(coefficient[1]*hiscloselist1.get(i)+coefficient[0]));
			diff.add(residual.get(i)-residual.get(i-1));
		}
		LinearRegressionTool.SPT1(residual.subList(0, residual.size()-1), diff,diff.size(),coefficient,dT);
		if(coefficient[1]<0) ;//true
		//t检验
		double t=(MMSTool.mean(diff)-0)/MMSTool.variance(diff)*Math.sqrt(diff.size());
		if(compare(t,alpha,diff.size()))
		{
			return correlation;
		}
		return -1;
	}
	
	public static boolean compare(double t,double alpha,int size)
	{
		if(alpha==0.01)
		{
			if(size<=25)
			{
				if(t<-3.57)
					return true;
			}
			else if(size>25&&size<=50)
			{
				if(t<-3.58)
					return true;
			}
			else if(size>50&&size<=100)
			{
				if(t<-3.51)
					return true;
			}
			else if(size>100&&size<=500)
			{
				if(t<-3.44)
					return true;
			}
			else
			{
				if(t<-3.43)
					return true;
			}
		}
		else if(alpha==0.05)
		{
			if(size<=25)
			{
				if(t<-3.00)
					return true;
			}
			else if(size>25&&size<=50)
			{
				if(t<-2.93)
					return true;
			}
			else if(size>50&&size<=100)
			{
				if(t<-2.89)
					return true;
			}
			else if(size>100&&size<=500)
			{
				if(t<-2.87)
					return true;
			}
			else
			{
				if(t<-2.86)
					return true;
			}
		}
		else if(alpha==0.1)
		{
			if(size<=25)
			{
				if(t<-2.63)
					return true;
			}
			else if(size>25&&size<=50)
			{
				if(t<-2.60)
					return true;
			}
			else if(size>50&&size<=100)
			{
				if(t<-2.58)
					return true;
			}
			else if(size>100&&size<=500)
			{
				if(t<-2.57)
					return true;
			}
			else
			{
				if(t<-2.57)
					return true;
			}
		}
		return false;
	}
}
