package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易价值订单*/
public class ValueFunction extends Function{
	public double value;
	public Function valueF;
	
	public double price;
	public Function priceF;
	
	public ValueFunction(){
		this.function="Value";
	}
	
	public ValueFunction(String siid,double value, double price) {
		this.function="Value";
		this.siid=siid;
		this.value = value;
		this.price = price;
	}

	public ValueFunction(String siid,Function siidF,double value, Function valueF,
			double price, Function priceF) {
		this.function="Value";
		this.siid=siid;
		this.siidF=siidF;
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
		this.siid=vo.siid;
		this.siidF=vo.siidF;
		this.value=vo.value;
		this.valueF=vo.valueF;
		this.price=vo.price;
		this.priceF=vo.priceF;
	}
	@Override
	public FunctionResult getResult(Date date) {
		if(siidF!=null)
		{
			siid=siidF.getResult(date).rS;
		}
		if(valueF!=null)
		{
			value=valueF.getResult(date).rD;
		}
		if(priceF!=null)
		{
			price=priceF.getResult(date).rD;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.location.add(ResultType.STRING.getCode());
		result.rD=value;
		result.rS=siid;
		return result;
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
		return "ValueFunction [value=" + value + ", valueF=" + valueF + ", price=" + price + ", priceF=" + priceF
				+ ", function=" + function + ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI
				+ ", resultUpIF=" + resultUpIF + ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF
				+ ", resultUpO=" + resultUpO + ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + "]";
	}

}
