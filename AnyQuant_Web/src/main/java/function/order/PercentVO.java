package function.order;

public class PercentVO {
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double percent;
	public PercentVO(int order, String siid, double percent) {
		super();
		this.order = order;
		this.siid = siid;
		this.percent = percent;
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
	@Override
	public String toString() {
		return "ValuePercentVO [order=" + order + ", siid=" + siid
				+ ", percent=" + percent + "]";
	}
}
