package function.risk;

public class StandardPercentVO {
	/**大于为正，小于为负，等于为0*/
	public int sign;
	public String siid;
	/**目标属性*/
	public String attribute;
	/**标准属性*/
	public String standard;
	public double percent;
	
	public StandardPercentVO(){}
	public StandardPercentVO(int sign,String siid, String attribute, String standard,
			double percent) {
		super();
		this.sign=sign;
		this.siid = siid;
		this.attribute = attribute;
		this.standard = standard;
		this.percent = percent;
	}
	
	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
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
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "StandardPercentVO [sign=" + sign + ", siid=" + siid
				+ ", attribute=" + attribute + ", standard=" + standard
				+ ", percent=" + percent + "]";
	}
}
