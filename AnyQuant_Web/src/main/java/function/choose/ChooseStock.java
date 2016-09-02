package function.choose;

public class ChooseStock {
	/**股票代码*/
	public String siid;
	/**该股占比*/
	public double percent;
	
	public ChooseStock()
	{
		this.siid=null;
		this.percent=0;
	}
	public ChooseStock(String siid, double percent) {
		this();
		this.siid = siid;
		this.percent = percent;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "ChooseStock [siid=" + siid + ", percent=" + percent + "]";
	}
	
}
