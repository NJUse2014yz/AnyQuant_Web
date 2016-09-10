package function.choose;

import java.sql.Date;
import java.util.ArrayList;

import ServiceTool.MultFacHelper;
import function.Function;
import function.FunctionResult;
import function.ResultType;
import po.MultFactData;
import tool.ListTool;
//TODO 还没加Function
//就一些要求的参数做30，60，300天的回测
//使用 平均换手率，平均成交量，平均涨跌幅，最新的成交量变异率（20），最旧的动向指标
public class MultFactFunction extends Function {
	public String attribute;
	public Function attributeF;
	public int days;
	public Function daysF;
	public int stosum;
	public Function stosumF;

	public MultFactFunction() {
		this.function = "MultFact";
		
		this.attribute = null;
		this.days = 30;
		this.stosum = 10;
		this.attributeF=null;
		this.daysF=null;
		this.stosumF=null;
		
		this.resultDownI=null;
		this.resultDownIF=null;
		this.resultDownO=null;
		this.resultDownOF=null;
		this.resultUpI=null;
		this.resultUpIF=null;
		this.resultUpO=null;
		this.resultUpOF=null;
	}

	public MultFactFunction(String attribute, int days, int stosum) {
		this();
		this.attribute = attribute;
		this.days = days;
		this.stosum = stosum;
	}

	public MultFactFunction(MultFactVO vo) {
		this.function = "MultFact";
		this.attribute = vo.attribute;
		this.days = vo.days;
		this.stosum = vo.stosum;
		this.attributeF=vo.attributeF;
		this.daysF=vo.daysF;
		this.stosumF=vo.stosumF;
	}

//	public static ArrayList<MultFactData> getAllResult() throws Exception{
//		ArrayList<MultFactData> result=new ArrayList<MultFactData>();
//		int[] days={30,60,300};
//		int[] sum={10,15,50};
//		String[] attribute={"turnover","amount","vr","dmh","dml","tr"};
//		
//		for(int i=0;i<attribute.length;i++){
//			for(int k=0;k<days.length;k++){
//				for(int m=0;m<sum.length;m++){
//					MultFactData temp=MultFacHelper.getAttriTop(attribute[i], days[k], sum[m]);
//					if(temp.sumsto!=0){
//						result.add(temp);
//					}
//				}
//			}
//		}
////		System.out.println(result.size());
//		return result;
//	}

	@Override
	public FunctionResult getResult(Date date){
		FunctionResult result = new FunctionResult();
		result.location.add(ResultType.STRINGLIST.getCode());
		result.rLS=new ListTool().getStockGroup(attribute, days, stosum);
		return result;

	}
	
	
//	public static void main(String[] args) throws Exception {
//		MultFacFunction.getAllResult();
//	}

}
