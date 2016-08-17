package backtest;

import java.sql.Date;

public class DateDouble {
	public long date;
	public double value;
	public DateDouble() {
		this.date = new Date(115,0,1).getTime();
		this.value = 0;
	}
	public DateDouble(long date, double value) {
		super();
		this.date = date;
		this.value = value;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
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
		return "DateDouble [date=" + date + ", value=" + value + "]";
	}
}
