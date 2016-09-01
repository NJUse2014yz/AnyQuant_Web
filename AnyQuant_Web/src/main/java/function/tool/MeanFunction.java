package function.tool;

import java.sql.Date;
import java.util.List;

import function.Function;
import function.FunctionResult;
import function.ResultType;
import tool.MMSTool;
/**得到平均值*/
public class MeanFunction extends Function{
	public List<Double> valueList;
	public Function valueListF;
	
	public MeanFunction()
	{
		this.function="Mean";
	}
	public MeanFunction(List<Double> valueList) {
		this.function="Mean";
		this.valueList = valueList;
	}
	public MeanFunction(List<Double> valueList, Function valueListF) {
		this.function="Mean";
		this.valueList = valueList;
		this.valueListF = valueListF;
	}
	public MeanFunction(MeanVO vo) {
		this.function="Mean";
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultDownO=vo.resultDownO;
		this.resultDownOF=vo.resultDownOF;
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
		this.valueList = vo.valueList;
		this.valueListF = vo.valueListF;
	}
	@Override
	public FunctionResult getResult(Date date) {
		if(valueListF!=null)
		{
			valueList=valueListF.getResult(date).rLD;
		}
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLE.getCode());
		result.rD=MMSTool.mean(valueList);
		return result;
	}
	@Override
	public String toString() {
		return "\nMeanFunction [valueList=" + valueList + ", valueListF=" + valueListF + ", function=" + function
				+ ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF
				+ "]\n";
	}
}
