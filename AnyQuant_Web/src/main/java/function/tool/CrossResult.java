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
		this.activeflag=null;
		this.passiveflag=null;
	}
	public CrossResult(int cross, int crosspoint, TrendFlag activeflag,
			TrendFlag passiveflag) {
		this();
		this.cross = cross;
		this.crosspoint = crosspoint;
		this.activeflag = activeflag;
		this.passiveflag = passiveflag;
	}
	
	public int getCross() {
		return cross;
	}
	public void setCross(int cross) {
		this.cross = cross;
	}
	public int getCrosspoint() {
		return crosspoint;
	}
	public void setCrosspoint(int crosspoint) {
		this.crosspoint = crosspoint;
	}
	public TrendFlag getActiveflag() {
		return activeflag;
	}
	public void setActiveflag(TrendFlag activeflag) {
		this.activeflag = activeflag;
	}
	public TrendFlag getPassiveflag() {
		return passiveflag;
	}
	public void setPassiveflag(TrendFlag passiveflag) {
		this.passiveflag = passiveflag;
	}
	@Override
	public String toString() {
		return "CrossResult [cross=" + cross + ", crosspoint=" + crosspoint
				+ ",\nactiveflag=" + activeflag + ",\npassiveflag=" + passiveflag
				+ "]";
	}
}
