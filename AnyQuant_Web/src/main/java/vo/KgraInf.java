package vo;

public class KgraInf {
	private static final long serialVersionUID = 1L;
	// 编号
	public String id;
	// 日期(周和月均取最后一天)
	public String date;
	// public Calendar date;
	// 最高价
	public double highPrice;
	// 最低价
	public double lowPrice;
	// 开盘价
	public double openPrice;
	// 收盘价
	public double closePrice;
	// 涨跌幅（正为涨，负为跌）
	public double increase;
	// 涨跌百分比（收盘-前一天收盘）/前一天收盘
	public double increPer;
	// 成交量
	public long volume;
	// 均值
	public double m5;
	public double m10;
	public double m20;
	public double m30;

	public KgraInf() {
		super();
		this.id = "";
		this.date = "";
		this.highPrice = 0;
		this.lowPrice = 0;
		this.openPrice = 0;
		this.closePrice = 0;
		this.increase = 0;
		this.increPer = 0;
		this.volume = 0;
		this.m5 = 0;
		this.m10 = 0;
		this.m20 = 0;
		this.m30 = 0;
	}

	/**
	 * @param id
	 * @param date
	 * @param high
	 * @param low
	 * @param open
	 * @param close
	 * @param increase
	 * @param percent
	 * @param trade
	 */
	public KgraInf(String id, String date, double high, double low, double open, double close, double increase,
			double percent, long trade, double m5, double m10, double m30) {
		super();
		this.id = id;
		this.date = date;
		this.highPrice = high;
		this.lowPrice = low;
		this.openPrice = open;
		this.closePrice = close;
		this.increase = increase;
		this.increPer = percent;
		this.volume = trade;
		this.m5 = m5;
		this.m10 = m10;
		this.m30 = m30;
	}

}