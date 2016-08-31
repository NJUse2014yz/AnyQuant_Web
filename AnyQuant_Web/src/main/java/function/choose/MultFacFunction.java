package function.choose;

import java.sql.Date;
import java.util.List;

import function.Function;
import function.FunctionResult;
import function.ResultType;
import po.StockInf;
import tool.ListTool;
//就一些要求的参数做30，60，300天的回测
//使用 平均换手率，平均成交量，平均涨跌幅，最新的成交量变异率（20），最旧的动向指标
public class MultFacFunction extends Function{

	public String attribute;
	
	public MultFacFunction()
	{
		this.function="MultFactor";
	}
	
	public MultFacFunction(String attribute){
		super();
		this.function="MultFactor";
		this.attribute = attribute;
	}
	
	public MultFacFunction(MultFacVO vo)
	{
		this.function="MultFactor";
		this.attribute = vo.attribute;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST);
		List<StockInf> list=null;
		try {
			list=ListTool.stockInfMapper.selectStockInf_all();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		for(int i=0;i<list.size();i++)
//		{
//			double value=new ListTool().getNew(list.get(i).getSid(), attribute);
//			if(value<up&&value>down)
//			{
//				result.rLS.add(list.get(i).getSid());
//			}
//		}
		return result;
	
	}

}
