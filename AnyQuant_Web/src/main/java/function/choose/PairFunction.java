package function.choose;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;
/**配对选股方法*/
public class PairFunction extends Function{
	/**主动配对的股票代码*/
	public String siid;
	/**配对股票数（1或2或3）*/
	public int num;
	
	public PairFunction(PairVO vo)
	{
		this.function="Pair";
		this.siid=vo.siid;
		this.num=vo.num;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST);
		result.rLS=new ListTool().getPair(siid, num);
		return result;
	}
	
//	public String getFunction() {
//		return function;
//	}
//	public void setFunction(String function) {
//		this.function = function;
//	}
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
