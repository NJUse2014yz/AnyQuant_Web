package function.order;

public class ValueVO {
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double value;
	public double price;
	public ValueVO(int order, String siid, double value, double price) {
		super();
		this.order = order;
		this.siid = siid;
		this.value = value;
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
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ValueVO [order=" + order + ", siid=" + siid + ", value="
				+ value + ", price=" + price + "]";
	}
}
