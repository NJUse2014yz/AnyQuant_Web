package function.choose;

import java.util.List;

import function.Function;
import function.FunctionResult;

public class IntersectionVO {
	/**方法买入结果的上界*/
	public FunctionResult resultUpI;
	/**得到买入结果上界的方法*/
	public Function resultUpIF;
	
	/**方法买入结果的下界*/
	public FunctionResult resultDownI;
	/**得到买入结果上界的方法*/
	public Function resultDownIF;
	
	/**方法卖出结果的上界*/
	public FunctionResult resultUpO;
	/**得到买入结果上界的方法*/
	public Function resultUpOF;
	
	/**方法卖出结果的下界*/
	public FunctionResult resultDownO;
	/**得到买入结果上界的方法*/
	public Function resultDownOF;
	
	public List<String> stockList1;
	public Function stockList1F;
	
	public List<String> stockList2;
	public Function stockList2F;
	
	public IntersectionVO()
	{
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
		this.stockList1=null;
		this.stockList1F=null;
		this.stockList2=null;
		this.stockList2F=null;
	}
	public IntersectionVO(List<String> stockList1, List<String> stockList2) {
		this();
		this.stockList1 = stockList1;
		this.stockList2 = stockList2;
	}

	public IntersectionVO(FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF,
			List<String> stockList1, Function stockList1F,
			List<String> stockList2, Function stockList2F) {
		this();
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
		this.stockList1 = stockList1;
		this.stockList1F = stockList1F;
		this.stockList2 = stockList2;
		this.stockList2F = stockList2F;
	}

	public FunctionResult getResultUpI() {
		return resultUpI;
	}

	public void setResultUpI(FunctionResult resultUpI) {
		this.resultUpI = resultUpI;
	}

	public Function getResultUpIF() {
		return resultUpIF;
	}

	public void setResultUpIF(Function resultUpIF) {
		this.resultUpIF = resultUpIF;
	}

	public FunctionResult getResultDownI() {
		return resultDownI;
	}

	public void setResultDownI(FunctionResult resultDownI) {
		this.resultDownI = resultDownI;
	}

	public Function getResultDownIF() {
		return resultDownIF;
	}

	public void setResultDownIF(Function resultDownIF) {
		this.resultDownIF = resultDownIF;
	}

	public FunctionResult getResultUpO() {
		return resultUpO;
	}

	public void setResultUpO(FunctionResult resultUpO) {
		this.resultUpO = resultUpO;
	}

	public Function getResultUpOF() {
		return resultUpOF;
	}

	public void setResultUpOF(Function resultUpOF) {
		this.resultUpOF = resultUpOF;
	}

	public FunctionResult getResultDownO() {
		return resultDownO;
	}

	public void setResultDownO(FunctionResult resultDownO) {
		this.resultDownO = resultDownO;
	}

	public Function getResultDownOF() {
		return resultDownOF;
	}

	public void setResultDownOF(Function resultDownOF) {
		this.resultDownOF = resultDownOF;
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
		return "IntersectionVO [resultUpI=" + resultUpI + ", resultUpIF="
				+ resultUpIF + ", resultDownI=" + resultDownI
				+ ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + ", stockList1="
				+ stockList1 + ", stockList1F=" + stockList1F + ", stockList2="
				+ stockList2 + ", stockList2F=" + stockList2F + "]";
	}
}
