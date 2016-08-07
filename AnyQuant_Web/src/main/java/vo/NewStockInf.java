package vo;
//新股上市数据
public class NewStockInf {
	
	public String code;//股票代码
	public String name;//股票名称
	public String ipo_date;//上网发行日期
	public String issue_date;//上市日期
	

	public int amount;//发行数量(万股)
	public int markets;//上网发行数量(万股)
	public double price;//发行价格(元)
	public double pe;//发行市盈率
	public double limit;//个人申购上限(万股)
	public double funds;//募集资金(亿元)
	public String ballot;//网上中签率(%)

	public NewStockInf() {
		this.code = "";
		this.name = "";
		this.ipo_date = "";
		this.issue_date = "";
		this.amount = 0;
		this.markets = 0;
		this.price = 0.0;
		this.pe = 0.0;
		this.limit = 0.0;
		this.funds = 0.0;
		this.ballot = "";
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpo_date() {
		return ipo_date;
	}

	public void setIpo_date(String ipo_date) {
		this.ipo_date = ipo_date;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMarkets() {
		return markets;
	}

	public void setMarkets(int markets) {
		this.markets = markets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPe() {
		return pe;
	}

	public void setPe(double pe) {
		this.pe = pe;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public String getBallot() {
		return ballot;
	}

	public void setBallot(String ballot) {
		this.ballot = ballot;
	}
	
}
