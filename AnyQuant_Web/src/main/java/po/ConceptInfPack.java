package po;

import java.util.List;

public class ConceptInfPack {
	/**行业名称*/
	public String cname;
	/**股票代码*/
	public String sid;
	/**行业股票信息*/
	public ConceptInf conceptInf;
	/**行业股票信息列表*/
	public List<ConceptInf> conceptInfList;
	public ConceptInfPack() {
		super();
		this.cname="";
		this.sid="";
		this.conceptInf = null;
		this.conceptInfList=null;
	}
	public ConceptInfPack(String cname, String sid, ConceptInf conceptInf,
			List<ConceptInf> conceptInfList) {
		super();
		this.cname = cname;
		this.sid = sid;
		this.conceptInf = conceptInf;
		this.conceptInfList = conceptInfList;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public ConceptInf getConceptInf() {
		return conceptInf;
	}
	public void setConceptInf(ConceptInf conceptInf) {
		this.conceptInf = conceptInf;
	}
	public List<ConceptInf> getConceptInfList() {
		return conceptInfList;
	}
	public void setConceptInfList(List<ConceptInf> conceptInfList) {
		this.conceptInfList = conceptInfList;
	}
	@Override
	public String toString() {
		return "ConceptInfPack [cname=" + cname + ", sid=" + sid
				+ ", conceptInf=" + conceptInf + ", conceptInfList="
				+ conceptInfList + "]";
	}
}