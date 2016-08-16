package mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import function.Function;
import function.choose.ChooseStock;
import po.Strategy;
import po.StrategySearch;
import tool.JsonExchangeTool;

public class StrategyMapperTest {
	public static StrategyMapper instance;
	public static void insert()
	{
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		instance=(StrategyMapper) applicationContext1.getBean("strategyMapper");
		Strategy strategy=new Strategy();
		strategy.userName="u1";
		strategy.createrName="u1";
		strategy.strategyName="s1";
		try {
			instance.insert(strategy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectStrategy()
	{
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		instance=(StrategyMapper) applicationContext1.getBean("strategyMapper");
		StrategySearch search=new StrategySearch();
		search.setUserName("u1");
		search.setCreaterName("u1");
		search.setStrategyName("s1");
		Strategy strategy=null;
		try {
			strategy=instance.selectStrategy(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String userName=strategy.userName;
		String createrName=strategy.createrName;
		String strategyName=strategy.strategyName;
		List<ChooseStock> stockList=JsonExchangeTool.getStock(strategy.stockList);
		List<Function> choose=JsonExchangeTool.getFunction(strategy.choose).get(0);//?
		List<List<Function>> flag=JsonExchangeTool.getFunction(strategy.flag);
		System.out.println(userName);
		System.out.println(createrName);
		System.out.println(strategyName);
		System.out.println(stockList);
		System.out.println(choose);
		System.out.println(flag);
	}
	public static void selectSelfStrategy()
	{
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		instance=(StrategyMapper) applicationContext1.getBean("strategyMapper");
		StrategySearch search=new StrategySearch();
		search.setUserName("u1");
		List<Strategy> selfStrategyList=null;
		try {
			selfStrategyList=instance.selectSelf(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<selfStrategyList.size();i++)
		{
			String userName=selfStrategyList.get(i).userName;
			String createrName=selfStrategyList.get(i).createrName;
			String strategyName=selfStrategyList.get(i).strategyName;
			List<ChooseStock> stockList=JsonExchangeTool.getStock(selfStrategyList.get(i).stockList);
			List<Function> choose=JsonExchangeTool.getFunction(selfStrategyList.get(i).choose).get(0);
			List<List<Function>> flag=JsonExchangeTool.getFunction(selfStrategyList.get(i).flag);		
			System.out.println(userName);
			System.out.println(createrName);
			System.out.println(strategyName);
			System.out.println(stockList);
			System.out.println(choose);
			System.out.println(flag);
		}
	}
	public static void selectSaveStrategy()
	{
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		instance=(StrategyMapper) applicationContext1.getBean("strategyMapper");
		StrategySearch search=new StrategySearch();
		search.setUserName("u2");
		List<Strategy> saveStrategyList=null;
		try {
			saveStrategyList=instance.selectSave(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<saveStrategyList.size();i++)
		{
			String userName=saveStrategyList.get(i).userName;
			String createrName=saveStrategyList.get(i).createrName;
			String strategyName=saveStrategyList.get(i).strategyName;
			List<ChooseStock> stockList=JsonExchangeTool.getStock(saveStrategyList.get(i).stockList);
			List<Function> choose=JsonExchangeTool.getFunction(saveStrategyList.get(i).choose).get(0);
			List<List<Function>> flag=JsonExchangeTool.getFunction(saveStrategyList.get(i).flag);		
			System.out.println(userName);
			System.out.println(createrName);
			System.out.println(strategyName);
			System.out.println(stockList);
			System.out.println(choose);
			System.out.println(flag);
		}
	}
	public static void main(String[] args)
	{
//		StrategyMapperTest.insert();
//		StrategyMapperTest.selectStrategy();
//		StrategyMapperTest.selectSelfStrategy();
//		StrategyMapperTest.selectSaveStrategy();
	}
}
