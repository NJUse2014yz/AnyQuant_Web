package service;

import java.sql.Date;
import java.util.List;

import function.Function;
import function.choose.ChooseStock;
import backtest.TestReport;

public interface BackTestService {
	/**完全自定义回测，返回回测报告：
	 * 股票和对应占比（0~1之间的一个数，且和为1）的列表
	 * 运用的方法列表
	 * 订单类型
	 * 初始金额
	 * 回测开始日期
	 * 回测结束日期
	 * 交易周期
	 * 基准大盘指数
	 * */
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList,Function orderType,
			double cash,Date startdate,Date enddate,int n,
			String benchmark) throws Exception;
	
	/**部分自定义回测，返回回测报告：
	 * 股票和对应占比（0~1之间的一个数，且和为1）的列表
	 * 运用的方法列表
	 * 订单类型
	 * 交易周期
	 * 基准大盘指数
	 * */
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList,Function orderType,
			int n,String benchmark) throws Exception;
	
	/**部分自定义回测，返回回测报告：
	 * 股票和对应占比（0~1之间的一个数，且和为1）的列表
	 * 运用的方法列表
	 * 订单类型
	 * 基准大盘指数
	 * */
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList,Function orderType,
			String benchmark) throws Exception;
	
	/**部分自定义回测，返回回测报告：
	 * 股票和对应占比（0~1之间的一个数，且和为1）的列表
	 * 运用的方法列表
	 * 订单类型
	 * 交易周期
	 * */
	public TestReport backtest(List<ChooseStock> stockList,
			List<Function> flagList,Function orderType,int n) throws Exception;
	
	
}
