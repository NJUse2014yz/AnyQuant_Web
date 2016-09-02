package po;

public class UserInf {
	public String userName;
	public String password;
	public int rank;
	public long score;
	public String stocks;
	
	
	public UserInf() {
		this.userName = null;
		this.password = null;
		this.rank = 0;
		this.score = 0;
		this.stocks = null;
	}

	public UserInf(String userName, String password) {
		this();
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
