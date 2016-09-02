package function.order;

import java.sql.Date;

import function.Function;
import function.FunctionResult;
import function.ResultType;
/**指定仓位股数订单*/
public class ShareTargetFunction extends Function{
	public double share;
	public Function shareF;
	
	public double price;
	public Function priceF;
	
	public ShareTargetFunction(){
		super();
		this.function="ShareTarget";
		this.siid=null;
		this.siidF=null;
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
		this.price=0;
		this.priceF=null;
		this.share=0;
		this.shareF=null;
	}
	
	public ShareTargetFunction(String siid,Function siidF,double share, Function shareF,
			double price, Function priceF) {
		this();
		this.function="ShareTarget";
		this.siid=siid;
		this.siidF=siidF;
		this.share = share;
		this.shareF = shareF;
		this.price = price;
		this.priceF = priceF;
	}

	public ShareTargetFunction(String siid,double share,double price) {
		this();
		this.function="ShareTarget";
		this.siid=siid;
		this.share = share;
		this.price = price;
	}

	public ShareTargetFunction(ShareVO vo)
	{
		this();
		this.function="ShareTarget";
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
	public FunctionResult getResult(Date date) {
		if(siidF!=null)
		{
			siid=siidF.getResult(date).rS;
		}
		if(shareF!=null)
		{
			share=shareF.getResult(date).rD;
		}
		if(priceF!=null)
		{
			price=priceF.getResult(date).rD;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.location.add(ResultType.STRING.getCode());
		result.rD=share;
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
		return "ShareTargetFunction [share=" + share + ", shareF=" + shareF + ", price=" + price + ", priceF=" + priceF
				+ ", function=" + function + ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI
				+ ", resultUpIF=" + resultUpIF + ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF
				+ ", resultUpO=" + resultUpO + ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + "]";
	}

	@Override
	public ShareTargetFunction clone() throws CloneNotSupportedException {
		return new ShareTargetFunction(new ShareVO(resultUpI, priceF, resultDownI, priceF, resultUpO, priceF, resultDownO, priceF, siid, priceF, share, shareF, price, priceF));
	}

}
