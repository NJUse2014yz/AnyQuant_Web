package ServiceTool;

import java.util.List;

import data.DataService;
import data.QuotaService;
import data.impl.DataServiceImpl;
import data.impl.QuotaServiceImpl;
import po.HistoryData;

public class VaRcalHelper {
	private static DataService dataService = new DataServiceImpl();
	private static QuotaService quotaService = new QuotaServiceImpl();

	public static long getSingleStock_cal(String stockid, int num_of_stock, int days, double alpha) throws Exception {
		List<HistoryData> his_data = dataService.getHistoryData_latest_n(stockid, days);
		if (his_data.size() < days) {
			System.out.println("data not enough");
			throw new Exception();
		}
		
		System.out.println(his_data);
		return 0;

	}

	public static Double getSingleStock_his(String stockid, int num_of_stock, int days, double alpha) throws Exception {
		List<HistoryData> his_data = dataService.getHistoryData_latest_n(stockid, days);
		if (his_data.size() < days) {
			System.out.println("data not enough");
			throw new Exception();
		}
//		System.out.println(his_data);
		int rank=(int) (days*(1-alpha));
		
		//从小到大排出第rank个；
		Double[] result=new Double[rank];
		for(int i=0;i<rank;i++){
			result[i]=his_data.get(i).getIncrease();
		}
		
		for(int i=rank;i<his_data.size();i++){
			Double temp=his_data.get(i).getIncrease();
			for(int j=0;j<rank;j++){
				if(temp<result[j]){
					Double trans=result[j];
					result[j]=temp;
					temp=trans;
				}
			}
		}
		return result[rank-1]*num_of_stock;
	}
	
	
	//with lambda
	public static Double getSingleStock_lambda(String stockid, int num_of_stock, int days, double alpha,double lambda) throws Exception {
		List<HistoryData> his_data = dataService.getHistoryData_latest_n(stockid, days);
		if (his_data.size() < days) {
			System.out.println("data not enough");
			throw new Exception();
		}
//		System.out.println(his_data);
				
		//排序   数字，权
		Double[][] result=new Double[days][2];
		double devide=1-Math.pow(lambda, days);
		for(int i=0;i<days;i++){
			result[i][0]=his_data.get(i).getIncrease();
			result[i][1]=(Math.pow(lambda, days-1-i))*(1-lambda)/devide;
		}
		//从大到小排列
		for(int i=0;i<days;i++){
			for(int j=0;j<days-1;j++){
				if(result[j][0]<result[j+1][0]){
					Double[] trans=result[j];
					result[j]=result[j+1];
					result[j+1]=trans;
				}
			}
		}
		for(int i=0;i<days;i++){
		System.out.println(result[i][0]+"  "+result[i][1]); }
		//计算超过概率的i；
		double perc=0.0;
		int i=0;
		while(perc<1-alpha){
			perc+=result[i][1];
			i++;
		}
//		System.out.println(i);
		return result[i][0]*num_of_stock;
	}

	public static void main(String[] args) throws Exception {
//		VaRcalHelper.getSingleStock_cal("sh600008", 100, 30, 0.95);
//		System.out.println(VaRcalHelper.getSingleStock_lambda("sh600008", 100, 100, 0.05,0.5));
		System.out.println(VaRcalHelper.getSingleStock_his("sh600008", 100, 100, 0.95));
			
	}

}
