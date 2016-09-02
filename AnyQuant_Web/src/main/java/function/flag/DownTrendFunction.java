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
/**下趋势判断*/
public class DownTrendFunction extends Function{
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
	
	public DownTrendFunction()
	{
		super();
		this.function="DownTrend";
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
		this.attribute=null;
		this.attributeF=null;
		this.day=0;
		this.dayF=null;
		this.standard=10;
		this.standardF=null;
	}
	
	public DownTrendFunction(String siid,String attribute, int day, double standard) {
		this();
		this.function="DownTrend";
		this.siid=siid;
		this.attribute = attribute;
		this.day = day;
		this.standard = standard;
	}

	public DownTrendFunction(String siid,Function siidF,String attribute, Function attributeF, int day,
			Function dayF, double standard, Function standardF) {
		this();
		this.function="DownTrend";
		this.siid=siid;
		this.siidF=siidF;
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.day = day;
		this.dayF = dayF;
		this.standard = standard;
		this.standardF = standardF;
	}

	public DownTrendFunction(TrendVO vo) {
		this();
		this.function="DownTrend";
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
		result.rD=flag.downtrend;
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
		return "DownTrendFunction [attribute=" + attribute + ", attributeF=" + attributeF + ", day=" + day + ", dayF="
				+ dayF + ", standard=" + standard + ", standardF=" + standardF + ", function=" + function + ", siid="
				+ siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF
				+ "]";
	}

}
