package service;

import java.util.List;

import po.FunctionDisRnk;
import po.Strategy;
import vo.StrategyVO;

public interface StrategyService {
	/**定制策略*/
	public void makeStrategy(StrategyVO vo);
	/**删除策略*/
	public void deleteStrategy(String userName,String createrName,String strategyName);
	/**获取保存的策略,用户名.创建用户名.策略名*/
	public StrategyVO getSingleStrategy(String userName,String createrName,String strategyName);
	/**获取自己的策略*/
	public List<StrategyVO> getSelfStrategy(String userName);
	/**获取收藏的策略*/
	public List<StrategyVO> getSaveStrategy(String userName);
	
	/**获取某个等级的所有方法*/
	public List<FunctionDisRnk> getRankFunctions(int rank);
	/**获取某个方法的描述、类别和等级*/
	public FunctionDisRnk getFunctionDisRnk(String name);
	/**获取某个类别的所有方法*/
	public List<FunctionDisRnk> getTypeFunction(String type);
	/**获取某个等级的某个类别的所有方法*/
	public List<FunctionDisRnk> getTRFunction(FunctionDisRnk fdr);
}
