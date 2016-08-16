package service.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import po.Strategy;
import po.StrategySearch;
import mapper.StrategyMapper;
import service.StrategyService;
import vo.StrategyVO;

public class StrategyServiceImpl implements StrategyService {
	@Autowired
	StrategyMapper strategyMapper;
	public StrategyServiceImpl(){};
	public StrategyServiceImpl(StrategyMapper strategyMapper) {
		super();
		this.strategyMapper = strategyMapper;
	}
	@Override
	public void makeStrategy(StrategyVO vo) {
		Strategy strategy=new Strategy();
		strategy.setUserName(vo.getUserName());
		strategy.setCreaterName(vo.getCreaterName());
		strategy.setStrategyName(vo.getStrategyName());
		strategy.setOrderType(JSONObject.fromObject(vo.getChoose()).toString());
		strategy.setChoose(JSONArray.fromObject(vo.getChoose()).toString());
		strategy.setFlag(JSONArray.fromObject(vo.getFlag()).toString());
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
