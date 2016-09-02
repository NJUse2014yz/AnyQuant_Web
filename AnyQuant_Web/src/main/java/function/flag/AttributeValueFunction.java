package function.flag;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

/**根据某些属性值发出交易信号,可以和DataFunction合并*/
public class AttributeValueFunction extends Function{
	public String attribute;
	public Function attributeF;
	
	public AttributeValueFunction()
	{
		super();
		this.function="AttributeValue";
		this.siid=null;
		this.siidF=null;
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
		this.attribute=null;
		this.attributeF=null;
	}
	
	public AttributeValueFunction(String siid,String attribute) {
		this();
		this.function="AttributeValue";
		this.siid=siid;
		this.attribute = attribute;
	}
	
	public AttributeValueFunction(String siid,Function siidF,String attribute, Function attributeF) {
		this();
		this.function="AttributeValue";
		this.siid=siid;
		this.siidF=siidF;
		this.attribute = attribute;
		this.attributeF = attributeF;
	}

	public AttributeValueFunction(AttributeValueVO vo)
	{
		this();
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
		if(siidF!=null)
		{
			siid=siidF.getResult(date).rS;
		}
		if(attributeF!=null)
		{
			attribute=attributeF.getResult(date).rS;
		}
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
		return "AttributeValueFunction [attribute=" + attribute + ", attributeF=" + attributeF + ", function="
				+ function + ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF="
				+ resultUpIF + ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO="
				+ resultUpO + ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF="
				+ resultDownOF + "]";
	}

}
