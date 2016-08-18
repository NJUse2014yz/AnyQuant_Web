package function.flag;

import java.sql.Date;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class DataFunction extends Function{
	public String siid;
	public String attribute;
	public long startdate;
	public long enddate;

	public DataFunction()
	{
		this.function="Data";
	}
	
	public DataFunction(DataVO vo){
		this.function="Data";
		this.siid=vo.siid;
		this.attribute=vo.attribute;
	}
	
	@Override
	public FunctionResult getResult() {
		List<Double> list=new ListTool().getList(siid,attribute,new Date(startdate),new Date(enddate));
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLELIST);
		result.rLD=list;
		return result;
	}

}
