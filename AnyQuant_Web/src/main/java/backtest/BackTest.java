package backtest;

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
import function.flag.TrendFunction;
import function.order.ShareFunction;
import po.DatePack;
import po.HistoryData;
import po.QuotaData;

public class BackTest {
	/**股仓*/
	public List<ChooseStock> stockList;
	/**交易标志*/
	public List<List<Function>> flagList;

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
	
	public BackTest(List<ChooseStock> stockList,
			List<List<Function>> flagList,Function orderType,
			double cash,Date startdate,Date enddate,int n,
			String benchmark) throws Exception
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
		this.orderType=orderType;
		this.flagList=flagList;
		
		this.numlist=new ArrayList<Integer>();
		this.capital=new ArrayList<DateDouble>();
		
		//---------------基准
//		this.benchmark=benchmark;
		this.bCapital=new ArrayList<DateDouble>();
		this.bCash=cash;
		this.bNum=0;
		//-------------------
		stockList.add(new ChooseStock(benchmark,1));//末尾加上基准
	}
	
	public TestReport test() throws Exception
	{
		//交易订单类型
		List<List<Function>> inOrders=new ArrayList<List<Function>>();
		List<List<Function>> outOrders=new ArrayList<List<Function>>();
		
		int b=stockList.size()-1;
		
		for(int i=0;i<stockList.size();i++)//基准放在最后
		{
			inOrders.add(new ArrayList<Function>());
			outOrders.add(new ArrayList<Function>());
		}
		
		//填充数据 mapper
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		HistoryDataMapper historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
		QuotaDataMapper quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");
		//历史和指标数据包（每个股票一个）的列表
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
		
		//历史第一日日期资本
		capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate(),cash));
		bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate(),bCash));
		
		//建仓,假设没有税费,从此次开始买入和卖出均用收盘价
		for(int i=0;i<stockList.size()-1;i++)
		{
			numlist.add((int)(cash*stockList.get(i).percent/100.0/HQstatisticlist.get(i).hislist.get(0).getClose()));
		}
		for(int i=0;i<stockList.size()-1;i++)
		{
			cash-=numlist.get(i)*HQstatisticlist.get(i).hislist.get(0).getClose();
		}
		//---------------基准
		int bNum=(int)(bCash/HQstatisticlist.get(b).hislist.get(0).getClose());
		bCash-=bNum*HQstatisticlist.get(b).hislist.get(0).getClose();
		numlist.add(bNum);
		//-----------------
		
		//开始回测历史
		//每日买入交易额，卖出交易额
		List<Double> inPrice=new ArrayList<Double>();
		List<Double> outPrice=new ArrayList<Double>();
		
		//下订单
		int length=HQstatisticlist.get(0).hislist.size();
		for(int k=n-1;k<length-1;k=k+n)//n=10默认每五天
		{
			boolean flagOutI=true;
			boolean flagOutO=true;
			for(int j=0;j<flagList.size();j++)
			{
				boolean flagInI=true;
				boolean flagInO=true;
				Function function=null;
				FunctionResult result=null;
				for(int h=0;h<flagList.get(j).size();h++)
				{
					
					TrendFunction function0=(TrendFunction)flagList.get(j).get(h);
					FunctionResult upFRI=function0.getResultUpI();
					FunctionResult downFRI=function0.getResultDownI();
					FunctionResult upFRO=function0.getResultUpO();
					FunctionResult downFRO=function0.getResultDownO();
					
					function=flagList.get(j).get(h);
					result=function.getResult();
				
					switch(result.location.get(0))
					{
					case BOOLEAN://boolean
						break;
					case INT://int
						break;
					case DOUBLE://double
						//触发订单
						switch(orderType.function)
						{
						case "Share"://股数订单
							if(result.rD<=upFRI.rD&&result.rD>=downFRI.rD)//暂时只使用一个判定
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
						case "Value":
							break;
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
				flagOutI=flagOutI&&flagInI;
				flagOutO=flagOutO&&flagInO;
			}
			
			if(flagOutI)
			{
				for(int i=0;i<stockList.size();i++)
				{
					inOrders.get(i).add(new ShareFunction(1,stockList.get(i).siid,1000,HQstatisticlist.get(i).hislist.get(k+1).getClose()));//暂用1000
				}
			}
			else
			{
				for(int i=0;i<stockList.size();i++)
				{
					inOrders.get(i).add(null);//如果不交易传入null
				}
			}
			if(flagOutO)
			{
				for(int i=0;i<stockList.size();i++)
				{
					outOrders.get(i).add(new ShareFunction(-1,stockList.get(i).siid,1000,HQstatisticlist.get(i).hislist.get(k+1).getClose()));
				}
			}
			else
			{
				for(int i=0;i<stockList.size();i++)
				{
					outOrders.get(i).add(null);//如果不交易传入null
				}
			}
			
			switch(orderType.getFunction())
			{
			case "Share":
				//产生交易
				for(int i=0;i<inOrders.get(0).size();i++)
				{//每次应交易情况
					double capitaltoday=0;//今日股票资本
					double inprice=0;//今日买入总价
					double outprice=0;//今日卖出总价
					
					for(int j=0;j<stockList.size()-1;j++)
					{//每只股票
						if(inOrders.get(j).get(i)!=null)
						{
							
							ShareFunction order=(ShareFunction)inOrders.get(j).get(i);
							if(order.order==1)
							{
								if(cash<=0)
								{
									;
								}
								else
								{
									cash-=order.share*order.price*(1+inTaxRatio);
									numlist.set(j,numlist.get(j)+order.share);//加仓
									inprice+=order.share*order.price;
								}
							}
							else if(order.order==-1)
							{
								if(order.share>=numlist.get(j))
								{
									cash+=order.share*order.price*(1-outTaxRatio);
									numlist.set(j,numlist.get(j)-order.share);
									outprice+=order.share*order.price;
								}
								else
								{
									cash+=numlist.get(j)*order.price*(1-outTaxRatio);
									numlist.set(j,0);//减仓
									outprice+=numlist.get(j)*order.price;
								}
							}
							capitaltoday+=numlist.get(j)*order.price;
						}
					}
					capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(i).getDate(),capitaltoday+cash));
					inPrice.add(inprice);
					outPrice.add(outprice);
					
					double bCapitalToday=0;
					double bInprice=0;
					double bOutprice=0;
					
					if(inOrders.get(b).get(i)!=null)
					{
						ShareFunction order=(ShareFunction)inOrders.get(b).get(i);
						if(order.order==1)
						{
							if(cash<=0)
							{
								;
							}
							else
							{
								bCash-=order.share*order.price*(1+inTaxRatio);
								numlist.set(b,numlist.get(b)+order.share);//加仓
								inprice+=order.share*order.price;	
							}
						}
						else if(order.order==-1)
						{
							if(order.share>=numlist.get(b))
							{
								bCash+=order.share*order.price*(1-outTaxRatio);
								numlist.set(b,numlist.get(b)-order.share);
								outprice+=order.share*order.price;
							}
							else
							{
								cash+=numlist.get(b)*order.price*(1-outTaxRatio);
								numlist.set(b,0);//减仓
								outprice+=numlist.get(b)*order.price;
							}
						}
						bCapitalToday+=numlist.get(b)*order.price;
					}
					bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(i).getDate(),bCapitalToday+bCash));
				}
				break;
			default:
				System.out.println("not in");
			}
		}
		//生成回测报告
		TestReport testReport=new TestReport(HQstatisticlist.get(0).hislist.size()/n,capital,bCapital,inPrice,outPrice);
//		System.out.println(inOrders.get(0).size());
//		System.out.println(capital.size());
//		System.out.println(bCapital.size());
//		System.out.println(bCapital.get(0));
		testReport.run(capital.get(capital.size()-1).value,capital.get(0).value,bCapital.get(bCapital.size()-1).value,bCapital.get(0).value);
		return testReport;
	}
}
