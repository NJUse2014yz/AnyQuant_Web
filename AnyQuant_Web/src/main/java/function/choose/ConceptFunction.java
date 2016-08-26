package function.choose;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class ConceptFunction extends Function{
	public String concept;
	
	public ConceptFunction(ConceptVO vo)
	{
		this.function="Concept";
		this.concept=vo.concept;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST);
		result.rLS=new ListTool().getConcept(concept);
		return result;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	@Override
	public String toString() {
		return "ConceptFunction [concept=" + concept + "]";
	}
	
}
