package function.choose;

import tool.ListTool;
import function.Function;
import function.FunctionResult;

public class PairFunction extends Function{
	public String siid;
	public int num;
	public PairFunction(PairVO vo)
	{
		this.function=PairFunction.class;
		this.siid=vo.siid;
		this.num=vo.num;
	}
	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(7);
		result.rLS=new ListTool().getPair(siid, num);
		return result;
	}
	
	
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "PairFunction [siid=" + siid + ", num=" + num + "]";
	}
}
