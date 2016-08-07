package po;

import java.sql.Date;

import tool.DateExchangeTool;

/**
 * @for 指数信息
 * @member 编号 id(-1), 指数代码 iid(""), 指数名称 iname("")
 * @author YU Fan
 * @date 2016年5月19日
 */
public class IndiceInf {
	/**编号*/
	private int id;
	/**指数代码*/
	private String iid;
	/**指数名称*/
	private String iname;
	/**更新日期*/
	private Date date;
	/**历史数据中最新id*/
	private int hisid;
	/**指标数据中最新id*/
	private int quoid;
	/**最近在历史数据中的weekid*/
	private int weekid;
	/**最近在周数据中的id*/
	private int weekhisid;
	/**最近在周指标数据中的id*/
	private int weekquoid;
	/**最近在历史数据中的monthid*/
	private int monthid;
	/**最近在月数据中的id*/
	private int monthhisid;
	/**最近在月指标数据中的id*/
	private int monthquoid;
	
	public IndiceInf() {
		super();
		this.id = -1;
		this.iid = "";
		this.iname = "";
		this.date = null;
		this.hisid = -1;
		this.quoid = -1;
		this.weekid = -1;
		this.weekhisid = -1;
		this.weekquoid = -1;
		this.monthid = -1;
		this.monthhisid = -1;
		this.monthquoid = -1;
	}
	public IndiceInf(int id, String iid, String iname, Date date, int hisid,
			int quoid, int weekid, int weekhisid, int weekquoid, int monthid,
			int monthhisid, int monthquoid) {
		super();
		this.id = id;
		this.iid = iid;
		this.iname = iname;
		this.date = date;
		this.hisid = hisid;
		this.quoid = quoid;
		this.weekid = weekid;
		this.weekhisid = weekhisid;
		this.weekquoid = weekquoid;
		this.monthid = monthid;
		this.monthhisid = monthhisid;
		this.monthquoid = monthquoid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHisid() {
		return hisid;
	}
	public void setHisid(int hisid) {
		this.hisid = hisid;
	}
	public int getQuoid() {
		return quoid;
	}
	public void setQuoid(int quoid) {
		this.quoid = quoid;
	}
	public int getWeekid() {
		return weekid;
	}
	public void setWeekid(int weekid) {
		this.weekid = weekid;
	}
	public int getWeekhisid() {
		return weekhisid;
	}
	public void setWeekhisid(int weekhisid) {
		this.weekhisid = weekhisid;
	}
	public int getWeekquoid() {
		return weekquoid;
	}
	public void setWeekquoid(int weekquoid) {
		this.weekquoid = weekquoid;
	}
	public int getMonthid() {
		return monthid;
	}
	public void setMonthid(int monthid) {
		this.monthid = monthid;
	}
	public int getMonthhisid() {
		return monthhisid;
	}
	public void setMonthhisid(int monthhisid) {
		this.monthhisid = monthhisid;
	}
	public int getMonthquoid() {
		return monthquoid;
	}
	public void setMonthquoid(int monthquoid) {
		this.monthquoid = monthquoid;
	}
	@Override
	public String toString() {
		return "IndiceInf [id=" + id + ", iid=" + iid + ", iname=" + iname
				+ ", date=" + date + ", hisid=" + hisid + ", quoid=" + quoid
				+ ", weekid=" + weekid + ", weekhisid=" + weekhisid
				+ ", weekquoid=" + weekquoid + ", monthid=" + monthid
				+ ", monthhisid=" + monthhisid + ", monthquoid=" + monthquoid
				+ "]";
	}
}
