package function.choose;

import java.sql.Date;
import java.util.List;

import ServiceTool.MultFacHelper;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import po.StockInf;
import tool.ListTool;

//就一些要求的参数做30，60，300天的回测
//使用 平均换手率，平均成交量，平均涨跌幅，最新的成交量变异率（20），最旧的动向指标
public class MultFacFunction extends Function {

	public String attribute;
	public int days;
	public int stosum;;

	public MultFacFunction() {
		this.function = "MultFactor";
	}

	public MultFacFunction(String attribute, int days, int stosum) {
		super();
		this.function = "MultFactor";
		this.attribute = attribute;
		this.days=days;
		this.stosum=stosum;
	}

	public MultFacFunction(MultFacVO vo) {
		this.function = "MultFactor";
		this.attribute = vo.attribute;
		this.days=vo.days;
		this.stosum=vo.stosum;
	}

	@Override
	public FunctionResult getResult(Date date) throws Exception {

		FunctionResult result = new FunctionResult();
		result.location.add(ResultType.STRINGLIST);
		List<StockInf> list = null;
		result.rLS.addAll(MultFacHelper.getAttriTop(attribute, days,stosum));
		return result;

	}

}
