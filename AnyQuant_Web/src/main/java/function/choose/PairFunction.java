package function.choose;

import tool.ListTool;
import bl.PairStrategy;
import function.Function;
import function.FunctionResult;

public class PairFunction implements Function{
	public String siid;
	public int num;
	public PairFunction(String siid,int num)
	{
		this.siid=siid;
		this.num=num;
	}
	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(7);
		result.rLS=new ListTool().getPair(siid, num);
		return result;
	}

}
