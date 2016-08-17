package po;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.StrategyVO;

public class Strategy {
	/**用户名*/
	public String userName;
	/**创建用户名（若是用户收藏的策略则这一项为其他用户名）*/
	public String createrName;
	/**策略名*/
	public String strategyName;
	/**订单类型的Json*/
	public String orderType;
	/**选股列表List<ChooseStock>的Json*/
	public String stockList;
	/**选股方法列表List<List<Function>>(内列表且，外列表或)的Json*/
	public String choose;
	/**出入场标志列表List<List<Function>>(内列表且，外列表或)的Json*/
	public String flagList;
	/**实测结果*/
	public String realTest;

	public Strategy(){}

	public Strategy(String userName, String createrName, String strategyName,
			String orderType, String stockList, String choose, String flagList,
			String realTest) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.orderType = orderType;
		this.stockList = stockList;
		this.choose = choose;
		this.flagList = flagList;
		this.realTest = realTest;
	}

	public Strategy(StrategyVO vo)
	{
		this.userName=vo.userName;
		this.createrName=vo.createrName;
		this.strategyName=vo.strategyName;
		this.orderType=JSONObject.fromObject(vo.getOrderType()).toString();
		this.choose=JSONArray.fromObject(vo.getChoose()).toString();
		this.stockList=JSONArray.fromObject(vo.getStockList()).toString();
		this.flagList=JSONArray.fromObject(vo.getFlagList()).toString();
		this.realTest=JSONObject.fromObject(vo.getRealTest()).toString();
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public String getFlagList() {
		return flagList;
	}

	public void setFlagList(String flagList) {
		this.flagList = flagList;
	}

	public String getRealTest() {
		return realTest;
	}

	public void setRealTest(String realTest) {
		this.realTest = realTest;
	}

	@Override
	public String toString() {
		return "Strategy [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName
				+ ", orderType=" + orderType + ", stockList=" + stockList
				+ ", choose=" + choose + ", flagList=" + flagList
				+ ", realTest=" + realTest + "]";
	}
}