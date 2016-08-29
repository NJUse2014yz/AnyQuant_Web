package service;

import java.util.ArrayList;

import ServiceTool.VaRcalHelper;
import vo.StockVaRunit;

public class VarCalTest {
	public static void single_cal_test() {
		try {
			VaRcalHelper.getSingleStock_cal("sh600008", 100, 30, 0.95);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mult_cal_test() {
		ArrayList<StockVaRunit> stolist = new ArrayList<StockVaRunit>();
		stolist.add(new StockVaRunit("sh600000", 100));
		stolist.add(new StockVaRunit("sh600004", 80));
		try {
			VaRcalHelper.getMultStock_cal(stolist, 100, 0.95);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void single_his_test() {
		try {
			VaRcalHelper.getSingleStock_his("sh600008", 100, 100, 0.95);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void single_his_lambda_test() {
		try {
			VaRcalHelper.getSingleStock_lambda("sh600008", 100, 100, 0.05, 0.5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mult_his_test() {
		ArrayList<StockVaRunit> stolist = new ArrayList<StockVaRunit>();
		stolist.add(new StockVaRunit("sh600000", 100));
		stolist.add(new StockVaRunit("sh600004", 80));
		try {
			VaRcalHelper.getMultStock_his(stolist, 100, 0.95);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void monte_test(){
		try {
			VaRcalHelper.getMonte("sh600008", 100, 100, 20, 0.95);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		VarCalTest.mult_cal_test();
		VarCalTest.mult_his_test();
		VarCalTest.single_cal_test();
		VarCalTest.single_his_lambda_test();
		VarCalTest.single_his_test();
		VarCalTest.monte_test();
	}
}
