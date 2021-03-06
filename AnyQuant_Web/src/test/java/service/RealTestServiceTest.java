package service;

import java.util.ArrayList;
import java.util.List;

import mapper.FunctionMapper;
import mapper.HistoryDataMapper;
import mapper.StrategyMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.order.ShareFunction;
import function.risk.StandardPercentFunction;
import function.risk.StandardPercentVO;
import service.impl.RealTestServiceImpl;
import service.impl.StrategyServiceImpl;
import vo.Flag;
import vo.RealTestVO;
import vo.StrategyVO;

public class RealTestServiceTest{
	public static ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static StrategyMapper strategyMapper=(StrategyMapper) applicationContext1.getBean("strategyMapper");
	public static FunctionMapper functionMapper=(FunctionMapper) applicationContext1.getBean("functionMapper");
	public static HistoryDataMapper historyMapper=(HistoryDataMapper) applicationContext1.getBean("historyDataMapper");
	public RealTestService instance=new RealTestServiceImpl(historyMapper,strategyMapper);
	
	public void initRealTest1()
	{
		instance.initRealTest("admin","admin","波浪理论",100000,1);
	}
	
	public void initRealTest2()
	{
		instance.initRealTest("admin","admin","五日金叉策略",100000,1);
	}
	
	public void realTestForToday()
	{
		RealTestVO vo=new RealTestVO();
		vo.cash=100000;
		vo.n=1;
		vo.stockList.add(new ChooseStock("sh600004",0.2));
		vo.stockList.add(new ChooseStock("sh600008",0.8));
		List<List<Function>> flagList=new ArrayList<List<Function>>();
		flagList.add(new ArrayList<Function>());
		FunctionResult resultUpI=new FunctionResult();
		resultUpI.location.add(ResultType.INT.getCode());
		resultUpI.rI=1;
		FunctionResult resultDownI=new FunctionResult();
		resultDownI.location.add(ResultType.INT.getCode());
		resultDownI.rI=1;
		FunctionResult resultUpO=new FunctionResult();
		resultUpO.location.add(ResultType.INT.getCode());
		resultUpO.rI=0;
		FunctionResult resultDownO=new FunctionResult();
		resultDownO.location.add(ResultType.INT.getCode());
		resultDownO.rI=0;
		
		TrendFunction testF=new TrendFunction();
		testF.setResultUpI(resultUpI);
		testF.setResultUpO(resultUpO);
		testF.setResultDownI(resultDownI);
		testF.setResultDownO(resultDownO);
		flagList.get(0).add(testF);
		
		ShareFunction orderType=new ShareFunction();
		orderType.siid="sh600004";
		vo.flags.add(new Flag(orderType,flagList));
		StandardPercentVO spfvo=new StandardPercentVO();
		spfvo.attribute="close";
		spfvo.sign=-1;
		spfvo.percent=0.8;
		spfvo.standard="m20";
		vo.risk.get(0).add(new StandardPercentFunction(spfvo));
		vo.numlist.add(0);
		vo.numlist.add(0);
		instance.realTestForToday(vo);
		System.out.println(vo);
		instance.realTestForToday(vo);
		System.out.println(vo);
		instance.realTestForToday(vo);
		System.out.println(vo);
		instance.realTestForToday(vo);
		System.out.println(vo);
	}
	
	public void saveRealTest1() {
		StrategyServiceImpl stImpl=new StrategyServiceImpl();
		stImpl.strategyMapper=strategyMapper;
		stImpl.functionMapper=functionMapper;
		StrategyVO strategy=stImpl.getSingleStrategy("admin","admin","波浪理论");
		RealTestVO vo=strategy.getRealTest();
		
		System.out.println(instance.realTestForToday(vo));
		instance.saveRealTest(strategy.userName, strategy.createrName, strategy.strategyName, vo);
	}
	
	public void saveRealTest2() {
		StrategyServiceImpl stImpl=new StrategyServiceImpl();
		stImpl.strategyMapper=strategyMapper;
		stImpl.functionMapper=functionMapper;
		StrategyVO strategy=stImpl.getSingleStrategy("admin","admin","五日金叉策略");
		RealTestVO vo=strategy.getRealTest();
		
		System.out.println(instance.realTestForToday(vo));
		instance.saveRealTest(strategy.userName, strategy.createrName, strategy.strategyName, vo);
	}
	
	public static void main(String[] args)
	{
		RealTestServiceTest test=new RealTestServiceTest();
//		test.saveRealTest1();
		test.saveRealTest2();
	}
}
