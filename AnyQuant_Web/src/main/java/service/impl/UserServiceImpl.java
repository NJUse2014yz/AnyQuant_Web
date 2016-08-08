package service.impl;

import javax.annotation.Resource;

import mapper.UserInfMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.UserInf;
import service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserInfMapper userInfMapper;
	
	@Override
	// 增加用户账户
	public void addUser(String Userid, String password) throws Exception {
		UserInf userInf=new UserInf(Userid,password);
		userInfMapper.signUp(userInf);
	}

	@Override
	// 登录
	public boolean LoginUser(String Userid, String password) throws Exception {
		return false;
	}
}
