package function.flag;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import mapper.HistoryDataMapper;
import mapper.QuotaDataMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import function.Function;
import function.FunctionResult;
import po.DatePack;
import bl.TrendFlag;
import bl.TrendPoint;
import bl.TrendTool;
import tool.ListTool;

public class TrendFunction implements Function{
	public HistoryDataMapper historyDataMapper;
	public List<TrendPoint> trendList=new ArrayList<TrendPoint>();
	public double standard;
	public TrendFunction(String siid,String attribute,Date start,Date end,Double standard)
	{
		this.standard=standard;
		List<Double> list=new ListTool().getList(siid,attribute,start,end);
		for(int i=0;i<list.size();i++)
		{
			trendList.add(new TrendPoint(i,list.get(i)));
		}
	}

	@Override
	public FunctionResult getResult() {
		TrendFlag flag=new TrendTool(standard,trendList).trend();
		FunctionResult result=new FunctionResult();
		result.location.add(3);
		result.rD=flag.trend;
		return result;
	}
	
}
