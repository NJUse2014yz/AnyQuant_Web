package mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HistoryDataMapperTest {
	public static HistoryDataMapper instance;
	public static void select_new()
	{
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		instance=(HistoryDataMapper) applicationContext1.getBean("historyDataMapper");
		try {
			System.out.println(instance.selectHistoryData_new_single("sh600004"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		HistoryDataMapperTest.select_new();
	}
}
