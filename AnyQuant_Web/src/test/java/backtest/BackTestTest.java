package backtest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import data.impl.DataServiceImpl;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.flag.TrendVO;
import function.order.ShareFunction;

public class BackTestTest {
	public BackTest instance;
	public TestReport test()
	{
		List<ChooseStock> stockList=new ArrayList<ChooseStock>();
		stockList.add(new ChooseStock("sh600000",0.2));
		stockList.add(new ChooseStock("sh600004",0.8));
		List<List<Function>> flagList=new ArrayList<List<Function>>();
		flagList.add(new ArrayList<Function>());
		FunctionResult resultUpI=new FunctionResult();
		resultUpI.location.add(ResultType.DOUBLELIST);
		resultUpI.rD=Math.PI/2;
		FunctionResult resultDownI=new FunctionResult();
		resultDownI.location.add(ResultType.DOUBLELIST);
		resultDownI.rD=0;
		FunctionResult resultUpO=new FunctionResult();
		resultUpO.location.add(ResultType.DOUBLELIST);
		resultUpO.rD=0;
		FunctionResult resultDownO=new FunctionResult();
		resultDownO.location.add(ResultType.DOUBLELIST);
		resultDownO.rD=-Math.PI/2;
		String siid="sh600000";
		String attribute="close";
		long start=new Date(2016-1900,5,1).getTime();
		long end=new Date(2016-1900,7,1).getTime();
		double standard=1;
		try {
			standard = new DataServiceImpl().getHistoryData_new("s","sh600000").getClose();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		TrendVO vo=new TrendVO(resultUpI, resultDownI, resultUpO, resultDownO,
				siid, attribute, start, end, standard);
		flagList.get(0).add(new TrendFunction(vo));
		ShareFunction orderType=new ShareFunction();
		double cash=100000;
		Date startdate=new Date(2015-1900,0,1);
		Date enddate=new Date(2016-1900,0,1);
		int n=1;
		String benchmark="sh000001";
		try {
			instance=new BackTest(stockList, flagList, orderType,
					cash, startdate, enddate, n, benchmark);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestReport report=null;
		try {
			report=instance.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	public static void main(String[] args)
	{
		System.out.println(new BackTestTest().test());
	}
}
