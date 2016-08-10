package function.flag;

import java.sql.Date;
import java.util.List;

import bl.CrossResult;
import bl.CrossTool;
import tool.ListTool;
import function.Function;
import function.FunctionResult;

public class CrossFunction implements Function {
	public List<Double> activelist;
	public List<Double> passivelist;
	public CrossFunction(String siid1,String attribute1,String siid2,String attribute2,Date start,Date end)
	{
		activelist=new ListTool().getList(siid1,attribute1,start,end);
		passivelist=new ListTool().getList(siid2,attribute2,start,end);
	}
	@Override
	public FunctionResult getResult() {
		CrossResult crossResult=new CrossTool(activelist,passivelist).cross();
		FunctionResult result=new FunctionResult();
		result.location.add(2);
		result.rI=crossResult.cross;
		return result;
	}
}
