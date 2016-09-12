package service;

import java.util.ArrayList;

import function.choose.ChooseStock;
import vo.StockVaRunit;

public interface VaRCalService {
	// 单只股票的正态
	// alpha只可取0.9,0.95,0.99
	public double getSingleStock_cal(int amount,String stockid, int days, double alpha) throws Exception;

	// delta-正态,即多股正态
	// alpha只可取0.9,0.95,0.99
	public double getMultStock_cal(int amount,ArrayList<ChooseStock> stolist, int days, double alpha) throws Exception;

	// 单只股票的历史模拟法
	// alpha可以任取(0,1)
	public Double getSingleStock_his(int amount,String stockid, int days, double alpha) throws Exception;

	// 单只股票历史模拟 with lambda加权
	// alpha,lambda 可以任取(0,1)
	public Double getSingleStock_lambda(int amount,String stockid, int days, double alpha, double lambda)
			throws Exception;

	// 多只股票的历史模拟法
	// alpha可以任取(0,1)
	public Double getMultStock_his(int amount,ArrayList<ChooseStock> stolist, int days, double alpha) throws Exception;

	// 蒙特卡洛方法
	// alpha可以任取(0,1)
	//frequent是一个正整数（例如取20）
	public double getMonte(int amount,String stockid,  int days, int frequent, double alpha) throws Exception;
}
