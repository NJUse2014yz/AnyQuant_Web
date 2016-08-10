package function.flag;

import java.sql.Date;
import java.util.List;

import bl.CrossResult;
import bl.CrossTool;
import tool.ListTool;
import function.Function;
import function.FunctionResult;

public class CrossPointFunction extends CrossFunction{
	public List<Double> activelist;
	public List<Double> passivelist;
	public CrossPointFunction(String siid1,String attribute1,String siid2,String attribute2,Date start,Date end)
	{
		super(siid1,attribute1,siid2,attribute2,start,end);
	}
	@Override
	public FunctionResult getResult() {
		CrossResult crossResult=new CrossTool(activelist,passivelist).cross();
		FunctionResult result=new FunctionResult();
		result.location.add(2);
		result.rI=crossResult.crosspoint;
		return result;
	}
}
