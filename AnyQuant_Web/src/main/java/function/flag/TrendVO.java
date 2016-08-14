package function.flag;

import function.FunctionResult;

public class TrendVO {
	/**方法买入结果的上界*/
	public FunctionResult resultUpI;
	/**方法买入结果的下界*/
	public FunctionResult resultDownI;
	/**方法卖出结果的上界*/
	public FunctionResult resultUpO;
	/**方法卖出结果的下界*/
	public FunctionResult resultDownO;
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
	
	public TrendVO(FunctionResult resultUpI, FunctionResult resultDownI,
			FunctionResult resultUpO, FunctionResult resultDownO, String siid,
			String attribute, long start, long end, double standard) {
		super();
		this.resultUpI = resultUpI;
		this.resultDownI = resultDownI;
		this.resultUpO = resultUpO;
		this.resultDownO = resultDownO;
		this.siid = siid;
		this.attribute = attribute;
		this.start = start;
		this.end = end;
		this.standard = standard;
	}
	public FunctionResult getResultUpI() {
		return resultUpI;
	}
	public void setResultUpI(FunctionResult resultUpI) {
		this.resultUpI = resultUpI;
	}
	public FunctionResult getResultDownI() {
		return resultDownI;
	}
	public void setResultDownI(FunctionResult resultDownI) {
		this.resultDownI = resultDownI;
	}
	public FunctionResult getResultUpO() {
		return resultUpO;
	}
	public void setResultUpO(FunctionResult resultUpO) {
		this.resultUpO = resultUpO;
	}
	public FunctionResult getResultDownO() {
		return resultDownO;
	}
	public void setResultDownO(FunctionResult resultDownO) {
		this.resultDownO = resultDownO;
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
		return "TrendVO [resultUpI=" + resultUpI + ", resultDownI="
				+ resultDownI + ", resultUpO=" + resultUpO + ", resultDownO="
				+ resultDownO + ", siid=" + siid + ", attribute=" + attribute
				+ ", start=" + start + ", end=" + end + ", standard="
				+ standard + "]";
	}
}
