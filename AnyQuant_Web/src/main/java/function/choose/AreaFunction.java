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
		super();
		this.function="Area";
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
		this.area=null;
		this.areaF=null;
	}
	public AreaFunction(String area) {
		this();
		this.function="Area";
		this.area = area;
	}
	public AreaFunction(String area, Function areaF) {
		this();
		this.function="Area";
		this.area = area;
		this.areaF = areaF;
	}

	public AreaFunction(AreaVO vo)
	{
		this();
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
		if(areaF!=null)
		{
			area=areaF.getResult(date).rS;
		}
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
		return "AreaFunction [area=" + area + ", areaF=" + areaF + ", function=" + function + ", siid=" + siid
				+ ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF + ", resultDownI="
				+ resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO + ", resultUpOF="
				+ resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF + "]";
	}
	
}
