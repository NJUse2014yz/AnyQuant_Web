package ServiceTool;

import java.util.ArrayList;
import java.util.List;

import data.DataService;
import data.QuotaService;
import data.impl.DataServiceImpl;
import data.impl.QuotaServiceImpl;
import po.HistoryData;
import vo.StockVaRunit;
import java.util.*;

public class VaRcalHelper {
	private static DataService dataService = new DataServiceImpl();
	private static QuotaService quotaService = new QuotaServiceImpl();

	// 单只股票的正态
	public static double getSingleStock_cal(String stockid, int num_of_stock, int days, double alpha) throws Exception {
		// 只考虑 alpha=0.90,0.975,0.95,0.99的情况
		double perc = 0.0;
		if (alpha == 0.9)
			perc = 0.8159;
		if (alpha == 0.95)
			perc = 0.8289;
		if (alpha == 0.99)
			perc = 0.8389;

		List<HistoryData> his_data = dataService.getHistoryData_latest_n(stockid, days);
		if (his_data.size() < days) {
			System.out.println("data not enough");
			throw new Exception();
		}

		double aver = 0;
		// 用增长率计算
		for (int i = 0; i < days; i++) {
			aver += his_data.get(i).getIncrPer();
		}
		aver = aver / days;

		double var = 0;
		for (int i = 0; i < days; i++) {
			var += Math.pow(his_data.get(i).getIncrPer() - aver, 2);
		}
		var = Math.pow(var / (days - 1), 0.5);

		return his_data.get(days - 1).getClose() * num_of_stock * (aver - var * perc);

	}

	// delta-正态
	public static double getMultStock_cal(ArrayList<StockVaRunit> stolist, int days, double alpha) throws Exception {
		// 只考虑 alpha=0.90,0.975,0.95,0.99的情况
		double perc = 0.0;
		if (alpha == 0.9)
			perc = 0.8159;
		if (alpha == 0.95)
			perc = 0.8289;
		if (alpha == 0.99)
			perc = 0.8389;

		// days个增长+E+var
		double[][] inflist = new double[stolist.size()][days + 2];

		for (int i = 0; i < stolist.size(); i++) {
			List<HistoryData> his_data = dataService.getHistoryData_latest_n(stolist.get(i).getStockid(), days);
			if (his_data.size() < days) {
				System.out.println("data not enough");
				throw new Exception();
			}

			double aver = 0;
			// 用增长率计算
			for (int k = 0; k < days; k++) {
				double Inc = his_data.get(k).getIncrease() * stolist.get(i).getNum_of_stock();
				inflist[i][k] = Inc;
				aver += Inc;
			}
			aver = aver / days;
			inflist[i][days] = aver;

			double var = 0;
			for (int k = 0; k < days; k++) {
				var += Math.pow(inflist[i][k] - aver, 2);
			}
			var = var / (days - 1);

			inflist[i][days + 1] = var;
		}

		// 不断更新叠加的结果;
		for (int i = 0; i < stolist.size() - 1; i++) {
			// 叠加var
			double cov = 0.0;
			for (int k = 0; k < days; k++) {
				cov += inflist[i][k] * inflist[i + 1][k];
			}
			cov = cov / days;
			cov -= inflist[i][days] * inflist[i + 1][days];

			inflist[i + 1][days + 1] = inflist[i + 1][days + 1] + inflist[i][days + 1] + 2 * cov;

			// 叠加其余项
			for (int k = 0; k <= days; k++) {
				inflist[i + 1][k] += inflist[i][k];
			}
		}

		int end = stolist.size() - 1;
		return inflist[end][days] - Math.pow(inflist[end][days + 1], 0.5) * perc;
	}

	// 单只股票的历史模拟法
	public static Double getSingleStock_his(String stockid, int num_of_stock, int days, double alpha) throws Exception {
		List<HistoryData> his_data = dataService.getHistoryData_latest_n(stockid, days);
		if (his_data.size() < days) {
			System.out.println("data not enough");
			throw new Exception();
		}
		// System.out.println(his_data);
		int rank = (int) (days * (1 - alpha));

		// 从小到大排出第rank个；
		Double[] result = new Double[rank];
		for (int i = 0; i < rank; i++) {
			result[i] = his_data.get(i).getIncrease();
		}

		for (int i = rank; i < his_data.size(); i++) {
			Double temp = his_data.get(i).getIncrease();
			for (int j = 0; j < rank; j++) {
				if (temp < result[j]) {
					Double trans = result[j];
					result[j] = temp;
					temp = trans;
				}
			}
		}
		return result[rank - 1] * num_of_stock;
	}

	// 单只股票历史模拟with lambda加权
	public static Double getSingleStock_lambda(String stockid, int num_of_stock, int days, double alpha, double lambda)
			throws Exception {
		List<HistoryData> his_data = dataService.getHistoryData_latest_n(stockid, days);
		if (his_data.size() < days) {
			System.out.println("data not enough");
			throw new Exception();
		}
		// System.out.println(his_data);

		// 排序 数字，权
		Double[][] result = new Double[days][2];
		double devide = 1 - Math.pow(lambda, days);
		for (int i = 0; i < days; i++) {
			result[i][0] = his_data.get(i).getIncrease();
			result[i][1] = (Math.pow(lambda, days - 1 - i)) * (1 - lambda) / devide;
		}
		// 从大到小排列
		for (int i = 0; i < days; i++) {
			for (int j = 0; j < days - 1; j++) {
				if (result[j][0] < result[j + 1][0]) {
					Double[] trans = result[j];
					result[j] = result[j + 1];
					result[j + 1] = trans;
				}
			}
		}
		for (int i = 0; i < days; i++) {
			System.out.println(result[i][0] + "  " + result[i][1]);
		}
		// 计算超过概率的i；
		double perc = 0.0;
		int i = 0;
		while (perc < 1 - alpha) {
			perc += result[i][1];
			i++;
		}
		// System.out.println(i);
		return result[i][0] * num_of_stock;
	}

	// 多只股票的历史模拟法
	public static Double getMultStock_his(ArrayList<StockVaRunit> stolist, int days, double alpha) throws Exception {
		double[] Inclist = new double[days];
		for (int i = 0; i < days; i++) {
			Inclist[i] = 0;
		}

		for (int i = 0; i < stolist.size(); i++) {
			List<HistoryData> his_data = dataService.getHistoryData_latest_n(stolist.get(i).getStockid(), days);
			if (his_data.size() < days) {
				System.out.println("data not enough");
				throw new Exception();
			} else {
				for (int k = 0; k < days; k++) {
					Inclist[k] += his_data.get(k).getIncrease() * stolist.get(i).getNum_of_stock();
				}
			}
		}

		// System.out.println(his_data);
		int rank = (int) (days * (1 - alpha));

		// 从小到大排出第rank个；
		Double[] result = new Double[rank];
		for (int i = 0; i < rank; i++) {
			result[i] = Inclist[i];
		}

		for (int i = rank; i < days; i++) {
			Double temp = Inclist[i];
			for (int j = 0; j < rank; j++) {
				if (temp < result[j]) {
					Double trans = result[j];
					result[j] = temp;
					temp = trans;
				}
			}
		}
		return result[rank - 1];
	}

	// 蒙特卡洛
	public static double getMonte(String stockid, int num_of_stock, int days, int frequent, double alpha)
			throws Exception {
		List<HistoryData> his_data = dataService.getHistoryData_latest_n(stockid, days);
		if (his_data.size() < days) {
			System.out.println("data not enough");
			throw new Exception();
		}else{
//			System.out.println(his_data.get(days-1).getDate());
		}

		double aver = 0;
		// 用增长率
		for (int i = 0; i < days; i++) {
			aver += his_data.get(i).getIncrPer();
		}
		aver = aver / days;

		double dvar = 0;
		for (int i = 0; i < days; i++) {
			dvar += Math.pow(his_data.get(i).getIncrPer() - aver, 2);
		}
		dvar = Math.pow(dvar / (days - 1), 0.5);

		// St=[];
		// S=[];
		// VAR=[];
		// u=input(' '); %日收益率的均值
		// o=input(' '); %日收益率的标准差
		double t = 6; // 从开盘到结束的时间小时
		double dt = t / frequent;

		Random rand = new Random();
		double[] predict = new double[1000];
		// 模拟出1000个可能的收盘价并将它们按升序排列
		for (int m = 0; m < 1000; m++) {
			double temp = aver;
			for (int n = 0; n < 20; n++) {
				temp = temp
						+ temp * (aver / 20 * dt + dvar / Math.pow(20, 0.5) * Math.pow(dt, 0.5) * rand.nextGaussian());
			}
			predict[m] = temp;

		}

		int rank = (int) (1000 * (1 - alpha));
		// 从小到大排出第rank个；
		Double[] result = new Double[rank];
		for (int i = 0; i < rank; i++) {
			result[i] = predict[i];
		}

		for (int i = rank; i < 1000; i++) {
			Double temp = predict[i];
			for (int j = 0; j < rank; j++) {
				if (temp < result[j]) {
					Double trans = result[j];
					result[j] = temp;
					temp = trans;
				}
			}
		}
//		System.out.println(aver);
//		System.out.println(result[rank - 1]);
		return result[rank - 1] * num_of_stock*his_data.get(days-1).getClose();
	}

	public static void main(String[] args) throws Exception {
		// VaRcalHelper.getSingleStock_cal("sh600008", 100, 30, 0.95);
		// System.out.println(VaRcalHelper.getSingleStock_lambda("sh600008",
		// 100, 100, 0.05,0.5));
		// System.out.println(VaRcalHelper.getSingleStock_his("sh600008", 100,
		// 100, 0.95));
//		System.out.println(VaRcalHelper.getSingleStock_cal("sh600008", 100, 100, 0.95));
//
//		ArrayList<StockVaRunit> stolist = new ArrayList<StockVaRunit>();
//		stolist.add(new StockVaRunit("sh600000", 100));
//		stolist.add(new StockVaRunit("sh600004", 80));
//		System.out.println(VaRcalHelper.getMultStock_his(stolist, 100, 0.95));
		System.out.println(VaRcalHelper.getMonte("sh600008", 100, 100,20, 0.95));

	}

}
