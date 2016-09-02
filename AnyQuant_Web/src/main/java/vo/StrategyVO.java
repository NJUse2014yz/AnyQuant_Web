package vo;

import java.util.List;

import backtest.TestReport;
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
	/**风险控制*/
	public List<List<Function>> risk;
	/**交易标志方法和对应订单类型的列表，优先级高的排在前*/
	public List<Flag> flags;	
	/**实测结果*/
	public RealTestVO realTest;
	/**回测报告*/
	public TestReport report;
	/**积分*/
	public double score;
	/**公开性,1为公开*/
	public int privacy;
	
	public StrategyVO()
	{
		this.userName = null;
		this.createrName = null;
		this.strategyName = null;
		this.stockList=null;
		this.choose=null;
		this.risk=null;
		this.flags=null;
		this.realTest=null;
		this.realTest.stockList=null;
		this.realTest.flags=null;
		this.realTest.risk=null;
		this.score=0;
		this.privacy=0;
		this.report=null;
	}

	public StrategyVO(Strategy strategy)
	{
		this();
		this.userName = strategy.userName;
		this.createrName = strategy.createrName;
		this.strategyName = strategy.strategyName;
		this.stockList=JsonExchangeTool.getStock(strategy.stockList);
		this.choose=JsonExchangeTool.getFunctionList(strategy.choose);
		this.risk=JsonExchangeTool.getFunctionList(strategy.risk);
		this.flags=JsonExchangeTool.getFlag(strategy.flags);
		this.realTest=JsonExchangeTool.getRealTest(strategy.realTest);
		this.realTest.stockList=this.stockList;
		this.realTest.flags=this.flags;
		this.realTest.risk=this.risk;
		this.score=strategy.score;
		this.privacy=strategy.privacy;
		try
		{
			this.report=JsonExchangeTool.getReport(strategy.report);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**指定策略时最常用的构造方法*/
	public StrategyVO(String userName, String createrName, String strategyName,
			List<ChooseStock> stockList, List<List<Function>> choose,
			List<List<Function>> risk, List<Flag> flags) {
		this();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.stockList = stockList;
		this.choose = choose;
		this.risk = risk;
		this.flags = flags;
	}
	public StrategyVO(String userName, String createrName, String strategyName,
			List<ChooseStock> stockList, List<List<Function>> choose,
			List<List<Function>> risk, List<Flag> flags, RealTestVO realTest,
			TestReport report, double score, int privacy) {
		this();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.stockList = stockList;
		this.choose = choose;
		this.risk = risk;
		this.flags = flags;
		this.realTest = realTest;
		this.report = report;
		this.score = score;
		this.privacy = privacy;
	}
	
	public StrategyVO(String userName, String createrName, String strategyName,
			List<ChooseStock> stockList, List<List<Function>> choose,
			List<List<Function>> risk, List<Flag> flags, RealTestVO realTest,
			TestReport report, double score) {
		this();
		this.userName = userName;
		this.createrName = createrName;
		this.strategyName = strategyName;
		this.stockList = stockList;
		this.choose = choose;
		this.risk = risk;
		this.flags = flags;
		this.realTest = realTest;
		this.report = report;
		this.score = score;
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

	public List<List<Function>> getRisk() {
		return risk;
	}

	public void setRisk(List<List<Function>> risk) {
		this.risk = risk;
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

	public TestReport getReport() {
		return report;
	}

	public void setReport(TestReport report) {
		this.report = report;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getPrivacy() {
		return privacy;
	}

	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}

	@Override
	public String toString() {
		return "StrategyVO [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName
				+ ", stockList=" + stockList + ", choose=" + choose + ", risk="
				+ risk + ", flags=" + flags + ", realTest=" + realTest
				+ ", report=" + report + ", score=" + score + ", privacy="
				+ privacy + "]";
	}
}
