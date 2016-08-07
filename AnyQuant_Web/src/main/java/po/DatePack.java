package po;

import java.sql.Date;
import java.sql.Time;

import tool.DateExchangeTool;


/**
 * @for 时间和代码的包装
 * @member 代码 ssid,日期 date
 * @author YU Fan
 * @date 2016年5月19日
 */
public class DatePack {
	/**代码*/
	private String siid;
	
	/**日期1*/
	private Date date1;
	/**时间1*/
	private Time time1;
	/**日1*/
	private int id1;
//	/**周1*/
//	private int weekid1;
//	/**月1*/
//	private int monthid1;
//	/**年1*/
//	private int yearid1;
	/**日期2*/
	private Date date2;
	/**时间2*/
	private Time time2;
	/**日1*/
	private int id2;
//	/**周1*/
//	private int weekid2;
//	/**月1*/
//	private int monthid2;
//	/**年1*/
//	private int yearid2;
	/**条数*/
	private int num;
	
	public DatePack() {
		super();
		this.siid = "";
		this.date1 = null;
		this.time1 = null;
		this.id1 = -1;
//		this.weekid1 = -1;
//		this.monthid1 = -1;
//		this.yearid1 = -1;
		this.date2 = null;
		this.time2 = null;
		this.id2 = -1;
//		this.weekid2 = -1;
//		this.monthid2 = -1;
//		this.yearid2 = -1;
		this.num = -1;
	}
	public DatePack(String siid, Date date1, Date date2, Time time1, Time time2, int id1, int id2,
//			int weekid1, int weekid2,
//			int monthid1, int monthid2,
//			int yearid1,int yearid2,
			int num) {
		super();
		this.siid = siid;
		this.date1 = date1;
		this.time1 = time1;
		this.id1 = id1;
//		this.weekid1 = weekid1;
//		this.monthid1 = monthid1;
//		this.yearid1 = yearid1;
		this.date2 = date2;
		this.time2 = time2;
		this.id2 = id2;
//		this.weekid2 = weekid2;
//		this.monthid2 = monthid2;
//		this.yearid2 = yearid2;
		this.num = num;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Time getTime1() {
		return time1;
	}
	public void setTime1(Time time1) {
		this.time1 = time1;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
//	public int getWeekid1() {
//		return weekid1;
//	}
//	public void setWeekid1(int weekid1) {
//		this.weekid1 = weekid1;
//	}
//	public int getMonthid1() {
//		return monthid1;
//	}
//	public void setMonthid1(int monthid1) {
//		this.monthid1 = monthid1;
//	}
//	public int getYearid1() {
//		return yearid1;
//	}
//	public void setYearid1(int yearid1) {
//		this.yearid1 = yearid1;
//	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public Time getTime2() {
		return time2;
	}
	public void setTime2(Time time2) {
		this.time2 = time2;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
//	public int getWeekid2() {
//		return weekid2;
//	}
//	public void setWeekid2(int weekid2) {
//		this.weekid2 = weekid2;
//	}
//	public int getMonthid2() {
//		return monthid2;
//	}
//	public void setMonthid2(int monthid2) {
//		this.monthid2 = monthid2;
//	}
//	public int getYearid2() {
//		return yearid2;
//	}
//	public void setYearid2(int yearid2) {
//		this.yearid2 = yearid2;
//	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "DatePack [siid=" + siid + ", date1=" + DateExchangeTool.dateToString1(date1) 
				+ ", time1=" + DateExchangeTool.timeToString(time1) + ", id1=" + id1 
//				+ ", weekid1=" + weekid1 + ", monthid1=" + monthid1 + ", yearid1=" + yearid1
				+ ", date2=" + DateExchangeTool.dateToString1(date2) + ", time2=" 
				+ DateExchangeTool.timeToString(time2) + ", id2=" + id2
//				+ ", weekid2=" + weekid2 + ", monthid2=" + monthid2+ ", yearid2=" + yearid2 
				+ ", num=" + num + "]";
	}
	
}
