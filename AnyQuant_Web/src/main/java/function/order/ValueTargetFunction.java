package function.order;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定持仓价值订单*/
public class ValueTargetFunction extends Function{
//	public String function;
	public String siid;
	public double value;
	
	public ValueTargetFunction(){
		this.function="ValueTarget";
	}
	public ValueTargetFunction(String function, String siid, double value) {
		super();
		this.function="ValueTarget";
		this.siid = siid;
		this.value = value;
	}
	public ValueTargetFunction(ValueVO vo)
	{
		this.function="ValueTarget";
		this.siid=vo.siid;
		this.value=vo.value;
	}
	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRING);
		result.location.add(ResultType.DOUBLELIST);
		result.rD=value;
		result.rS=siid;
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
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ValueTargetFunction [function=" + function + ", siid=" + siid
				+ ", value=" + value + "]";
	}
}
