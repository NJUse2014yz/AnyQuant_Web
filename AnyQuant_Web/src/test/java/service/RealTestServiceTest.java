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
import function.OrderFunction;
import function.ResultType;
import function.TestFunction;
import function.choose.ChooseStock;
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
	
	public void initRealTest()
	{
		instance.initRealTest("u1","u1","s1",50000,1);
	}
	public void realTestForToday()
	{
		RealTestVO vo=new RealTestVO();
		vo.cash=100000;
		vo.n=1;
		vo.stockList.add(new ChooseStock("test1",0.2));
		vo.stockList.add(new ChooseStock("test2",0.8));
		List<List<Function>> flagList=new ArrayList<List<Function>>();
		flagList.add(new ArrayList<Function>());
		FunctionResult resultUpI=new FunctionResult();
		resultUpI.location.add(ResultType.INT);
		resultUpI.rI=1;
		FunctionResult resultDownI=new FunctionResult();
		resultDownI.location.add(ResultType.INT);
		resultDownI.rI=1;
		FunctionResult resultUpO=new FunctionResult();
		resultUpO.location.add(ResultType.INT);
		resultUpO.rI=0;
		FunctionResult resultDownO=new FunctionResult();
		resultDownO.location.add(ResultType.INT);
		resultDownO.rI=0;
		
		TestFunction testF=new TestFunction();
		testF.setResultUpI(resultUpI);
		testF.setResultUpO(resultUpO);
		testF.setResultDownI(resultDownI);
		testF.setResultDownO(resultDownO);
		flagList.get(0).add(testF);
		
		OrderFunction orderType=new OrderFunction();
		vo.flags.add(new Flag(orderType,flagList));
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
	public void saveRealTest() {
		StrategyVO strategy=new StrategyServiceImpl(strategyMapper,functionMapper).getSingleStrategy("u1","u1","s1");
		RealTestVO vo=strategy.getRealTest();
		
		instance.realTestForToday(vo);
		instance.saveRealTest(strategy.userName, strategy.createrName, strategy.strategyName, vo);
	}
	public static void main(String[] args)
	{
		RealTestServiceTest test=new RealTestServiceTest();
//		test.initRealTest();
//		test.saveRealTest();
		test.realTestForToday();
	}
}
