package mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.UserInf;

public class UserInfMapperTest {
	public UserInfMapper userInfMapper;
	public UserInfMapperTest()
	{
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		userInfMapper=(UserInfMapper) applicationContext1.getBean("userInfMapper");
	}
	public void signUp()
	{
		UserInf userInf=new UserInf("test","000");
		try {
			userInfMapper.signUp(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new UserInfMapperTest().signUp();
	}
}
