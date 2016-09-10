package function.choose;

import java.sql.Date;
import java.util.ArrayList;

import po.StockPair;
import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;
/**配对选股方法*/
public class BestPairFunction extends Function{
	/**配对股票查找最好的配对*/
	
	public BestPairFunction()
	{
		super();
		this.function="BestPair";
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
	}

	
	@Override
	public FunctionResult getResult(Date date) {
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.STRINGLIST.getCode());
		StockPair pair=new StockPair();
		try {
			pair = new ListTool().stockInfMapper.selectStockPair();
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.rLS=new ArrayList<String>();
		result.rLS.add(pair.sid.toString());
		result.rLS.add(pair.partner1.toString());
		return result;
	}

	@Override
	public String toString() {
		return "BestPairFunction []";
	}
}
