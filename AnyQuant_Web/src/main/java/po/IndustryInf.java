package po;

public class IndustryInf {
	private String sid;
	private String name;
	private String cname;
	
	public IndustryInf()
	{
		this.sid = null;
		this.name = null;
		this.cname = null;
	}
	public IndustryInf(String sid, String name, String cname) {
		this();
		this.sid = sid;
		this.name = name;
		this.cname = cname;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "IndustryInf [sid=" + sid + ", name=" + name + ", cname="
				+ cname + "]";
	}
}
