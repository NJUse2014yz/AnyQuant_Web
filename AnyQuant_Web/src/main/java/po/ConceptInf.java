package po;

public class ConceptInf {
	public String sid;
	public String name;
	public String cname;
	public ConceptInf() {
		super();
		this.sid = "";
		this.name = "";
		this.cname = "";
	}
	public ConceptInf(String sid, String name, String cname) {
		super();
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
		return "ConceptInf [sid=" + sid + ", name=" + name + ", cname=" + cname
				+ "]";
	}
}
