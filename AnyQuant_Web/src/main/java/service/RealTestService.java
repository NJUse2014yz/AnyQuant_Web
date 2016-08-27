package service;


import java.util.List;

import vo.RealTestVO;

public interface RealTestService {
	/**对今天的市场进行实测，结果直接影响传入的VO*/
	public String realTestForToday(RealTestVO vo);
	/**将实测结果存储*/
	public void saveRealTest(String userName,String createrName,String strategyName,RealTestVO vo);
	/**初始化实测参数*/
	public void initRealTest(String userName,String createrName,String strategyName,double cash,int n);
	/**查看实测历史*/
	public List<String> queryHistory(String userName,String createrName,String strategyName);
}
