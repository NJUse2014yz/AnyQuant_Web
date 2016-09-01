package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易股数百分比订单*/
public class SharePercentFunction extends Function{
	public double percent;
	public Function percentF;
	
	public double price;
	public Function priceF;
	
	public SharePercentFunction(){
		this.function = "SharePercent";
	}
	
	public SharePercentFunction(String siid,double percent, double price) {
		this.function = "SharePercent";
		this.siid = siid;
		this.percent = percent;
		this.price = price;
	}

	public SharePercentFunction(String siid, Function siidF,
			double percent, Function percentF, double price, Function priceF) {
		this.function = "SharePercent";
		this.siid = siid;
		this.siidF = siidF;
		this.percent = percent;
		this.percentF = percentF;
		this.price = price;
		this.priceF = priceF;
	}

	public SharePercentFunction(PercentVO vo)
	{
		this.function="SharePercent";
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
		this.percent=vo.percent;
		this.percentF=vo.percentF;
		this.price=vo.price;
		this.priceF=vo.priceF;
	}
	@Override
	public FunctionResult getResult(Date date) {
		if(siidF!=null)
		{
			siid=siidF.getResult(date).rS;
		}
		if(percentF!=null)
		{
			percent=percentF.getResult(date).rD;
		}
		if(priceF!=null)
		{
			price=priceF.getResult(date).rD;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.location.add(ResultType.STRING.getCode());
		result.rD=percent;
		result.rS=siid;
		return result;
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

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public Function getPercentF() {
		return percentF;
	}

	public void setPercentF(Function percentF) {
		this.percentF = percentF;
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
		return "SharePercentFunction [percent=" + percent + ", percentF=" + percentF + ", price=" + price + ", priceF="
				+ priceF + ", function=" + function + ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI
				+ ", resultUpIF=" + resultUpIF + ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF
				+ ", resultUpO=" + resultUpO + ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + "]";
	}

}
