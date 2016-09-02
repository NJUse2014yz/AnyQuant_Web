package function.tool;

import function.Function;
import function.FunctionResult;

public class MultipleVO {
	public double v1;
	public Function v1F;
	public double v2;
	public Function v2F;
	
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
	/**得到卖出结果上界的方法*/
	public Function resultUpOF;
	
	/**方法卖出结果的下界*/
	public FunctionResult resultDownO;
	/**得到买入结果上界的方法*/
	public Function resultDownOF;
	
	public MultipleVO()
	{
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
		this.v1=0;
		this.v1F=null;
		this.v2=0;
		this.v2F=null;
	}
	public MultipleVO(double v1, Function v1f, double v2, Function v2f,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF) {
		this();
		this.v1 = v1;
		v1F = v1f;
		this.v2 = v2;
		v2F = v2f;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
	}
	
	public double getV1() {
		return v1;
	}
	public void setV1(double v1) {
		this.v1 = v1;
	}
	public Function getV1F() {
		return v1F;
	}
	public void setV1F(Function v1f) {
		v1F = v1f;
	}
	public double getV2() {
		return v2;
	}
	public void setV2(double v2) {
		this.v2 = v2;
	}
	public Function getV2F() {
		return v2F;
	}
	public void setV2F(Function v2f) {
		v2F = v2f;
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
	@Override
	public String toString() {
		return "MultipleVO [v1=" + v1 + ", v1F=" + v1F + ", v2=" + v2 + ", v2F="
				+ v2F + ", resultDownI=" + resultDownI + ", resultDownIF="
				+ resultDownIF + ", resultUpO=" + resultUpO + ", resultUpOF="
				+ resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + "]";
	}
}
