package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.UserInfMapper;
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

	@Override
	public void changeUserId(String OldUserid, String newUserid) throws Exception {
		// TODO Auto-generated method stub
		//假设界面已经判断newUserid非空
		
	}

	@Override
	public void changePassword(String Userid, String OldPassword, String NewPassword) throws Exception {
		// TODO Auto-generated method stub
		String old_Pass=OldPassword.trim();
		String new_Pass=NewPassword.trim();
		
		UserInf userInf=null;
			userInf=userInfMapper.select(Userid);
		if(userInf.getPassword().equals(old_Pass))
		{
			//修改密码
		}else{
			throw new Exception();
		}
		
	}
}
