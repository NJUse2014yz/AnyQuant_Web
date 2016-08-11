package function.choose;

import tool.ListTool;
import function.Choose;
import function.Function;
import function.FunctionResult;
/**配对选股方法*/
public class PairFunction extends Function{
	public String function;
	public String siid;
	public int num;
	public PairFunction(PairVO vo)
	{
		this.function="Pair";
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
	
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
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
