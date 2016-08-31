package ServiceTool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import data.DataService;
import data.QuotaService;
import data.impl.DataServiceImpl;
import data.impl.QuotaServiceImpl;
import po.HistoryData;
import po.MultFactData;
import po.QuotaData;
import po.StockInf;
import tool.DateExchangeTool;

public class MultFacHelper {

	private static DataService dataService = new DataServiceImpl();
	private static QuotaService quotaService = new QuotaServiceImpl();

	// 平均换手率，平均成交量,成交量变异率（20）vr，最旧的动向指标dmh,dml,tr
	public static MultFactData getAttriTop(String Attribute, int days, int sumsto) throws Exception {
		MultFactData multfactdata;
		ArrayList<String> result = new ArrayList<String>();
		List<StockInf> stolist = dataService.getStockList();
		ArrayList<MultFacInf> templist=new ArrayList<MultFacInf>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, -1);
		String endDate = sdf.format(today.getTime());
		today.add(Calendar.DATE, 1 - days);
		String startDate = sdf.format(today.getTime());

		for(int i=0;i<stolist.size();i++){
			String stockid=stolist.get(i).getSid();
			List<HistoryData> historyData=dataService.getHistoryStockData_siidTime(stockid,
					DateExchangeTool.stringToSqlDate(startDate),DateExchangeTool.stringToSqlDate(endDate));
			
			int hisize=historyData.size();
			
			double incPerc=0.0;
			double attribute=0.0;
			
			if(hisize!=0){
				
				for(int k=0;k<historyData.size();k++){
					incPerc+=historyData.get(k).getIncrPer();
				}
				
				List<QuotaData> quotaData;
				
				switch (Attribute) {
				case "turnover":
					for(int k=0;k<historyData.size();k++){
						attribute+=historyData.get(k).getTurnover();
					}
					attribute=attribute/hisize;
//					System.out.println(stockid+"  "+attribute);
					break;
				case "amount":
					for(int k=0;k<historyData.size();k++){
						attribute+=historyData.get(k).getAmount();
					}
					attribute=attribute/hisize;
					break;
				case "vr":
					quotaData=dataService.getDayQData(stockid,
							DateExchangeTool.stringToSqlDate(startDate),DateExchangeTool.stringToSqlDate(endDate));
					int num=0;
					for(int k=0;k<hisize;k+=20){
						attribute+=quotaData.get(k).getVr();
						num++;
					}
					attribute=attribute/num;
					break;
				case "dmh":
					quotaData=dataService.getDayQData(stockid,
							DateExchangeTool.stringToSqlDate(startDate),DateExchangeTool.stringToSqlDate(endDate));
					attribute=quotaData.get(0).getDmh();
					break;
				case "dml":
					quotaData=dataService.getDayQData(stockid,
							DateExchangeTool.stringToSqlDate(startDate),DateExchangeTool.stringToSqlDate(endDate));
					attribute=quotaData.get(0).getDml();
					break;
				case "tr":
					quotaData=dataService.getDayQData(stockid,
							DateExchangeTool.stringToSqlDate(startDate),DateExchangeTool.stringToSqlDate(endDate));
					attribute=quotaData.get(0).getTr();
					break;
				default:
					break;
				}
				
				
			}
			MultFacInf inf=new MultFacInf(stockid,attribute,incPerc);
			templist.add(inf);
		}
		//对列表的数据进行排序
		sort(templist);
//		for(int i=0;i<templist.size();i++){
//			System.out.println(i+" "+templist.get(i).attribute);
//		}
		
		//按stosum依次计算；
		int teams=templist.size()/sumsto;
		if(teams<=0){
			System.out.println("the value of sumsto is unreasonable");
			return new MultFactData();
		}
		
		double[] testResult=new double[teams];
		for(int i=0;i<teams;i++){
			for(int k=0;k<sumsto;k++){
				testResult[i]+=templist.get(i*sumsto+k).IncPerc;
			}
		}
//		for(int i=0;i<testResult.length;i++){
//			System.out.println(i+" "+testResult[i]);
//		}
//		System.out.println(templist.size());
		//查找到最大收益
		int max=0;
		for(int t=1;t<teams;t++){
			if(testResult[t]>testResult[max]){
				max=t;
			}
		}
//		for(int i=0;i<sumsto;i++){
//			result.add(templist.get(max*sumsto+i).stockId);
//			System.out.println(i+"  "+templist.get(max*sumsto+i).stockId);
//		}
		
		multfactdata=new MultFactData(Attribute,result,testResult[max]/10,days,sumsto);
		
		return multfactdata;
	}
	
	public static void sort(ArrayList<MultFacInf> list){
		for(int i=0;i<list.size();i++){
			for(int k=0;k<list.size()-1;k++){
				if(list.get(k).attribute<list.get(k+1).attribute){
					MultFacInf trans=list.get(k);
					list.set(k, list.get(k+1));
					list.set(k+1, trans);
				}
			}
		}
//		return list;
	}
	
//	public static double ListBackTest(ArrayList<String> result, int days) {
//		return 0.0;
//	}

	public static void main(String[] args) throws Exception {
		MultFacHelper.getAttriTop("turnover",30,10);
	}
	
	
}
