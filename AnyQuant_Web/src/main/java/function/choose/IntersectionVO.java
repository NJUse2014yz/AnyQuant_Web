package function.choose;

import java.util.List;

public class IntersectionVO {
	public List<String> stockList1;
	public List<String> stockList2;
	public IntersectionVO(List<String> stockList1, List<String> stockList2) {
		super();
		this.stockList1 = stockList1;
		this.stockList2 = stockList2;
	}
	public List<String> getStockList1() {
		return stockList1;
	}
	public void setStockList1(List<String> stockList1) {
		this.stockList1 = stockList1;
	}
	public List<String> getStockList2() {
		return stockList2;
	}
	public void setStockList2(List<String> stockList2) {
		this.stockList2 = stockList2;
	}
	@Override
	public String toString() {
		return "IntersectionVO [stockList1=" + stockList1 + ", stockList2="
				+ stockList2 + "]";
	}
}
