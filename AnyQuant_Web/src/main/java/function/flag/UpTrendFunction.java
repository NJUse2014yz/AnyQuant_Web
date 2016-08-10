package function.flag;

import java.sql.Date;

import function.FunctionResult;
import bl.TrendFlag;
import bl.TrendTool;

public class UpTrendFunction extends TrendFunction{

	public UpTrendFunction(String siid, String attribute, Date start, Date end,Double standard) {
		super(siid, attribute, start, end, standard);
	}
	public FunctionResult getResult()
	{
		TrendFlag flag=new TrendTool(standard,trendList).trend();
		FunctionResult result=new FunctionResult();
		result.location.add(3);
		result.rD=flag.uptrend;
		return result;
	}

}
