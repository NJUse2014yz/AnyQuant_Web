package function.flag;

import java.sql.Date;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class DataFunction extends Function{
//	public String siid;
	public String attribute;
	public int day;

	public DataFunction()
	{
		this.function="Data";
	}
	
	public DataFunction(DataVO vo){
		this.function="Data";
		this.siid=vo.siid;
		this.attribute=vo.attribute;
		this.day=vo.day;
	}
	
	@Override
	public FunctionResult getResult(Date today) {
		Date start=new Date(today.getTime()-day*24*60*60*1000);
		Date end=today;
		List<Double> list=new ListTool().getList(siid,attribute,start,end);
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLELIST);
		result.rLD=list;
		return result;
	}

}
