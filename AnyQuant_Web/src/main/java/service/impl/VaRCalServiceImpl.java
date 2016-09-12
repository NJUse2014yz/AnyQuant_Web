package service.impl;

import java.util.ArrayList;

import ServiceTool.VaRcalHelper;
import data.DataService;
import data.impl.DataServiceImpl;
import function.choose.ChooseStock;
import service.VaRCalService;
import vo.StockVaRunit;

public class VaRCalServiceImpl implements VaRCalService{
	private DataService dataService=new DataServiceImpl();
//	private QuotaService quotaService=new QuotaServiceImpl();
	

	@Override
	public double getSingleStock_cal(int amount, String stockid, int days, double alpha) throws Exception {
		// TODO Auto-generated method stub
		int num=change(amount,stockid);
		return VaRcalHelper.getSingleStock_cal(stockid, num, days, alpha);
	}

	@Override
	public double getMultStock_cal(int amount, ArrayList<ChooseStock> stolist, int days, double alpha)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<StockVaRunit> list=change(amount,stolist);
		return VaRcalHelper.getMultStock_cal(list, days, alpha);
	}

	@Override
	public Double getSingleStock_his(int amount, String stockid, int days, double alpha) throws Exception {
		// TODO Auto-generated method stub
		int num=change(amount,stockid);
		return VaRcalHelper.getSingleStock_his(stockid, num, days, alpha);
	}

	@Override
	public Double getSingleStock_lambda(int amount, String stockid, int days, double alpha, double lambda)
			throws Exception {
		// TODO Auto-generated method stub
		int num=change(amount,stockid);
		return VaRcalHelper.getSingleStock_lambda(stockid, num, days, alpha, lambda);
	}

	@Override
	public Double getMultStock_his(int amount, ArrayList<ChooseStock> stolist, int days, double alpha)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<StockVaRunit> list=change(amount,stolist);
		return VaRcalHelper.getMultStock_his(list, days, alpha);
	}

	@Override
	public double getMonte(int amount, String stockid, int days, int frequent, double alpha) throws Exception {
		// TODO Auto-generated method stub
		int num=change(amount,stockid);
		return VaRcalHelper.getMonte(stockid, num, days, frequent, alpha);
	}

	
	
	private int change(int amount,String stockid) throws Exception{
		double close=dataService.getHistoryData_latest_n(stockid,1).get(0).getClose();
		return (int)(amount/close);
	}
	
	private ArrayList<StockVaRunit> change(int amount,ArrayList<ChooseStock> stolist) throws Exception{
		ArrayList<StockVaRunit> result=new ArrayList<StockVaRunit>();
		for(int i=0;i<stolist.size();i++){
			String tempid=stolist.get(i).getSiid();
			double close=dataService.getHistoryData_latest_n(tempid,1).get(0).getClose();
			int tempnum=(int)(amount*stolist.get(i).getPercent()/close);
			if(tempnum!=0){
			StockVaRunit temp=new StockVaRunit(tempid,tempnum);
			result.add(temp);
			}
		}
		return result;
	}

	
	public static void main(String[] args) throws Exception {
		VaRCalServiceImpl here=new VaRCalServiceImpl();
		System.out.println(here.getMonte(10000, "sh600004", 30, 10, 0.9));
	}
}
