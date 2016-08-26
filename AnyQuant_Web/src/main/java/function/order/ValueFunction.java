package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易价值订单*/
public class ValueFunction extends Function{
	/**买入1，卖出-1*/
	public int order;
//	public String siid;
	public double value;
	public double price;
	
	public ValueFunction(){
		this.function="Value";
	}
	public ValueFunction(int order, String siid, double value, double price) {
		super();
		this.order = order;
		this.siid = siid;
		this.value = value;
		this.price = price;
	}
	public ValueFunction(ValueVO vo)
	{
		this.function="Value";
		this.order=vo.order;
		this.siid=vo.siid;
		this.value=vo.value;
		this.price=vo.price;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE);
		result.location.add(ResultType.STRING);
		result.rD=value;
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
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ValueFunction [order=" + order + ", siid=" + siid + ", value="
				+ value + ", price=" + price + "]";
	}
}
