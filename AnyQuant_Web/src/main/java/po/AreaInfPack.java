package po;

import java.util.List;

public class AreaInfPack {
	/**地域名称*/
	public String area;
	/**股票代码*/
	public String sid;
	/**地域股票信息*/
	public AreaInf areaInf;
	/**地域股票信息列表*/
	public List<AreaInf> areaInfList;
	public AreaInfPack() {
		this.area=null;
		this.sid=null;
		this.areaInf = null;
		this.areaInfList=null;
	}
	public AreaInfPack(String area, String sid, AreaInf areaInf,
			List<AreaInf> areaInfList) {
		this();
		this.area = area;
		this.sid = sid;
		this.areaInf = areaInf;
		this.areaInfList = areaInfList;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public AreaInf getAreaInf() {
		return areaInf;
	}
	public void setAreaInf(AreaInf areaInf) {
		this.areaInf = areaInf;
	}
	public List<AreaInf> getAreaInfList() {
		return areaInfList;
	}
	public void setAreaInfList(List<AreaInf> areaInfList) {
		this.areaInfList = areaInfList;
	}
	@Override
	public String toString() {
		return "AreaInfPack [area=" + area + ", sid=" + sid + ", areaInf="
				+ areaInf + ", areaInfList=" + areaInfList + "]";
	}
	
}