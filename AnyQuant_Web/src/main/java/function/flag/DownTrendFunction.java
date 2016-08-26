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
	/**股票代码*/
//	public String siid;
	/**数据属性，具体见ListTool的switch中*/
	public String attribute;
	/**天数*/
	public int day;
	/**数据标准值，一般取该数据最近一段时间取值的平均数*/
	public double standard;
	
	public DownTrendFunction(TrendVO vo) {
		this.function="DownTrend";
		this.siid=vo.siid;
		this.attribute=vo.attribute;
		this.day=vo.day;
		this.standard=vo.standard;
		this.resultUpI=vo.resultUpI;
		this.resultDownI=vo.resultDownI;
		this.resultUpO=vo.resultUpO;
		this.resultDownO=vo.resultDownO;
	}
	public FunctionResult getResult(Date today)
	{
		Date start=new Date(today.getTime()-day*24*60*60*1000);
		Date end=today;
		List<TrendPoint> trendList=new ArrayList<TrendPoint>();
		List<Double> list=new ListTool().getList(siid,attribute,start,end);
		for(int i=0;i<list.size();i++)
		{
			trendList.add(new TrendPoint(i,list.get(i)));
		}
		TrendFlag flag=new TrendTool(standard,trendList).trend();
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLELIST);
		result.rD=flag.downtrend;
		return result;
	}
	
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public double getStandard() {
		return standard;
	}
	public void setStandard(double standard) {
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "DownTrendFunction [siid=" + siid + ", attribute=" + attribute
				+ ", day=" + day + ", standard=" + standard + "]";
	}
}
