package po;

public class StrategySearch {
	public String userName;
	public String createrName;
	public String strategyName;
	public String str;
	public int i;
	public double d;
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
	
	public StrategySearch(String userName, String createrName,
			String strategyName, String str, int i, double d) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.str = str;
		this.i = i;
		this.d = d;
	}

	public StrategySearch(String userName, String createrName,
			String strategyName,String str) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.str=str;
	}
	
	
	public StrategySearch(String userName, String createrName,
			String strategyName, String str, double d) {
		super();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.str = str;
		this.d = d;
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
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "StrategySearch [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName + ", str="
				+ str + ", i=" + i + ", d=" + d + "]";
	}
}
