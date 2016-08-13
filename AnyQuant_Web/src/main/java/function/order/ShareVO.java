package function.order;

public class ShareVO {
	public int order;
	public String siid;
	public int share;
	public ShareVO(int order, String siid, int share) {
		super();
		this.order = order;
		this.siid = siid;
		this.share = share;
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
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	@Override
	public String toString() {
		return "ShareVO [order=" + order + ", siid=" + siid + ", share="
				+ share + "]";
	}
}
