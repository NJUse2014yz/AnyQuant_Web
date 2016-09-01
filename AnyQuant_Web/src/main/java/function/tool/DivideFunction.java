package function.tool;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;

public class DivideFunction extends Function {
	public double v1;
	public Function v1F;
	public double v2;
	public Function v2F;
	
	public DivideFunction()
	{
		this.function="Divide";
	}
	public DivideFunction(double v1,double v2)
	{
		this.function="Divide";
		this.v1=v1;
		this.v2=v2;
	}
	public DivideFunction(double v1, Function v1f, double v2, Function v2f) {
		this.function="Divide";
		this.v1 = v1;
		this.v1F = v1f;
		this.v2 = v2;
		this.v2F = v2f;
	}
	public DivideFunction(AddVO vo)
	{
		this.function="Divide";
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultDownO=vo.resultDownO;
		this.resultDownOF=vo.resultDownOF;
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
		this.v1 = vo.v1;
		this.v1F = vo.v1F;
		this.v2 =vo.v2;
		this.v2F = vo.v2F;
	}
	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.rD=v1/v2;
		return result;
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
	@Override
	public String toString() {
		return "\nDivideFunction [v1=" + v1 + ", v1F=" + v1F + ", v2=" + v2 + ", v2F=" + v2F + ", function=" + function
				+ ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF
				+ "]\n";
	}

}
