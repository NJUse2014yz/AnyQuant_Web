package function.order;

import function.Function;
import function.FunctionResult;
/**指定交易股数百分比订单*/
public class SharePercentFunction extends Function{
//	public String function;
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double percent;
	
	public SharePercentFunction(){
		super();
		this.function = "SharePercent";
	}
	public SharePercentFunction(String function, int order, String siid,
			double percent) {
		super();
		this.function = "SharePercent";
		this.order = order;
		this.siid = siid;
		this.percent = percent;
	}
	public SharePercentFunction(SharePercentVO vo)
	{
		this.function="SharePercent";
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
		return "SharePercentFunction [function=" + function + ", order="
				+ order + ", siid=" + siid + ", percent=" + percent + "]";
	}
}
