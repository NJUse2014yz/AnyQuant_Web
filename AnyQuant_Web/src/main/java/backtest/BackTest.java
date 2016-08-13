package backtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mapper.HistoryDataMapper;
import mapper.QuotaDataMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import function.Function;
import function.FunctionResult;
import function.choose.ChooseStock;
import po.DatePack;
import po.HistoryData;
import po.QuotaData;
//import vo.QuotaAnalysis;
//import vo.TradeSignal;
//import backtest.BackTestInnerService;
//import backtest.tool.AnalyseSignalPack;
//import backtest.tool.DateDouble;
//import backtest.tool.HisQuoPack;
//import backtest.tool.TestReport;
//import bl.BiasAnalyse;
//import bl.QuotaAnalyse;

public class BackTest {
	/**股仓*/
	public List<ChooseStock> stockList;
	/**交易标志*/
	public List<Function> flagList;

	/**初始现金*/
	public double cash;
	/**每只股票的持股数*/
	List<Integer> numlist;
	
	/**税费(默认采用买千分之一，卖千分之二的税费)*/
	public double inTaxRatio;
	public double outTaxRatio;
	
	/**回测开始日期*/
	public Date startdate;
	/**回测结束日期*/
	public Date enddate;
	/**回测周期（单位：日）*/
	public int n;
	/**每日资本*/
	public List<DateDouble> capital;
	
	/**基准*/
	public String benchmark;
	/**每日资本-基准*/
	public List<DateDouble> bCapital;
	/**基准现金*/
	public double bCash;
	/**基准股数*/
	public double bNum;
	
	/**交易订单类型*/
	public Function orderType;
	
	public void setParam(List<ChooseStock> stockList,
			List<Function> flagList,Function orderType,
			double cash,Date startdate,Date enddate,int n,
			String benchmark) throws Exception
	{
		this.stockList=stockList;
		//保证股票池占比总和为1
		int sum=0;
		for(int i=0;i<stockList.size();i++)
		{
			sum+=stockList.get(i).percent;
		}
		if(sum!=1)
			throw new Exception();
		
		this.cash=cash;
		this.inTaxRatio=0.001;
		this.outTaxRatio=0.002;
		this.startdate=startdate;
		this.enddate=enddate;
		this.n=n;
		this.benchmark=benchmark;
		this.orderType=orderType;
		this.flagList=flagList;
		
		numlist=new ArrayList<Integer>();
		capital=new ArrayList<DateDouble>();
//		capital.add(cash);
		
		//---------------基准
		this.benchmark=benchmark;
		bCapital=new ArrayList<DateDouble>();
//		bCapital.add(cash);
		bCash=cash;
		bNum=0;
		//-------------------
	}
/*	public void setParam(List<ChooseStock> stockList,double cash,Date startdate,Date enddate,int n,
			List<AnalyseSignalPack> analyseSignalPacks,String benchmark,AnalyseSignalPack bAnalyseSignalPack) throws Exception
	{
		this.stockList=stockList;

		int sum=0;
		for(int i=0;i<stockList.size();i++)
		{
			sum+=stockList.get(i).percent;
		}
		if(sum!=100)
			throw new Exception();
		
		this.cash=cash;
		this.inTaxRatio=0.001;
		this.outTaxRatio=0.002;
		this.startdate=startdate;
		this.enddate=enddate;
		this.n=n;
		this.analyseSignalPacks=analyseSignalPacks;
		numlist=new ArrayList<Integer>();
		capital=new ArrayList<DateDouble>();
//		capital.add(cash);
		
		//---------------基准
		this.benchmark=benchmark;
		bCapital=new ArrayList<DateDouble>();
//		bCapital.add(cash);
		this.bAnalyseSignalPack=bAnalyseSignalPack;
		bCash=cash;
		bNum=0;
		//-------------------
	}
*/	
//	public TestReport runTest(List<ChooseStock> stockList,List<AnalyseSignalPack> analyseSignalPacks,AnalyseSignalPack bAnalyseSignalPack) throws Exception 
//	{
//		setParam(stockList,100000,new Date(115,0,1),new Date(116,0,1),10,analyseSignalPacks,"sh000300",bAnalyseSignalPack);
//		return test();
//	}

	public TestReport runTest_self(List<ChooseStock> stockList,
			List<Function> flagList,Function orderType,
			double cash,Date startdate,Date enddate,int n,
			String benchmark) throws Exception {
		setParam(stockList,flagList,orderType,cash,startdate,enddate,n,benchmark);
		return test();
	}
//	public TestReport test() throws Exception
//	{
//		return null;
//	}
	
	public TestReport test() throws Exception
	{
		//填充历史数据
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		HistoryDataMapper historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
		QuotaDataMapper quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");

		List<HisQuoPack> HQstatisticlist=new ArrayList<HisQuoPack>();
		
		DatePack datePack=new DatePack();
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		for(int i=0;i<stockList.size();i++)
		{
			datePack.setSiid(stockList.get(i).siid);
			List<HistoryData> hisList=historyDataMapper.selectHistoryData_b_date(datePack);
			List<QuotaData> quoList=quotaDataMapper.selectQuotaData_b_date(datePack);
			HQstatisticlist.add(new HisQuoPack(hisList,quoList));
		}
		capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate(),cash));
		bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate(),bCash));
		//--------------基准
		datePack.setSiid(benchmark);
		HisQuoPack bHQstatisticlist=new HisQuoPack(historyDataMapper.selectHistoryData_b_date(datePack),quotaDataMapper.selectQuotaData_b_date(datePack));
		//----------------
		
		//建仓,假设没有税费,从此次开始买入和卖出均用收盘价
		for(int i=0;i<stockList.size();i++)
		{
			numlist.add((int)(cash*stockList.get(i).percent/100.0/HQstatisticlist.get(i).hislist.get(0).getClose()));
		}
		for(int i=0;i<stockList.size();i++)
		{
			cash-=numlist.get(i)*HQstatisticlist.get(i).hislist.get(0).getClose();
		}
		//---------------基准
		int bNum=(int)(bCash/bHQstatisticlist.hislist.get(0).getClose());
		bCash-=bNum*bHQstatisticlist.hislist.get(0).getClose();
		//-----------------
		
		//开始回测历史
		List<Double> inPrice=new ArrayList<Double>();
		List<Double> outPrice=new ArrayList<Double>();
		
		for(int k=n-1;k<HQstatisticlist.get(0).hislist.size();k=k+n)//n=10默认每五天
		{
			double capitaltoday=0;//今日股票资本
			double inprice=0;//今日买入总价
			double outprice=0;//今日卖出总价
			for(int j=0;j<flagList.size();j++)
			{
				Function function=flagList.get(j);
//				switch(function.getFunction())
//				{
//				case "Share":
//					
//					break;
//				}
				FunctionResult result=function.getResult();
				FunctionResult upFR=function.getResult();
				FunctionResult downFR=function.getResult();
				switch(result.location.get(0))
				{
				case 1://boolean
					break;
				case 2://int
					break;
				case 3://double
					if(result.rD<=upFR.rD&&result.rD>=downFR.rD)
					{
						//触发交易
					}
					break;
				case 4://String
					break;
				case 5://int list
					break;
				case 6://double list
					break;
				case 7://String list
					break;
				}
			}
				AnalyseSignalPack analyseSignalPack=analyseSignalPacks.get(j);
				boolean sellFlag=false;
				boolean buyFlag=false;
				for(int i=0;i<analyseSignalPack.analyses.size();i++)//对于某股票的某个指标
				{
					QuotaAnalyse analyse=analyseSignalPack.analyses.get(i);
					//每次设置新的
					analyse.setAnalysis(new QuotaAnalysis());
					analyse.setEnddate(HQstatisticlist.get(j).hislist.get(k-1).getDate());
					
					TradeSignal tradeSignal=analyseSignalPack.signals.get(i);
					QuotaAnalysis analysis=analyse.pro_quo();
					if(analysis.scoreIn>analysis.scoreOut
							&&analysis.scoreIn>tradeSignal.sell.scoreIn)
						buyFlag=true;
					else
						buyFlag=false;
					
					if(analysis.scoreOut>analysis.scoreIn
							&&analysis.scoreOut>tradeSignal.sell.scoreOut)
						sellFlag=true;
					else
						sellFlag=false;
				}
				double price=HQstatisticlist.get(j).hislist.get(k).getClose();
				
				if(sellFlag==true&&buyFlag==false)//sell
				{
					int num=numlist.get(j);
					cash+=num*price*(1-outTaxRatio);
					numlist.set(j,0);//减仓
					outprice+=num*price;
				}
				else if(sellFlag==false&&buyFlag==true)//buy
				{
					int num=(int)(cash/(price*(1+inTaxRatio)));//可以买入多少只
					cash-=num*price*(1+inTaxRatio);
					numlist.set(j,numlist.get(j)+num);//加仓
					inprice+=num*price;
				}
				else//wait
				{
					;
				}
				capitaltoday+=numlist.get(j)*price;
			capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(k).getDate(),capitaltoday+cash));
			try{

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			inPrice.add(inprice);
			outPrice.add(outprice);
			//-----------------------------------------------------------------基准
			boolean bSellFlag=false;
			boolean bBuyFlag=false;
			
			for(int i=0;i<bAnalyseSignalPack.analyses.size();i++)//对于基准的某个指标
			{
				TradeSignal tradeSignal=bAnalyseSignalPack.signals.get(i);
				QuotaAnalysis analysis=bAnalyseSignalPack.analyses.get(i).pro_quo();
				if(analysis.scoreIn>analysis.scoreOut
						&&analysis.scoreIn>tradeSignal.buy.scoreIn)
					bBuyFlag=true;
				else
					bBuyFlag=false;
				
				if(analysis.scoreOut>analysis.scoreIn
						&&analysis.scoreOut>tradeSignal.sell.scoreOut)
					bSellFlag=true;
				else
					bSellFlag=false;
			}
			double price=bHQstatisticlist.hislist.get(k).getClose();
			if(bSellFlag==true&&bBuyFlag==false)//sell
			{
				bCash+=bNum*price*(1-outTaxRatio);
				bNum=0;//减仓
			}
			else if(bSellFlag==false&&bBuyFlag==true)//buy
			{
				int num=(int)(bCash/price*(1+inTaxRatio));//可以买入多少只
				bCash-=num*price*(1+inTaxRatio);
				bNum+=num;//加仓
			}
			else//wait
			{
				;
			}
			bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(k).getDate(),bNum*price+bCash));
			//-----------------------------------------------------------------
		}
		//生成回测报告
		TestReport testReport=new TestReport(bHQstatisticlist.hislist.size()/n,capital,bCapital,inPrice,outPrice);
		
		testReport.run(capital.get(capital.size()-1).value,capital.get(0).value,bCapital.get(bCapital.size()-1).value,bCapital.get(0).value);
		return testReport;
	}

}
