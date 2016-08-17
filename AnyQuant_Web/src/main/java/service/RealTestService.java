package service;

import vo.RealTestVO;

public interface RealTestService {
	/**对今天的市场进行实测，结果直接影响传入的VO*/
	public void realTestForToday(RealTestVO vo);
	/**将实测结果存储*/
	public void saveRealTest(String userName,String createrName,String strategyName,RealTestVO vo);
}
