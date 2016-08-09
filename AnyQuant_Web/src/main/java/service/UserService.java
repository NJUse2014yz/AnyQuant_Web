package service;


public interface UserService {
	//增加用户账户
	public void addUser(String Userid,String password) throws Exception;
	//登录
	public boolean LoginUser(String Userid,String password) throws Exception;
	//修改用户名
	public void changeUserId(String OldUserid,String newUserid)throws Exception;
	//修改密码
	public void changePassword(String Userid,String OldPassword,String newPassword)throws Exception;
	
}