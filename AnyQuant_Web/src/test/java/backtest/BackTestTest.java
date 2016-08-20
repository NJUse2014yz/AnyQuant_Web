package backtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import vo.Flag;
import data.impl.DataServiceImpl;
import function.Function;
import function.FunctionResult;
import function.OrderFunction;
import function.ResultType;
import function.TestFunction;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.flag.TrendVO;
import function.order.ShareFunction;

public class BackTestTest {
	public BackTest instance;
	public TestReport test()
	{
		List<ChooseStock> stockList=new ArrayList<ChooseStock>();
		stockList.add(new ChooseStock("test1",0.2));
		stockList.add(new ChooseStock("test2",0.8));
		List<List<Function>> flagList=new ArrayList<List<Function>>();
		flagList.add(new ArrayList<Function>());
		FunctionResult resultUpI=new FunctionResult();
		resultUpI.location.add(ResultType.INT);
		resultUpI.rI=1;
		FunctionResult resultDownI=new FunctionResult();
		resultDownI.location.add(ResultType.INT);
		resultDownI.rI=1;
		FunctionResult resultUpO=new FunctionResult();
		resultUpO.location.add(ResultType.INT);
		resultUpO.rI=0;
		FunctionResult resultDownO=new FunctionResult();
		resultDownO.location.add(ResultType.INT);
		resultDownO.rI=0;
		
		TestFunction testF=new TestFunction();
		testF.setResultUpI(resultUpI);
		testF.setResultUpO(resultUpO);
		testF.setResultDownI(resultDownI);
		testF.setResultDownO(resultDownO);
		flagList.get(0).add(testF);
		
		OrderFunction orderType=new OrderFunction();
		
		double cash=100000;
		Date startdate=new Date(2015-1900,0,1);
		Date enddate=new Date(2016-1900,0,1);
		int n=1;
		String benchmark="testB";
		List<Flag> flags=new ArrayList<Flag>();
		flags.add(new Flag(orderType,flagList));
		try {
			instance=new BackTest(stockList, flags,
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
		File file=new File("test.txt");
		FileWriter fw=null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw=new BufferedWriter(fw);
		try {
			bw.write(new BackTestTest().test().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		new BackTestTest().test();
	}
}
