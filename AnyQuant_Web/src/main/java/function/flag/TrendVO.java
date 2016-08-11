package function.flag;

public class TrendVO {
	public String siid;
	public String attribute;
	public long start;
	public long end;
	public double standard;
	
	public TrendVO(String siid, String attribute, long start, long end,
			double standard) {
		super();
		this.siid = siid;
		this.attribute = attribute;
		this.start = start;
		this.end = end;
		this.standard = standard;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public double getStandard() {
		return standard;
	}
	public void setStandard(double standard) {
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "TrendVO [siid=" + siid + ", attribute=" + attribute
				+ ", start=" + start + ", end=" + end + ", standard="
				+ standard + "]";
	}
}
