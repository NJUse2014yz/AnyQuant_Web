package vo;

import java.util.List;

import po.Strategy;
import tool.JsonExchangeTool;
import function.Function;
import function.choose.ChooseStock;

public class StrategyVO {
	/**用户名*/
	public String userName;
	/**创建用户名（若是用户收藏的策略则这一项为其他用户名）*/
	public String createrName;
	/**策略名*/
	public String strategyName;
	/**订单类型，可以只传入无参数的对象*/
	public Function orderType;
	/**选股列表，percent相加为1，选股可为choose的结果也可以手动加入*/
	public List<ChooseStock> stockList;
	/**选股方法列表(内列表各元素（类）'且'关系，外列表各元素（列表）'或'关系)*/
	public List<List<Function>> choose;
	/**出入场标志列表(内列表'且'，外列表'或')*/
	public List<List<Function>> flagList;
	/**实测结果*/
	public RealTestVO realTest;
	
	public StrategyVO(){}
	
	public StrategyVO(String userName, String createrName, String strategyName,
			Function orderType, List<ChooseStock> stockList,
			List<List<Function>> choose, List<List<Function>> flagList,
			RealTestVO realTest) {
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

	public StrategyVO(Strategy strategy)
	{
		this.userName=strategy.userName;
		this.createrName=strategy.createrName;
		this.strategyName=strategy.strategyName;
		this.orderType=JsonExchangeTool.getOrder(strategy.orderType);
		this.stockList=JsonExchangeTool.getStock(strategy.stockList);
		this.choose=JsonExchangeTool.getFunction(strategy.choose);
		this.flagList=JsonExchangeTool.getFunction(strategy.flagList);
		this.realTest=JsonExchangeTool.getRealTest(strategy.realTest);
		this.realTest.flagList=this.flagList;
		this.realTest.stockList=this.stockList;
		this.realTest.orderType=this.orderType;
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

	public List<List<Function>> getFlagList() {
		return flagList;
	}

	public void setFlagList(List<List<Function>> flagList) {
		this.flagList = flagList;
	}

	public RealTestVO getRealTest() {
		return realTest;
	}

	public void setRealTest(RealTestVO realTest) {
		this.realTest = realTest;
	}

	@Override
	public String toString() {
		return "StrategyVO [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName
				+ ", orderType=" + orderType + ", stockList=" + stockList
				+ ", choose=" + choose + ", flagList=" + flagList
				+ ", realTest=" + realTest + "]";
	}
}
