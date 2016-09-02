package function.choose;

import function.Function;
import function.FunctionResult;

public class IndustryVO {
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
	
	public String industry;
	public Function industryF;

	public IndustryVO() 
	{
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
		this.industry=null;
		this.industryF=null;
	}
	public IndustryVO(String industry)
	{
		this();
		this.industry=industry;
		this.resultUpI = null;
		this.resultUpIF = null;
		this.resultDownI = null;
		this.resultDownIF = null;
		this.resultUpO = null;
		this.resultUpOF = null;
		this.resultDownO = null;
		this.resultDownOF = null;
		this.industryF = null;
	}
	public IndustryVO(FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF, String industry,
			Function industryF) {
		this();
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
		this.industry = industry;
		this.industryF = industryF;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Function getIndustryF() {
		return industryF;
	}

	public void setIndustryF(Function industryF) {
		this.industryF = industryF;
	}

	@Override
	public String toString() {
		return "IndustryVO [resultUpI=" + resultUpI + ", resultUpIF="
				+ resultUpIF + ", resultDownI=" + resultDownI
				+ ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + ", industry=" + industry
				+ ", industryF=" + industryF + "]";
	}
}
