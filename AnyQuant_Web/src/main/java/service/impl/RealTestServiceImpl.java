package service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import backtest.DateDouble;
import function.Function;
import function.FunctionResult;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.order.ShareFunction;
import mapper.HistoryDataMapper;
import mapper.StrategyMapper;
import po.Strategy;
import po.StrategySearch;
import service.RealTestService;
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
	
	public RealTestServiceImpl(HistoryDataMapper hisMapper,StrategyMapper strMapper)
	{
		this.hisMapper=hisMapper;
		this.strMapper=strMapper;
	}

	@Override
	public void realTestForToday(RealTestVO vo) {
		List<Double> priceList=new ArrayList<Double>();
		for(int i=0;i<vo.stockList.size();i++)
		{
			double close=0;
			try {
				close=hisMapper.selectHistoryData_new_single(vo.stockList.get(i).siid).getClose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				priceList.add(close);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(close);
		}
	
		List<List<Function>> inOrders=new ArrayList<List<Function>>();
		List<List<Function>> outOrders=new ArrayList<List<Function>>();
		
		for(int i=0;i<vo.stockList.size();i++)
		{
			inOrders.add(new ArrayList<Function>());
			outOrders.add(new ArrayList<Function>());
		}
		
		boolean flagOutI=true;
		boolean flagOutO=true;
		for(int j=0;j<vo.flagList.size();j++)
		{
			boolean flagInI=true;
			boolean flagInO=true;
			Function function=null;
			FunctionResult result=null;
			for(int h=0;h<vo.flagList.get(j).size();h++)
			{
				Function function0=vo.flagList.get(j).get(h);
				FunctionResult upFRI=function0.getResultUpI();
				FunctionResult downFRI=function0.getResultDownI();
				FunctionResult upFRO=function0.getResultUpO();
				FunctionResult downFRO=function0.getResultDownO();
				
				function=vo.flagList.get(j).get(h);
				result=function.getResult();
			
				switch(result.location.get(0))
				{
				case BOOLEAN://boolean
					break;
				case INT://int
					break;
				case DOUBLE://double
					//触发订单
					switch(vo.orderType.function)
					{
					case "Share"://股数订单
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

		System.out.println(vo.stockList);
		System.out.println(priceList);
		
		if(flagOutI)
		{
			for(int i=0;i<vo.stockList.size();i++)
			{
				inOrders.get(i).add(new ShareFunction(1,vo.stockList.get(i).siid,1000,priceList.get(i)));//暂用1000
			}
		}
		else
		{
			for(int i=0;i<vo.stockList.size();i++)
			{
				inOrders.get(i).add(null);//如果不交易传入null
			}
		}
		if(flagOutO)
		{
			for(int i=0;i<vo.stockList.size();i++)
			{
				outOrders.get(i).add(new ShareFunction(-1,vo.stockList.get(i).siid,1000,priceList.get(i)));
			}
		}
		else
		{
			for(int i=0;i<vo.stockList.size();i++)
			{
				outOrders.get(i).add(null);//如果不交易传入null
			}
		}
	
		switch(vo.orderType.getFunction())
		{
		case "Share":
			//产生交易
			for(int i=0;i<inOrders.get(0).size();i++)
			{//每次应交易情况
				double capitaltoday=0;//今日股票资本
				double inprice=0;//今日买入总价
				double outprice=0;//今日卖出总价
				
				for(int j=0;j<vo.stockList.size()-1;j++)
				{//每只股票
					ShareFunction order=(ShareFunction)inOrders.get(j).get(i);
					if(inOrders.get(j).get(i)!=null)
					{
						if(order.order==1)
						{
							if(vo.cash-order.share*order.price*(1+inTaxRatio)<0)
							{
								int share=(int) (vo.cash*(1-inTaxRatio)/order.price);
								vo.cash-=share*order.price*(1+inTaxRatio);
								vo.numlist.set(j,vo.numlist.get(j)+share);//加仓
								inprice+=share*order.price;
							}
							else
							{
								vo.cash-=order.share*order.price*(1+inTaxRatio);
								vo.numlist.set(j,vo.numlist.get(j)+order.share);//加仓
								inprice+=order.share*order.price;
							}
						}
						else if(order.order==-1)
						{
							if(order.share>=vo.numlist.get(j))
							{
								vo.cash+=order.share*order.price*(1-outTaxRatio);
								vo.numlist.set(j,vo.numlist.get(j)-order.share);
								outprice+=order.share*order.price;
							}
							else
							{
								vo.cash+=vo.numlist.get(j)*order.price*(1-outTaxRatio);
								vo.numlist.set(j,0);//减仓
								outprice+=vo.numlist.get(j)*order.price;
							}
						}
					}
					capitaltoday+=vo.numlist.get(j)*order.price;
				}
				
				vo.capital.add(new DateDouble(Calendar.getInstance().getTimeInMillis(),capitaltoday+vo.cash));
			}
			break;
		}
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
	
}
