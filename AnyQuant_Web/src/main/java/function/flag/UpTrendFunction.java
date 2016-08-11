package function.flag;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import bl.TrendFlag;
import bl.TrendPoint;
import bl.TrendTool;

public class UpTrendFunction extends Function{
	public String siid;
	public String attribute;
	public long start;
	public long end;
	public double standard;
	
	public UpTrendFunction(TrendVO vo) 
	{
		this.function=UpTrendFunction.class;
		this.siid=vo.siid;
		this.attribute=vo.attribute;
		this.start=vo.start;
		this.end=vo.end;
		this.standard=vo.standard;
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
		return "UpTrendFunction [siid=" + siid + ", attribute=" + attribute
				+ ", start=" + start + ", end=" + end + ", standard="
				+ standard + "]";
	}

}
