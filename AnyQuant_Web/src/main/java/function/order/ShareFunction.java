package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易股数订单*/
public class ShareFunction extends Function{
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public int share;
	public double price;
	
	public ShareFunction(){
		super();
		this.function = "Share";
	}
	public ShareFunction(int order, String siid, int share,double price) {
		super();
		this.function = "Share";
		this.order = order;
		this.siid = siid;
		this.share = share;
		this.price=price;
	}
	public ShareFunction(ShareVO vo)
	{
		function="Share";
		this.order=vo.order;
		this.siid=vo.siid;
		this.share=vo.share;
		this.price=vo.price;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRING);
		result.location.add(ResultType.DOUBLELIST);
		result.rD=share;
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
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ShareFunction [order=" + order + ", siid=" + siid + ", share="
				+ share + ", price=" + price + "]";
	}
}
