package po;

import net.sf.json.JSONArray;

public class Strategy {
	public String userName;
	public String createrName;
	public String strategyName;
	public String stockList;
	public String choose;
	public String flag;

	public Strategy()
	{
		
	}
	
	public Strategy(String userName, String createrName, String strategyName,
			String stockList, String choose, String flag) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
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
	public String getStockList() {
		return stockList;
	}
	public void setStockList(String stockList) {
		this.stockList = stockList;
	}
	public String getChoose() {
		return choose;
	}
	public void setChoose(String choose) {
		this.choose = choose;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "StrategyJson [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName
				+ ", stockList=" + stockList + ", choose=" + choose + ", flag="
				+ flag + "]";
	}
}
