package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import data.impl.DataServiceImpl;
import po.StockInf;
import service.impl.StrategyServiceImpl;
import vo.ChooseStock;
import vo.SelfStrategy;
import function.Function;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.TrendFunction;
import function.flag.TrendVO;

public class StrategyServiceTest {
	public static StrategyService instance=new StrategyServiceImpl();
	public static void makeStrategy()
	{
		String siid="sh600004";
		
		//userName
		String userName="u1";
		//strategyName
		String strategyName="test";
		//choose
		int num=100;
		PairVO pairVO=new PairVO(siid,num);
		PairFunction pair=new PairFunction(pairVO);
//		List<FunctionInfo> list=new FunctionServiceImpl().choose(Choose.PAIR);
//		Map map=new HashMap();
//		for(int i=0;i<list.size();i++)
//		{
//			switch(list.get(i).name)
//			{
//			case "sid":
//				map.put("sid",siid);
//			case "num":
//				map.put("num",num);
//			}
//		}
		List<Function> choose=new ArrayList<Function>();
		choose.add(pair);
		//chooseStock
		StockInf stockInf=null;
		try {
			stockInf = new DataServiceImpl().getStockInf_sid(siid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String partner=stockInf.getPartner1();
		List<ChooseStock> stockList=new ArrayList<ChooseStock>();
		stockList.add(new ChooseStock(siid,50));
		stockList.add(new ChooseStock(partner,50));
		//flag
		String attribute="close";
		Date start=new Date(2015-1900,0,1);
		Date end=new Date(Calendar.getInstance().getTimeInMillis());
		Double standard=0.5;
		TrendVO trendVO=new TrendVO(siid,attribute,start.getTime(),end.getTime(),standard);
		TrendFunction trend=new TrendFunction(trendVO);
		List<Function> flag=new ArrayList<Function>();
		flag.add(trend);
		
		SelfStrategy strategy=new SelfStrategy(userName,strategyName,stockList,choose,flag);
		instance.makeStrategy(strategy);
	}
	public static void main(String[] args)
	{
		StrategyServiceTest.makeStrategy();
	}
}
