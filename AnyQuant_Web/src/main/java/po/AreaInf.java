package po;

public class AreaInf {
	private String sid;
	private String name;
	private String area;
	public AreaInf() {
		super();
		this.sid = "";
		this.name = "";
		this.area = "";
	}
	public AreaInf(String sid, String name, String area) {
		super();
		this.sid = sid;
		this.name = name;
		this.area = area;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "AreaInf [sid=" + sid + ", name=" + name + ", area=" + area
				+ "]";
	}
}
