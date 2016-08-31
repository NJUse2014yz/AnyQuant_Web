package function.choose;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class AreaFunction extends Function{
	public String area;
	public Function areaF;
	
	public AreaFunction()
	{
		this.function="Area";
	}
	public AreaFunction(String area) {
		this.function="Area";
		this.area = area;
	}
	public AreaFunction(String area, Function areaF) {
		this.function="Area";
		this.area = area;
		this.areaF = areaF;
	}

	public AreaFunction(AreaVO vo)
	{
		this.function="Area";
		this.resultUpI = vo.resultUpI;
		this.resultUpIF = vo.resultUpIF;
		this.resultDownI = vo.resultDownI;
		this.resultDownIF = vo.resultDownIF;
		this.resultUpO = vo.resultUpO;
		this.resultUpOF = vo.resultUpOF;
		this.resultDownO = vo.resultDownO;
		this.resultDownOF = vo.resultDownOF;
		this.area=vo.area;
		this.areaF=vo.areaF;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST.getCode());
		result.rLS=new ListTool().getArea(area);
		return result;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Function getAreaF() {
		return areaF;
	}
	public void setAreaF(Function areaF) {
		this.areaF = areaF;
	}
	@Override
	public String toString() {
		return "AreaFunction [area=" + area + ", areaF=" + areaF + "]";
	}
}
