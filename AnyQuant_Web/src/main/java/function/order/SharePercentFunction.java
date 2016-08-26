package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易股数百分比订单*/
public class SharePercentFunction extends Function{
	/**买入1，卖出-1*/
	public int order;
//	public String siid;
	public double percent;
	public double price;
	
	public SharePercentFunction(){
		super();
		this.function = "SharePercent";
	}
	public SharePercentFunction(String function, int order, String siid,
			double percent,double price) {
		super();
		this.function = "SharePercent";
		this.order = order;
		this.siid = siid;
		this.percent = percent;
		this.price=price;
	}
	public SharePercentFunction(PercentVO vo)
	{
		this.function="SharePercent";
		this.order=vo.order;
		this.siid=vo.siid;
		this.percent=vo.percent;
		this.price=vo.price;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE);
		result.location.add(ResultType.STRING);
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SharePercentFunction [order=" + order + ", siid=" + siid
				+ ", percent=" + percent + ", price=" + price + "]";
	}
}
