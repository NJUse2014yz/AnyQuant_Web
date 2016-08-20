package mapper;

import java.util.List;

import po.Strategy;
import po.StrategySearch;

public interface StrategyMapper {
	public void insert(Strategy strategy) throws Exception;
	public void delete(StrategySearch search) throws Exception;
	public Strategy selectStrategy(StrategySearch search) throws Exception;
	public List<Strategy> selectSelf(StrategySearch search) throws Exception;
	public List<Strategy> selectSave(StrategySearch search) throws Exception;
	public void modifyRealTest(StrategySearch search) throws Exception;
}
