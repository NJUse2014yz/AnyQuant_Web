package function.order;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易价值订单*/
public class ValueFunction extends Function{
//	public String function;
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double value;
	
	public ValueFunction(){
		this.function="Value";
	}
	public ValueFunction(String function, int order, String siid, double value) {
		super();
		this.function="Value";
		this.order = order;
		this.siid = siid;
		this.value = value;
	}
	public ValueFunction(ValueVO vo)
	{
		this.function="Value";
		this.order=vo.order;
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
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
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
		return "ValueFunction [function=" + function + ", order=" + order
				+ ", siid=" + siid + ", value=" + value + "]";
	}
}
