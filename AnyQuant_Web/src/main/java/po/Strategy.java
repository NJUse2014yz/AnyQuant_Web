package po;

import java.util.List;

import backtest.TestReport;
import function.Function;
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
	/**选股列表List<ChooseStock>的Json*/
	public String stockList;
	/**选股方法列表List<List<Function>>(内列表且，外列表或)的Json*/
	public String choose;
	/**风险控制*/
	public String risk;
	/**交易标志和对应订单类型列表的Json*/
	public String flags;
	/**实测结果*/
	public String realTest;
	/**回测报告*/
	public String report;
	/**积分*/
	public double score;
	/**公开性*/
	public int privacy;
	
	public Strategy()
	{
		this.userName=null;
		this.createrName=null;
		this.strategyName=null;
		this.choose=null;
		this.stockList=null;
		this.risk=null;
		this.flags=null;
		this.realTest=null;
		this.report=null;
		this.score=0;
		this.privacy=0;
	}

	public Strategy(StrategyVO vo)
	{
		this();
		this.userName=vo.userName;
		this.createrName=vo.createrName;
		this.strategyName=vo.strategyName;
		this.choose=JSONArray.fromObject(vo.getChoose()).toString();
		this.stockList=JSONArray.fromObject(vo.getStockList()).toString();
		this.risk=JSONArray.fromObject(vo.getRisk()).toString();
		this.flags=JSONArray.fromObject(vo.getFlags()).toString();
		this.realTest=JSONObject.fromObject(vo.getRealTest()).toString();
		this.report=JSONObject.fromObject(vo.report).toString();
		this.score=vo.score;
		this.privacy=vo.privacy;
	}

	public Strategy(String userName, String createrName, String strategyName,
			String stockList, String choose, String risk, String flags,
			String realTest, String report, double score, int privacy) {
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

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getRealTest() {
		return realTest;
	}

	public void setRealTest(String realTest) {
		this.realTest = realTest;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
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
		return "Strategy [userName=" + userName + ", createrName="
				+ createrName + ", strategyName=" + strategyName
				+ ", stockList=" + stockList + ", choose=" + choose + ", risk="
				+ risk + ", flags=" + flags + ", realTest=" + realTest
				+ ", report=" + report + ", score=" + score + ", privacy="
				+ privacy + "]";
	}
	
}