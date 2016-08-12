package service;


public interface UserService {
	//查询用户名是否存在
	public boolean UserNameExists(String Userid)throws Exception;
	//增加用户账户
	public void addUser(String Userid,String password) throws Exception;
	//登录
	public boolean LoginUser(String Userid,String password) throws Exception;
	//修改用户名
	public void modifyUserId(String OldUserid,String newUserid)throws Exception;
	//修改密码
	public void modifyPassword(String Userid,String OldPassword,String newPassword)throws Exception;
	//加分
	public void modifyScore(String Userid,int add_score)throws Exception;
}