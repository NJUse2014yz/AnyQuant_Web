package backtest;

import java.sql.Date;

public class DateDouble {
	public Date date;
	public double value;
	public DateDouble() {
		this.date = new Date(115,0,1);
		this.value = 0;
	}
	public DateDouble(Date date, double value) {
		this.date = date;
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "DoubleDate [date=" + date + ", value=" + value + "]";
	}
}
