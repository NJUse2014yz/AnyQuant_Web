package function.risk;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

/**某指标至某标准值的某百分比*/
public class StandardPercentFunction extends Function{
	/**大于为正，小于为负，等于为0*/
	public int sign;
	public Function signF;
	
	/**目标属性*/
	public String attribute;
	public Function attributeF;
	
	/**标准属性*/
	public String standard;
	public Function standardF;
	
	public double percent;
	public Function percentF;
	
	public StandardPercentFunction()
	{
		this.function="StandardPercent";
	}
	
	public StandardPercentFunction(String siid,int sign,String attribute,String standard,double percent) {
		this.function="StandardPercent";
		this.siid=siid;
		this.sign = sign;
		this.attribute = attribute;
		this.standard = standard;
		this.percent = percent;
	}
	public StandardPercentFunction(String siid,Function siidF,
			int sign, Function signF, String attribute,
			Function attributeF, String standard, Function standardF,
			double percent, Function percentF) {
		this.function="StandardPercent";
		this.siid=siid;
		this.siidF=siidF;
		this.sign = sign;
		this.signF = signF;
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.standard = standard;
		this.standardF = standardF;
		this.percent = percent;
		this.percentF = percentF;
	}

	public StandardPercentFunction(StandardPercentVO vo)
	{
		this.function="StandardPercent";
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultDownO=vo.resultDownO;
		this.resultDownOF=vo.resultDownOF;
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
		this.sign=vo.sign;
		this.signF=vo.signF;
		this.siid=vo.siid;
		this.siidF=vo.siidF;
		this.attribute=vo.attribute;
		this.attribute=vo.attribute;
		this.standard=vo.standard;
		this.standardF=vo.standardF;
		this.percent=vo.percent;
		this.percentF=vo.percentF;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		if(siidF!=null)
		{
			siid=siidF.getResult(date).rS;
		}
		if(signF!=null)
		{
			sign=signF.getResult(date).rI;
		}
		if(attributeF!=null)
		{
			attribute=attributeF.getResult(date).rS;
		}
		if(percentF!=null)
		{
			percent=percentF.getResult(date).rD;
		}
		if(standardF!=null)
		{
			standard=standardF.getResult(date).rS;
		}
		double targetValue=new ListTool().getNew(siid, attribute);
		double standardValue=new ListTool().getNew(siid, standard);
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.BOOLEAN.getCode());
		
		if(sign>0&&targetValue>standardValue*percent
				||sign<0&&targetValue<standardValue*percent
				||sign==0&&targetValue==standardValue*percent)
		{
			result.rB=true;
		}
		return result;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public Function getSignF() {
		return signF;
	}
	public void setSignF(Function signF) {
		this.signF = signF;
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
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Function getAttributeF() {
		return attributeF;
	}
	public void setAttributeF(Function attributeF) {
		this.attributeF = attributeF;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Function getStandardF() {
		return standardF;
	}
	public void setStandardF(Function standardF) {
		this.standardF = standardF;
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

	@Override
	public String toString() {
		return "StandardPercentFunction [sign=" + sign + ", signF=" + signF + ", attribute=" + attribute
				+ ", attributeF=" + attributeF + ", standard=" + standard + ", standardF=" + standardF + ", percent="
				+ percent + ", percentF=" + percentF + ", function=" + function + ", siid=" + siid + ", siidF=" + siidF
				+ ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF + ", resultDownI=" + resultDownI
				+ ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO + ", resultUpOF=" + resultUpOF
				+ ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF + "]";
	}

}
