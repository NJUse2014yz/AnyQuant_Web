package function.order;

import function.Function;
import function.FunctionResult;
/**指定交易股数百分比订单*/
public class SharePercentFunction implements Function{
	public String function;
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double percent;
	
	public SharePercentFunction(){}
	public SharePercentFunction(String function, int order, String siid,
			double percent) {
		super();
		this.function = function;
		this.order = order;
		this.siid = siid;
		this.percent = percent;
	}
	public SharePercentFunction(SharePercentVO vo)
	{
		function="Percent";
		this.order=vo.order;
		this.siid=vo.siid;
		this.percent=vo.percent;
	}
	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(4);
		result.location.add(3);
		result.rD=percent;
		result.rS=siid;
		return result;
	}
	@Override
	public String toString() {
		return "SharePercentFunction [function=" + function + ", order="
				+ order + ", siid=" + siid + ", percent=" + percent + "]";
	}
}
