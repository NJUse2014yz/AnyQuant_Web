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
	
	public StockInf()
	{
		super();
		id=-1;
		sid="";
		sname="";
		date=null;
		hisid=-1;
		quoid=-1;
		weekid=-1;
		weekhisid=-1;
		weekquoid=-1;
		monthid=-1;
		monthhisid=-1;
		monthquoid=-1;
	}
	public StockInf(String sid,String name)
	{
		super();
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
	}
	public StockInf(int id, String sid, String sname, Date date, int hisid,
			int quoid, int weekid, int weekhisid, int weekquoid, int monthid,
			int monthhisid, int monthquoid) {
		super();
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

	@Override
	public String toString() {
		return "StockInf [id=" + id + ", sid=" + sid + ", sname=" + sname
				+ ", date=" + date + ", hisid=" + hisid + ", quoid=" + quoid
				+ ", weekid=" + weekid + ", weekhisid=" + weekhisid
				+ ", weekquoid=" + weekquoid + ", monthid=" + monthid
				+ ", monthhisid=" + monthhisid + ", monthquoid=" + monthquoid
				+ "]";
	}
	
}
