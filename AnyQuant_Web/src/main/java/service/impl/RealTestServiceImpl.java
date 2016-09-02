 package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import backtest.DateDouble;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.order.ShareFunction;
import function.order.SharePercentFunction;
import function.order.ShareTargetFunction;
import function.order.ValueFunction;
import function.order.ValuePercentFunction;
import function.order.ValueTargetFunction;
import mapper.HistoryDataMapper;
import mapper.StrategyMapper;
import po.HistoryData;
import po.Strategy;
import po.StrategySearch;
import service.RealTestService;
import tool.DateExchangeTool;
import vo.RealTestVO;
import vo.StrategyVO;

public class RealTestServiceImpl implements RealTestService {
	/**税费(默认采用买千分之一，卖千分之二的税费)*/
	public static double inTaxRatio=0.001;
	public static double outTaxRatio=0.002;
	@Autowired
	public HistoryDataMapper hisMapper;
	@Autowired
	public StrategyMapper strMapper;
	
	public RealTestVO vo;
	
	public RealTestServiceImpl(){}
	public RealTestServiceImpl(HistoryDataMapper hisMapper,StrategyMapper strMapper)
	{
		this.hisMapper=hisMapper;
		this.strMapper=strMapper;
	}

	@Override
	public String realTestForToday(RealTestVO vo) {//在15:00之后调用 TODO 开发通知功能、交易周期
		Date today=new Date(Calendar.getInstance().getTimeInMillis());
		Date yesterday=new Date(Calendar.getInstance().getTimeInMillis()-24*60*60*1000);
		String history=DateExchangeTool.dateToString1(today)+"\n";
		if(vo==null||vo.capital==null||vo.flags==null||vo.history==null||vo.numlist==null||vo.stockList==null)
		{
			System.err.println("RealTestServiceImpl==>e1 RealTestVO or it's essential elements are null");
			return history;
		}
//		File file=new File("realtest.txt");
//		FileWriter fw=null;
//		try {
//			fw = new FileWriter(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		BufferedWriter bw=new BufferedWriter(fw);
//		try {
//			bw.write("flags "+vo.flags+"\r\n\r\n");
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
//		/***********************************************/
		this.vo=vo;
		List<Double> priceList=new ArrayList<Double>();
		List<Double> valueList=new ArrayList<Double>();
		for(int i=0;i<vo.stockList.size();i++)
		{
			double open=0;
			double close=0;
			try {
				HistoryData data=hisMapper.selectHistoryData_new_single(vo.stockList.get(i).siid);
				open=data.getOpen();//买进价格为今日开盘价/*=====================*/
				close=data.getClose();
			} catch (Exception e2) {
				System.err.println("RealTestServiceImpl==>e2 mysql exception");
			}
			priceList.add(open);
			valueList.add(close);
		}
		
//		/*===========================*/
//		try {
//			bw.write("今日价格： "+priceList+"\n");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		/*===========================*/
		
		//一天的不同订单
		List<Function> inOrder=new ArrayList<Function>();
		//一天的不同订单
		List<Function> outOrder=new ArrayList<Function>();
		
		boolean flagOutI=false;
		boolean flagOutO=false;
		for(int k=0;k<vo.flags.size();k++)
		{//多个订单类型
			List<List<Function>> flagList=vo.flags.get(k).flagList;
			Function orderType=vo.flags.get(k).orderType;
			for(int j=0;j<flagList.size();j++)
			{//外列表
				boolean flagInI=true;
				boolean flagInO=true;
				Function function=null;
				FunctionResult result=null;
				for(int h=0;h<flagList.get(j).size();h++)
				{//内列表
					function=flagList.get(j).get(h);
					
					FunctionResult resultUpI=function.getResultUpI();
					FunctionResult resultDownI=function.getResultDownI();
					FunctionResult resultUpO=function.getResultUpO();
					FunctionResult resultDownO=function.getResultDownO();
					
					result=function.getResult(yesterday);//预测使用前一天及之前的数据
				
//					System.out.println("result "+result.rI);/*======================*/
					
					if(function.resultUpIF!=null)
					{
						resultUpI=function.resultUpIF.getResult(yesterday);
					}
					if(function.resultUpOF!=null)
					{
						resultUpO=function.resultUpOF.getResult(yesterday);
					}
					if(function.resultDownIF!=null)
					{
						resultDownI=function.resultDownIF.getResult(yesterday);
					}
					if(function.resultDownOF!=null)
					{
						resultDownO=function.resultDownOF.getResult(yesterday);
					}
					
					switch(ResultType.getEnum(result.location.get(0)))
					{
					case BOOLEAN://boolean
						if(resultUpI!=null)
						{
							if(result.rB==resultUpI.rB)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
						}
						if(resultDownI!=null)
						{
							if(result.rB==resultDownI.rB)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
						}
						if(resultUpO!=null)
						{
							if(result.rB==resultUpO.rB)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
						}
						if(resultDownO!=null)
						{
							if(result.rB==resultDownO.rB)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
						}
						break;
					case INT://int
						if(resultUpI!=null)
						{
							if(result.rI<=resultUpI.rI)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
						}
						if(resultDownI!=null)
						{
							if(result.rI>=resultDownI.rI)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
						}
						if(resultUpO!=null)
						{
							if(result.rI<=resultUpO.rI)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
						}
						if(resultDownO!=null)
						{
							if(result.rI>=resultDownO.rI)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
						}
						break;
					case DOUBLE://double
						//触发订单
						if(resultUpI!=null)
						{
							if(result.rD<=resultUpI.rD)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
						}
						if(resultDownI!=null)
						{
							if(result.rD>=resultDownI.rD)
							{
								flagInI=flagInI&&true;
							}
							else
							{
								flagInI=flagInI&&false;
							}
						}
						if(resultUpO!=null)
						{
							if(result.rD<=resultUpO.rD)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
						}
						if(resultDownO!=null)
						{
							if(result.rD>=resultDownO.rD)
							{
								flagInO=flagInO&&true;
							}
							else
							{
								flagInO=flagInO&&false;
							}
						}
						break;
					case STRING://String
						break;
					case INTLIST://int list
						break;
					case DOUBLELIST://double list
						for(int i=0;i<result.rLD.size();i++)
						{
							if(resultUpI!=null)
							{
								if(result.rLD.get(i)<=resultUpI.rLD.get(i))
								{
									flagInI=flagInI&&true;
								}
								else
								{
									flagInI=flagInI&&false;
								}
							}
							if(resultDownI!=null)
							{
								if(result.rLD.get(i)>=resultDownI.rLD.get(i))
								{
									flagInI=flagInI&&true;
								}
								else
								{
									flagInI=flagInI&&false;
								}
							}
							if(resultUpO!=null)
							{
								if(result.rLD.get(i)<=resultUpO.rLD.get(i))
								{
									flagInO=flagInO&&true;
								}
								else
								{
									flagInO=flagInO&&false;
								}
							}
							if(resultDownO!=null)
							{
								if(result.rLD.get(i)>=resultDownO.rLD.get(i))
								{
									flagInO=flagInO&&true;
								}
								else
								{
									flagInO=flagInO&&false;
								}
							}
						}
						break;
					case STRINGLIST://String list
						break;
					}
				}
				flagOutI=flagOutI||flagInI;
				flagOutO=flagOutO||flagInO;
			}

			String siidForTrade=orderType.siid;
			if(orderType.siidF!=null)
			{
				siidForTrade=orderType.siidF.getResult(yesterday).rS;
			}
			
			if(flagOutI)
			{
				inOrder.add(setOrder(orderType,yesterday,priceList.get(getNum(siidForTrade))));
//				/*=======================*/
//				try {
//					bw.write("买入\r\n");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				/*=======================*/
			}
			else
			{
//				/*=======================*/
//				try {
//					bw.write("不买\r\n");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				/*=======================*/
				inOrder.add(null);
			}
			if(flagOutO)
			{
//				/*=======================*/
//				try {
//					bw.write("卖出\r\n");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				/*=======================*/
				outOrder.add(setOrder(orderType,yesterday,priceList.get(getNum(siidForTrade))));
			}
			else
			{
//				/*=======================*/
//				try {
//					bw.write("不卖\r\n");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				/*=======================*/
				outOrder.add(null);
			}
		}
		int i=0;
		double capitaltoday=0;//今日股票资本
		double inprice=0;//今日买入总价
		double outprice=0;//今日卖出总价
		for(int k=0;k<vo.flags.size();k++)
		{
			if(inOrder.get(k)!=null)
			{
				ShareFunction order=(ShareFunction)inOrder.get(k);
				String target=order.getResult(null).rS;
				int j=getNum(target);
				if(vo.cash-order.share*order.price*(1+inTaxRatio)<0)
				{
					int share=(int) (vo.cash*(1-inTaxRatio)/order.price);
					vo.cash-=share*order.price*(1+inTaxRatio);
					vo.numlist.set(j,vo.numlist.get(j)+share);//加仓
					inprice+=share*order.price;
					/*=========================*/
					history+="买入"+target+" "+share+"股;价格"+order.price+"\n";
//					try {
//						bw.write("买入"+target+" "+share+"股;价格"+order.price+"\n");
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					/*=========================*/
				}
				else
				{
					vo.cash-=order.share*order.price*(1+inTaxRatio);
					vo.numlist.set(j,vo.numlist.get(j)+(int)order.share);//加仓
					inprice+=order.share*order.price;
					/*=========================*/
					history+="买入"+target+" "+order.share+"股;价格"+order.price+"\n";
//					try {
//						bw.write("买入"+target+" "+order.share+"股;价格"+order.price+"\n");
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					/*=========================*/
				}
			}
			if(outOrder.get(k)!=null)
			{
				ShareFunction order=(ShareFunction)outOrder.get(k);
				String target=order.getResult(null).rS;
				int j=getNum(target);
				if(order.share<=vo.numlist.get(j))
				{
					vo.cash+=order.share*order.price*(1-outTaxRatio);
					vo.numlist.set(j,vo.numlist.get(j)-(int)order.share);
					outprice+=order.share*order.price;
					/*=========================*/
//					try {
						history+="卖出"+target+" "+order.share+"股;价格"+order.price+"\n";
//						bw.write("卖出"+target+" "+order.share+"股;价格"+order.price+"\n");
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					/*=========================*/
				}
				else
				{
					/*=========================*/
//					try {
						history+="卖出"+target+" "+vo.numlist.get(i)+"股;价格"+order.price+"\n";
//						bw.write("卖出"+target+" "+vo.numlist.get(i)+"股;价格"+order.price+"\n");
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					/*=========================*/
					vo.cash+=vo.numlist.get(j)*order.price*(1-outTaxRatio);
					vo.numlist.set(j,0);//减仓
					outprice+=vo.numlist.get(j)*order.price;
				}
			}
			
			//risk
			for(int j=0;j<vo.numlist.size();j++)
			{
				boolean avoidRiskOut=false;
				for(int p=0;p<vo.risk.size();p++)
				{
					boolean avoidRiskIn=true;
					for(int q=0;q<vo.risk.get(p).size();q++)
					{
						vo.risk.get(p).get(q).siid=vo.stockList.get(j).siid;
						avoidRiskIn=avoidRiskIn&&vo.risk.get(p).get(q).getResult(null).rB;
					}
					avoidRiskOut=avoidRiskOut||avoidRiskIn;
				}
				if(avoidRiskOut)
				{
					double price=priceList.get(j);
					/*==========================*/
//					try {
						history+="风险控制： 清空股票"+vo.stockList.get(j).siid+" "+vo.numlist.get(j)+"股;价格"+price+"\n";
//						bw.write("风险控制： 清空股票"+vo.stockList.get(j).siid+" "+vo.numlist.get(j)+"股;价格"+price+"\n");
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					/*==========================*/
					vo.cash+=vo.numlist.get(j)*price*(1-outTaxRatio);
					vo.numlist.set(j,0);//减仓
					outprice+=vo.numlist.get(j)*price;
				}
			}
			
		}
		for(int j=0;j<vo.numlist.size()-1;j++)
		{
			capitaltoday+=vo.numlist.get(j)*valueList.get(j);
		}
		vo.capital.add(new DateDouble(today.getTime(),capitaltoday+vo.cash));
		
		/*==========================*/
//		try {
			history+="今日资本: "+vo.capital.get(vo.capital.size()-1).value+"\n";
//			bw.write("今日资本: "+vo.capital.get(vo.capital.size()-1)+"\n");
//		} catch (IOException e3) {
//			e3.printStackTrace();
//		}
//		try {
			history+="各股持股"+vo.numlist+"\n";
//			bw.write("各股持股"+vo.numlist+"\n\n");
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
		/*==========================*/
		
		/*==========================*/
//		try {
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			fw.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		/*==========================*/
//		System.out.println(vo.stockList);
//		System.out.println(vo.flags);
//		System.out.println(vo.risk);
//		System.out.println(vo.capital);/*======================*/
		
		vo.history.add(history);
		return history;
	}

	@Override
	public void saveRealTest(String userName, String createrName,
			String strategyName, RealTestVO vo) {
		String str=JSONObject.fromObject(vo).toString();
		StrategySearch search=new StrategySearch(userName,createrName,strategyName,str);
		try {
			strMapper.modifyRealTest(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initRealTest(String userName,String createrName,String strategyName,double cash, int n) {
		RealTestVO vo=new RealTestVO();
		vo.setCash(cash);
		vo.setN(n);
		vo.setCapital(new ArrayList<DateDouble>());
		vo.getCapital().add(new DateDouble(Calendar.getInstance().getTimeInMillis(),cash));
		vo.setNumList(new ArrayList<Integer>());
		for(int i=0;i<new StrategyServiceImpl(strMapper).getSingleStrategy(userName, createrName, strategyName).getStockList().size();i++)
		{
			vo.getNumList().add(0);
		}
		vo.setHistory(new ArrayList<String>());
		String str=JSONObject.fromObject(vo).toString();
		StrategySearch search=new StrategySearch(userName,createrName,strategyName,str);
		try {
			strMapper.modifyRealTest(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNum(String siid)
	{
		for(int i=0;i<vo.stockList.size();i++)
		{
			if(vo.stockList.get(i).siid.equals(siid))
			{
				return i;
			}
		}
		return -1;
	}
	
	public Function setOrder(Function order,Date today,double price)
	{
		String siid=order.siid;
		if(order.siidF!=null)
		{
			siid=order.siidF.getResult(today).rS;
		}
		double value=0;
		
		switch(order.function)
		{
		case "Share":
			ShareFunction sf=(ShareFunction) order;
			value=sf.share;
			if(sf.shareF!=null)
			{
				value=sf.shareF.getResult(today).rD;
			}
			if(sf.priceF!=null)
			{
				price=sf.priceF.getResult(today).rD;
			}
			return new ShareFunction(siid,(int)value,price);
		case "SharePercent":
			SharePercentFunction spf=(SharePercentFunction)order;
			value=spf.percent;
			if(spf.percentF!=null)
			{
				value=spf.percentF.getResult(today).rD;
			}
			if(spf.priceF!=null)
			{
				price=spf.priceF.getResult(today).rD;
			}
			int sum=0;
			for(int i=0;i<vo.numlist.size();i++)
			{
				sum+=vo.numlist.get(i);
			}
			
			return new ShareFunction(siid,null,(int)sum*value,null,price,null);
		case "ShareTarget":
			ShareTargetFunction stf=(ShareTargetFunction)order;
			value=stf.share;
			if(stf.shareF!=null)
			{
				value=stf.shareF.getResult(today).rD;
			}
			if(stf.priceF!=null)
			{
				price=stf.priceF.getResult(today).rD;
			}
			int shareTargetShare=0;
			for(int i=0;i<vo.stockList.size();i++)
			{
				if(vo.stockList.get(i).siid.equals(siid))
				{
					if(vo.numlist.get(i)<value)
					{
						shareTargetShare=(int)value-vo.numlist.get(i);
					}
					else
					{
						shareTargetShare=vo.numlist.get(i)-(int)value;
					}
				}
			}
			return new ShareFunction(siid,shareTargetShare,price);
		case "Value":
			ValueFunction vf=(ValueFunction)order;
			value=vf.value;
			if(vf.priceF!=null)
			{
				price=vf.priceF.getResult(today).rD;
			}
			if(vf.valueF!=null)
			{
				value=vf.valueF.getResult(today).rD;
			}
			return new ShareFunction(siid,(int)value/price,price);
		case "ValuePercent":
			ValuePercentFunction vpf=(ValuePercentFunction)order;
			value=vpf.percent;
			if(vpf.priceF!=null)
			{
				price=vpf.priceF.getResult(today).rD;
			}
			if(vpf.percentF!=null)
			{
				value=vpf.percentF.getResult(today).rD;
			}
			int shareVP=(int) (vo.capital.get(vo.capital.size()-1).getValue()*value/price);
			return new ShareFunction(siid,null,shareVP,null,price,null);
		case "ValueTarget":
			ValueTargetFunction vtf=(ValueTargetFunction)order;
			value=vtf.value;
			if(vtf.priceF!=null)
			{
				price=vtf.priceF.getResult(today).rD;
			}
			if(vtf.valueF!=null)
			{
				value=vtf.valueF.getResult(today).rD;
			}
			double valueReal=0;
			for(int i=0;i<vo.numlist.size();i++)
			{
				if(vo.stockList.get(i).siid.equals(siid))
				{
					valueReal=value-vo.numlist.get(i)*price;
				}
			}
			int shareVT=0;
			if(valueReal<0)
			{
				shareVT=(int) (-valueReal/price);
			}
			else
			{
				shareVT=(int) (valueReal/price);
			}
			return new ShareFunction(siid,null,shareVT,null,price,null);
		default:
			return null;
		}
	}

	@Override
	public List<String> queryHistory(String userName, String createrName,
			String strategyName) {
		StrategySearch search=new StrategySearch(userName,createrName,strategyName);
		StrategyVO strategy=null;
		try {
			strategy=new StrategyServiceImpl(strMapper).getSingleStrategy(userName, createrName, strategyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return strategy.getRealTest().history;
	}
	
	
	public static void main(String[] args)
	{
		HashMap map=new HashMap();
		Calendar cal=Calendar.getInstance();
		String history="hhh";
		
		map.put(new Date(cal.get(Calendar.YEAR)-1900,cal.get(Calendar.MONTH),cal.get(Calendar.DATE)).getTime(),"1");
		map.put(new Date(cal.get(Calendar.YEAR)-1900,cal.get(Calendar.MONTH),cal.get(Calendar.DATE)+1).getTime(),"2");
		map.put(new Date(cal.get(Calendar.YEAR)-1900,cal.get(Calendar.MONTH),cal.get(Calendar.DATE)+2).getTime(),"3");
	}

	
}
