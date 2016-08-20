package function;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易股数订单*/
public class OrderFunction extends Function{
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public int share;
	public double price;
	
	public OrderFunction(){
		super();
		this.function = "Order";
	}
	public OrderFunction(int order, String siid, int share,double price) {
		super();
		this.function = "Order";
		this.order = order;
		this.siid = siid;
		this.share = share;
		this.price=price;
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
		return "OrderFunction [order=" + order + ", siid=" + siid + ", share="
				+ share + ", price=" + price + "]";
	}
}
