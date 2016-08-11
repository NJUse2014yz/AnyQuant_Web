package service;

import java.util.List;

import po.Strategy;

public interface StrategyService {
	/**定制策略*/
	public void makeStrategy(Strategy strategy);
	/**获取保存的策略*/
	public Strategy getSingleStrategy(String userName,String createrName,String strategyName);
	/**获取自己的策略*/
	public List<Strategy> getSelfStrategy(String userName);
	/**获取收藏的策略*/
	public List<Strategy> getSaveStrategy(String userName);
}
