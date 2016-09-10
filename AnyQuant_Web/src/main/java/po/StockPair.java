package po;


public class StockPair {
	public String sid;
	public String partner1;
	public double coe1;
	public StockPair()
	{
		this.sid=null;
		this.partner1=null;
		this.coe1=-1;
	}
	public StockPair(String sid, String partner1, double coe1) {
		super();
		this.sid = sid;
		this.partner1 = partner1;
		this.coe1 = coe1;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
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
	@Override
	public String toString() {
		return "StockPair [sid=" + sid + ", partner1=" + partner1 + ", coe1="
				+ coe1 + "]";
	}
}
