package vo;

import java.util.ArrayList;
import java.util.List;

import backtest.DateDouble;
import function.Function;
import function.choose.ChooseStock;
import function.order.ShareFunction;

public class RealTestVO {
	/**目前现金*/
	public double cash;
	/**交易周期*/
	public int n;
	/**股票池*/
	public List<ChooseStock> stockList;
	/**风险控制*/
	public List<List<Function>> risk;
	/**交易标志和订单类型的列表*/
	public List<Flag> flags;
	/**各股持股*/
	public List<Integer> numlist;
	/**今日资本*/
	public List<DateDouble> capital;
	/**历史记录*/
	public List<String> history;
	
	public RealTestVO(){
		cash=10000;
		n=1;
		stockList=null;
		risk=null;
		flags=null;
		numlist=null;
		capital=null;
		history=null;
	}
	
	public RealTestVO(double cash, int n, List<ChooseStock> stockList,
			List<Flag> flags, List<Integer> numList,
			List<DateDouble> capital,List<List<Function>> risk,List<String> history) {
		this();
		this.cash = cash;
		this.n = n;
		this.stockList = stockList;
		this.flags = flags;
		this.numlist = numList;
		this.capital = capital;
		this.risk=risk;
		this.history=history;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public List<Integer> getNumList() {
		return numlist;
	}
	public void setNumList(List<Integer> numList) {
		this.numlist = numList;
	}
	public List<DateDouble> getCapital() {
		return capital;
	}
	public void setCapital(List<DateDouble> capital) {
		this.capital = capital;
	}
	public List<String> getHistory() {
		return history;
	}
	public void setHistory(List<String> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "RealTestVO [cash=" + cash + ", n=" + n + ", stockList="
				+ stockList + ", risk=" + risk + ", flags=" + flags
				+ ", numlist=" + numlist + ", capital=" + capital
				+ ", history=" + history + "]";
	}
}
