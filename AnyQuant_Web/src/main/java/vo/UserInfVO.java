package vo;

import java.util.List;

import po.UserInf;
import tool.JsonExchangeTool;

public class UserInfVO {
	public String userName;
	public int rank;
	public double score;
	public List<String> stocks;
	
	public UserInfVO(String userName, int rank, double score,
			List<String> stocks) {
		super();
		this.userName = userName;
		this.rank = rank;
		this.score = score;
		this.stocks = stocks;
	}
	public UserInfVO(UserInf inf)
	{
		this.userName=inf.userName;
		this.rank=inf.rank;
		this.score=inf.score;
		this.stocks=JsonExchangeTool.getSaveStocks(inf.stocks);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public List<String> getStocks() {
		return stocks;
	}
	public void setStocks(List<String> stocks) {
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "UserInfVO [userName=" + userName + ", rank=" + rank
				+ ", score=" + score + ", stocks=" + stocks + "]";
	}
}
