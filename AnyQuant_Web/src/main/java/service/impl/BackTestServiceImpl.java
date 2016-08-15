package service.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import function.Function;
import function.choose.ChooseStock;
import backtest.BackTest;
import backtest.TestReport;
import service.BackTestService;

public class BackTestServiceImpl implements BackTestService {

	@Override
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList,Function orderType,
			double cash,Date startdate,Date enddate,int n,
			String benchmark) throws Exception {
		BackTest backTest=new BackTest(stockList, flagList, orderType, cash, startdate, enddate, n, benchmark);
		TestReport report=backTest.test();
		return report;
	}

	@Override
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList, Function orderType, int n, String benchmark)
			throws Exception {
		Date enddate=new Date(Calendar.getInstance().getTimeInMillis());
		Date startdate=new Date(enddate.getYear()-1,enddate.getMonth(),enddate.getDate()-1);
		double cash=100000;
		BackTest backTest=new BackTest(stockList, flagList, orderType, cash, startdate, enddate, n, benchmark);
		TestReport report=backTest.test();
		return report;
	}

	@Override
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList, Function orderType, String benchmark)
			throws Exception {
		Date enddate=new Date(Calendar.getInstance().getTimeInMillis());
		Date startdate=new Date(enddate.getYear()-1,enddate.getMonth(),enddate.getDate()-1);
		double cash=100000;
		int n=1;
		BackTest backTest=new BackTest(stockList, flagList, orderType, cash, startdate, enddate, n, benchmark);
		TestReport report=backTest.test();
		return report;
	}

	@Override
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList, Function orderType, int n)
			throws Exception {
		Date enddate=new Date(Calendar.getInstance().getTimeInMillis());
		Date startdate=new Date(enddate.getYear()-1,enddate.getMonth(),enddate.getDate()-1);
		double cash=100000;
		String benchmark="sh000300";
		BackTest backTest=new BackTest(stockList, flagList, orderType, cash, startdate, enddate, n, benchmark);
		TestReport report=backTest.test();
		return report;
	}

}
