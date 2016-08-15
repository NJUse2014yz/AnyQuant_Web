package function.order;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易价值百分比订单*/
public class ValuePercentFunction extends Function{
//	public String function;
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double percent;
	
	public ValuePercentFunction(){
		this.function="ValuePercent";
	}
	public ValuePercentFunction(String function, int order, String siid,
			double percent) {
		super();
		this.function="ValuePercent";
		this.order = order;
		this.siid = siid;
		this.percent = percent;
	}
	public ValuePercentFunction(PercentVO vo)
	{
		this.function="ValuePercent";
		this.order=vo.order;
		this.siid=vo.siid;
		this.percent=vo.percent;
	}
	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRING);
		result.location.add(ResultType.DOUBLELIST);
		result.rD=percent;
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
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "ValuePercentFunction [function=" + function + ", order="
				+ order + ", siid=" + siid + ", percent=" + percent + "]";
	}
}
