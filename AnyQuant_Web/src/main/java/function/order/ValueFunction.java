package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易价值订单*/
public class ValueFunction extends Function{
	/**买入1，卖出-1*/
	public int order;
	
	public double value;
	public Function valueF;
	
	public double price;
	public Function priceF;
	
	public ValueFunction(){
		this.function="Value";
	}
	
	public ValueFunction(int order, double value, double price) {
		this.function="Value";
		this.order = order;
		this.value = value;
		this.price = price;
	}

	public ValueFunction(int order, double value, Function valueF,
			double price, Function priceF) {
		this.function="Value";
		this.order = order;
		this.value = value;
		this.valueF = valueF;
		this.price = price;
		this.priceF = priceF;
	}

	public ValueFunction(ValueVO vo)
	{
		this.function="Value";
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultDownO=vo.resultDownO;
		this.resultDownOF=vo.resultDownOF;
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
		this.order=vo.order;
		this.siid=vo.siid;
		this.siidF=vo.siidF;
		this.value=vo.value;
		this.valueF=vo.valueF;
		this.price=vo.price;
		this.priceF=vo.priceF;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.location.add(ResultType.STRING.getCode());
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Function getValueF() {
		return valueF;
	}

	public void setValueF(Function valueF) {
		this.valueF = valueF;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Function getPriceF() {
		return priceF;
	}

	public void setPriceF(Function priceF) {
		this.priceF = priceF;
	}

	@Override
	public String toString() {
		return "ValueFunction [order=" + order + ", value=" + value
				+ ", valueF=" + valueF + ", price=" + price + ", priceF="
				+ priceF + "]";
	}
}
