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
	/**交易标志和订单类型的列表*/
	public List<Flag> flags;
	/**各股持股*/
	public List<Integer> numlist;
	/**今日资本*/
	public List<DateDouble> capital;
	
	public RealTestVO(){
		cash=10000;
		n=1;
		stockList=new ArrayList<ChooseStock>();
		flags=new ArrayList<Flag>();
		numlist=new ArrayList<Integer>();
		capital=new ArrayList<DateDouble>();
	}
	
	public RealTestVO(double cash, int n, List<ChooseStock> stockList,
			List<Flag> flags, List<Integer> numList,
			List<DateDouble> capital) {
		super();
		this.cash = cash;
		this.n = n;
		this.stockList = stockList;
		this.flags = flags;
		this.numlist = numList;
		this.capital = capital;
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

	@Override
	public String toString() {
		return "RealTestVO [cash=" + cash + ", n=" + n + ", stockList="
				+ stockList + ", flags=" + flags + ", numlist=" + numlist
				+ ", capital=" + capital + "]";
	}
}
