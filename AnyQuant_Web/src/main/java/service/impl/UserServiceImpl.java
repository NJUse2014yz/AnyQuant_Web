package service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ServiceTool.UserRankHelper;
import bl.RankHelper;
import mapper.UserInfMapper;
import po.ModifyPack;
import po.StrategySearch;
import po.UserInf;
import service.UserService;
import tool.ListTool;
import vo.UserInfVO;

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
	public UserInf getUserInf(String Userid) throws Exception {
		// TODO Auto-generated method stub
		UserInf userInf = null;
		try {
			userInf = userInfMapper.select(Userid);
		} catch (Exception e) {
			e.printStackTrace();
//			return false;
		}
		return userInf;
	}
	

	@Override
	public void modifyUserId(String OldUserid, String newUserid) throws Exception {
		// 假设界面已经判断newUserid非空
		ModifyPack modifyPack = new ModifyPack();
		modifyPack.setStr_key(OldUserid);
		modifyPack.setStr_new(newUserid);
			userInfMapper.modifyUserName(modifyPack);
	}
	@Override
	public void modifyPassword(String Userid, String OldPassword, String NewPassword) throws Exception {
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
	
	@Override
	public void addStock(String userName,String siid){
		UserInf userInf=null;
		try {
			userInf=userInfMapper.select(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray jArray=JSONArray.fromObject(userInf.stocks);
		jArray.add(siid);
		userInf.stocks=jArray.toString();
		try {
			userInfMapper.modifyStocks(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<String> queryStocks(String userName) {
		UserInf userInf=null;
		try {
			userInf=userInfMapper.select(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> stocks=new ArrayList<String>();
		JSONArray jArray=JSONArray.fromObject(userInf.stocks);
		for(int i=0;i<jArray.size();i++)
		{
			stocks.add(jArray.getString(i));
		}
		return stocks;
	}

	@Override
	public int changeLevel(String userName) {
		StrategySearch search=new StrategySearch();
		search.setUserName(userName);
		double score=0;
		try {
			score=ListTool.strategyMapper.selectScore(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int rank=0;
		//升级
		if(score>=200&&score<800)
		{
			rank=1;
		}
		else if(score>=800&&score<2000)
		{
			rank=2;
		}
		else if(score>=2000&&score<4000)
		{
			rank=3;
		}
		else
		{
			rank=4;
		}
		UserInf userInf=new UserInf();
		userInf.setUserName(userName);
		userInf.setRank(rank);
		try {
			ListTool.userInfMapper.modifyScoreRank(userInf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rank;
	}

	@Override
	public UserInfVO queryUser(String userName) {
		UserInf userInf=null;
		try {
			userInf=userInfMapper.select(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserInfVO vo=new UserInfVO(userInf);
		return vo;
	}
	
	public static void main(String[] args) throws Exception {
		UserServiceImpl user=new UserServiceImpl();
//		user.modifyScore("u4",1000);
//		System.out.println(user.UserNameExists("u2"));
//		System.out.println(user.LoginUser("u7","77777"));
		System.out.println(user.getUserInf("congye6"));
		}

}


