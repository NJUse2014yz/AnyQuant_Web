package po;

public class StrategySearch {
	public String userName;
	public String createrName;
	public String strategyName;
	public StrategySearch()
	{
		
	}
	public StrategySearch(String userName, String createrName,
			String strategyName) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
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
	@Override
	public String toString() {
		return "StrategySearch [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName + "]";
	}
}
