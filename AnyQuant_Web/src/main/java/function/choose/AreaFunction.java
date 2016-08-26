package function.choose;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class AreaFunction extends Function{
	public String area;
	
	public AreaFunction(AreaVO vo)
	{
		this.function="Area";
		this.area=vo.area;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST);
		result.rLS=new ListTool().getArea(area);
		return result;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "AreaFunction [area=" + area + "]";
	}
	
}
