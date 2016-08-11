package function.flag;

public class CrossVO {
	public String siid1;
	public String attribute1;
	public String siid2;
	public String attribute2;
	public long start;
	public long end;
	public CrossVO(String siid1, String attribute1, String siid2,
			String attribute2, long start, long end) {
		super();
		this.siid1 = siid1;
		this.attribute1 = attribute1;
		this.siid2 = siid2;
		this.attribute2 = attribute2;
		this.start = start;
		this.end = end;
	}
	public String getSiid1() {
		return siid1;
	}
	public void setSiid1(String siid1) {
		this.siid1 = siid1;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getSiid2() {
		return siid2;
	}
	public void setSiid2(String siid2) {
		this.siid2 = siid2;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
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
	@Override
	public String toString() {
		return "CrossVO [siid1=" + siid1 + ", attribute1=" + attribute1
				+ ", siid2=" + siid2 + ", attribute2=" + attribute2
				+ ", start=" + start + ", end=" + end + "]";
	}
}
