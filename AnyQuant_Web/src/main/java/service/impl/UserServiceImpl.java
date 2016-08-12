package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ServiceTool.UserRankHelper;
import bl.RankHelper;
import mapper.UserInfMapper;
import po.ModifyPack;
import po.UserInf;
import service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserInfMapper userInfMapper;
	
	
	public UserServiceImpl() {
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		userInfMapper=(UserInfMapper) applicationContext1.getBean("userInfMapper");
	}

	@Override
	public boolean UserNameExists(String Userid) throws Exception {
		UserInf userInf = null;
		try {
			userInf = userInfMapper.select(Userid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if(userInf==null){
			return false;
		}
		return true;
	}
	
	@Override
	// 增加用户账户
	public void addUser(String Userid, String password) {
		UserInf userInf = new UserInf(Userid, password);
		try {
			userInfMapper.signUp(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// 登录
	public boolean LoginUser(String Userid, String password) {
		UserInf userInf = null;
		try {
			userInf = userInfMapper.select(Userid);
		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}
		if(userInf==null){
			return false;
		}
		if (userInf.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void modifyUserId(String OldUserid, String newUserid) throws Exception {
		// TODO Auto-generated method stub
		// 假设界面已经判断newUserid非空
		ModifyPack modifyPack = new ModifyPack();
		modifyPack.setStr_key(OldUserid);
		modifyPack.setStr_new(newUserid);
			userInfMapper.modifyUserName(modifyPack);
	}
	@Override
	public void modifyPassword(String Userid, String OldPassword, String NewPassword) throws Exception {
		// TODO Auto-generated method stub
		String old_Pass = OldPassword.trim();
		String new_Pass = NewPassword.trim();

		UserInf userInf = null;
			userInf = userInfMapper.select(Userid);
		//判断旧密码输入是否正确
		if (userInf.getPassword().equals(old_Pass)) {
			// 修改密码
			userInf.setUserName(Userid);
			userInf.setPassword(NewPassword);
			userInfMapper.modifyPassword(userInf);
		} else {
			System.out.println("the Old Password is wrong!");
			throw new Exception();
		}

	}

	@Override
	public void modifyScore(String Userid, int add_score) throws Exception {

		// TODO Auto-generated method stub
		UserInf userInf=null;
		try {
			userInf = userInfMapper.select(Userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long cur_score=userInf.getScore()+add_score;
		userInf.setScore(cur_score);
		userInf.setRank(UserRankHelper.getRank(cur_score));
		try {
			userInfMapper.modifyScoreRank(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		UserServiceImpl user=new UserServiceImpl();
//		user.modifyScore("u4",1000);
//		System.out.println(user.UserNameExists("u2"));
		System.out.println(user.LoginUser("u7","77777"));
		}

	
}
