package function.flag;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

/**根据一定日期内的数据属性值大小判断是否进行交易*/
public class DataFunction extends Function{
	/**设计的属性名*/
	public String attribute;
	public Function attributeF;
	
	/**数据的天数*/
	public int day;
	public Function dayF;

	public DataFunction()
	{
		super();
		this.function="Data";
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
		this.attribute=null;
		this.attributeF=null;
		this.day=0;
		this.dayF=null;
	}
	
	public DataFunction(String siid,String attribute, int day) {
		this();
		this.function="Data";
		this.siid=siid;
		this.attribute = attribute;
		this.day = day;
	}

	public DataFunction(String siid,Function siidF,String attribute, Function attributeF, int day,
			Function dayF) {
		this();
		this.function="Data";
		this.siid=siid;
		this.siidF=siidF;
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.day = day;
		this.dayF = dayF;
	}

	public DataFunction(DataVO vo){
		this();
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
		Date start=new Date(date.getTime()-(day-1)*24*60*60*1000);
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
		return "\nDataFunction [attribute=" + attribute + ", attributeF=" + attributeF + ", day=" + day + ", dayF=" + dayF
				+ ", function=" + function + ", siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI
				+ ", resultUpIF=" + resultUpIF + ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF
				+ ", resultUpO=" + resultUpO + ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO
				+ ", resultDownOF=" + resultDownOF + "]";
	}
	
}
