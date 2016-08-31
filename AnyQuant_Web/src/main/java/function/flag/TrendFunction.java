package function.flag;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.tool.TrendFlag;
import function.tool.TrendPoint;
import function.tool.TrendTool;
import tool.ListTool;
/**趋势判断*/
public class TrendFunction extends Function{
	/**股票代码*/
	public String siid;
	public Function siidF;
	
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
	
	public TrendFunction()
	{
		this.function="Trend";
	}
	
	public TrendFunction(String attribute, int day, double standard) {
		this.function="Trend";
		this.attribute = attribute;
		this.day = day;
		this.standard = standard;
	}

	public TrendFunction(String attribute, Function attributeF, int day,
			Function dayF, double standard, Function standardF) {
		this.function="Trend";
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.day = day;
		this.dayF = dayF;
		this.standard = standard;
		this.standardF = standardF;
	}
	
	public TrendFunction(TrendVO vo)
	{
		this.function="Trend";
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

	@Override
	public FunctionResult getResult(Date today) {
		Date start=new Date(today.getTime()-day*24*60*60*1000);
		Date end=today;
		List<TrendPoint> trendList=new ArrayList<TrendPoint>();
		List<Double> list=new ListTool().getList(siid,attribute,start,end);
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++)
		{
			trendList.add(new TrendPoint(i,list.get(i)));
		}
		TrendFlag flag=new TrendTool(standard,trendList).trend();
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.rD=flag.trend;
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
		return "TrendFunction [siid=" + siid + ", siidF=" + siidF
				+ ", attribute=" + attribute + ", attributeF=" + attributeF
				+ ", day=" + day + ", dayF=" + dayF + ", standard=" + standard
				+ ", standardF=" + standardF + "]";
	}
}
