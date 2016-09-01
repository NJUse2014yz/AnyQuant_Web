package function.tool;

import java.util.List;

import function.Function;
import function.FunctionResult;

public class MeanVO {
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
	
	public List<Double> valueList;
	public Function valueListF;
	public MeanVO(FunctionResult resultUpI, Function resultUpIF, FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF, FunctionResult resultDownO, Function resultDownOF,
			List<Double> valueList, Function valueListF) {
		super();
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
		this.valueList = valueList;
		this.valueListF = valueListF;
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
	public List<Double> getValueList() {
		return valueList;
	}
	public void setValueList(List<Double> valueList) {
		this.valueList = valueList;
	}
	public Function getValueListF() {
		return valueListF;
	}
	public void setValueListF(Function valueListF) {
		this.valueListF = valueListF;
	}
	@Override
	public String toString() {
		return "MeanVO [resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF + ", resultDownI=" + resultDownI
				+ ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO + ", resultUpOF=" + resultUpOF
				+ ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF + ", valueList=" + valueList
				+ ", valueListF=" + valueListF + "]";
	}
}
