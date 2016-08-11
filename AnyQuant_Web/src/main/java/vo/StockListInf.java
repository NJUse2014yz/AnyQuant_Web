package vo;

import java.sql.Date;

public class StockListInf {
	// StockData的列表信息
	public String stockId;
	public String name;
	/** 日期 */
	public String date;
	/** 开盘价 */
	public double open;
	/** 收盘价 */
	public double close;
	/** 涨跌额 */
	public double increase;
	/** 涨跌百分比 */
	public double incrPer;
	/** 最低价 */
	public double low;
	/** 最高价 */
	public double high;
	/** 成交量 */
	public long volume;
	/** 成交额 */
	public long amount;
	/** 换手率 */
	public double turnover;
	
	/**配对1*/
	public String partner1;
	/**系数1*/
	public double coe1;
	/**配对2*/
	public String partner2;
	/**系数2*/
	public double coe2;
	/**配对3*/
	public String partner3;
	/**系数3*/
	public double coe3;

	public StockListInf(String stockId, String date, double open, double close, double increase, double incrPer,
			double low, double high, long volume, long amount, double turnover) {
		super();
		this.stockId = stockId;
		this.date = date;
		this.open = open;
		this.close = close;
		this.increase = increase;
		this.incrPer = incrPer;
		this.low = low;
		this.high = high;
		this.volume = volume;
		this.amount = amount;
		this.turnover = turnover;
	}

	public StockListInf() {
		stockId = null;
		this.date = null;
		this.open = 0;
		this.close = 0;
		this.increase = 0;
		this.incrPer = 0;
		this.low = 0;
		this.high = 0;
		this.volume = 0;
		this.amount = 0;
		this.turnover = 0;
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getIncrease() {
		return increase;
	}

	public void setIncrease(double increase) {
		this.increase = increase;
	}

	public double getIncrPer() {
		return incrPer;
	}

	public void setIncrPer(double incrPer) {
		this.incrPer = incrPer;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public String getPartner1() {
		return partner1;
	}

	public void setPartner1(String partner1) {
		this.partner1 = partner1;
	}

	public double getCoe1() {
		return coe1;
	}

	public void setCoe1(double coe1) {
		this.coe1 = coe1;
	}

	public String getPartner2() {
		return partner2;
	}

	public void setPartner2(String partner2) {
		this.partner2 = partner2;
	}

	public double getCoe2() {
		return coe2;
	}

	public void setCoe2(double coe2) {
		this.coe2 = coe2;
	}

	public String getPartner3() {
		return partner3;
	}

	public void setPartner3(String partner3) {
		this.partner3 = partner3;
	}

	public double getCoe3() {
		return coe3;
	}

	public void setCoe3(double coe3) {
		this.coe3 = coe3;
	}
}
