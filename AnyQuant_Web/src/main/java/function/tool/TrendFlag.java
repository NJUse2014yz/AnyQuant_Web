package function.tool;

import java.util.List;

public class TrendFlag {
	public double trend;
	public double uptrend;
	public double downtrend;
	public List<TrendPoint> list;
	public TrendFlag(List<TrendPoint> list)
	{
		this.list=list;
	}
	@Override
	public String toString() {
		return "TrendFlag [trend=" + trend + ", uptrend=" + uptrend
				+ ", downtrend=" + downtrend + ",\nlist=" + list + "]";
	}
}
