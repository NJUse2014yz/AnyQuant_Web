package function.flag;

import function.Function;
import function.FunctionResult;

public class MaxMinVO {
	/**涉及的股票代码*/
	public String siid;
	public Function siidF;
	
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
	
	/**数据属性名*/
	public String attribute;
	public Function attributeF;
	
	/**要求极大值还是极小值*/
	public int mm=0;//极大值为1，极小值为0
	public Function mmF;
	
	/**需要几个值*/
	public int num=0;//几个
	public Function numF;
	
	
	/**需要的是第几个极值*/
	public int loc=0;
	public Function locF;
	
	public MaxMinVO()
	{
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
		this.mm=0;
		this.mmF=null;
		this.num=0;
		this.numF=null;
		this.loc=0;
		this.locF=null;
	}

	public MaxMinVO(String siid, Function siidF, FunctionResult resultUpI, Function resultUpIF,
			FunctionResult resultDownI, Function resultDownIF, FunctionResult resultUpO, Function resultUpOF,
			FunctionResult resultDownO, Function resultDownOF, String attribute, Function attributeF, int mm,
			Function mmF, int num, Function numF, int loc, Function locF) {
		this();
		this.siid = siid;
		this.siidF = siidF;
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
		this.mm = mm;
		this.mmF = mmF;
		this.num = num;
		this.numF = numF;
		this.loc = loc;
		this.locF = locF;
	}

	public String getSiid() {
		return siid;
	}

	public void setSiid(String siid) {
		this.siid = siid;
	}

	public Function getSiidF() {
		return siidF;
	}

	public void setSiidF(Function siidF) {
		this.siidF = siidF;
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

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public Function getMmF() {
		return mmF;
	}

	public void setMmF(Function mmF) {
		this.mmF = mmF;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Function getNumF() {
		return numF;
	}

	public void setNumF(Function numF) {
		this.numF = numF;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public Function getLocF() {
		return locF;
	}

	public void setLocF(Function locF) {
		this.locF = locF;
	}

	@Override
	public String toString() {
		return "MaxMinVO [siid=" + siid + ", siidF=" + siidF + ", resultUpI=" + resultUpI + ", resultUpIF=" + resultUpIF
				+ ", resultDownI=" + resultDownI + ", resultDownIF=" + resultDownIF + ", resultUpO=" + resultUpO
				+ ", resultUpOF=" + resultUpOF + ", resultDownO=" + resultDownO + ", resultDownOF=" + resultDownOF
				+ ", attribute=" + attribute + ", attributeF=" + attributeF + ", mm=" + mm + ", mmF=" + mmF + ", num="
				+ num + ", numF=" + numF + ", loc=" + loc + ", locF=" + locF + "]";
	}

}
