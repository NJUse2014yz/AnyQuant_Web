package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定交易股数订单*/
public class ShareFunction extends Function{
	/**买入1，卖出-1*/
	public int order;
	
	public double share;
	public Function shareF;
	
	public double price;
	public Function priceF;
	
	public ShareFunction(){
		this.function = "Share";
	}
	
	public ShareFunction(int order,String siid, double share,double price) {
		this.function = "Share";
		this.order = order;
		this.siid=siid;
		this.share = share;
		this.price = price;
	}
	
	public ShareFunction(int order,String siid,Function siidF, double share, Function shareF,
			double price, Function priceF) {
		this.function = "Share";
		this.order = order;
		this.siid=siid;
		this.siidF=siidF;
		this.share = share;
		this.shareF = shareF;
		this.price = price;
		this.priceF = priceF;
	}

	public ShareFunction(ShareVO vo)
	{
		this.function="Share";
		this.order=vo.order;
		this.siid=vo.siid;
		this.siidF=vo.siidF;
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
		this.share=vo.share;
		this.shareF=vo.shareF;
		this.price=vo.price;
		this.priceF=vo.priceF;
	}
	@Override
	public FunctionResult getResult(Date today) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.location.add(ResultType.STRING.getCode());
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

	public double getShare() {
		return share;
	}

	public void setShare(double share) {
		this.share = share;
	}

	public Function getShareF() {
		return shareF;
	}

	public void setShareF(Function shareF) {
		this.shareF = shareF;
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
		return "ShareFunction [order=" + order + ", share=" + share
				+ ", shareF=" + shareF + ", price=" + price + ", priceF="
				+ priceF + "]";
	}
}
