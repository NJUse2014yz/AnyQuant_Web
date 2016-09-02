package po;

import java.io.Serializable;
import java.sql.Date;

import tool.DateExchangeTool;

/**
 * @for 股票信息
 * @member 编号 id(-1), 股票代码 sid(""), 股票名称 sname("")
 * @author YU Fan
 * @date 2016年5月19日
 */
public class StockInf {
	/**编号*/
	private int id;
	/**股票代码*/
	private String sid;
	/**股票名称*/
	private String sname;
	/**最近更新日期*/
	private Date date;
	/**最近在历史数据中的id*/
	private int hisid;
	/**最近在指标数据中的id*/
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
	/**配对股票*/
	private String partner1;
	/**相关系数*/
	private double coe1;
	/**配对股票*/
	private String partner2;
	/**相关系数*/
	private double coe2;
	/**配对股票*/
	private String partner3;
	/**相关系数*/
	private double coe3;
	public StockInf()
	{
		id=-1;
		sid=null;
		sname=null;
		date=null;
		hisid=-1;
		quoid=-1;
		weekid=-1;
		weekhisid=-1;
		weekquoid=-1;
		monthid=-1;
		monthhisid=-1;
		monthquoid=-1;
		partner1=null;
		coe1=0;
		partner2=null;
		coe2=0;
		partner3=null;
		coe3=0;
	}
	public StockInf(String sid,String name)
	{
		this();
		id=-1;
		this.sid=sid;
		this.sname=name;
		date=null;
		hisid=-1;
		quoid=-1;
		weekid=-1;
		weekhisid=-1;
		weekquoid=-1;
		monthid=-1;
		monthhisid=-1;
		monthquoid=-1;
		partner1=null;
		coe1=0;
		partner2=null;
		coe2=0;
		partner3=null;
		coe3=0;
	}
	public StockInf(int id, String sid, String sname, Date date, int hisid,
			int quoid, int weekid, int weekhisid, int weekquoid, int monthid,
			int monthhisid, int monthquoid) {
		this();
		this.id = id;
		this.sid = sid;
		this.sname = sname;
		this.date = date;
		this.hisid = hisid;
		this.quoid = quoid;
		this.weekid = weekid;
		this.weekhisid = weekhisid;
		this.weekquoid = weekquoid;
		this.monthid = monthid;
		this.monthhisid = monthhisid;
		this.monthquoid = monthquoid;
		partner1=null;
		coe1=0;
		partner2=null;
		coe2=0;
		partner3=null;
		coe3=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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
	public String getPartner1() {
		return partner1;
	}
	public void setPartner1(String partner1) {
		this.partner1 = partner1;
	}
	public double getCoe1() {
		return coe1;
	}
	public void setCoe1(double coe1) {
		this.coe1 = coe1;
	}
	public String getPartner2() {
		return partner2;
	}
	public void setPartner2(String partner2) {
		this.partner2 = partner2;
	}
	public double getCoe2() {
		return coe2;
	}
	public void setCoe2(double coe2) {
		this.coe2 = coe2;
	}
	public String getPartner3() {
		return partner3;
	}
	public void setPartner3(String partner3) {
		this.partner3 = partner3;
	}
	public double getCoe3() {
		return coe3;
	}
	public void setCoe3(double coe3) {
		this.coe3 = coe3;
	}
	@Override
	public String toString() {
		return "StockInf [id=" + id + ", sid=" + sid + ", sname=" + sname
				+ ", date=" + date + ", hisid=" + hisid + ", quoid=" + quoid
				+ ", weekid=" + weekid + ", weekhisid=" + weekhisid
				+ ", weekquoid=" + weekquoid + ", monthid=" + monthid
				+ ", monthhisid=" + monthhisid + ", monthquoid=" + monthquoid
				+ ", partner1=" + partner1 + ", coe1=" + coe1 + ", partner2="
				+ partner2 + ", coe2=" + coe2 + ", partner3=" + partner3
				+ ", coe3=" + coe3 + "]";
	}
}
