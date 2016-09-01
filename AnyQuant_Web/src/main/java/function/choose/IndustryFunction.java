package function.choose;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class IndustryFunction extends Function{
	public String industry;
	public Function industryF;
	
	public IndustryFunction()
	{
		this.function="Industry";
	}
	
	public IndustryFunction(String industry) {
		this.function="Industry";
		this.industry = industry;
	}
	
	public IndustryFunction(String industry, Function industryF) {
		this.function="Industry";
		this.industry = industry;
		this.industryF = industryF;
	}
	
	public IndustryFunction(IndustryVO vo)
	{
		this.function="Industry";
		this.resultUpI = vo.resultUpI;
		this.resultUpIF = vo.resultUpIF;
		this.resultDownI = vo.resultDownI;
		this.resultDownIF = vo.resultDownIF;
		this.resultUpO = vo.resultUpO;
		this.resultUpOF = vo.resultUpOF;
		this.resultDownO = vo.resultDownO;
		this.resultDownOF = vo.resultDownOF;
		this.industry=vo.industry;
		this.industryF=vo.industryF;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		if(industryF!=null)
		{
			industry=industryF.getResult(date).rS;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST.getCode());
		result.rLS=new ListTool().getIndustry(industry);
		return result;
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
		return "IndustryFunction [industry=" + industry + ", industryF=" + industryF + ", function=" + function
				+ ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF
				+ "]";
	}
	
}
