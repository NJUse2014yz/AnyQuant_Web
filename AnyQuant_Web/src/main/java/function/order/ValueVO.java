package function.order;

import function.Function;
import function.FunctionResult;

public class ValueVO {
	/**方法买入结果的上界*/
	public FunctionResult resultUpI;
	/**得到买入结果上界的方法*/
	public Function resultUpIF;
	
	/**方法买入结果的下界*/
	public FunctionResult resultDownI;
	/**得到买入结果上界的方法*/
	public Function resultDownIF;
	
	/**方法卖出结果的上界*/
	public FunctionResult resultUpO;
	/**得到买入结果上界的方法*/
	public Function resultUpOF;
	
	/**方法卖出结果的下界*/
	public FunctionResult resultDownO;
	/**得到买入结果上界的方法*/
	public Function resultDownOF;
	
	public String siid;
	public Function siidF;
	
	public double value;
	public Function valueF;
	
	public double price;
	public Function priceF;
	
	public ValueVO(){}
	public ValueVO(FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF,
			String siid, Function siidF, double value, Function valueF,
			double price, Function priceF) {
		super();
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
		this.siid = siid;
		this.siidF = siidF;
		this.value = value;
		this.valueF = valueF;
		this.price = price;
		this.priceF = priceF;
	}
	public FunctionResult getResultUpI() {
		return resultUpI;
	}
	public void setResultUpI(FunctionResult resultUpI) {
		this.resultUpI = resultUpI;
	}
	public Function getResultUpIF() {
		return resultUpIF;
	}
	public void setResultUpIF(Function resultUpIF) {
		this.resultUpIF = resultUpIF;
	}
	public FunctionResult getResultDownI() {
		return resultDownI;
	}
	public void setResultDownI(FunctionResult resultDownI) {
		this.resultDownI = resultDownI;
	}
	public Function getResultDownIF() {
		return resultDownIF;
	}
	public void setResultDownIF(Function resultDownIF) {
		this.resultDownIF = resultDownIF;
	}
	public FunctionResult getResultUpO() {
		return resultUpO;
	}
	public void setResultUpO(FunctionResult resultUpO) {
		this.resultUpO = resultUpO;
	}
	public Function getResultUpOF() {
		return resultUpOF;
	}
	public void setResultUpOF(Function resultUpOF) {
		this.resultUpOF = resultUpOF;
	}
	public FunctionResult getResultDownO() {
		return resultDownO;
	}
	public void setResultDownO(FunctionResult resultDownO) {
		this.resultDownO = resultDownO;
	}
	public Function getResultDownOF() {
		return resultDownOF;
	}
	public void setResultDownOF(Function resultDownOF) {
		this.resultDownOF = resultDownOF;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public Function getSiidF() {
		return siidF;
	}
	public void setSiidF(Function siidF) {
		this.siidF = siidF;
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
		return "ValueVO [resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF="
				+ resultDownIF + ", resultUpO=" + resultUpO + ", resultUpOF="
				+ resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF 
				+ ", siid=" + siid + ", siidF=" + siidF + ", value=" + value
				+ ", valueF=" + valueF + ", price=" + price + ", priceF="
				+ priceF + "]";
	}
}
