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
import function.ResultType;
import function.choose.ChooseStock;
import function.flag.TrendFunction;
import function.flag.TrendVO;
import function.order.ShareFunction;
import function.risk.StandardPercentFunction;
import function.risk.StandardPercentVO;

public class BackTestTest {
	public BackTest instance;
	//暂不能用
	public TestReport test()
	{
		List<ChooseStock> stockList=new ArrayList<ChooseStock>();
		stockList.add(new ChooseStock("test1",0.2));
		stockList.add(new ChooseStock("test2",0.8));
		List<List<Function>> flagList=new ArrayList<List<Function>>();
		flagList.add(new ArrayList<Function>());
		FunctionResult resultUpI=new FunctionResult();
		resultUpI.location.add(ResultType.INT.getCode());
		resultUpI.rI=1;
		FunctionResult resultDownI=new FunctionResult();
		resultDownI.location.add(ResultType.INT.getCode());
		resultDownI.rI=1;
		FunctionResult resultUpO=new FunctionResult();
		resultUpO.location.add(ResultType.INT.getCode());
		resultUpO.rI=0;
		FunctionResult resultDownO=new FunctionResult();
		resultDownO.location.add(ResultType.INT.getCode());
		resultDownO.rI=0;
		
		TrendFunction testF=new TrendFunction();
		testF.setResultUpI(resultUpI);
		testF.setResultUpO(resultUpO);
		testF.setResultDownI(resultDownI);
		testF.setResultDownO(resultDownO);
		flagList.get(0).add(testF);
		
		ShareFunction orderType=new ShareFunction();
		orderType.siid="test1";
		orderType.share=10;
		double cash=100000;
		Date startdate=new Date(2015-1900,0,1);
		Date enddate=new Date(2016-1900,0,1);
		int n=1;
		String benchmark="testB";
		
		List<Flag> flags=new ArrayList<Flag>();
		flags.add(new Flag(orderType,flagList));
		
		ShareFunction bOrderType=new ShareFunction();
		bOrderType.siid="testB";
		bOrderType.share=10;
		Flag bFlag=new Flag(bOrderType,flagList);
		
		StandardPercentVO spfvo=new StandardPercentVO();
		spfvo.attribute="close";
		spfvo.standard="m20";
		spfvo.percent=0.8;
		spfvo.sign=-1;
		StandardPercentFunction spf=new StandardPercentFunction(spfvo);
		List<List<Function>> risk=new ArrayList<List<Function>>();
		risk.get(0).add(spf);
		
		try {
			instance=new BackTest(stockList, flags,
					cash, startdate, enddate, n, benchmark,bFlag,risk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestReport report=null;
		try {
			report=instance.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(report);
		return report;
	}
	public static void main(String[] args)
	{
//		File file=new File("test.txt");
//		FileWriter fw=null;
//		try {
//			fw = new FileWriter(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		BufferedWriter bw=new BufferedWriter(fw);
//		try {
//			bw.write(new BackTestTest().test().toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			fw.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		new BackTestTest().test();
	}
}
