package service;

import java.util.List;

import backtest.TestReport;
import po.FunctionDisRnk;
import po.Strategy;
import vo.StrategyVO;

public interface StrategyService {
	/**定制策略*/
	public void makeStrategy(StrategyVO vo);
	/**删除策略*/
	public void deleteStrategy(String userName,String createrName,String strategyName);
	/**收藏策略*/
	public void saveStrategy(String userName,String createrName,String strategyName);
	/**获取保存的策略,用户名.创建用户名.策略名*/
	public StrategyVO getSingleStrategy(String userName,String createrName,String strategyName);
	/**获取自己的策略*/
	public List<StrategyVO> getSelfStrategy(String userName);
	/**获取收藏的策略*/
	public List<StrategyVO> getSaveStrategy(String userName);
	/**获取策略回测报告*/
	public TestReport getReport(String userName,String createrName,String strategyName);
	/**获取单个策略积分*/
	public double getScore(String userName,String createrName,String strategyName);
	/**获取所有策略积分*/
	public double getScoreSum(String userName);
	/**设置某个策略公开性,1为公开*/
	public void setPrivacy(String userName,String createrName,String strategyName,int privacy);
	/**获取某个策略公开性*/
	public int getPrivacy(String userName,String createrName,String strategyName);
	/**编辑策略*/
	public void editStrategy(StrategyVO vo);
	
	/**获取某个等级的所有方法*/
	public List<FunctionDisRnk> getRankFunctions(int rank);
	/**获取某个方法的描述、类别和等级*/
	public FunctionDisRnk getFunctionDisRnk(String name);
	/**获取某个类别的所有方法*/
	public List<FunctionDisRnk> getTypeFunction(String type);
	/**获取某个等级的某个类别的所有方法*/
	public List<FunctionDisRnk> getTRFunction(FunctionDisRnk fdr);
	
	/**获取某个等级的所有策略*/
	public List<FunctionDisRnk> getRankStrategys(int rank);
	/**获取某个策略的描述、类别和等级*/
	public FunctionDisRnk getStrategyDisRnk(String name);
	/**获取某个类别的所有策略*/
	public List<FunctionDisRnk> getTypeStrategy(String type);
	/**获取某个等级的某个类别的所有策略*/
	public List<FunctionDisRnk> getTRStrategy(FunctionDisRnk fdr);
	
	/**获取某个等级的所有指标*/
	public List<FunctionDisRnk> getRankQuotas(int rank);
	/**获取某个指标的描述、类别和等级*/
	public FunctionDisRnk getQuotaDisRnk(String name);
	/**获取某个类别的所有指标*/
	public List<FunctionDisRnk> getTypeQuota(String type);
	/**获取某个等级的某个类别的所有指标*/
	public List<FunctionDisRnk> getTRQuota(FunctionDisRnk fdr);
}
