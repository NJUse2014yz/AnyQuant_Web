package function.flag;

public class DataVO {
	public String siid;
	public String attribute;
	public int day;
	
	public DataVO(String siid, String attribute,int day) {
		super();
		this.siid = siid;
		this.attribute = attribute;
		this.day=day;
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "DataVO [siid=" + siid + ", attribute=" + attribute + ", day="
				+ day + "]";
	}
}
