package function.flag;

import java.sql.Date;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

public class DataFunction extends Function{
	/**设计的属性名*/
	public String attribute;
	public Function attributeF;
	
	/**数据的天数*/
	public int day;
	public Function dayF;

	public DataFunction()
	{
		this.function="Data";
	}
	
	public DataFunction(String siid,String attribute, int day) {
		this.function="Data";
		this.siid=siid;
		this.attribute = attribute;
		this.day = day;
	}

	public DataFunction(String siid,Function siidF,String attribute, Function attributeF, int day,
			Function dayF) {
		this.function="Data";
		this.siid=siid;
		this.siidF=siidF;
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.day = day;
		this.dayF = dayF;
	}

	public DataFunction(DataVO vo){
		this.function="Data";
		this.siid=vo.siid;
		this.siidF=vo.siidF;
		this.attribute=vo.attribute;
		this.attributeF=vo.attributeF;
		this.day=vo.day;
		this.dayF=vo.dayF;
		this.resultDownI=vo.resultDownI;
		this.resultDownIF=vo.resultDownIF;
		this.resultDownO=vo.resultDownO;
		this.resultDownOF=vo.resultDownOF;
		this.resultUpI=vo.resultUpI;
		this.resultUpIF=vo.resultUpIF;
		this.resultUpO=vo.resultUpO;
		this.resultUpOF=vo.resultUpOF;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		if(siidF!=null)
		{
			siid=siidF.getResult(date).rS;
		}
		if(attributeF!=null)
		{
			attribute=attributeF.getResult(date).rS;
		}
		if(dayF!=null)
		{
			day=dayF.getResult(date).rI;
		}
		Date start=new Date(date.getTime()-day*24*60*60*1000);
		Date end=date;
		List<Double> list=new ListTool().getList(siid,attribute,start,end);
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.DOUBLELIST.getCode());
		result.rLD=list;
		return result;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Function getAttributeF() {
		return attributeF;
	}
	public void setAttributeF(Function attributeF) {
		this.attributeF = attributeF;
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
		return "DataFunction [siid=" + siid + ", siidF=" + siidF
				+ ", attribute=" + attribute + ", attributeF=" + attributeF
				+ ", day=" + day + ", dayF=" + dayF + "]";
	}
}
