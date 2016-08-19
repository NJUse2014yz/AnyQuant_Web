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
import tool.MMSTool;
import vo.Flag;

public class BackTest {
	/**股仓*/
	public List<ChooseStock> stockList;
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
	/**每日资本-基准*/
	public List<DateDouble> bCapital;
	/**基准现金*/
	public double bCash;
	/**基准股数*/
	public double bNum;
	
	public BackTest(List<ChooseStock> stockList,
			List<Flag> flags,
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
		int b=stockList.size()-1;
		
		/**列表最外层为不同订单，中层为不同股票，里层为不同天*/
		List<List<List<Function>>> inOrderList=new ArrayList<List<List<Function>>>();
		/**列表最外层为不同订单，中层为不同股票，里层为不同天*/
		List<List<List<Function>>> outOrderList=new ArrayList<List<List<Function>>>();
		for(int j=0;j<flags.size();j++)
		{
			inOrderList.add(new ArrayList<List<Function>>());
			outOrderList.add(new ArrayList<List<Function>>());
			for(int i=0;i<stockList.size();i++)
			{
				inOrderList.get(j).add(new ArrayList<Function>());
				outOrderList.get(j).add(new ArrayList<Function>());
			}	
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
		capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate().getTime(),cash));
		bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(0).getDate().getTime(),bCash));
		
		//建仓,假设没有税费,从此次开始买入和卖出均用收盘价TODO
		for(int i=0;i<stockList.size()-1;i++)
		{
			numlist.add((int)(cash*stockList.get(i).percent/HQstatisticlist.get(i).hislist.get(0).getClose()));
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
		List<Double> lenList=new ArrayList<Double>();
		for(int i=0;i<stockList.size();i++)
		{
			lenList.add((double)HQstatisticlist.get(i).hislist.size());	
		}
		int length=(int) MMSTool.min_double(lenList);
		int counter=0;
		for(int m=n-1;m<length;m=m+n)//n=10默认每五天
		{//每个交易日
			counter++;
			for(int k=0;k<flags.size();k++)
			{//多个订单类型
				List<List<Function>> flagList=flags.get(k).flagList;
				Function orderType=flags.get(k).orderType;
				boolean flagOutI=true;
				boolean flagOutO=true;
				for(int j=0;j<flagList.size();j++)
				{//外列表
					boolean flagInI=true;
					boolean flagInO=true;
					Function function=null;
					FunctionResult result=null;
					for(int h=0;h<flagList.get(j).size();h++)
					{//内列表
						function=flagList.get(j).get(h);
						result=function.getResult(new Date(HQstatisticlist.get(j).hislist.get(m).getDate().getTime()));//TODO
						
						FunctionResult upFRI=function.getResultUpI();
						FunctionResult downFRI=function.getResultDownI();
						FunctionResult upFRO=function.getResultUpO();
						FunctionResult downFRO=function.getResultDownO();
				
						switch(result.location.get(0))
						{
						case BOOLEAN://boolean
							break;
						case INT://int
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
				}

				if(flagOutI)
				{
					for(int i=0;i<stockList.size();i++)
					{
						inOrderList.get(k).get(i).add(setOrder(orderType.function,1,stockList.get(i).siid,1000,HQstatisticlist.get(i).hislist.get(m+1).getClose()));//暂用1000
					}
				}
				else
				{
					for(int i=0;i<stockList.size();i++)
					{
						inOrderList.get(k).get(i).add(null);//如果不交易传入null
					}
				}
				if(flagOutO)
				{
					for(int i=0;i<stockList.size();i++)
					{
						outOrderList.get(k).get(i).add(setOrder(orderType.function,-1,stockList.get(i).siid,1000,HQstatisticlist.get(i).hislist.get(m+1).getClose()));
					}
				}
				else
				{
					for(int i=0;i<stockList.size();i++)
					{
						outOrderList.get(k).get(i).add(null);//如果不交易传入null
					}
				}
			}
			
			
			
			double capitaltoday=0;//今日股票资本
			double inprice=0;//今日买入总价
			double outprice=0;//今日卖出总价
			for(int j=0;j<stockList.size()-1;j++)
			{//每只股票
				for(int k=0;k<flags.size();k++)
				{//多种订单
					Function orderType=flags.get(k).orderType;
					switch(orderType.getFunction())
					{
					case "Share":
					//产生交易		
						if(inOrderList.get(k).get(j).get(m)!=null)
						{
							ShareFunction order=(ShareFunction)inOrderList.get(k).get(j).get(m);
								if(cash-order.share*order.price*(1+inTaxRatio)<0)
								{
									int share=(int) (cash*(1-inTaxRatio)/order.price);
									cash-=share*order.price*(1+inTaxRatio);
									numlist.set(j,numlist.get(j)+share);//加仓
									inprice+=share*order.price;
								}
								else
								{
									cash-=order.share*order.price*(1+inTaxRatio);
									numlist.set(j,numlist.get(j)+order.share);//加仓
									inprice+=order.share*order.price;
								}
						}
						if(outOrderList.get(k).get(j).get(m)!=null)
						{
							ShareFunction order=(ShareFunction)inOrderList.get(k).get(j).get(m);								
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
						break;
					case "Percent":
						
						break;
					}
				}//k 多种订单
				capitaltoday+=numlist.get(j)*HQstatisticlist.get(j).hislist.get(m).getClose();
			}//j 每股
			capital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(m).getDate().getTime(),capitaltoday+cash));
			inPrice.add(inprice);
			outPrice.add(outprice);

			
			double bCapitalToday=0;
			double bInprice=0;
			double bOutprice=0;
			for(int k=0;k<flags.size();k++)
			{//多种订单
				Function orderType=flags.get(k).orderType;
				switch(orderType.getFunction())
				{
				case "Share":
					ShareFunction order=(ShareFunction)inOrderList.get(k).get(b).get(m);
					if(inOrderList.get(k).get(b).get(m)!=null)
					{
						if(cash-order.share*order.price*(1+inTaxRatio)<0)
						{
							int share=(int) (cash*(1-inTaxRatio)/order.price);
							cash-=share*order.price*(1+inTaxRatio);
							numlist.set(b,numlist.get(b)+share);//加仓
							bInprice+=share*order.price;
						}
						else
						{
							bCash-=order.share*order.price*(1+inTaxRatio);
							numlist.set(b,numlist.get(b)+order.share);//加仓
							bInprice+=order.share*order.price;	
						}
					}
					if(outOrderList.get(k).get(b).get(m)!=null)
					{
						if(order.share>=numlist.get(b))
						{
							bCash+=order.share*order.price*(1-outTaxRatio);
							numlist.set(b,numlist.get(b)-order.share);
							bOutprice+=order.share*order.price;
						}
						else
						{
							cash+=numlist.get(b)*order.price*(1-outTaxRatio);
							numlist.set(b,0);//减仓
							bOutprice+=numlist.get(b)*order.price;
						}
					}
					break;
				default:
					System.out.println("not in");
				}
			}
			bCapitalToday+=numlist.get(b)*HQstatisticlist.get(b).hislist.get(m).getClose();
			bCapital.add(new DateDouble(HQstatisticlist.get(0).hislist.get(m).getDate().getTime(),bCapitalToday+bCash));
		}
		//生成回测报告
		TestReport testReport=new TestReport(HQstatisticlist.get(0).hislist.size()/n,capital,bCapital,inPrice,outPrice);
		testReport.run(capital.get(capital.size()-1).value,capital.get(0).value,bCapital.get(bCapital.size()-1).value,bCapital.get(0).value);
		return testReport;
	}
	public Function setOrder(String type,int order,String siid,double value,double price)
	{
		return null;
	}
}
