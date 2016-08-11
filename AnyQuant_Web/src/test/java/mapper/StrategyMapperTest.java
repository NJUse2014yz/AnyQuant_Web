package mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Strategy;

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
	public static void main(String[] args)
	{
		StrategyMapperTest.insert();
	}
}
