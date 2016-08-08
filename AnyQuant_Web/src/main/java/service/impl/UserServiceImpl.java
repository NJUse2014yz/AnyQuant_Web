package service.impl;

import mapper.UserInfMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.UserInf;
import service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserInfMapper userInfMapper;
	
	@Override
	// 增加用户账户
	public void addUser(String Userid, String password){
		UserInf userInf=new UserInf(Userid,password);
		try {
			userInfMapper.signUp(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// 登录
	public boolean LoginUser(String Userid, String password){
		UserInf userInf=null;
		try {
			userInf=userInfMapper.select(Userid);
		} catch (Exception e) {
			return false;
		}
		if(userInf.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
}
