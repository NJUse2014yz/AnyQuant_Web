package function.risk;

import java.sql.Date;

import tool.ListTool;
import function.Function;
import function.FunctionResult;
import function.ResultType;

/**某指标至某标准值的某百分比*/
public class StandardPercentFunction extends Function{
	/**大于为正，小于为负，等于为0*/
	public int sign;
//	public String siid;
	/**目标属性*/
	public String attribute;
	/**标准属性*/
	public String standard;
	public double percent;
	
	public StandardPercentFunction(StandardPercentVO vo)
	{
		this.function="StandardPercent";
		this.sign=vo.sign;
		this.siid=vo.siid;
		this.attribute=vo.attribute;
		this.standard=vo.standard;
		this.percent=vo.percent;
	}
	
	@Override
	public FunctionResult getResult(Date date) {
		double targetValue=new ListTool().getNew(siid, attribute);
		double standardValue=new ListTool().getNew(siid, standard);
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.BOOLEAN);
		
		if(sign>0&&targetValue>standardValue*percent
				||sign<0&&targetValue<standardValue*percent
				||sign==0&&targetValue==standardValue*percent)
		{
			result.rB=true;
		}
		return result;
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
		return "StandardPercentFunction [sign=" + sign + ", siid=" + siid
				+ ", attribute=" + attribute + ", standard=" + standard
				+ ", percent=" + percent + "]";
	}
}
