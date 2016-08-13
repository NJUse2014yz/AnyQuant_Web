package service;

import java.util.List;

import po.HistoryData;
import data.DataService;
import data.impl.DataServiceImpl;

public class DataServiceTest {
	public static DataService instance=new DataServiceImpl();
	public static void getHistoryData_latest_n()
	{
		String siid="sh600000";
		int n=3;
		List<HistoryData> list=null;
		try {
			list=instance.getHistoryData_latest_n(siid, n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
	public static void main(String[] args)
	{
		DataServiceTest.getHistoryData_latest_n();
	}
}
