package function;

import java.sql.Date;

/**所有的工具方法的接口*/
public abstract class Function {
	/**方法名，不需用户填写*/
	public String function=null;
	
	/**涉及的股票代码*/
	public String siid=null;
	/**得到股票代码的方法*/
	public Function siidF=null;
	
	/**方法买入结果的上界*/
	public FunctionResult resultUpI=null;
	/**得到买入结果上界的方法*/
	public Function resultUpIF=null;
	
	/**方法买入结果的下界*/
	public FunctionResult resultDownI=null;
	/**得到买入结果上界的方法*/
	public Function resultDownIF=null;
	
	/**方法卖出结果的上界*/
	public FunctionResult resultUpO=null;
	/**得到买入结果上界的方法*/
	public Function resultUpOF=null;
	
	/**方法卖出结果的下界*/
	public FunctionResult resultDownO=null;
	/**得到买入结果上界的方法*/
	public Function resultDownOF=null;
	
	public Function(){}
	public Function(String function, String siid, Function siidF,
			FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF) {
		super();
		this.function = function;
		this.siid = siid;
		this.siidF = siidF;
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
	}
	
	public abstract FunctionResult getResult(Date date);
	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSiid() {
		return siid;
	}

	public void setSiid(String siid) {
		this.siid = siid;
	}

	public Function getSiidF() {
		return siidF;
	}

	public void setSiidF(Function siidF) {
		this.siidF = siidF;
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
		return "Function [function=" + function + ", siid=" + siid + ", siidF="
				+ siidF + ", resultUpI=" + resultUpI + ", resultUpIF="
				+ resultUpIF + ", resultDownI=" + resultDownI
				+ ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + "]";
	}
	@Override
	public Function clone() throws CloneNotSupportedException {
		return (Function) super.clone();
	}
	
}
