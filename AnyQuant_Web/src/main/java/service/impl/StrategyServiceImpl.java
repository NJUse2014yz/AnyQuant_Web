package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import po.Strategy;
import po.StrategySearch;
import mapper.StrategyMapper;
import service.StrategyService;

public class StrategyServiceImpl implements StrategyService {
	@Autowired
	StrategyMapper strategyMapper;
	public StrategyServiceImpl(){};
	public StrategyServiceImpl(StrategyMapper strategyMapper) {
		super();
		this.strategyMapper = strategyMapper;
	}
	@Override
	public void makeStrategy(Strategy strategy) {
		try {
			strategyMapper.insert(strategy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Strategy getSingleStrategy(String userName, String createrName,
			String strategyName) {
		StrategySearch search=new StrategySearch(userName,createrName,strategyName);
		Strategy strategy=null;
		try {
			strategy=strategyMapper.selectStrategy(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strategy;
	}
	@Override
	public List<Strategy> getSelfStrategy(String userName) {
		List<Strategy> strategyList=null;
		StrategySearch search=new StrategySearch();
		search.setUserName(userName);
		try {
			strategyList=strategyMapper.selectSelf(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strategyList;
	}
	@Override
	public List<Strategy> getSaveStrategy(String userName) {
		List<Strategy> strategyList=null;
		StrategySearch search=new StrategySearch();
		search.setUserName(userName);
		try {
			strategyList=strategyMapper.selectSave(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strategyList;
	}

}
