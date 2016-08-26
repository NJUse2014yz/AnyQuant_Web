package function.choose;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class IndustryFunction extends Function{
	public String industry;
	
	public IndustryFunction(IndustryVO vo)
	{
		this.function="Industry";
		this.industry=vo.industry;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST);
		result.rLS=new ListTool().getIndustry(industry);
		return result;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Override
	public String toString() {
		return "IndustryFunction [industry=" + industry + "]";
	}
	
}
