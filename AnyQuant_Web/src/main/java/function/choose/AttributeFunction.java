package function.choose;

import java.sql.Date;
import java.util.List;

import po.StockInf;
import service.impl.StockDataServiceImpl;
import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class AttributeFunction extends Function{
	public double up;
	public double down;
	public String attribute;
	
	public AttributeFunction()
	{
		this.function="Attribute";
	}
	public AttributeFunction(double up, double down, String attribute) {
		super();
		this.function="Attribute";
		this.up = up;
		this.down = down;
		this.attribute = attribute;
	}
	public AttributeFunction(AttributeVO vo)
	{
		this.function="Attribute";
		this.up = vo.up;
		this.down = vo.down;
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
		for(int i=0;i<list.size();i++)
		{
			double value=new ListTool().getNew(list.get(i).getSid(), attribute);
			if(value<up&&value>down)
			{
				result.rLS.add(list.get(i).getSid());
			}
		}
		return result;
	}

}
