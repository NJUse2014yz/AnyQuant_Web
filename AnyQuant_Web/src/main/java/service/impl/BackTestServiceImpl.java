package service.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import mapper.HistoryDataMapper;
import mapper.StrategyMapper;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import po.StrategySearch;
import function.Function;
import function.choose.ChooseStock;
import backtest.BackTest;
import backtest.TestReport;
import service.BackTestService;
import vo.Flag;
import vo.RealTestVO;

public class BackTestServiceImpl implements BackTestService {
	@Autowired
	public StrategyMapper strMapper;
	
	public BackTestServiceImpl(){}
	public BackTestServiceImpl(StrategyMapper strMapper)
	{
		this.strMapper=strMapper;
	}
	@Override
	public TestReport backtest(List<ChooseStock> stockList, List<Flag> flags,
			double cash, Date startdate, Date enddate, int n, String benchmark,Flag bFlag,List<List<Function>> risk)
			throws Exception {
		BackTest backTest=new BackTest(stockList, flags, cash, startdate, enddate, n, benchmark,bFlag,risk);
		TestReport report=backTest.test();
		return report;
	}

	@Override
	public TestReport backtest(List<ChooseStock> stockList, List<Flag> flags,
			int n, String benchmark,Flag bFlag,List<List<Function>> risk) throws Exception {
		Date enddate=new Date(Calendar.getInstance().getTimeInMillis());
		Date startdate=new Date(enddate.getYear()-1,enddate.getMonth(),enddate.getDate()-1);
		double cash=100000;
		BackTest backTest=new BackTest(stockList, flags, cash, startdate, enddate, n, benchmark,bFlag,risk);
		TestReport report=backTest.test();
		return report;
	}

	@Override
	public TestReport backtest(List<ChooseStock> stockList, List<Flag> flags,
			String benchmark,Flag bFlag,List<List<Function>> risk) throws Exception {
		Date enddate=new Date(Calendar.getInstance().getTimeInMillis());
		Date startdate=new Date(enddate.getYear()-1,enddate.getMonth(),enddate.getDate()-1);
		double cash=100000;
		int n=1;
		BackTest backTest=new BackTest(stockList, flags, cash, startdate, enddate, n, benchmark,bFlag,risk);
		TestReport report=backTest.test();
		return report;
	}

	@Override
	public TestReport backtest(List<ChooseStock> stockList, List<Flag> flags,
			int n,Flag bFlag,List<List<Function>> risk) throws Exception {
		Date enddate=new Date(Calendar.getInstance().getTimeInMillis());
		Date startdate=new Date(enddate.getYear(),enddate.getMonth()-5,enddate.getDate()-1);
		double cash=100000;
		String benchmark="sh000001";
		BackTest backTest=new BackTest(stockList, flags, cash, startdate, enddate, n, benchmark,bFlag,risk);
		TestReport report=backTest.test();
		return report;
	}

	@Override
	public void saveBackTest(String userName,String createrName,String strategyName,TestReport report) {
		double score=0;
		//评分方法
		score+=report.annualizedReturns;
		score+=report.alpha;
		score+=report.beta;
		score+=report.sharpeRatio;
		score-=report.volatility;
		score+=report.informationRatio;
		score-=report.maxDrawdown/report.capital.get(0).value;
		
		StrategySearch search=new StrategySearch(userName, createrName, strategyName, JSONObject.fromObject(report).toString(),score);
		try {
			strMapper.modifyReport(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
