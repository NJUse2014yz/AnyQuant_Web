package vo;

import java.util.List;

import function.Function;

public class SelfStrategy {
	public String userName;
	public String strategyName;
	public List<ChooseStock> stockList;
	public List<Function> choose;
	public List<Function> flag;
	
	public SelfStrategy()
	{
		
	}
	public SelfStrategy(String userName, String strategyName,
			List<ChooseStock> stockList, List<Function> choose,
			List<Function> flag) {
		super();
		this.userName = userName;
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
	public List<Function> getChoose() {
		return choose;
	}
	public void setChoose(List<Function> choose) {
		this.choose = choose;
	}
	public List<Function> getFlag() {
		return flag;
	}
	public void setFlag(List<Function> flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "SelfStrategy [userName=" + userName + ", strategyName="
				+ strategyName + ", stockList=" + stockList + ", choose="
				+ choose + ", flag=" + flag + "]";
	}
}
