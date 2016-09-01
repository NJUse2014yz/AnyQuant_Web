package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backtest.TestReport;
import mapper.FunctionMapper;
import mapper.QuotaInfMapper;
import mapper.StrategyInfMapper;
import mapper.StrategyMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import data.impl.DataServiceImpl;
import po.StockInf;
import po.Strategy;
import service.impl.BackTestServiceImpl;
import service.impl.StrategyServiceImpl;
import tool.JsonExchangeTool;
import vo.Attribute;
import vo.Flag;
import vo.RealTestVO;
import vo.StrategyVO;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.choose.AreaFunction;
import function.choose.AreaVO;
import function.choose.ChooseStock;
import function.choose.IndustryFunction;
import function.choose.IndustryVO;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.DataFunction;
import function.flag.MaxMinFunction;
import function.flag.TrendFunction;
import function.flag.TrendVO;
import function.order.ShareFunction;
import function.risk.StandardPercentFunction;
import function.risk.StandardPercentVO;
import function.tool.AddFunction;
import function.tool.DivideFunction;
import function.tool.MeanFunction;
import function.tool.MinusFunction;
import function.tool.MultipleFunction;

public class StrategyServiceTest {
	public static ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static FunctionMapper functionMapper=(FunctionMapper) applicationContext1.getBean("functionMapper");
	public static StrategyMapper strategyMapper=(StrategyMapper) applicationContext1.getBean("strategyMapper");
	public static StrategyInfMapper strategyInfMapper=(StrategyInfMapper) applicationContext1.getBean("strategyInfMapper");
	public static QuotaInfMapper quotaInfMapper=(QuotaInfMapper) applicationContext1.getBean("quotaInfMapper");
	public static StrategyService instance=new StrategyServiceImpl(strategyMapper,functionMapper,strategyInfMapper,quotaInfMapper);
	
	public static void chooseStock()
	{
		List<List<Function>> choose=new ArrayList<List<Function>>();
		choose.add(new ArrayList<Function>());
		choose.add(new ArrayList<Function>());
		
		AreaVO areaVO1=new AreaVO("江苏");
		choose.get(0).add(new AreaFunction(areaVO1));
		IndustryVO industryVO=new IndustryVO("商业百货");
		choose.get(0).add(new IndustryFunction(industryVO));
		
		AreaVO areaVO2=new AreaVO("上海");
		choose.get(1).add(new AreaFunction(areaVO2));
//		System.out.println("choose "+choose);
		System.out.println(instance.chooseStock(choose, Calendar.getInstance()));
	}
	public static void makeStrategy()
	{
		StrategyVO strategy=new StrategyVO();
		String siid="sh600004";
		//Name
		strategy.setUserName("admin");
		strategy.setCreaterName("admin");
		strategy.setStrategyName("波浪理论");
		
		//choose
		strategy.setChoose(null);
		
		//stockList
		List<ChooseStock> stockList=new ArrayList<ChooseStock>();
		stockList.add(new ChooseStock(siid,1));
		strategy.setStockList(stockList);
		
		//flag
		List<Flag> flags=new ArrayList<Flag>();
		List<List<Function>> functions=new ArrayList<List<Function>>();
		functions.add(new ArrayList<Function>());
		//==========================以下为趋势买入判断的方法==============================//
		TrendFunction tf1=new TrendFunction(siid,Attribute.close.getCode(),5,10);//以最近5天siid(sh600004)的收盘价的趋势为标志，标准暂写10
			MeanFunction mef1=new MeanFunction();
				DataFunction df2=new DataFunction(siid,Attribute.close.getCode(),5);//得到最近5天的收盘价
			mef1.valueListF=df2;//平均值方法的值列表是由数据方法得到的最近5天的收盘价
		tf1.standardF=mef1;//趋势方法的标准是由平均值方法得到的最近5天收盘价的平均值
		FunctionResult fr1=new FunctionResult();
			fr1.location.add(ResultType.DOUBLE.getCode());
			fr1.rD=0;
		tf1.resultUpI=fr1;//买入上界为趋势为0
		//========================================================================//
		functions.get(0).add(tf1);//首先满足价格在下跌
		//==========================以下为数据值买入判断的方法=============================//
		DataFunction df1=new DataFunction(siid,Attribute.close.getCode(),1);//以最近(昨天)siid(sh600004)的收盘价为标志
			AddFunction af1=new AddFunction();
				MultipleFunction muf1=new MultipleFunction();
					DivideFunction dif1=new DivideFunction();
						MaxMinFunction mmf2=new MaxMinFunction(1,siid,Attribute.close.getCode(),-1);//得到最近的第一个极小值
						MaxMinFunction mmf3=new MaxMinFunction(2,siid,Attribute.close.getCode(),1);//得到最近的第二个极大值
					dif1.v1F=mmf2;//除法的被被数是由极值方法得到的最近的第一个极小值
					dif1.v2F=mmf3;//除法的被被数是由极值方法得到的最近的第二个极大值
				muf1.v2F=dif1;//乘法的第二个乘数是由除法方法得到的最近第一个极小值与最近第二个极大值的商
					MaxMinFunction mmf1=new MaxMinFunction(1,siid,Attribute.close.getCode(),1);//得到最近的第一个极大值
				muf1.v1F=mmf1;//乘法的第一个乘数是由极大值方法得到的最近的第一个极大值
			af1.v1F=muf1;//加法的第一个加数是由乘法方法得到的预计买入价
			af1.v2=0.3;//加法的第二个加数是偏移值0.3	
		df1.resultUpIF=af1;//买入上界方法--加法
			MinusFunction mf1=new MinusFunction();
			mf1.v1F=muf1;//减法的被减数是由乘法方法得到的预计买入价
			mf1.v2=0.3;//减法的减数是偏移值0.3
		df1.resultDownIF=mf1;//买入下界方法--减法
		//=========================================================================//
		functions.get(0).add(df1);//其次满足收盘价达到一定值
		ShareFunction sf=new ShareFunction();
			sf.siid=siid;
			sf.share=50;
		flags.add(new Flag(sf,functions));//订单为达到条件交易siid(sh600004)50股
		strategy.setFlags(flags);
		
		//risk
		StandardPercentFunction spf1=new StandardPercentFunction(siid,-1,Attribute.close.getCode(),Attribute.m20.getCode(),0.5);//当siid(sh600004)的收盘价达到20日均线的0.5时强制清仓
			FunctionResult upFRO=new FunctionResult();
			upFRO.location.add(ResultType.BOOLEAN.getCode());
			upFRO.rB=true;
			FunctionResult downFRO=new FunctionResult();
			downFRO.location.add(ResultType.BOOLEAN.getCode());
			downFRO.rB=true;
		spf1.resultDownO=downFRO;
		spf1.resultUpO=upFRO;
		List<List<Function>> risk=new ArrayList<List<Function>>();
		risk.add(new ArrayList<Function>());
		risk.get(0).add(spf1);
		strategy.setRisk(risk);
		
		instance.makeStrategy(strategy);
	}
	public static void getStrategy()
	{
		StrategyVO strategy=instance.getSingleStrategy("admin","admin","波浪理论");
		
		System.out.println("userName "+strategy.userName);
		System.out.println("createrName "+strategy.createrName);
		System.out.println("strategyName "+strategy.strategyName);
		System.out.println("stockList "+strategy.stockList);
		System.out.println("choose "+strategy.choose);
		System.out.println("risk "+strategy.risk);
		System.out.println("flags "+strategy.flags);
		System.out.println("report "+strategy.report);
		System.out.println("realTest "+strategy.realTest);
		System.out.println("score "+strategy.score);
//		userName admin
//		createrName admin
//		strategyName 波浪理论
//		stockList [ChooseStock [siid=sh600004, percent=1.0]]
//		choose []
//		risk [[StandardPercentFunction [sign=-1, signF=null, attribute=close, attributeF=null, standard=m20, standardF=null, percent=0.5, percentF=null, function=StandardPercent, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=FunctionResult [location=[1], rB=true, rI=0, rD=0.0, rS=, rL=0, rLI=[], rLD=[], rLS=[], rLL=[]], resultUpOF=null, resultDownO=FunctionResult [location=[1], rB=true, rI=0, rD=0.0, rS=, rL=0, rLI=[], rLD=[], rLS=[], rLL=[]], resultDownOF=null]]]
//		flags [
//		Flag [orderType=ShareFunction [share=50.0, shareF=null, price=0.0, priceF=null, function=Share, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null],
//		flagList=[[
//		TrendFunction [attribute=close, attributeF=null, day=5, dayF=null, standard=10.0, standardF=null, function=Trend, siid=sh600004, siidF=null, resultUpI=FunctionResult [location=[3], rB=false, rI=0, rD=0.0, rS=, rL=0, rLI=[], rLD=[], rLS=[], rLL=[]], resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null], 
//		DataFunction [attribute=null, attributeF=null, day=1, dayF=null, function=Data, siid=null, siidF=null, resultUpI=null, resultUpIF=
//		AddFunction [v1=0.0, v1F=
//		MultipleFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		DivideFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=-1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Divide, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Multiple, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.3, v2F=null, function=Add, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, resultDownI=null, resultDownIF=
//		MinusFunction [v1=0.0, v1F=
//		MultipleFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		DivideFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=-1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Divide, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Multiple, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.3, v2F=null, function=Minus, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]]]
//		]
//		]
//		report null
//		realTest RealTestVO [cash=10000.0, n=1, stockList=[ChooseStock [siid=sh600004, percent=1.0]], risk=[[StandardPercentFunction [sign=-1, signF=null, attribute=close, attributeF=null, standard=m20, standardF=null, percent=0.5, percentF=null, function=StandardPercent, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=FunctionResult [location=[1], rB=true, rI=0, rD=0.0, rS=, rL=0, rLI=[], rLD=[], rLS=[], rLL=[]], resultUpOF=null, resultDownO=FunctionResult [location=[1], rB=true, rI=0, rD=0.0, rS=, rL=0, rLI=[], rLD=[], rLS=[], rLL=[]], resultDownOF=null]]], flags=[
//		Flag [orderType=ShareFunction [share=50.0, shareF=null, price=0.0, priceF=null, function=Share, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null],
//		flagList=[[
//		TrendFunction [attribute=close, attributeF=null, day=5, dayF=null, standard=10.0, standardF=null, function=Trend, siid=sh600004, siidF=null, resultUpI=FunctionResult [location=[3], rB=false, rI=0, rD=0.0, rS=, rL=0, rLI=[], rLD=[], rLS=[], rLL=[]], resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null], 
//		DataFunction [attribute=null, attributeF=null, day=1, dayF=null, function=Data, siid=null, siidF=null, resultUpI=null, resultUpIF=
//		AddFunction [v1=0.0, v1F=
//		MultipleFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		DivideFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=-1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Divide, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Multiple, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.3, v2F=null, function=Add, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, resultDownI=null, resultDownIF=
//		MinusFunction [v1=0.0, v1F=
//		MultipleFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		DivideFunction [v1=0.0, v1F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=-1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.0, v2F=
//		MaxMinFunction [attribute=null, attributeF=null, mm=1, mmF=null, num=0, numF=null, loc=0, locF=null, function=MaxMin, siid=sh600004, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Divide, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, function=Multiple, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, v2=0.3, v2F=null, function=Minus, siid=null, siidF=null, resultUpI=null, resultUpIF=null, resultDownI=null, resultDownIF=null, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]
//		, resultUpO=null, resultUpOF=null, resultDownO=null, resultDownOF=null]]]
//		]
//		], numlist=[], capital=[], history=[]]
//		score 0.0
	}
	public static void getSelfStrategy()
	{
		List<StrategyVO> selfStrategyList=instance.getSelfStrategy("u1");
		for(int i=0;i<selfStrategyList.size();i++)
		{
			String userName=selfStrategyList.get(i).userName;
			String createrName=selfStrategyList.get(i).createrName;
			String strategyName=selfStrategyList.get(i).strategyName;
			List<ChooseStock> stockList=selfStrategyList.get(i).stockList;
			List<Function> choose=selfStrategyList.get(i).choose.get(0);
			List<Flag> flag=selfStrategyList.get(i).flags;
			System.out.println(userName);
			System.out.println(createrName);
			System.out.println(strategyName);
			System.out.println(stockList);
			System.out.println(choose);
			System.out.println(flag);
		}
	}
	public static void getSaveStrategy()
	{
		List<StrategyVO> saveStrategyList=instance.getSaveStrategy("u1");
		for(int i=0;i<saveStrategyList.size();i++)
		{
			String userName=saveStrategyList.get(i).userName;
			String createrName=saveStrategyList.get(i).createrName;
			String strategyName=saveStrategyList.get(i).strategyName;
			List<ChooseStock> stockList=saveStrategyList.get(i).stockList;
			List<List<Function>> choose=saveStrategyList.get(i).choose;
			List<Flag> flag=saveStrategyList.get(i).flags;
			List<List<Function>> risk=saveStrategyList.get(i).risk;
			TestReport report=saveStrategyList.get(i).report;
			RealTestVO realTest=saveStrategyList.get(i).realTest;
			double score=saveStrategyList.get(i).score;
			System.out.println(userName);
			System.out.println(createrName);
			System.out.println(strategyName);
			System.out.println(stockList);
			System.out.println(choose);
			System.out.println(flag);
			System.out.println(risk);
			System.out.println(report);
			System.out.println(realTest);
			System.out.println(score);
		}
	}
	public static void getFunction()
	{
		System.out.println(instance.getFunctionDisRnk("Trend"));
		System.out.println(instance.getQuotaDisRnk("m5"));
		System.out.println(instance.getStrategyDisRnk("五日金叉策略"));
	}
	public static void deleteStrategy()
	{
		instance.deleteStrategy("admin","admin","波浪理论");
	}
	public static void saveReport()
	{
		BackTestService backTest=new BackTestServiceImpl(strategyMapper);
		StrategyVO vo=new StrategyServiceImpl(strategyMapper).getSingleStrategy("u1","u1", "s1");
		TestReport report=null;
		try {
			report = backTest.backtest(vo.stockList, vo.flags, 1, vo.flags.get(0), vo.risk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		backTest.saveBackTest("u1", "u1", "s1", report);
		System.out.println(report);
	}
	public static void saveStrategy()
	{
		instance.saveStrategy("u1","u3","s3");
	}
	public static void main(String[] args)
	{
//		StrategyServiceTest.deleteStrategy();
//		StrategyServiceTest.makeStrategy();
//		StrategyServiceTest.getSaveStrategy();
//		StrategyServiceTest.chooseStock();
		StrategyServiceTest.getStrategy();
//		new RealTestServiceTest().initRealTest();
//		new RealTestServiceTest().saveRealTest();
//		StrategyServiceTest.saveReport();
//		System.out.println(new StrategyServiceImpl(strategyMapper).getScore("u1","u1","s1"));
		
//		StrategyServiceTest.getStrategy();
//		StrategyServiceTest.getSelfStrategy();
//		StrategyServiceTest.getSaveStrategy();
//		new StrategyServiceTest().getFunction();
		
		
		
	}
	
}
