package function.choose;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import function.Function;
import function.FunctionResult;
import function.ResultType;

public class IntersectionFunction extends Function{
	public List<String> stockList1;
	public List<String> stockList2;
	
	public IntersectionFunction()
	{
		this.function="Intersection";
		this.stockList1=new ArrayList<String>();
		this.stockList2=new ArrayList<String>();
	}
	public IntersectionFunction(IntersectionVO vo) {
		super();
		this.function="Intersection";
		this.stockList1 = vo.stockList1;
		this.stockList2 = vo.stockList2;
	}

	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST);
		for(int i=0;i<stockList1.size();i++)
		{
			String temp=stockList1.get(i);
			if(stockList2.contains(temp))
			{
				result.rLS.add(temp);
			}
		}
		
		return result;
	}

}
