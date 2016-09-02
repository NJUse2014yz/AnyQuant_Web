package service;

import mapper.FunctionMapper;
import mapper.HistoryDataMapper;
import mapper.StrategyMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.impl.BackTestServiceImpl;
import service.impl.StrategyServiceImpl;
import vo.StrategyVO;

public class BackTestServiceTest {
	public static BackTestService instance=new BackTestServiceImpl();
	public static ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static StrategyMapper strategyMapper=(StrategyMapper) applicationContext1.getBean("strategyMapper");
	public static FunctionMapper functionMapper=(FunctionMapper) applicationContext1.getBean("functionMapper");
	public static HistoryDataMapper historyMapper=(HistoryDataMapper) applicationContext1.getBean("historyDataMapper");
	
	public static void test()
	{
		StrategyServiceImpl stImpl=new StrategyServiceImpl();
		stImpl.strategyMapper=strategyMapper;
		stImpl.functionMapper=functionMapper;
		StrategyVO strategy=stImpl.getSingleStrategy("admin","admin","波浪理论");
		
		try {
			instance.backtest(strategy.stockList, strategy.flags, 1, strategy.flags.get(0), strategy.risk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		BackTestServiceTest.test();
	}
}
