package function.flag;

public class DataVO {
	public String siid;
	public String attribute;
	public DataVO(String siid, String attribute) {
		super();
		this.siid = siid;
		this.attribute = attribute;
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
	@Override
	public String toString() {
		return "DataVO [siid=" + siid + ", attribute=" + attribute + "]";
	}
}
