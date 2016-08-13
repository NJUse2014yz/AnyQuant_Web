package function.order;

import function.Function;
import function.FunctionResult;
/**指定交易股数订单*/
public class ShareFunction implements Function{
	public String function;
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public int share;
	
	public ShareFunction(){}
	public ShareFunction(String function, int order, String siid, int share) {
		super();
		this.function = function;
		this.order = order;
		this.siid = siid;
		this.share = share;
	}
	public ShareFunction(ShareVO vo)
	{
		function="Percent";
		this.order=vo.order;
		this.siid=vo.siid;
		this.share=vo.share;
	}
	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(4);
		result.location.add(3);
		result.rD=share;
		result.rS=siid;
		return result;
	}
	@Override
	public String toString() {
		return "ShareFunction [function=" + function + ", order=" + order
				+ ", siid=" + siid + ", share=" + share + "]";
	}
}
