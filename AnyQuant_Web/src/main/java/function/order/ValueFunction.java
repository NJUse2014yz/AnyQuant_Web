package function.order;

import function.Function;
import function.FunctionResult;
/**指定交易价值订单*/
public class ValueFunction implements Function{
	public String function;
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double value;
	
	public ValueFunction(){}
	public ValueFunction(String function, int order, String siid, double value) {
		super();
		this.function = function;
		this.order = order;
		this.siid = siid;
		this.value = value;
	}
	public ValueFunction(ValueVO vo)
	{
		function="Percent";
		this.order=vo.order;
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
