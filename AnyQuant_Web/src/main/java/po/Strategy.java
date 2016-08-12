package po;

import net.sf.json.JSONArray;

public class Strategy {
	/**用户名*/
	public String userName;
	/**创建用户名（若是用户收藏的策略则这一项为其他用户名）*/
	public String createrName;
	/**策略名*/
	public String strategyName;
	/**选股列表List<ChooseStock>的Json*/
	public String stockList;
	/**选股方法列表List<Function>的Json*/
	public String choose;
	/**出入场标志列表List<Function>的Json*/
	public String flag;

	public Strategy(){}

	
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
		return "Strategy [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName
				+ ", stockList=" + stockList + ", choose=" + choose + ", flag="
				+ flag + "]";
	}
	
}
