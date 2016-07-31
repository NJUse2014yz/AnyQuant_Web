package service;


public interface UserService {
	//增加用户账户
	public void addUser(String Userid,String password) throws Exception;
	//登录
	public boolean LoginUser(String Userid,String password) throws Exception;
	
}