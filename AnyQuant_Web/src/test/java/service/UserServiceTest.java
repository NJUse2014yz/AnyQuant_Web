package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
	public UserService userService;//直接new一个impl对象就无法实现注解，mapper为空
	public UserServiceTest()
	{
		ApplicationContext applicationContext2 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-service.xml");
		userService=(UserService) applicationContext2.getBean("UserService");
	}
	public void signUp()
	{
		try {
			userService.addUser("test1", "666");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new UserServiceTest().signUp();
	}
}
