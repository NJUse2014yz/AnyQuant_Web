package function.choose;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class ConceptFunction extends Function{
	public String concept;
	public Function conceptF;
	
	public ConceptFunction()
	{
		this.function="Concept";
	}
	
	public ConceptFunction(String concept) {
		this.function="Concept";
		this.concept = concept;
	}
	
	public ConceptFunction(String concept, Function conceptF) {
		this.function="Concept";
		this.concept = concept;
		this.conceptF = conceptF;
	}

	public ConceptFunction(ConceptVO vo)
	{
		this.function="Concept";
		this.resultUpI = vo.resultUpI;
		this.resultUpIF = vo.resultUpIF;
		this.resultDownI = vo.resultDownI;
		this.resultDownIF = vo.resultDownIF;
		this.resultUpO = vo.resultUpO;
		this.resultUpOF = vo.resultUpOF;
		this.resultDownO = vo.resultDownO;
		this.resultDownOF = vo.resultDownOF;
		this.concept=vo.concept;
		this.conceptF=vo.conceptF;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		if(conceptF!=null)
		{
			concept=conceptF.getResult(date).rS;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST.getCode());
		result.rLS=new ListTool().getConcept(concept);
		return result;
	}

	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public Function getConceptF() {
		return conceptF;
	}
	public void setConceptF(Function conceptF) {
		this.conceptF = conceptF;
	}
	@Override
	public String toString() {
		return "ConceptFunction [concept=" + concept + ", conceptF=" + conceptF
				+ "]";
	}
}
