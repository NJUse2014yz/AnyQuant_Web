package bl;

public class TrendPoint {
	public int index;
	public double value;
	public TrendPoint(int index,double value)
	{
		this.index=index;
		this.value=value;
	}
	@Override
	public String toString() {
		return "TrendPoint [index=" + index + ", value=" + value + "]";
	}
}
