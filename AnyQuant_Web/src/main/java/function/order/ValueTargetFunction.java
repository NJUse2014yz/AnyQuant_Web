package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定持仓价值订单*/
public class ValueTargetFunction extends Function{
	public String siid;
	public double value;
	public double price;
	
	public ValueTargetFunction(){
		this.function="ValueTarget";
	}
	public ValueTargetFunction(String function, String siid, double value,double price) {
		super();
		this.function="ValueTarget";
		this.siid = siid;
		this.value = value;
		this.price=price;
	}
	public ValueTargetFunction(ValueVO vo)
	{
		this.function="ValueTarget";
		this.siid=vo.siid;
		this.value=vo.value;
		this.price=vo.price;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRING);
		result.location.add(ResultType.DOUBLELIST);
		result.rD=value;
		result.rS=siid;
		return result;
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
		return "ValueTargetFunction [siid=" + siid + ", value=" + value
				+ ", price=" + price + "]";
	}
}
