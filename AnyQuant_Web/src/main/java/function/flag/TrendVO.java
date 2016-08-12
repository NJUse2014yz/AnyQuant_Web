package function.flag;

import function.FunctionResult;

public class TrendVO {
	/**方法结果的上界*/
	public FunctionResult resultUp;
	/**方法结果的下界*/
	public FunctionResult resultDown;
	/**股票代码*/
	public String siid;
	/**数据属性，具体见ListTool的switch中*/
	public String attribute;
	/**数据开始日期的毫秒数*/
	public long start;
	/**数据截止日期的毫秒数*/
	public long end;
	/**数据标准值，一般取该数据最近一段时间取值的平均数*/
	public double standard;
	
	
	public TrendVO(FunctionResult resultUp, FunctionResult resultDown,
			String siid, String attribute, long start, long end, double standard) {
		super();
		this.resultUp = resultUp;
		this.resultDown = resultDown;
		this.siid = siid;
		this.attribute = attribute;
		this.start = start;
		this.end = end;
		this.standard = standard;
	}
	public FunctionResult getResultUp() {
		return resultUp;
	}
	public void setResultUp(FunctionResult resultUp) {
		this.resultUp = resultUp;
	}
	public FunctionResult getResultDown() {
		return resultDown;
	}
	public void setResultDown(FunctionResult resultDown) {
		this.resultDown = resultDown;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public double getStandard() {
		return standard;
	}
	public void setStandard(double standard) {
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "TrendVO [resultUp=" + resultUp + ", resultDown=" + resultDown
				+ ", siid=" + siid + ", attribute=" + attribute + ", start="
				+ start + ", end=" + end + ", standard=" + standard + "]";
	}
	
}
