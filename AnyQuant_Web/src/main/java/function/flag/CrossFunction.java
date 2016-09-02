package function.flag;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import function.tool.CrossResult;
import function.tool.CrossTool;
/**判断双线交叉方向方法*/
public class CrossFunction extends Function {
	/**主动交叉股票代码*/
	public String siid1;
	public Function siid1F;
	/**主动数据属性，具体见ListTool的switch中*/
	public String attribute1;
	public Function attribute1F;
	/**被动交叉股票代码*/
	public String siid2;
	public Function siid2F;
	/**被动数据属性*/
	public String attribute2;
	public Function attribute2F;
	/**往前推的天数(包括今天)*/
	public int day;
	public Function dayF;
	
	public CrossFunction()
	{
		super();
		this.function="Cross";
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
		this.siid1=null;
		this.siid1F=null;
		this.attribute1=null;
		this.attribute1F=null;
		this.siid2=null;
		this.siid2F=null;
		this.attribute2=null;
		this.attribute2F=null;
		this.day=0;
		this.dayF=null;
	}
	
	public CrossFunction(String siid1, String attribute1, String siid2,String attribute2, int day) {
		this();
		this.function="Cross";
		this.siid1 = siid1;
		this.attribute1 = attribute1;
		this.siid2 = siid2;
		this.attribute2 = attribute2;
		this.day = day;
	}
	
	public CrossFunction(String siid1, Function siid1f, String attribute1,
			Function attribute1f, String siid2, Function siid2f,
			String attribute2, Function attribute2f, int day, Function dayF) {
		this();
		this.function="Cross";
		this.siid1 = siid1;
		siid1F = siid1f;
		this.attribute1 = attribute1;
		attribute1F = attribute1f;
		this.siid2 = siid2;
		siid2F = siid2f;
		this.attribute2 = attribute2;
		attribute2F = attribute2f;
		this.day = day;
		this.dayF = dayF;
	}

	public CrossFunction(CrossVO vo)
	{
		this();
		this.function="Cross";
		this.siid1=vo.siid1;
		this.siid1F=vo.siid1F;
		this.attribute1=vo.attribute1;
		this.attribute1F=vo.attribute1F;
		this.siid2=vo.siid2;
		this.siid2F=vo.siid2F;
		this.attribute2=vo.attribute2;
		this.attribute2F=vo.attribute2F;
		this.day=vo.day;
		this.dayF=vo.dayF;
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
		this.resultUpO=vo.resultDownO;
		this.resultUpOF=vo.resultDownOF;
	}
	@Override
	public FunctionResult getResult(Date date) {
		if(siid1F!=null)
		{
			siid1=siid1F.getResult(date).rS;
		}
		if(siid2F!=null)
		{
			siid2=siid2F.getResult(date).rS;
		}
		if(attribute1F!=null)
		{
			attribute1=attribute1F.getResult(date).rS;
		}
		if(attribute2F!=null)
		{
			attribute2=attribute2F.getResult(date).rS;
		}
		if(dayF!=null)
		{
			day=dayF.getResult(date).rI;
		}
		Date start=new Date(date.getTime()-day*24*60*60*1000);
		Date end=date;
		List<Double> activelist=new ListTool().getList(siid1,attribute1,start,end);
		List<Double> passivelist=new ListTool().getList(siid2,attribute2,start,end);
		CrossResult crossResult=new CrossTool(activelist,passivelist).cross();
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.INT.getCode());
		result.rI=crossResult.cross;
		return result;
	}
	public String getSiid1() {
		return siid1;
	}
	public void setSiid1(String siid1) {
		this.siid1 = siid1;
	}
	public Function getSiid1F() {
		return siid1F;
	}
	public void setSiid1F(Function siid1f) {
		siid1F = siid1f;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public Function getAttribute1F() {
		return attribute1F;
	}
	public void setAttribute1F(Function attribute1f) {
		attribute1F = attribute1f;
	}
	public String getSiid2() {
		return siid2;
	}
	public void setSiid2(String siid2) {
		this.siid2 = siid2;
	}
	public Function getSiid2F() {
		return siid2F;
	}
	public void setSiid2F(Function siid2f) {
		siid2F = siid2f;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public Function getAttribute2F() {
		return attribute2F;
	}
	public void setAttribute2F(Function attribute2f) {
		attribute2F = attribute2f;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Function getDayF() {
		return dayF;
	}
	public void setDayF(Function dayF) {
		this.dayF = dayF;
	}

	@Override
	public String toString() {
		return "CrossFunction [siid1=" + siid1 + ", siid1F=" + siid1F + ", attribute1=" + attribute1 + ", attribute1F="
				+ attribute1F + ", siid2=" + siid2 + ", siid2F=" + siid2F + ", attribute2=" + attribute2
				+ ", attribute2F=" + attribute2F + ", day=" + day + ", dayF=" + dayF + ", function=" + function
				+ ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF
				+ "]";
	}

}
