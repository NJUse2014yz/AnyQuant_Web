package function.tool;

public class TrendPoint {
	public int index;
	public double value;
	
	public TrendPoint()
	{
		this.index=0;
		this.value=0;
	}
	public TrendPoint(int index,double value)
	{
		this();
		this.index=index;
		this.value=value;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "TrendPoint [index=" + index + ", value=" + value + "]";
	}
}
