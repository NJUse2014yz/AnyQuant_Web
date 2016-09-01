package function.choose;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import function.Function;
import function.FunctionResult;
import function.ResultType;

public class IntersectionFunction extends Function{
	public List<String> stockList1;
	public Function stockList1F;
	
	public List<String> stockList2;
	public Function stockList2F;
	
	public IntersectionFunction()
	{
		this.function="Intersection";
	}
	
	public IntersectionFunction(List<String> stockList1,List<String> stockList2) {
		this.function="Intersection";
		this.stockList1 = stockList1;
		this.stockList2 = stockList2;
	}
	
	public IntersectionFunction(List<String> stockList1, Function stockList1F,
			List<String> stockList2, Function stockList2F) {
		this.function="Intersection";
		this.stockList1 = stockList1;
		this.stockList1F = stockList1F;
		this.stockList2 = stockList2;
		this.stockList2F = stockList2F;
	}

	public IntersectionFunction(IntersectionVO vo) {
		this.function="Intersection";
		this.resultUpI = vo.resultUpI;
		this.resultUpIF = vo.resultUpIF;
		this.resultDownI = vo.resultDownI;
		this.resultDownIF = vo.resultDownIF;
		this.resultUpO = vo.resultUpO;
		this.resultUpOF = vo.resultUpOF;
		this.resultDownO = vo.resultDownO;
		this.resultDownOF = vo.resultDownOF;
		this.stockList1 = vo.stockList1;
		this.stockList1F = vo.stockList1F;
		this.stockList2 = vo.stockList2;
		this.stockList2F = vo.stockList2F;
	}

	@Override
	public FunctionResult getResult(Date date) {
		if(stockList1F!=null)
		{
			stockList1=stockList1F.getResult(date).rLS;
		}
		if(stockList2F!=null)
		{
			stockList2=stockList2F.getResult(date).rLS;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST.getCode());
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
	public List<String> getStockList1() {
		return stockList1;
	}
	public void setStockList1(List<String> stockList1) {
		this.stockList1 = stockList1;
	}
	public Function getStockList1F() {
		return stockList1F;
	}
	public void setStockList1F(Function stockList1F) {
		this.stockList1F = stockList1F;
	}
	public List<String> getStockList2() {
		return stockList2;
	}
	public void setStockList2(List<String> stockList2) {
		this.stockList2 = stockList2;
	}
	public Function getStockList2F() {
		return stockList2F;
	}
	public void setStockList2F(Function stockList2F) {
		this.stockList2F = stockList2F;
	}
	@Override
	public String toString() {
		return "IntersectionFunction [stockList1=" + stockList1
				+ ", stockList1F=" + stockList1F + ", stockList2=" + stockList2
				+ ", stockList2F=" + stockList2F + "]";
	}
}
