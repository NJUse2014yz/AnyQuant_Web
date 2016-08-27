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
import function.OrderFunction;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.order.ShareFunction;
import mapper.HistoryDataMapper;
import mapper.StrategyMapper;
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
	
	public RealTestServiceImpl(HistoryDataMapper hisMapper,StrategyMapper strMapper)
	{
		this.hisMapper=hisMapper;
		this.strMapper=strMapper;
	}

	@Override
	public String realTestForToday(RealTestVO vo) {//在15:00之后调用 TODO 开发通知功能
		
		String history=DateExchangeTool.dateToString1(new Date(Calendar.getInstance().getTimeInMillis()))+"\n";
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
		/***********************************************/
		this.vo=vo;
		List<Double> priceList=new ArrayList<Double>();
		for(int i=0;i<vo.stockList.size();i++)
		{
			double close=0;
			try {
				close=hisMapper.selectHistoryData_new_single(vo.stockList.get(i).siid).getOpen();//买进价格为今日开盘价/*=====================*/
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				priceList.add(close);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
					
					FunctionResult upFRI=function.getResultUpI();
					FunctionResult downFRI=function.getResultDownI();
					FunctionResult upFRO=function.getResultUpO();
					FunctionResult downFRO=function.getResultDownO();
					
					result=function.getResult(new Date(Calendar.getInstance().getTimeInMillis()-24*60*60*1000));//预测使用前一天及之前的数据
				
//					System.out.println("result "+result.rI);/*======================*/
					
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
							flagInI=flagInI&&true;
						}
						else
						{
							flagInI=flagInI&&false;
						}
						if(result.rI<=upFRO.rI&&result.rI>=downFRO.rI)
						{
							flagInO=flagInO&&true;
						}
						else
						{
							flagInO=flagInO&&false;
						}
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

	//		System.out.println(vo.stockList);
	//		System.out.println(priceList);
		
			if(flagOutI)
			{
				inOrder.add(setOrder(orderType.function,1,orderType.getResult(null).rS,orderType.getResult(null).rD,priceList.get(getNum(orderType.getResult(null).rS))));
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
				outOrder.add(setOrder(orderType.function,-1,orderType.getResult(null).rS,orderType.getResult(null).rD,priceList.get(getNum(orderType.getResult(null).rS))));
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
		vo.capital.add(new DateDouble(Calendar.getInstance().getTimeInMillis(),capitaltoday+vo.cash));
		
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
		vo.getCapital().add(new DateDouble(Calendar.getInstance().getTimeInMillis(),cash));
		for(int i=0;i<new StrategyServiceImpl(strMapper).getSingleStrategy(userName, createrName, strategyName).getStockList().size();i++)
		{
			vo.getNumList().add(0);
		}
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
		System.out.println(siid);
		for(int i=0;i<vo.stockList.size();i++)
		{
			if(vo.stockList.get(i).siid.equals(siid))
			{
				System.out.println(i);
				return i;
			}
		}
		System.out.println(-1);
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
			for(int i=0;i<vo.numlist.size();i++)
			{
				sum+=vo.numlist.get(i);
			}
			return new ShareFunction(order,siid,sum*value,price);
		case "ShareTarget":
			int shareTargetShare=0;
			for(int i=0;i<vo.stockList.size();i++)
			{
				if(vo.stockList.get(i).siid.equals(siid))
				{
					if(vo.numlist.get(i)<value)
					{
						order=1;
						shareTargetShare=(int)value-vo.numlist.get(i);
					}
					else
					{
						order=-1;
						shareTargetShare=vo.numlist.get(i)-(int)value;
					}
				}
			}
			return new ShareFunction(order,siid,shareTargetShare,price);
		case "Value":
			return new ShareFunction(order,siid,(int)value/price,price);
		case "ValuePercent":
			int shareVP=(int) (vo.capital.get(vo.capital.size()-1).getValue()*value/price);
			return new ShareFunction(order,siid,shareVP,price);
		case "ValueTarget":
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
