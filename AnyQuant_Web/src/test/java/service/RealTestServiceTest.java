package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import mapper.FunctionMapper;
import mapper.HistoryDataMapper;
import mapper.StrategyMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import function.Function;
import backtest.DateDouble;
import service.impl.RealTestServiceImpl;
import service.impl.StrategyServiceImpl;
import tool.JsonExchangeTool;
import vo.RealTestVO;
import vo.StrategyVO;

public class RealTestServiceTest{
	public static ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static StrategyMapper strategyMapper=(StrategyMapper) applicationContext1.getBean("strategyMapper");
	public static FunctionMapper functionMapper=(FunctionMapper) applicationContext1.getBean("functionMapper");
	public static HistoryDataMapper historyMapper=(HistoryDataMapper) applicationContext1.getBean("historyDataMapper");
	public RealTestService instance=new RealTestServiceImpl(historyMapper,strategyMapper);
	
	public void saveRealTest() {
		StrategyVO strategy=new StrategyServiceImpl(strategyMapper,functionMapper).getSingleStrategy("u1","u1","s1");
		RealTestVO vo=strategy.getRealTest();
		List<DateDouble> capital=new ArrayList<DateDouble>();
		capital.add(new DateDouble(new Date(2016-1900,7,17).getTime(),50000));
		vo.setCapital(capital);
		vo.setCash(50000);
		vo.flagList=strategy.getFlagList();
		vo.setN(1);
		List<Integer> numList=new ArrayList<Integer>();
		for(int i=0;i<strategy.getStockList().size();i++)
		{
			numList.add(0);
		}
		vo.setNumList(numList);
		vo.orderType=strategy.getOrderType();
		vo.stockList=strategy.getStockList();
		
		instance.realTestForToday(vo);
		instance.saveRealTest(strategy.userName, strategy.createrName, strategy.strategyName, vo);
	}
	public static void main(String[] args)
	{
		new RealTestServiceTest().saveRealTest();
	}
}
