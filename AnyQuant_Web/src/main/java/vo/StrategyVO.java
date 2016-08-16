package vo;

import java.util.List;

import function.Function;
import function.choose.ChooseStock;

public class StrategyVO {
	/**用户名*/
	public String userName;
	/**创建用户名（若是用户收藏的策略则这一项为其他用户名）*/
	public String createrName;
	/**策略名*/
	public String strategyName;
	/**订单类型*/
	public Function orderType;
	/**选股列表*/
	public List<ChooseStock> stockList;
	/**选股方法列表(内列表且，外列表或)*/
	public List<List<Function>> choose;
	/**出入场标志列表(内列表且，外列表或)*/
	public List<List<Function>> flag;
	
	public StrategyVO(String userName, String createrName, String strategyName,
			Function orderType, List<ChooseStock> stockList,
			List<List<Function>> choose, List<List<Function>> flag) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.orderType = orderType;
		this.stockList = stockList;
		this.choose = choose;
		this.flag = flag;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getStrategyName() {
		return strategyName;
	}
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	public Function getOrderType() {
		return orderType;
	}
	public void setOrderType(Function orderType) {
		this.orderType = orderType;
	}
	public List<ChooseStock> getStockList() {
		return stockList;
	}
	public void setStockList(List<ChooseStock> stockList) {
		this.stockList = stockList;
	}
	public List<List<Function>> getChoose() {
		return choose;
	}
	public void setChoose(List<List<Function>> choose) {
		this.choose = choose;
	}
	public List<List<Function>> getFlag() {
		return flag;
	}
	public void setFlag(List<List<Function>> flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "StrategyVO [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName
				+ ", orderType=" + orderType + ", stockList=" + stockList
				+ ", choose=" + choose + ", flag=" + flag + "]";
	}
}
