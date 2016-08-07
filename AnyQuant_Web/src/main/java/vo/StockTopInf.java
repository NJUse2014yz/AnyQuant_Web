package vo;

public class StockTopInf {
	public StockTopInf() {
	}
	public String stockId;
	public String name;
	public String pchange; //percent
	public double amount; //（万）
	public double buy; //（万）
	public double bratio;
	public double sell; //（万）
	public double sratio; 
	public String reason;
	public String date;
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPchange() {
		return pchange;
	}
	public void setPchange(String pchange) {
		this.pchange = pchange;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBuy() {
		return buy;
	}
	public void setBuy(double buy) {
		this.buy = buy;
	}
	public double getBratio() {
		return bratio;
	}
	public void setBratio(double bratio) {
		this.bratio = bratio;
	}
	public double getSell() {
		return sell;
	}
	public void setSell(double sell) {
		this.sell = sell;
	}
	public double getSratio() {
		return sratio;
	}
	public void setSratio(double sratio) {
		this.sratio = sratio;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
