package function.flag;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.tool.TrendFlag;
import function.tool.TrendPoint;
import function.tool.TrendTool;
/**上趋势判断*/
public class UpTrendFunction extends Function{
	/**数据属性*/
	public String attribute;
	public Function attributeF;
	
	/**往前推的天数*/
	public int day;
	public Function dayF;
	
	/**数据标准值，一般取该数据最近一段时间取值的平均数*/
	public double standard;
	/**standard的获取方法*/
	public Function standardF;
	
	public UpTrendFunction()
	{
		this.function="UpTrend";
	}
	
	public UpTrendFunction(String siid,String attribute, int day, double standard) {
		this.function="UpTrend";
		this.siid=siid;
		this.attribute = attribute;
		this.day = day;
		this.standard = standard;
	}

	public UpTrendFunction(String siid,Function siidF,String attribute, Function attributeF, int day,
			Function dayF, double standard, Function standardF) {
		this.siid=siid;
		this.siidF=siidF;
		this.function="UpTrend";
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.day = day;
		this.dayF = dayF;
		this.standard = standard;
		this.standardF = standardF;
	}
	
	public UpTrendFunction(TrendVO vo) 
	{
		this.function="UpTrend";
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
		this.resultDownO=vo.resultDownO;
		this.resultDownOF=vo.resultDownOF;
		this.siid=vo.siid;
		this.siidF=vo.siidF;
		this.attribute=vo.attribute;
		this.attributeF=vo.attributeF;
		this.day=vo.day;
		this.dayF=vo.dayF;
		this.standard=vo.standard;
		this.standardF=vo.standardF;
	}
	public FunctionResult getResult(Date date)
	{
		if(siidF!=null)
		{
			siid=siidF.getResult(date).rS;
		}
		if(attributeF!=null)
		{
			attribute=attributeF.getResult(date).rS;
		}
		if(dayF!=null)
		{
			day=dayF.getResult(date).rI;
		}
		if(standardF!=null)
		{
			standard=standardF.getResult(date).rD;
		}
		Date start=new Date(date.getTime()-day*24*60*60*1000);
		Date end=date;
		List<TrendPoint> trendList=new ArrayList<TrendPoint>();
		List<Double> list=new ListTool().getList(siid,attribute,start,end);
		for(int i=0;i<list.size();i++)
		{
			trendList.add(new TrendPoint(i,list.get(i)));
		}
		TrendFlag flag=new TrendTool(standard,trendList).trend();
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.rD=flag.uptrend;
		return result;
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Function getDayF() {
		return dayF;
	}
	public void setDayF(Function dayF) {
		this.dayF = dayF;
	}
	public double getStandard() {
		return standard;
	}
	public void setStandard(double standard) {
		this.standard = standard;
	}
	public Function getStandardF() {
		return standardF;
	}
	public void setStandardF(Function standardF) {
		this.standardF = standardF;
	}

	@Override
	public String toString() {
		return "UpTrendFunction [attribute=" + attribute + ", attributeF=" + attributeF + ", day=" + day + ", dayF="
				+ dayF + ", standard=" + standard + ", standardF=" + standardF + ", function=" + function + ", siid="
				+ siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF
				+ "]";
	}

}
