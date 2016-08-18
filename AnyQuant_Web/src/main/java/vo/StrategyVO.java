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
	/**选股列表，percent相加为1，选股可为choose的结果也可以手动加入*/
	public List<ChooseStock> stockList;
	/**选股方法列表(内列表各元素（类）'且'关系，外列表各元素（列表）'或'关系)*/
	public List<List<Function>> choose;
	/**交易标志方法和对应订单类型的列表，优先级高的排在前*/
	public List<Flag> flags;
	
	/**实测结果*/
	public RealTestVO realTest;
	
	public StrategyVO(){}

	public StrategyVO(Strategy strategy)
	{
		this.userName = strategy.userName;
		this.createrName = strategy.createrName;
		this.strategyName = strategy.strategyName;
		this.stockList=JsonExchangeTool.getStock(strategy.stockList);
		this.choose=JsonExchangeTool.getFunction(strategy.choose);
		this.flags=JsonExchangeTool.getFlag(strategy.flags);
		this.realTest=JsonExchangeTool.getRealTest(strategy.realTest);
	}
	
	public StrategyVO(String userName, String createrName, String strategyName,
			List<ChooseStock> stockList, List<List<Function>> choose,
			List<Flag> flags, RealTestVO realTest) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.stockList = stockList;
		this.choose = choose;
		this.flags = flags;
		this.realTest = realTest;
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

	public List<Flag> getFlags() {
		return flags;
	}

	public void setFlags(List<Flag> flags) {
		this.flags = flags;
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
				+ ", stockList=" + stockList + ", choose=" + choose
				+ ", flags=" + flags + ", realTest=" + realTest + "]";
	}
}
