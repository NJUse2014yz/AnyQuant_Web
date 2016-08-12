package function.flag;

import function.FunctionResult;

public class CrossVO {
	/**方法结果的上界*/
	public FunctionResult resultUp;
	/**方法结果的下界*/
	public FunctionResult resultDown;
	/**主动交叉股票代码*/
	public String siid1;
	/**主动数据属性，具体见ListTool的switch中*/
	public String attribute1;
	/**被动交叉股票代码*/
	public String siid2;
	/**被动数据属性*/
	public String attribute2;
	/**数据开始日期的毫秒数*/
	public long start;
	/**数据截止日期的毫秒数*/
	public long end;
	public CrossVO(FunctionResult resultUp, FunctionResult resultDown,
			String siid1, String attribute1, String siid2, String attribute2,
			long start, long end) {
		super();
		this.resultUp = resultUp;
		this.resultDown = resultDown;
		this.siid1 = siid1;
		this.attribute1 = attribute1;
		this.siid2 = siid2;
		this.attribute2 = attribute2;
		this.start = start;
		this.end = end;
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
	public String getSiid1() {
		return siid1;
	}
	public void setSiid1(String siid1) {
		this.siid1 = siid1;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getSiid2() {
		return siid2;
	}
	public void setSiid2(String siid2) {
		this.siid2 = siid2;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
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
	@Override
	public String toString() {
		return "CrossVO [resultUp=" + resultUp + ", resultDown=" + resultDown
				+ ", siid1=" + siid1 + ", attribute1=" + attribute1
				+ ", siid2=" + siid2 + ", attribute2=" + attribute2
				+ ", start=" + start + ", end=" + end + "]";
	}
}
