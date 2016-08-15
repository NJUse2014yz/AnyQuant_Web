package function.order;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定仓位股数订单*/
public class ShareTargetFunction extends Function{
//	public String function;
	public String siid;
	public int share;
	
	public ShareTargetFunction(){
		this.function="ShareTarget";
	}
	public ShareTargetFunction(ShareVO vo)
	{
		this.function="ShareTarget";
		this.siid=vo.siid;
		this.share=vo.share;
	}
	
	public ShareTargetFunction(String function, String siid, int share) {
		super();
		this.function="ShareTarget";
		this.siid = siid;
		this.share = share;
	}

	@Override
	public FunctionResult getResult() {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRING);
		result.location.add(ResultType.DOUBLELIST);
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
		return "ShareTargetFunction [function=" + function + ", siid=" + siid
				+ ", share=" + share + "]";
	}
}
