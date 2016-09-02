package function.tool;

import java.util.List;

public class TrendFlag {
	public double trend;
	public double uptrend;
	public double downtrend;
	public List<TrendPoint> list;
	
	public TrendFlag()
	{
		this.trend=0;
		this.uptrend=0;
		this.downtrend=0;
		this.list=null;
	}
	public TrendFlag(List<TrendPoint> list)
	{
		this();
		this.list=list;
	}
	
	public double getTrend() {
		return trend;
	}
	public void setTrend(double trend) {
		this.trend = trend;
	}
	public double getUptrend() {
		return uptrend;
	}
	public void setUptrend(double uptrend) {
		this.uptrend = uptrend;
	}
	public double getDowntrend() {
		return downtrend;
	}
	public void setDowntrend(double downtrend) {
		this.downtrend = downtrend;
	}
	public List<TrendPoint> getList() {
		return list;
	}
	public void setList(List<TrendPoint> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "TrendFlag [trend=" + trend + ", uptrend=" + uptrend
				+ ", downtrend=" + downtrend + ",\nlist=" + list + "]";
	}
}
