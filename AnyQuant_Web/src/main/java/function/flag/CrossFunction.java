package function.flag;

import java.sql.Date;
import java.util.List;

import tool.ListTool;
import function.Flag;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.tool.CrossResult;
import function.tool.CrossTool;
/**判断双线交叉方向方法*/
public class CrossFunction extends Function {
//	/**方法名*/
//	public String function;
	/**方法买入结果的上界*/
	public FunctionResult resultUpI;
	/**方法买入结果的下界*/
	public FunctionResult resultDownI;
	/**方法卖出结果的上界*/
	public FunctionResult resultUpO;
	/**方法卖出结果的下界*/
	public FunctionResult resultDownO;
	/**主动交叉股票代码*/
	public String siid1;
	/**主动数据属性，具体见ListTool的switch中*/
	public String attribute1;
	/**被动交叉股票代码*/
	public String siid2;
	/**被动数据属性*/
	public String attribute2;
	/**数据开始日期的毫秒数*/
	public long start;
	/**数据截止日期的毫秒数*/
	public long end;
	
	public CrossFunction(CrossVO vo)
	{
		this.function="Cross";
		this.siid1=vo.siid1;
		this.attribute1=vo.attribute1;
		this.siid2=vo.siid2;
		this.attribute2=vo.attribute2;
		this.start=vo.start;
		this.end=vo.end;
		this.resultUpI=vo.resultUpI;
		this.resultDownI=vo.resultDownI;
		this.resultUpO=vo.resultUpO;
		this.resultDownO=vo.resultDownO;
	}
	@Override
	public FunctionResult getResult() {
		List<Double> activelist=new ListTool().getList(siid1,attribute1,new Date(start),new Date(end));
		List<Double> passivelist=new ListTool().getList(siid2,attribute2,new Date(start),new Date(end));
		CrossResult crossResult=new CrossTool(activelist,passivelist).cross();
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLELIST);
		result.rI=crossResult.cross;
		return result;
	}
	
	
//	public String getFunction() {
//		return function;
//	}
//	public void setFunction(String function) {
//		this.function = function;
//	}
	
	public String getSiid1() {
		return siid1;
	}
	public FunctionResult getResultUpI() {
		return resultUpI;
	}
	public void setResultUpI(FunctionResult resultUpI) {
		this.resultUpI = resultUpI;
	}
	public FunctionResult getResultDownI() {
		return resultDownI;
	}
	public void setResultDownI(FunctionResult resultDownI) {
		this.resultDownI = resultDownI;
	}
	public FunctionResult getResultUpO() {
		return resultUpO;
	}
	public void setResultUpO(FunctionResult resultUpO) {
		this.resultUpO = resultUpO;
	}
	public FunctionResult getResultDownO() {
		return resultDownO;
	}
	public void setResultDownO(FunctionResult resultDownO) {
		this.resultDownO = resultDownO;
	}
	public void setSiid1(String siid1) {
		this.siid1 = siid1;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getSiid2() {
		return siid2;
	}
	public void setSiid2(String siid2) {
		this.siid2 = siid2;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
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
	@Override
	public String toString() {
		return "CrossFunction [resultUpI=" + resultUpI + ", resultDownI="
				+ resultDownI + ", resultUpO=" + resultUpO + ", resultDownO="
				+ resultDownO + ", siid1=" + siid1 + ", attribute1="
				+ attribute1 + ", siid2=" + siid2 + ", attribute2="
				+ attribute2 + ", start=" + start + ", end=" + end + "]";
	}
}
