package backtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import function.OrderFunction;
import function.TestFunction;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.order.ShareFunction;
import po.DatePack;
import po.HistoryData;
import po.QuotaData;
import service.impl.BackTestServiceImpl;
import tool.ListTool;
import tool.MMSTool;
import vo.Flag;

public class BackTest {
	/**股仓*/
	public List<ChooseStock> stockList;
	/**历史和指标数据包（每个股票一个）的列表*/
	public List<HisQuoPack> HQstatisticlist=new ArrayList<HisQuoPack>();
	/**风险控制列表*/
	public List<List<Function>> risk;
	/**订单类型和交易标志的列表*/
	public List<Flag> flags;
	
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
	/**基准的策略*/
	public Flag bFlag;
	/**每日资本-基准*/
	public List<DateDouble> bCapital;
	/**基准现金*/
	public double bCash;
	/**基准股数*/
	public double bNum;
	
	public BackTest(List<ChooseStock> stockList,
			List<Flag> flags,
			double cash,Date startdate,Date enddate,int n,
			String benchmark,Flag bFlag,List<List<Function>> risk) throws Exception
	{
		this.stockList=stockList;
		//保证股票池占比总和为1
		double sum=0;
		for(int i=0;i<stockList.size();i++)
		{
			sum=sum+stockList.get(i).percent;
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
		this.risk=risk;
		this.flags=flags;
		this.bFlag=bFlag;
		this.numlist=new ArrayList<Integer>();
		this.capital=new ArrayList<DateDouble>();
		
		//---------------基准
		this.bCapital=new ArrayList<DateDouble>();
		this.bCash=cash;
		this.bNum=0;
		//-------------------
		this.flags.add(bFlag);
		this.stockList.add(new ChooseStock(benchmark,1));//末尾加上基准
	}
	
	public TestReport test() throws Exception
	{
		File file=new File("test.txt");
		FileWriter fw=null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("flags "+flags+"\r\n\r\n");
	/***********************************************/
		
		//交易订单类型
		int b=stockList.size()-1;
		
		//一天的不同订单
		List<Function> inOrder=new ArrayList<Function>();
		//一天的不同订单
		List<Function> outOrder=new ArrayList<Function>();
		
		//填充数据 mapper
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		HistoryDataMapper historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
		QuotaDataMapper quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");

		DatePack datePack=new DatePack();
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		for(int i=0;i<stockList.size();i++)
		{
			datePack.setSiid(stockList.get(i).siid);/*==========\\\\===========*/
//			datePack.setSiid("sh600000");/*==========\\\\===========*/
			List<HistoryData> hisList=historyDataMapper.selectHistoryData_b_date(datePack);
			List<QuotaData> quoList=quotaDataMapper.selectQuotaData_b_date(datePack);
			HQstatisticlist.add(new HisQuoPack(hisList,quoList));
		}
		
//		/*==================*/
//		for(int i=0;i<HQstatisticlist.get(0).hislist.size();i++)
//		{
//			HQstatisticlist.get(0).hislist.get(i).setClose(10);
//			HQstatisticlist.get(1).hislist.get(i).setClose(10);
//			HQstatisticlist.get(2).hislist.get(i).setClose(10);
//		}
//		/*==================*/
	
		//历史第一日日期资本
		capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate().getTime(),cash));
		bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate().getTime(),bCash));

		//建仓,假设没有税费,从此次开始买入和卖出均用开盘价 TODO
		for(int i=0;i<stockList.size()-1;i++)
		{
			numlist.add((int)(cash*stockList.get(i).percent/HQstatisticlist.get(i).hislist.get(0).getOpen()));/*==========\\\\===========*/
//			numlist.add(500);/*==========\\\\===========*/
		}
		for(int i=0;i<stockList.size()-1;i++)
		{
			cash-=numlist.get(i)*HQstatisticlist.get(i).hislist.get(0).getOpen();/*==========\\\\===========*/
//			cash-=numlist.get(i)*10;/*==========\\\\===========*/
		}
		//---------------基准
		int bNum=(int)(bCash/HQstatisticlist.get(b).hislist.get(0).getOpen());/*==========\\\\===========*/
		bCash-=bNum*HQstatisticlist.get(b).hislist.get(0).getOpen();/*==========\\\\===========*/
		numlist.add(bNum);/*==========\\\\===========*/
//		int bNum=500;/*==========\\\\===========*/
//		bCash-=bNum*10;/*==========\\\\===========*/
//		numlist.add(bNum);/*==========\\\\===========*/
		//-----------------

		//开始回测历史
		//每日买入交易额，卖出交易额
		List<Double> inPrice=new ArrayList<Double>();
		List<Double> outPrice=new ArrayList<Double>();
		
		/*=================*/
		bw.write("初始情况"+numlist+" "+cash+"\n\n");
		/*=================*/
		
		//下订单
		List<Double> lenList=new ArrayList<Double>();
		for(int i=0;i<stockList.size();i++)
		{
			lenList.add((double)HQstatisticlist.get(i).hislist.size());	
		}
		int length=(int) MMSTool.min_double(lenList);
		int counter=0;
		for(int m=n-1+1;m<length;m=m+n)//n=1默认每天
		{//每个交易日
			counter++;
			inOrder.clear();
			outOrder.clear();
			for(int k=0;k<flags.size();k++)
			{//多个订单类型
				List<List<Function>> flagList=flags.get(k).flagList;
				Function orderType=flags.get(k).orderType;
				boolean flagOutI=false;
				boolean flagOutO=false;
				for(int j=0;j<flagList.size();j++)
				{//外列表
					boolean flagInI=true;
					boolean flagInO=true;
					Function function=null;
					FunctionResult result=null;
					for(int h=0;h<flagList.get(j).size();h++)
					{//内列表
						function=flagList.get(j).get(h);
						result=function.getResult(new Date(HQstatisticlist.get(j).hislist.get(m-1).getDate().getTime()));
						
//						bw.write("交易标志"+function.function+" 结果为   "+result.rI+"\r\n");/*==================================*/
						
						FunctionResult upFRI=function.getResultUpI();
						FunctionResult downFRI=function.getResultDownI();
						FunctionResult upFRO=function.getResultUpO();
						FunctionResult downFRO=function.getResultDownO();
				
//						bw.write("upFRI "+upFRI.rI);/*====================*/
//						bw.write(" downFRI "+downFRI.rI);/*====================*/
//						bw.write(" upFRO "+upFRO.rI);/*====================*/
//						bw.write(" downFRO "+downFRO.rI+"\r\n");/*====================*/
						
						switch(result.location.get(0))
						{
						case BOOLEAN://boolean
							if(result.rB==upFRI.rB&&result.rB==downFRI.rB)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
							if(result.rB==upFRO.rB&&result.rB==downFRO.rB)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
							break;
						case INT://int
							if(result.rI<=upFRI.rI&&result.rI>=downFRI.rI)
							{
//								bw.write("in\r\n");/*======================*/
								flagInI=flagInI&&true;
							}
							else
							{
//								bw.write("not in\r\n");/*======================*/
								flagInI=flagInI&&false;
							}
							if(result.rI<=upFRO.rI&&result.rI>=downFRO.rI)
							{
//								bw.write("out\r\n");/*======================*/
								flagInO=flagInO&&true;
							}
							else
							{
//								bw.write("not out\r\n");/*======================*/
								flagInO=flagInO&&false;
							}
//							bw.write("内部买入标志 "+flagInI+" 内部卖出标志 "+flagInO+"\r\n");/*=================*/
							break;
						case DOUBLE://double
							//触发订单
							if(result.rD<=upFRI.rD&&result.rD>=downFRI.rD)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
							if(result.rD<=upFRO.rD&&result.rD>=downFRO.rD)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
							break;
						case STRING://String
							break;
						case INTLIST://int list
							break;
						case DOUBLELIST://double list
							break;
						case STRINGLIST://String list
							break;
						}
					}
					flagOutI=flagOutI||flagInI;
					flagOutO=flagOutO||flagInO;
//					bw.write("外部买入标志 "+flagOutI+" 外部卖出标志 "+flagOutO+"\r\n");/*=======================*/
				}

				FunctionResult result=orderType.getResult(null);
				if(flagOutI)
				{
//					bw.write("买入"+orderType.getResult(null).rS+"\r\n");/*=======================*/
					inOrder.add(setOrder(orderType.function,1,orderType.siid,result.rD,HQstatisticlist.get(getNum(orderType.siid)).hislist.get(m).getOpen()));
					
				}
				else
				{
//					bw.write("不买"+orderType.getResult(null).rS+"\r\n");/*=======================*/
					inOrder.add(null);
				}
				if(flagOutO)
				{
//					bw.write("卖出"+orderType.getResult(null).rS+"\r\n");/*=======================*/
					outOrder.add(setOrder(orderType.function,-1,orderType.siid,result.rD,HQstatisticlist.get(getNum(orderType.siid)).hislist.get(m).getOpen()));
				}
				else
				{
//					bw.write("不卖"+orderType.getResult(null).rS+"\r\n");/*=======================*/
					outOrder.add(null);
				}
			}
			
//			/*======================*/
			bw.write("今日买入订单"+inOrder+"\n");
			bw.write("今日卖出订单"+outOrder+"\n");
//			/*======================*/
			
			
			double capitaltoday=0;//今日股票资本
			double inprice=0;//今日买入总价
			double outprice=0;//今日卖出总价
			
			for(int k=0;k<flags.size()-1;k++)
			{
				if(inOrder.get(k)!=null)
				{
					ShareFunction order=(ShareFunction)inOrder.get(k);
					int j=getNum(order.siid);
					if(cash-order.share*order.price*(1+inTaxRatio)<0)
					{
						int share=(int) (cash*(1-inTaxRatio)/order.price);
						bw.write("买入"+order.siid+";股数： "+share+";价格: "+order.price+"\n");/*==========================*/
						cash-=share*order.price*(1+inTaxRatio);
						numlist.set(j,numlist.get(j)+share);//加仓
						inprice+=share*order.price;
					}
					else
					{
						cash-=order.share*order.price*(1+inTaxRatio);
						bw.write("买入"+order.siid+"股数： "+order.share+";价格: "+order.price+"\n");/*==========================*/
						numlist.set(j,numlist.get(j)+(int)order.share);//加仓
						inprice+=order.share*order.price;
					}
				}
				if(outOrder.get(k)!=null)
				{
					ShareFunction order=(ShareFunction)outOrder.get(k);
					int j=getNum(order.siid);
					if(order.share<=numlist.get(j))
					{
						cash+=order.share*order.price*(1-outTaxRatio);
						bw.write("卖出"+order.siid+"股数： "+order.share+";价格: "+order.price+"\n");/*==========================*/
						numlist.set(j,numlist.get(j)-(int)order.share);
						outprice+=order.share*order.price;
					}
					else
					{
						cash+=numlist.get(j)*order.price*(1-outTaxRatio);
						bw.write("卖出"+order.siid+"股数： "+numlist.get(j)+";价格: "+order.price+"\n");/*==========================*/
						numlist.set(j,0);//减仓
						outprice+=numlist.get(j)*order.price;
					}
				}
			}
			
			double bCapitalToday=0;
			double bInprice=0;
			double bOutprice=0;
			int bLocation=flags.size()-1;
			if(inOrder.get(bLocation)!=null)
			{
				ShareFunction order=(ShareFunction)inOrder.get(bLocation);
				if(bCash-order.share*order.price*(1+inTaxRatio)<0)
				{
					int share=(int) (bCash*(1-inTaxRatio)/order.price);
					bCash-=share*order.price*(1+inTaxRatio);
					numlist.set(b,numlist.get(b)+share);//加仓
					bInprice+=share*order.price;
				}
				else
				{
					bCash-=order.share*order.price*(1+inTaxRatio);
					numlist.set(b,numlist.get(b)+(int)order.share);//加仓
					bInprice+=order.share*order.price;	
				}
			}
			if(outOrder.get(bLocation)!=null)
			{
				ShareFunction order=(ShareFunction)outOrder.get(bLocation);								
				if(order.share>=numlist.get(b))
				{
					bCash+=order.share*order.price*(1-outTaxRatio);
					numlist.set(b,numlist.get(b)-(int)order.share);
					bOutprice+=order.share*order.price;
				}
				else
				{
					bCash+=numlist.get(b)*order.price*(1-outTaxRatio);
					numlist.set(b,0);//减仓
					bOutprice+=numlist.get(b)*order.price;
				}
			}
			
			//risk
			for(int j=0;j<numlist.size();j++)
			{
				boolean avoidRiskOut=false;
				for(int p=0;p<risk.size();p++)
				{
					boolean avoidRiskIn=true;
					for(int q=0;q<risk.get(p).size();q++)
					{
						risk.get(p).get(q).siid=stockList.get(j).siid;
						avoidRiskIn=avoidRiskIn&&risk.get(p).get(q).getResult(HQstatisticlist.get(0).hislist.get(m-1).getDate()).rB;
					}
					avoidRiskOut=avoidRiskOut||avoidRiskIn;
				}
				if(avoidRiskOut)
				{
					double price=HQstatisticlist.get(j).hislist.get(m).getClose();
					cash+=numlist.get(j)*price*(1-outTaxRatio);
//					bw.write("清空"+order.getResult(null).rS+"股数： "+numlist.get(j)+"\n");/*==========================*/
					numlist.set(j,0);//减仓
					outprice+=numlist.get(j)*price;
				}
			}
			
			inPrice.add(inprice);
			outPrice.add(outprice);
			
//			bw.write("inPrice:"+inPrice.get(m-1)+" outPrice:"+outPrice.get(m-1)+"\r\n\r\n");
			
			//清算
			for(int j=0;j<numlist.size()-1;j++)
			{
				capitaltoday+=numlist.get(j)*HQstatisticlist.get(j).hislist.get(m-1).getClose();
			}
			capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(m).getDate().getTime(),capitaltoday+cash));
			
//			bw.write("资本情况:\r\n");
//			bw.write("capital "+capital.get(m)+"\n");/*=====================================*/
			
			bCapitalToday+=numlist.get(b)*HQstatisticlist.get(b).hislist.get(m).getClose();
			bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(m).getDate().getTime(),bCapitalToday+bCash));
		}
		
		/*==========================*/
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*==========================*/
		
		//生成回测报告
		TestReport testReport=new TestReport(HQstatisticlist.get(0).hislist.size()/n,capital,bCapital,inPrice,outPrice);
		testReport.run(capital.get(capital.size()-1).value,capital.get(0).value,bCapital.get(bCapital.size()-1).value,bCapital.get(0).value);
		return testReport;
	}
	
	public int getNum(String siid)
	{
		int num=0;
		for(int i=0;i<stockList.size();i++)
		{
			if(stockList.get(i).siid.equals(siid))
			{
				return i;
			}
		}
		return -1;
	}
	
	public Function setOrder(String type,int order,String siid,double value,double price)
	{
		switch(type)
		{
		case "Share":
			return new ShareFunction(order,siid,(int)value,price);
		case "Order":
			return new ShareFunction(order,siid,(int)value,price);
		case "SharePercent":
			int sum=0;
			for(int i=0;i<numlist.size();i++)
			{
				sum+=numlist.get(i);
			}
			return new ShareFunction(order,siid,sum*value,price);
		case "ShareTarget":
			int shareTargetShare=0;
			for(int i=0;i<stockList.size();i++)
			{
				if(stockList.get(i).siid.equals(siid))
				{
					if(numlist.get(i)<value)
					{
						order=1;
						shareTargetShare=(int)value-numlist.get(i);
					}
					else
					{
						order=-1;
						shareTargetShare=numlist.get(i)-(int)value;
					}
				}
			}
			return new ShareFunction(order,siid,shareTargetShare,price);
		case "Value":
			return new ShareFunction(order,siid,(int)value/price,price);
		case "ValuePercent":
			int shareVP=(int) (capital.get(capital.size()-1).getValue()*value/price);
			return new ShareFunction(order,siid,shareVP,price);
		case "ValueTarget":
			double valueReal=0;
			for(int i=0;i<numlist.size();i++)
			{
				if(stockList.get(i).siid.equals(siid))
				{
					valueReal=value-numlist.get(i)*price;
				}
			}
			int shareVT=0;
			if(valueReal<0)
			{
				order=-1;
				shareVT=(int) (-valueReal/price);
			}
			else
			{
				order=1;
				shareVT=(int) (valueReal/price);
			}
			return new ShareFunction(order,siid,shareVT,price);
		default:
			return null;
		}
	}
}
