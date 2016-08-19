package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易价值百分比订单*/
public class ValuePercentFunction extends Function{
	/**买入1，卖出-1*/
	public int order;
	public String siid;
	public double percent;
	public double price;
	
	public ValuePercentFunction(){
		this.function="ValuePercent";
	}
	public ValuePercentFunction(String function, int order, String siid,
			double percent,double price) {
		super();
		this.function="ValuePercent";
		this.order = order;
		this.siid = siid;
		this.percent = percent;
		this.price=price;
	}
	public ValuePercentFunction(PercentVO vo)
	{
		this.function="ValuePercent";
		this.order=vo.order;
		this.siid=vo.siid;
		this.percent=vo.percent;
		this.price=vo.price;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRING);
		result.location.add(ResultType.DOUBLELIST);
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
		return "ValuePercentFunction [order=" + order + ", siid=" + siid
				+ ", percent=" + percent + ", price=" + price + "]";
	}
}
