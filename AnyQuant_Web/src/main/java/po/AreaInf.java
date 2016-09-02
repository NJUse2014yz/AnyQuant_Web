package po;

public class AreaInf {
	private String sid;
	private String name;
	private String area;
	public AreaInf() {
		super();
		this.sid = null;
		this.name = null;
		this.area = null;
	}
	public AreaInf(String sid, String name, String area) {
		this();
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
