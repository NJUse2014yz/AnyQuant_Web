package mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.ModifyPack;
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
	public void select()
	{
		try {
			System.out.println(userInfMapper.select("u7"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("JJJJJJHHHHHHHHH");
		}
	}
	public void modifyUserName()
	{
		ModifyPack modifyPack=new ModifyPack();
		modifyPack.setStr_key("test");
		modifyPack.setStr_new("yest");
		try {
			userInfMapper.modifyUserName(modifyPack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void modifyPassword()
	{
		UserInf userInf=new UserInf();
		userInf.setUserName("yest");
		userInf.setPassword("666");
		try {
			userInfMapper.modifyPassword(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void modifyScoreRank()
	{
		UserInf userInf=new UserInf();
		userInf.setUserName("yest");
		userInf.setScore(2);
		userInf.setRank(0);//等级没有提高也一定要把原等级传入
		try {
			userInfMapper.modifyScoreRank(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new UserInfMapperTest().select();
//		new UserInfMapperTest().modifyUserName();
//		new UserInfMapperTest().modifyPassword();
//		new UserInfMapperTest().modifyScoreRank();
	}
}
