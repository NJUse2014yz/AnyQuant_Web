package mapper;

import java.util.List;

import po.Strategy;
import po.StrategySearch;

public interface StrategyMapper {
	public void insert(Strategy strategy) throws Exception;
	public void delete(StrategySearch search) throws Exception;
	public void save(StrategySearch search) throws Exception;
	public Strategy selectStrategy(StrategySearch search) throws Exception;
	public List<Strategy> selectSelf(StrategySearch search) throws Exception;
	//修改，待测试
	public List<Strategy> selectSave(StrategySearch search) throws Exception;
	public void modifyRealTest(StrategySearch search) throws Exception;
	public void modifyReport(StrategySearch search) throws Exception;
	public void modifyPrivacy(StrategySearch search) throws Exception;
	public double selectScore(StrategySearch search) throws Exception;
	public double selectScoreSum(StrategySearch search) throws Exception;
	public int selectPrivacy(StrategySearch search) throws Exception;
	
	public void modifyStrategy(Strategy strategy) throws Exception;
}
