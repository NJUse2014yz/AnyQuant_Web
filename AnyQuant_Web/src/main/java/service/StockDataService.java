package service;

import java.util.List;

import common.Ktype;
import common.Ltype;
import common.MarketType;
import vo.AllBigDealInf;
import vo.HaltStockInf;
import vo.KgraInf;
import vo.LinegraInf;
import vo.NewStockInf;
//import vo.RealTimeInf;
import vo.StockListInf;
import vo.StockNewsInf;
import vo.StockTopInf;

/**
 * 股票数据处理
 * @author zhangqi
 * @date 2016年5月9日
 */
public interface StockDataService {
	//查询股票列表数据（输入页号，显示该页的股票条目信息）
	public List<StockListInf> showListStock(int n)throws Exception;
	//获得单只股票的基础信息
	public StockListInf showSingleStock(String id)throws Exception;
	//获得单只股票的一段历史数据
	public List<StockListInf> showHistory(String id,String date1,String date2)throws Exception;
	//股票序号查询
	public List<StockListInf> searchStock(String key)throws Exception;
	//股票的分时图
//	public List<RealTimeInf> getRealTime(String id)throws Exception;
	//股票的K线图数据
	public List<KgraInf> getKgraph(String id,Ktype type,String date1,String date2) throws Exception;
	//股票的折线图数据
	public List<LinegraInf> getLinegraph(String id,Ltype type,String date1,String date2)throws Exception;
	//得到龙虎榜(前10位)
	public List<StockTopInf> getRank()throws Exception;
	//得到沪深指数的列表
	public List<StockListInf> getIndiceList(MarketType type) throws Exception;
	//股票比较   返回类型待定
	public void Compare(String sid1,String sid2)throws Exception;
	//指定股票的新闻信息
	public List<StockNewsInf> getStockNews(String id) throws Exception;
	//新股上市信息
	public List<NewStockInf> getNewStocks()throws Exception;
	//停牌股票信息
	public List<HaltStockInf> getHaltStock() throws Exception;
	//大单信息
	public AllBigDealInf getdeal(String id)throws Exception;
}
