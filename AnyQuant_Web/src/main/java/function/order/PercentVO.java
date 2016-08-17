package function.order;

public class PercentVO {
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double percent;
	public double price;
	
	public PercentVO(int order, String siid, double percent, double price) {
		super();
		this.order = order;
		this.siid = siid;
		this.percent = percent;
		this.price = price;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PercentVO [order=" + order + ", siid=" + siid + ", percent="
				+ percent + ", price=" + price + "]";
	}
}
