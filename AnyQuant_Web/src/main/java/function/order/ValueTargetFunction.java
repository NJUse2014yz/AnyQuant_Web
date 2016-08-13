package function.order;

import function.Function;
import function.FunctionResult;
/**指定持仓价值订单*/
public class ValueTargetFunction implements Function{
	public String function;
	public String siid;
	public double value;
	
	public ValueTargetFunction(){}
	public ValueTargetFunction(String function, String siid, double value) {
		super();
		this.function = function;
		this.siid = siid;
		this.value = value;
	}
	public ValueTargetFunction(ValueVO vo)
	{
		function="Percent";
		this.siid=vo.siid;
		this.value=vo.value;
	}
	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(4);
		result.location.add(3);
		result.rD=value;
		result.rS=siid;
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
