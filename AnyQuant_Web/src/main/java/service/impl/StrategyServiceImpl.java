package service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import backtest.TestReport;
import function.Function;
import function.choose.ChooseStock;
import function.choose.IntersectionFunction;
import po.FunctionDisRnk;
import po.Strategy;
import po.StrategySearch;
import mapper.FunctionMapper;
import mapper.QuotaInfMapper;
import mapper.StrategyInfMapper;
import mapper.StrategyMapper;
import service.StrategyService;
import tool.JsonExchangeTool;
import vo.StrategyVO;

public class StrategyServiceImpl implements StrategyService {
	@Autowired
	public StrategyMapper strategyMapper;
	@Autowired
	public FunctionMapper functionMapper;
	@Autowired
	public StrategyInfMapper strategyInfMapper;
	@Autowired
	public QuotaInfMapper quotaInfMapper;
	
	
	public StrategyServiceImpl(){};
	public StrategyServiceImpl(StrategyMapper strategyMapper,FunctionMapper functionMapper,
			StrategyInfMapper strategyInfMapper,QuotaInfMapper quotaInfMapper) {
		super();
		this.strategyMapper = strategyMapper;
		this.functionMapper = functionMapper;
		this.strategyInfMapper=strategyInfMapper;
		this.quotaInfMapper=quotaInfMapper;
	}
	public StrategyServiceImpl(StrategyMapper strategyMapper) {
		super();
		this.strategyMapper = strategyMapper;
	}
	@Override
	public List<String> chooseStock(List<List<Function>> choose,Calendar today) {
		List<String> result=new ArrayList<String>();
		for(int i=0;i<choose.size();i++)
		{
			List<String> temp=new ArrayList<String>();
			for(int j=0;j<choose.get(i).size();j++)
			{
				List<String> inList=choose.get(i).get(j).getResult(new Date(0)).rLS;
				if(j==0)
				{
					temp=inList;
				}
				else
				{
					int k=0;
					while(k<temp.size())
					{
						if(!inList.contains((temp.get(k))))
						{
							temp.remove(k);
						}
						else
						{
							k++;
						}
					}
				}
			}
			for(int k=0;k<temp.size();k++)
			{
				if(!result.contains((temp.get(k))))
				{
					result.add(temp.get(k));
				}
			}
		}
		return result;
	}
	@Override
	public void makeStrategy(StrategyVO vo) {
		Strategy strategy=new Strategy(vo);
		
		try {
			strategyMapper.insert(strategy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void editStrategy(StrategyVO vo) {
		Strategy strategy=new Strategy(vo);
		
		try {
			strategyMapper.modifyStrategy(strategy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteStrategy(String userName,String createrName,String strategyName)
	{
		StrategySearch search=new StrategySearch(userName,createrName,strategyName);
		try {
			strategyMapper.delete(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void saveStrategy(String userName, String createrName,
			String strategyName) {
		StrategySearch search=new StrategySearch(userName, createrName, strategyName);
		try {
			strategyMapper.save(search);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	public StrategyVO getSingleStrategy(String userName, String createrName,
			String strategyName) {
		StrategySearch search=new StrategySearch(userName,createrName,strategyName);
		Strategy strategy=null;
		try {
			strategy=strategyMapper.selectStrategy(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new StrategyVO(strategy);
	}
	@Override
	public List<StrategyVO> getSelfStrategy(String userName) {
		List<Strategy> strategyList=null;
		StrategySearch search=new StrategySearch();
		search.setUserName(userName);
		try {
			strategyList=strategyMapper.selectSelf(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<StrategyVO> voList=new ArrayList<StrategyVO>();
		for(int i=0;i<strategyList.size();i++)
		{
			voList.add(new StrategyVO(strategyList.get(i)));
		}
		return voList;
	}
	@Override
	public List<StrategyVO> getSaveStrategy(String userName) {
		List<Strategy> strategyList=null;
		StrategySearch search=new StrategySearch();
		search.setUserName(userName);
		try {
			strategyList=strategyMapper.selectSave(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<StrategyVO> voList=new ArrayList<StrategyVO>();
		for(int i=0;i<strategyList.size();i++)
		{
			voList.add(new StrategyVO(strategyList.get(i)));
		}
		return voList;
	}
	@Override
	public List<FunctionDisRnk> getRankFunctions(int rank) {
		List<FunctionDisRnk> list=null;
		try {
			list=functionMapper.selectRank(rank);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public FunctionDisRnk getFunctionDisRnk(String name) {
		FunctionDisRnk fdr=null;
		try {
			fdr=functionMapper.selectFunction(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdr;
	}
	@Override
	public List<FunctionDisRnk> getTypeFunction(String type) {
		List<FunctionDisRnk> fdrList=null;
		try {
			fdrList=functionMapper.selectType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdrList;
	}
	@Override
	public List<FunctionDisRnk> getTRFunction(FunctionDisRnk fdr) {
		List<FunctionDisRnk> fdrList=null;
		try {
			fdrList=functionMapper.selectTypeRank(fdr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdrList;
	}
	@Override
	public List<FunctionDisRnk> getRankStrategys(int rank) {
		List<FunctionDisRnk> list=null;
		try {
			list=strategyInfMapper.selectRank(rank);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public FunctionDisRnk getStrategyDisRnk(String name) {
		FunctionDisRnk fdr=null;
		try {
			fdr=strategyInfMapper.selectStrategyInf(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdr;
	}
	@Override
	public List<FunctionDisRnk> getTypeStrategy(String type) {
		List<FunctionDisRnk> fdrList=null;
		try {
			fdrList=strategyInfMapper.selectType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdrList;
	}
	@Override
	public List<FunctionDisRnk> getTRStrategy(FunctionDisRnk fdr) {
		List<FunctionDisRnk> fdrList=null;
		try {
			fdrList=strategyInfMapper.selectTypeRank(fdr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdrList;
	}
	@Override
	public List<FunctionDisRnk> getRankQuotas(int rank) {
		List<FunctionDisRnk> list=null;
		try {
			list=quotaInfMapper.selectRank(rank);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public FunctionDisRnk getQuotaDisRnk(String name) {
		FunctionDisRnk fdr=null;
		try {
			fdr=quotaInfMapper.selectQuotaInf(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdr;
	}
	@Override
	public List<FunctionDisRnk> getTypeQuota(String type) {
		List<FunctionDisRnk> fdrList=null;
		try {
			fdrList=quotaInfMapper.selectType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdrList;
	}
	@Override
	public List<FunctionDisRnk> getTRQuota(FunctionDisRnk fdr) {
		List<FunctionDisRnk> fdrList=null;
		try {
			fdrList=quotaInfMapper.selectTypeRank(fdr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdrList;
	}
	@Override
	public TestReport getReport(String userName, String createrName,
			String strategyName) {
		StrategySearch search=new StrategySearch(userName,createrName,strategyName);
		Strategy strategy=null;
		try {
			strategy=strategyMapper.selectStrategy(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonExchangeTool.getReport(strategy.report);
	}
	@Override
	public double getScore(String userName, String createrName,
			String strategyName) {
		StrategySearch search=new StrategySearch(userName,createrName,strategyName);
		double value=0;
		try {
			value=strategyMapper.selectScore(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	@Override
	public double getScoreSum(String userName) {
		StrategySearch search=new StrategySearch();
		search.setUserName(userName);
		double value=0;
		try {
			value=strategyMapper.selectScoreSum(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	@Override
	public int getPrivacy(String userName, String createrName,
			String strategyName) {
		StrategySearch search=new StrategySearch(userName, createrName, strategyName);
		int privacy=0;
		try {
			privacy=strategyMapper.selectPrivacy(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return privacy;
	}
	@Override
	public void setPrivacy(String userName, String createrName,
			String strategyName, int privacy) {
		StrategySearch search=new StrategySearch(userName, createrName, strategyName);
		search.setI(privacy);
		try {
			strategyMapper.modifyPrivacy(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
