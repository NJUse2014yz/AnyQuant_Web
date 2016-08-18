package service;

import mapper.FunctionMapper;
import mapper.HistoryDataMapper;
import mapper.StrategyMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.impl.RealTestServiceImpl;
import service.impl.StrategyServiceImpl;
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
		test.saveRealTest();
	}
}
