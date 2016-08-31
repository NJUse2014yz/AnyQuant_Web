package function.flag;

import function.Function;
import function.FunctionResult;

public class CrossVO {
	/**方法买入结果的上界*/
	public FunctionResult resultUpI;
	/**得到买入结果上界的方法*/
	public Function resultUpIF;
	
	/**方法买入结果的下界*/
	public FunctionResult resultDownI;
	/**得到买入结果上界的方法*/
	public Function resultDownIF;
	
	/**方法卖出结果的上界*/
	public FunctionResult resultUpO;
	/**得到买入结果上界的方法*/
	public Function resultUpOF;
	
	/**方法卖出结果的下界*/
	public FunctionResult resultDownO;
	/**得到买入结果上界的方法*/
	public Function resultDownOF;
	
	/**主动交叉股票代码*/
	public String siid1;
	public Function siid1F;
	/**主动数据属性，具体见ListTool的switch中*/
	public String attribute1;
	public Function attribute1F;
	/**被动交叉股票代码*/
	public String siid2;
	public Function siid2F;
	/**被动数据属性*/
	public String attribute2;
	public Function attribute2F;
	/**往前推的天数*/
	public int day;
	public Function dayF;

	public CrossVO(){}
	public CrossVO(FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF, String siid1,
			Function siid1f, String attribute1, Function attribute1f,
			String siid2, Function siid2f, String attribute2,
			Function attribute2f, int day, Function dayF) {
		super();
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
		this.siid1 = siid1;
		siid1F = siid1f;
		this.attribute1 = attribute1;
		attribute1F = attribute1f;
		this.siid2 = siid2;
		siid2F = siid2f;
		this.attribute2 = attribute2;
		attribute2F = attribute2f;
		this.day = day;
		this.dayF = dayF;
	}

	public FunctionResult getResultUpI() {
		return resultUpI;
	}

	public void setResultUpI(FunctionResult resultUpI) {
		this.resultUpI = resultUpI;
	}

	public Function getResultUpIF() {
		return resultUpIF;
	}

	public void setResultUpIF(Function resultUpIF) {
		this.resultUpIF = resultUpIF;
	}

	public FunctionResult getResultDownI() {
		return resultDownI;
	}

	public void setResultDownI(FunctionResult resultDownI) {
		this.resultDownI = resultDownI;
	}

	public Function getResultDownIF() {
		return resultDownIF;
	}

	public void setResultDownIF(Function resultDownIF) {
		this.resultDownIF = resultDownIF;
	}

	public FunctionResult getResultUpO() {
		return resultUpO;
	}

	public void setResultUpO(FunctionResult resultUpO) {
		this.resultUpO = resultUpO;
	}

	public Function getResultUpOF() {
		return resultUpOF;
	}

	public void setResultUpOF(Function resultUpOF) {
		this.resultUpOF = resultUpOF;
	}

	public FunctionResult getResultDownO() {
		return resultDownO;
	}

	public void setResultDownO(FunctionResult resultDownO) {
		this.resultDownO = resultDownO;
	}

	public Function getResultDownOF() {
		return resultDownOF;
	}

	public void setResultDownOF(Function resultDownOF) {
		this.resultDownOF = resultDownOF;
	}

	public String getSiid1() {
		return siid1;
	}

	public void setSiid1(String siid1) {
		this.siid1 = siid1;
	}

	public Function getSiid1F() {
		return siid1F;
	}

	public void setSiid1F(Function siid1f) {
		siid1F = siid1f;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public Function getAttribute1F() {
		return attribute1F;
	}

	public void setAttribute1F(Function attribute1f) {
		attribute1F = attribute1f;
	}

	public String getSiid2() {
		return siid2;
	}

	public void setSiid2(String siid2) {
		this.siid2 = siid2;
	}

	public Function getSiid2F() {
		return siid2F;
	}

	public void setSiid2F(Function siid2f) {
		siid2F = siid2f;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public Function getAttribute2F() {
		return attribute2F;
	}

	public void setAttribute2F(Function attribute2f) {
		attribute2F = attribute2f;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Function getDayF() {
		return dayF;
	}

	public void setDayF(Function dayF) {
		this.dayF = dayF;
	}

	@Override
	public String toString() {
		return "CrossVO [resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF="
				+ resultDownIF + ", resultUpO=" + resultUpO + ", resultUpOF="
				+ resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + ", siid1=" + siid1
				+ ", siid1F=" + siid1F + ", attribute1=" + attribute1
				+ ", attribute1F=" + attribute1F + ", siid2=" + siid2
				+ ", siid2F=" + siid2F + ", attribute2=" + attribute2
				+ ", attribute2F=" + attribute2F + ", day=" + day + ", dayF="
				+ dayF + "]";
	}
	
}
