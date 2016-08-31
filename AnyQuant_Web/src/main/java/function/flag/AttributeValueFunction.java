package function.flag;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

/**根据某些属性值发出交易信号*/
public class AttributeValueFunction extends Function{
	public String attribute;
	public Function attributeF;
	
	public AttributeValueFunction()
	{
		this.function="AttributeValue";
	}
	
	public AttributeValueFunction(String siid,String attribute) {
		this.function="AttributeValue";
		this.siid=siid;
		this.attribute = attribute;
	}
	
	public AttributeValueFunction(String siid,Function siidF,String attribute, Function attributeF) {
		this.function="AttributeValue";
		this.siid=siid;
		this.siidF=siidF;
		this.attribute = attribute;
		this.attributeF = attributeF;
	}

	public AttributeValueFunction(AttributeValueVO vo)
	{
		this.function="AttributeValue";
		this.siid=vo.siid;
		this.siidF=vo.siidF;
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultDownO=vo.resultDownO;
		this.resultDownOF=vo.resultDownOF;
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
		this.attribute=vo.attribute;
		this.attributeF=vo.attributeF;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.rD=new ListTool().getNew(siid, attribute);
		return result;
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
		return "AttributeValueFunction [attribute=" + attribute
				+ ", attributeF=" + attributeF + "]";
	}
}
