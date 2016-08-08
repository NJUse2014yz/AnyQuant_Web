package service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import bl.DataHelper;
import bl.NewsHelper;
import bl.RankHelper;
import bl.SpecStocksHelper;
import common.Ktype;
import common.Ltype;
import common.MarketType;
import data.DataService;
import data.QuotaService;
import data.impl.DataServiceImpl;
import data.impl.QuotaServiceImpl;
import po.HistoryData;
import po.IndiceInf;
import po.QuotaData;
import po.StockInf;
import service.StockDataService;
import tool.DateExchangeTool;
import vo.AllBigDealInf;
import vo.HaltStockInf;
import vo.KgraInf;
import vo.LinegraInf;
import vo.NewStockInf;
import vo.StockListInf;
import vo.StockNewsInf;
import vo.StockTopInf;

/**
 * 股票数据处理
 * 
 * @author zhangqi
 * @date 2016年5月21日
 */
public class StockDataServiceImpl implements StockDataService {
	private DataService dataService=new DataServiceImpl();
	private QuotaService quotaService=new QuotaServiceImpl();
	@Override
	public List<StockListInf> showListStock(int n) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<StockListInf> result = new ArrayList<StockListInf>();
		int numperpage = 10;// 假设一页有10条
		List<StockInf> list = dataService.getStockList();
		for (int i = numperpage * (n - 1); i < numperpage * n; i++) {
			if (i < list.size()) {
				result.add(DataHelper.TurnStockListInf(dataService.getHistoryData_new("s", list.get(i).getSid()),
						list.get(i).getSid(), list.get(i).getSname()));
			}
		}
		return result;
	}

	@Override
	public StockListInf showSingleStock(String id) throws Exception {
		HistoryData temp = dataService.getHistoryData_new_single(id);
		String sname="";
		try{
		StockInf inf = dataService.getStockInf_sid(id);
		sname=inf.getSname();
				}catch(Exception e){
					IndiceInf inf=dataService.getIndiceInf_iid(id);
					sname=inf.getIname();
				}
		return DataHelper.TurnStockListInf(temp, id, sname);
	}
	
	@Override
	public List<StockListInf> showHistory(String id,String date1,String date2) throws Exception {
		// TODO Auto-generated method stub
		List<HistoryData> list_h = dataService.getHistoryStockData_siidTime(id, DateExchangeTool.stringToSqlDate(date1),
				DateExchangeTool.stringToSqlDate(date2));
		List<StockListInf> result=null;
		StockInf inf = dataService.getStockInf_sid(id);
		for(int i=0;i<list_h.size();i++){
			result.add(DataHelper.TurnStockListInf(list_h.get(i), id, inf.getSname()));
		}
		return null;
	}


	@Override
	public List<StockListInf> searchStock(String key) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<StockListInf> result = new ArrayList<StockListInf>();
		List<StockInf> list = dataService.getStockList();
		for (int i = 0; i < list.size(); i++) {
			StockInf temp=list.get(i);
			if ((temp.getSid().contains(key))||(temp.getSname().contains(key))) {
				String sid = list.get(i).getSid();
				result.add(DataHelper.TurnStockListInf(dataService.getHistoryData_new("s", sid), sid,
						dataService.getStockInf_sid(sid).getSname()));
			}
		}
		return result;
	}

	@Override
	public List<KgraInf> getKgraph(String id, Ktype type, String date1, String date2) throws Exception {
		// TODO Auto-generated method stub
		List<HistoryData> list_h = null;
		List<QuotaData> list_q = null;

		switch (type) {
		case DAILY:
			list_h = dataService.getHistoryStockData_siidTime(id, DateExchangeTool.stringToSqlDate(date1),
					DateExchangeTool.stringToSqlDate(date2));
			list_q = dataService.getDayQData(id, DateExchangeTool.stringToSqlDate(date1),
					DateExchangeTool.stringToSqlDate(date2));
			for (int i = 0; i < list_q.size(); i++) {
//				System.out.println("GGGGGGG   " + list_q.get(i).getM5() + "   " + list_q.get(i).getM10());
			}
			break;
		case WEEKLY:
			list_h = dataService.getWeekHData(id, DateExchangeTool.stringToSqlDate(date1),
					DateExchangeTool.stringToSqlDate(date2));
			list_q = dataService.getWeekQData(id, DateExchangeTool.stringToSqlDate(date1),
					DateExchangeTool.stringToSqlDate(date2));
			break;
		case MONTHLY:
			list_h = dataService.getMonthHData(id, DateExchangeTool.stringToSqlDate(date1),
					DateExchangeTool.stringToSqlDate(date2));
			list_q = dataService.getMonthQData(id, DateExchangeTool.stringToSqlDate(date1),
					DateExchangeTool.stringToSqlDate(date2));
			break;
		default:
			break;
		}

		System.out.println("list_h:" + list_h.size());
		System.out.println("list_q:" + list_q.size());
		return DataHelper.TurnKgraInf(list_h, list_q);
	}

	@Override
	public List<LinegraInf> getLinegraph(String id, Ltype type, String date1, String date2) throws Exception {
		// TODO Auto-generated method stub
		List<QuotaData> list_q = quotaService.getDayQData(id, DateExchangeTool.stringToSqlDate(date1),
				DateExchangeTool.stringToSqlDate(date2));
		return DataHelper.TurnLinegraInf(id, list_q);
	}

	@Override
	public List<StockTopInf> getRank() throws Exception {
		// TODO Auto-generated method stub
		Runtime run = Runtime.getRuntime();
		String result = "";
		try {
			Process p = run.exec("python E:/python/toplist.py");
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = br.readLine()) != null) {
				result += lineStr;
			}
			br.close();
			in.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return RankHelper.toList(result);
	}

	@Override
	public List<StockListInf> getIndiceList(MarketType type) throws Exception {
		// TODO Auto-generated method stub
		List<IndiceInf> temp = dataService.getIndiceList();
		ArrayList<String> list = new ArrayList<String>();

		switch (type) {
		case ALL:
			for (int i = 0; i < temp.size(); i++) {
				list.add(temp.get(i).getIid());
			}
			break;
		case SH:
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getIid().contains("sh")) {
					list.add(temp.get(i).getIid());
				}
			}
			break;
		case SZ:
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getIid().contains("sz")) {
					list.add(temp.get(i).getIid());
				}
			}
			break;
		}
		ArrayList<StockListInf> result = new ArrayList<StockListInf>();
		for (int i = 0; i < list.size(); i++) {
			result.add(DataHelper.TurnStockListInf(dataService.getHistoryData_new("i", list.get(i)), list.get(i),
					dataService.getIndiceInf_iid(list.get(i)).getIname()));
		}
		return result;
	}

	@Override
	public void Compare(String sid1, String sid2) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StockNewsInf> getStockNews(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			File file = new File("E:/python/stockId.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			FileWriter fileWritter = new FileWriter("E:/python/stockId.txt", false);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(id.substring(2));
			bufferWritter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 调用python脚本
		Runtime run = Runtime.getRuntime();
		String result = "";
		try {
			Process p = run.exec("python E:/python/stocknews.py");
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = br.readLine()) != null) {
				result += lineStr;
			}
			br.close();
			in.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return NewsHelper.turnSingleNews(result);
	}
	
	@Override
	public List<NewStockInf> getNewStocks() throws Exception {
		// 调用python脚本
		Runtime run = Runtime.getRuntime();
		String result = "";
		try {
			Process p = run.exec("python E:/python/NewStocks.py");
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = br.readLine()) != null) {
				result += lineStr;
			}
			br.close();
			in.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return SpecStocksHelper.getNew(result);
	}

	@Override
	public List<HaltStockInf> getHaltStock() throws Exception {
		// 调用python脚本
		Runtime run = Runtime.getRuntime();
		String result = "";
		try {
			Process p = run.exec("python E:/python/HaltStocks.py");
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = br.readLine()) != null) {
				result += lineStr;
			}
			br.close();
			in.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return SpecStocksHelper.getHalt(result);
	}

	@Override
	public AllBigDealInf getdeal(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			File file = new File("E:/python/stockId.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			FileWriter fileWritter = new FileWriter("E:/python/stockId.txt", false);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(id.substring(2));
			bufferWritter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 调用python脚本
		Runtime run = Runtime.getRuntime();
		String result = "";
		try {
			Process p = run.exec("python E:/python/deal.py");
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = br.readLine()) != null) {
				result += lineStr;
			}
			br.close();
			in.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return DataHelper.turnDeal(result);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		StockDataServiceImpl here = new StockDataServiceImpl();
//		here.showListStock(10);
//		 List<StockListInf> temp = here.getIndiceList(MarketType.SH);
//		 System.out.println(temp.size());
//		 for (int i = 0; i < temp.size(); i++) {
//		 System.out.println(temp.get(i).date + " " + temp.get(i).getStockId() + " "
//		 + temp.get(i).amount);
//		 }
//		StockListInf temp=here.showSingleStock("sh600000");
//		 System.out.println(temp.date + " " + temp.amount );
//		 List<KgraInf> temp=here.getKgraph("sh600990",
//		 Ktype.DAILY, "2001-09-23","2016-06-08");
//		 for (int i = 0; i < temp.size(); i++) {
//		 System.out.println(temp.get(i).date + " " + temp.get(i).m5 + " " +
//		 temp.get(i).m10);
//		 }

//		List<LinegraInf> temp=here.getLinegraph("sh000001", Ltype.BIAS, "2016-03-02", "2016-05-27");
//		for (int i = 0; i < temp.size(); i++) {
//			 System.out.println(temp.get(i).bias5 + " " + temp.get(i).bias10 + " " +
//			 temp.get(i).bias20);
//			 }
		
//		List<StockTopInf> temp=here.getRank();
//		for (int i = 0; i < temp.size(); i++) {
//			 System.out.println(temp.get(i).name + " " + temp.get(i).date + " " +
//			 temp.get(i).reason);
//			 }
		
//		StockListInf temp=here.showSingleStock("sz399001");
//		System.out.println(temp.name+"  "+temp.close);
//		List<StockNewsInf> temp= here.getStockNews("sh600880");
//		for(int i=0;i<temp.size();i++){
//			System.out.println(temp.get(i).date+"  "+temp.get(i).title+"  "+temp.get(i).type);
//		}c
//		List<NewStockInf> temp=here.getNewStocks();
//		for(int i=0;i<temp.size();i++){
//			System.out.println(temp.get(i).code+"  "+temp.get(i).name+"  "+temp.get(i).amount);
//		}
//		List<HaltStockInf> temp=here.getHaltStock();
//		System.out.println(temp.size());
		AllBigDealInf temp=here.getdeal("sh600990");
		
		for(int i=0;i<temp.list.size();i++){
			System.out.println(temp.list.get(i).volume+"  "+temp.list.get(i).type+"  "+temp.list.get(i).time);
		}
		System.out.println(temp.SumBuy+" "+temp.SumMid+" "+temp.SumSell);
	}

	

	
	
}
