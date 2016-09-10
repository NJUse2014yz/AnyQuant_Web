package function.choose;

import function.Function;
import function.FunctionResult;

public class MultFactVO {
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
	
	public String attribute;
	public Function attributeF;
	public int days;
	public Function daysF;
	public int stosum;
	public Function stosumF;

	public MultFactVO()
	{
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
		
		this.attribute=null;
		this.days=30;
		this.stosum=10;
		this.attributeF=null;
		this.daysF=null;
		this.stosumF=null;
	}
	
	public MultFactVO(String attribute) {
		this();
		this.attribute = attribute;
	}
	public MultFactVO(String attribute, int days, int stosum) {
		this();
		this.attribute = attribute;
		this.days = days;
		this.stosum = stosum;
		this.attributeF=null;
		this.daysF=null;
		this.stosumF=null;
	}
	public MultFactVO(String attribute, Function attributeF, int days,
			Function daysF, int stosum, Function stosumF) {
		this();
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.days = days;
		this.daysF = daysF;
		this.stosum = stosum;
		this.stosumF = stosumF;
	}

	public MultFactVO(FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF,
			FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF,
			String attribute, Function attributeF, int days, Function daysF,
			int stosum, Function stosumF) {
		super();
		this.resultUpI = resultUpI;
		this.resultUpIF = resultUpIF;
		this.resultDownI = resultDownI;
		this.resultDownIF = resultDownIF;
		this.resultUpO = resultUpO;
		this.resultUpOF = resultUpOF;
		this.resultDownO = resultDownO;
		this.resultDownOF = resultDownOF;
		this.attribute = attribute;
		this.attributeF = attributeF;
		this.days = days;
		this.daysF = daysF;
		this.stosum = stosum;
		this.stosumF = stosumF;
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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Function getDaysF() {
		return daysF;
	}

	public void setDaysF(Function daysF) {
		this.daysF = daysF;
	}

	public int getStosum() {
		return stosum;
	}

	public void setStosum(int stosum) {
		this.stosum = stosum;
	}

	public Function getStosumF() {
		return stosumF;
	}

	public void setStosumF(Function stosumF) {
		this.stosumF = stosumF;
	}

	@Override
	public String toString() {
		return "MultFacVO [attribute=" + attribute + ", attributeF="
				+ attributeF + ", days=" + days + ", daysF=" + daysF
				+ ", stosum=" + stosum + ", stosumF=" + stosumF + "]";
	}
}
