package function.tool;

import function.Function;
import function.FunctionResult;

public class MinusVO {
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
	public MinusVO(double v1, Function v1f, double v2, Function v2f,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF) {
		super();
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
	@Override
	public String toString() {
		return "MinusVO [v1=" + v1 + ", v1F=" + v1F + ", v2=" + v2 + ", v2F="
				+ v2F + ", resultDownI=" + resultDownI + ", resultDownIF="
				+ resultDownIF + ", resultUpO=" + resultUpO + ", resultUpOF="
				+ resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + "]";
	}
}
