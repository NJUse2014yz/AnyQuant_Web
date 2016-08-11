package service.impl;

import net.sf.json.JSONObject;
import service.StrategyService;
import vo.SelfStrategy;

public class StrategyServiceImpl implements StrategyService {

	@Override
	public void makeStrategy(SelfStrategy strategy) {
//		System.out.println(strategy.toString());
		System.out.println(JSONObject.fromObject(strategy));
	}

}
