package function.choose;

import java.sql.Date;
import java.util.List;

import po.StockInf;
import service.impl.StockDataServiceImpl;
import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class AttributeFunction extends Function{
	public double up;
	public Function upF;
	
	public double down;
	public Function downF;
	
	public String attribute;
	public Function attributeF;
	
	public AttributeFunction()
	{
		this.function="Attribute";
	}
	
	public AttributeFunction(double up, double down,String attribute) {
		this.function="Attribute";
		this.up = up;
		this.down = down;
		this.attribute = attribute;
	}

	public AttributeFunction(double up, Function upF, double down,
			Function downF, String attribute, Function attributeF) {
		this.function="Attribute";
		this.up = up;
		this.upF = upF;
		this.down = down;
		this.downF = downF;
		this.attribute = attribute;
		this.attributeF = attributeF;
	}

	public AttributeFunction(AttributeVO vo)
	{
		this.function="Attribute";
		this.resultUpI = vo.resultUpI;
		this.resultUpIF = vo.resultUpIF;
		this.resultDownI = vo.resultDownI;
		this.resultDownIF = vo.resultDownIF;
		this.resultUpO = vo.resultUpO;
		this.resultUpOF = vo.resultUpOF;
		this.resultDownO = vo.resultDownO;
		this.resultDownOF = vo.resultDownOF;
		this.up = vo.up;
		this.upF=vo.upF;
		this.down = vo.down;
		this.downF=vo.downF;
		this.attribute = vo.attribute;
		this.attributeF=vo.attributeF;
	}

	@Override
	public FunctionResult getResult(Date date) {
		if(attributeF!=null)
		{
			attribute=attributeF.getResult(date).rS;
		}
		if(upF!=null)
		{
			up=upF.getResult(date).rD;
		}
		if(downF!=null)
		{
			down=downF.getResult(date).rD;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST.getCode());
		List<StockInf> list=null;
		try {
			list=ListTool.stockInfMapper.selectStockInf_all();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++)
		{
			double value=new ListTool().getNew(list.get(i).getSid(), attribute);
			if(value<up&&value>down)
			{
				result.rLS.add(list.get(i).getSid());
			}
		}
		return result;
	}

	public double getUp() {
		return up;
	}

	public void setUp(double up) {
		this.up = up;
	}

	public Function getUpF() {
		return upF;
	}

	public void setUpF(Function upF) {
		this.upF = upF;
	}

	public double getDown() {
		return down;
	}

	public void setDown(double down) {
		this.down = down;
	}

	public Function getDownF() {
		return downF;
	}

	public void setDownF(Function downF) {
		this.downF = downF;
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
		return "AttributeFunction [up=" + up + ", upF=" + upF + ", down="
				+ down + ", downF=" + downF + ", attribute=" + attribute
				+ ", attributeF=" + attributeF + "]";
	}

}
