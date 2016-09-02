package function.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
		super();
		this.function="Mean";
		this.siid=null;
		this.siidF=null;
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
		this.valueList=null;
		this.valueListF=null;
	}
	public MeanFunction(List<Double> valueList) {
		this();
		this.function="Mean";
		this.valueList = valueList;
	}
	public MeanFunction(List<Double> valueList, Function valueListF) {
		this();
		this.function="Mean";
		this.valueList = valueList;
		this.valueListF = valueListF;
	}
	public MeanFunction(MeanVO vo) {
		this();
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
		result.location.add(ResultType.DOUBLELIST.getCode());
		result.rD=MMSTool.mean(valueList);
		result.rLD=new ArrayList<Double>();
		result.rLD.add(result.rD);
		return result;
	}
	
	public List<Double> getValueList() {
		return valueList;
	}
	public void setValueList(List<Double> valueList) {
		this.valueList = valueList;
	}
	public Function getValueListF() {
		return valueListF;
	}
	public void setValueListF(Function valueListF) {
		this.valueListF = valueListF;
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
