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
	/**日期2*/
	private Date date2;
	/**时间2*/
	private Time time2;
	/**日1*/
	private int id2;
	/**条数*/
	private int num;
	
	public DatePack() {
		this.siid = null;
		this.date1 = null;
		this.time1 = null;
		this.id1 = -1;
		this.date2 = null;
		this.time2 = null;
		this.id2 = -1;
		this.num = -1;
	}
	public DatePack(String siid, Date date1, Date date2, Time time1, Time time2, int id1, int id2,int num) {
		this();
		this.siid = siid;
		this.date1 = date1;
		this.time1 = time1;
		this.id1 = id1;
		this.date2 = date2;
		this.time2 = time2;
		this.id2 = id2;
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
				+ ", date2=" + DateExchangeTool.dateToString1(date2) + ", time2=" 
				+ DateExchangeTool.timeToString(time2) + ", id2=" + id2
				+ ", num=" + num + "]";
	}
	
}
