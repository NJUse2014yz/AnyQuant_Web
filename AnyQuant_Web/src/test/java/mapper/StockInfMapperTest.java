package mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StockInfMapperTest {
	public static StockInfMapper instance;
	public static void selectStockPair()
	{
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		instance=(StockInfMapper) applicationContext1.getBean("stockInfMapper");
		try {
			System.out.println(instance.selectStockPair());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		StockInfMapperTest.selectStockPair();
	}
}
