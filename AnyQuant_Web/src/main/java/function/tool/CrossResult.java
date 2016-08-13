package function.tool;

public class CrossResult {
	/**交叉结果：上穿：1，下穿：-1，其它：0*/
	public int cross;
	/**最近的交叉点*/
	public int crosspoint;
	public TrendFlag activeflag;
	public TrendFlag passiveflag;
	
	public CrossResult()
	{
		cross=0;
		crosspoint=0;
	}
	public CrossResult(int cross, int crosspoint, TrendFlag activeflag,
			TrendFlag passiveflag) {
		super();
		this.cross = cross;
		this.crosspoint = crosspoint;
		this.activeflag = activeflag;
		this.passiveflag = passiveflag;
	}
	
	@Override
	public String toString() {
		return "CrossResult [cross=" + cross + ", crosspoint=" + crosspoint
				+ ",\nactiveflag=" + activeflag + ",\npassiveflag=" + passiveflag
				+ "]";
	}
}
