package vo;

public class StockVaRunit {

	private String stockid;
	private int num_of_stock;
	
	public StockVaRunit(String stockid, int num_of_stock) {
		this.stockid = stockid;
		this.num_of_stock = num_of_stock;
	}

	public String getStockid() {
		return stockid;
	}

	public void setStockid(String stockid) {
		this.stockid = stockid;
	}

	public int getNum_of_stock() {
		return num_of_stock;
	}

	public void setNum_of_stock(int num_of_stock) {
		this.num_of_stock = num_of_stock;
	}
	
	
	
	
}
