package function.order;

import function.Function;
import function.FunctionResult;
/**指定交易股数订单*/
public class ShareFunction extends Function{
//	public String function;
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public int share;
	
	public ShareFunction(){
		super();
		this.function = "Share";
	}
	public ShareFunction(int order, String siid, int share) {
		super();
		this.function = "Share";
		this.order = order;
		this.siid = siid;
		this.share = share;
	}
	public ShareFunction(ShareVO vo)
	{
		function="Share";
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
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	@Override
	public String toString() {
		return "ShareFunction [function=" + function + ", order=" + order
				+ ", siid=" + siid + ", share=" + share + "]";
	}
}
