package po;

public class UserInf {
	public String userName;
	public String password;
	public int rank;
	public long score;
	public String stocks;
	
	public UserInf()
	{
		super();
	}
	public UserInf(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public String getStocks() {
		return stocks;
	}
	public void setStocks(String stocks) {
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "UserInf [userName=" + userName + ", password=" + password
				+ ", rank=" + rank + ", score=" + score + ", stocks=" + stocks
				+ "]";
	}
}
