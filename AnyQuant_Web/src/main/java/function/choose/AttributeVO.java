package function.choose;

import function.Function;
import function.FunctionResult;

public class AttributeVO {
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
	
	public double up;
	public Function upF;
	
	public double down;
	public Function downF;
	
	public String attribute;
	public Function attributeF;
	
	public AttributeVO(){}
	public AttributeVO(double up, double down, String attribute)
	{
		this.up = up;
		this.down = down;
		this.attribute = attribute;
	}
	public AttributeVO(FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF, double up,
			Function upF, double down, Function downF, String attribute,
			Function attributeF) {
		super();
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
		this.up = up;
		this.upF = upF;
		this.down = down;
		this.downF = downF;
		this.attribute = attribute;
		this.attributeF = attributeF;
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
	public double getUp() {
		return up;
	}
	public void setUp(double up) {
		this.up = up;
	}
	public Function getUpF() {
		return upF;
	}
	public void setUpF(Function upF) {
		this.upF = upF;
	}
	public double getDown() {
		return down;
	}
	public void setDown(double down) {
		this.down = down;
	}
	public Function getDownF() {
		return downF;
	}
	public void setDownF(Function downF) {
		this.downF = downF;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Function getAttributeF() {
		return attributeF;
	}
	public void setAttributeF(Function attributeF) {
		this.attributeF = attributeF;
	}
	@Override
	public String toString() {
		return "AttributeVO [resultUpI=" + resultUpI + ", resultUpIF="
				+ resultUpIF + ", resultDownI=" + resultDownI
				+ ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + ", up=" + up + ", upF="
				+ upF + ", down=" + down + ", downF=" + downF + ", attribute="
				+ attribute + ", attributeF=" + attributeF + "]";
	}
}
