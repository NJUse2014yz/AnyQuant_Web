package function.flag;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import tool.ListTool;
import function.Flag;
import function.Function;
import function.FunctionResult;
import function.tool.TrendFlag;
import function.tool.TrendPoint;
import function.tool.TrendTool;
/**上趋势判断*/
public class UpTrendFunction extends Function{
//	/**方法名*/
//	public String function;
	/**方法结果的上界*/
	public FunctionResult resultUp;
	/**方法结果的下界*/
	public FunctionResult resultDown;
	/**股票代码*/
	public String siid;
	/**数据属性，具体见ListTool的switch中*/
	public String attribute;
	/**数据开始日期的毫秒数*/
	public long start;
	/**数据截止日期的毫秒数*/
	public long end;
	/**数据标准值，一般取该数据最近一段时间取值的平均数*/
	public double standard;
	
	public UpTrendFunction(TrendVO vo) 
	{
		this.function="UpTrend";
		this.siid=vo.siid;
		this.attribute=vo.attribute;
		this.start=vo.start;
		this.end=vo.end;
		this.standard=vo.standard;
		this.resultUp=vo.resultUp;
		this.resultDown=vo.resultDown;
	}
	public FunctionResult getResult()
	{
		List<TrendPoint> trendList=new ArrayList<TrendPoint>();
		List<Double> list=new ListTool().getList(siid,attribute,new Date(start),new Date(end));
		for(int i=0;i<list.size();i++)
		{
			trendList.add(new TrendPoint(i,list.get(i)));
		}
		TrendFlag flag=new TrendTool(standard,trendList).trend();
		FunctionResult result=new FunctionResult();
		result.location.add(3);
		result.rD=flag.uptrend;
		return result;
	}
	
//	public String getFunction() {
//		return function;
//	}
//	public void setFunction(String function) {
//		this.function = function;
//	}
	public FunctionResult getResultUp() {
		return resultUp;
	}
	public void setResultUp(FunctionResult resultUp) {
		this.resultUp = resultUp;
	}
	public FunctionResult getResultDown() {
		return resultDown;
	}
	public void setResultDown(FunctionResult resultDown) {
		this.resultDown = resultDown;
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
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public double getStandard() {
		return standard;
	}
	public void setStandard(double standard) {
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "UpTrendFunction [function=" + function + ", resultUp="
				+ resultUp + ", resultDown=" + resultDown + ", siid=" + siid
				+ ", attribute=" + attribute + ", start=" + start + ", end="
				+ end + ", standard=" + standard + "]";
	}
}
