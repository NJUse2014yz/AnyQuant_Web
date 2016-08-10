package vo;

import po.StockInf;

public class StockPair {
	public StockInf stock1;
	public StockInf stock2;
	public double correlation;
	public StockPair() {
		super();
		this.stock1 = null;
		this.stock2 = null;
		this.correlation = 0;
	}
	public StockPair(StockInf stock1, StockInf stock2, double correlation) {
		super();
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.correlation = correlation;
	}
	public StockInf getStock1() {
		return stock1;
	}
	public void setStock1(StockInf stock1) {
		this.stock1 = stock1;
	}
	public StockInf getStock2() {
		return stock2;
	}
	public void setStock2(StockInf stock2) {
		this.stock2 = stock2;
	}
	public double getCorrelation() {
		return correlation;
	}
	public void setCorrelation(double correlation) {
		this.correlation = correlation;
	}
	@Override
	public String toString() {
		return "StockPair [stock1=" + stock1 + ", stock2=" + stock2
				+ ", correlation=" + correlation + "]";
	}
}
