package po;

import java.util.List;

public class IndustryInfPack {
	/**行业名称*/
	public String cname;
	/**股票代码*/
	public String sid;
	/**行业股票信息*/
	public IndustryInf industryInf;
	/**行业股票信息列表*/
	public List<IndustryInf> industryInfList;
	public IndustryInfPack() {
		super();
		this.cname="";
		this.sid="";
		this.industryInf = null;
		this.industryInfList=null;
	}
	public IndustryInfPack(String cname, String sid, IndustryInf industryInf,
			List<IndustryInf> industryInfList) {
		super();
		this.cname = cname;
		this.sid = sid;
		this.industryInf = industryInf;
		this.industryInfList = industryInfList;
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
	public IndustryInf getIndustryInf() {
		return industryInf;
	}
	public void setIndustryInf(IndustryInf industryInf) {
		this.industryInf = industryInf;
	}
	public List<IndustryInf> getIndustryInfList() {
		return industryInfList;
	}
	public void setIndustryInfList(List<IndustryInf> industryInfList) {
		this.industryInfList = industryInfList;
	}
	@Override
	public String toString() {
		return "IndustryInfPack [cname=" + cname + ", sid=" + sid
				+ ", industryInf=" + industryInf + ", industryInfList="
				+ industryInfList + "]";
	}
}