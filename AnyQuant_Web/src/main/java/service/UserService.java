package service;

import java.util.List;

import po.UserInf;
import vo.UserInfVO;


public interface UserService {
	//查询用户名是否存在
	public boolean UserNameExists(String Userid)throws Exception;
	//增加用户账户
	public void addUser(String Userid,String password) throws Exception;
	//登录
	public boolean LoginUser(String Userid,String password) throws Exception;
	//获得用户信息
	public UserInf getUserInf(String Userid)throws Exception;
	//修改用户名
	public void modifyUserId(String OldUserid,String newUserid)throws Exception;
	//修改密码
	public void modifyPassword(String Userid,String OldPassword,String newPassword)throws Exception;
	//加分
	public void modifyScore(String Userid,int add_score)throws Exception;
	//添加关注的股票
	public void addStock(String userName,String siid);
	//查询关注的股票
	public List<String> queryStocks(String userName);
	//改变等级
	public int changeLevel(String userName);
	//查询用户信息
	public UserInfVO queryUser(String userName);
}