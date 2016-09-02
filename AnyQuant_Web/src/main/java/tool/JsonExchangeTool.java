package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.set.SynchronizedSortedSet;

import backtest.DateDouble;
import backtest.TestReport;
import vo.Flag;
import vo.RealTestVO;
import function.Function;
import function.FunctionResult;
import function.choose.AreaFunction;
import function.choose.AreaVO;
import function.choose.AttributeFunction;
import function.choose.AttributeVO;
import function.choose.ChooseStock;
import function.choose.ConceptFunction;
import function.choose.ConceptVO;
import function.choose.IndustryFunction;
import function.choose.IndustryVO;
import function.choose.IntersectionFunction;
import function.choose.IntersectionVO;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.CrossFunction;
import function.flag.CrossPointFunction;
import function.flag.CrossVO;
import function.flag.DataFunction;
import function.flag.DataVO;
import function.flag.DownTrendFunction;
import function.flag.MaxMinFunction;
import function.flag.MaxMinVO;
import function.flag.TrendFunction;
import function.flag.TrendVO;
import function.flag.UpTrendFunction;
import function.order.ShareFunction;
import function.order.SharePercentFunction;
import function.order.ShareTargetFunction;
import function.order.ValueFunction;
import function.order.ValuePercentFunction;
import function.order.ValueTargetFunction;
import function.risk.StandardPercentFunction;
import function.risk.StandardPercentVO;
import function.tool.AddFunction;
import function.tool.DivideFunction;
import function.tool.MeanFunction;
import function.tool.MinusFunction;
import function.tool.MultipleFunction;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

public class JsonExchangeTool {
	/**得到股票池*/
	public static List<ChooseStock> getStock(String json)
	{
		List<ChooseStock> list=null;
		JSONArray jArray=null;
		JSONObject jObject=null;
		try{
			jArray=JSONArray.fromObject(json);
		}catch(Exception e1)
		{
			System.err.println("JsonExchangeTool==>e1:json exception");
			return null;
		}
		if(jArray!=null)
		{
			list=new ArrayList<ChooseStock>();
			for(int i=0;i<jArray.size();i++)
			{
				jObject=jArray.getJSONObject(i);
				String siid=jObject.getString("siid");
				Double percent=jObject.getDouble("percent");
				list.add(new ChooseStock(siid,percent));
			}
		}
		else
		{
			System.err.println("JsonExchangeTool==>e2:jArray is null");
		}
		return list;//如果没有则返回null,不是空列表
	}
	
	/**得到收藏的股票列表*/
	public static List<String> getSaveStocks(String json)
	{
		List<String> list=null;
		JSONArray jArray=null;
		try
		{
			jArray=JSONArray.fromObject(json);
		} catch(Exception e3)
		{
			System.err.println("JsonExchangeTool==>e3:json exception");
			return null;
		}
		if(jArray!=null)
		{
			list=new ArrayList<String>();
			for(int i=0;i<jArray.size();i++)
			{
				list.add(jArray.getString(i));
			}
		}
		else
		{
			System.err.println("JsonExchangeTool==>e4:jArray is null");
		}	
		return list;//如果没有则返回null,不是空列表
	}
	
	/**得到交易信号列表*/
	public static List<Flag> getFlag(String json)
	{
		List<Flag> flags=null;
		JSONArray jArray=null;
		try
		{
			jArray=JSONArray.fromObject(json);
		} catch(Exception e5)
		{
			System.err.println("JsonExchangeTool==>e5:json exception");
			return null;
		}
		if(jArray!=null)
		{
			flags=new ArrayList<Flag>();
			for(int i=0;i<jArray.size();i++)
			{
				JSONObject jObject=(JSONObject) jArray.get(i);
				flags.add(new Flag(getOrder(jObject.get("orderType").toString()),getFunctionList(jObject.get("flagList").toString())));
			}
		}
		else
		{
			System.err.println("JsonExchangeTool==>e6:jArray is null");
		}
		return flags;//如果没有则返回null,不是空列表
	}
	
	/**得到方法结果*/
	public static FunctionResult getResult(JSONObject json)
	{
		FunctionResult result=new FunctionResult();
		JSONObject jObject=json;
		if(!jObject.toString().equals("null"))
		{
			try{
				result.location=jObject.getJSONArray("location");//location肯定不是null所以不会报错，至少是一个空列表
			}catch(Exception e7)
			{
				System.err.println("JsonExchangeTool==>e7:json exception");
			}
			if(result.location.size()==0)
			{
				System.err.println("JsonExchangeTool==>e8:result.location is blank,result should be null");
				return null;//如果location为空列表，返回null
			}
			result.rB=jObject.getBoolean("rB");
			result.rI=jObject.getInt("rI");
			result.rD=jObject.getDouble("rD");
			result.rS=jObject.getString("rS");
			result.rL=jObject.getLong("rL");
			try{
				result.rLI=jObject.getJSONArray("rLI");
			} catch(Exception e9)
			{
				System.err.println("JsonExchangeTool==>e9:rLI is null");
			}
			try{
				result.rLD=jObject.getJSONArray("rLD");
			} catch(Exception e10)
			{
				System.err.println("JsonExchangeTool==>e10:rLD is null");
			}
			try{
				result.rLS=jObject.getJSONArray("rLS");
			} catch(Exception e11)
			{
				System.err.println("JsonExchangeTool==>e11:rLS is null");
			}
			try{
				result.rLL=jObject.getJSONArray("rLL");
			} catch(Exception e12)
			{
				System.err.println("JsonExchangeTool==>e12:rLL is null");
			}
			return result;
		}
		else
		{
			System.err.println("JsonExchangeTool==>e13:jObject is null");
			return null;//json对象为空返回null
		}
	}
	
	/**得到方法*/
	public static Function getFunction(JSONObject json)
	{
		JSONObject jObject=json;
		if(!jObject.toString().equals("null")){
			String function=jObject.getString("function");
			String siid=null;
			JSONObject siidFJ=null;
			JSONObject resultUpIJ=null;
			JSONObject resultUpIFJ=null;
			JSONObject resultDownIJ=null;
			JSONObject resultDownIFJ=null;
			JSONObject resultUpOJ=null;
			JSONObject resultUpOFJ=null;
			JSONObject resultDownOJ=null;
			JSONObject resultDownOFJ=null;
			
			Function siidF=null;
			FunctionResult resultUpI=null;
			Function resultUpIF=null;
			FunctionResult resultDownI=null;
			Function resultDownIF=null;
			FunctionResult resultUpO=null;
			Function resultUpOF=null;
			FunctionResult resultDownO=null;
			Function resultDownOF=null;
			
			resultUpOJ=jObject.getJSONObject("resultUpO");
			resultUpO=getResult(resultUpOJ);
			resultDownOJ=jObject.getJSONObject("resultDownO");
			resultDownO=getResult(resultDownOJ);
			resultUpIJ=jObject.getJSONObject("resultUpI");
			resultUpI=getResult(resultUpIJ);
			resultDownIJ=jObject.getJSONObject("resultDownI");
			resultDownI=getResult(resultDownIJ);
			resultUpOFJ=jObject.getJSONObject("resultUpOF");
			resultUpOF=getFunction(resultUpOFJ);
			resultDownOFJ=jObject.getJSONObject("resultDownOF");
			resultDownOF=getFunction(resultDownOFJ);
			resultUpIFJ=jObject.getJSONObject("resultUpIF");
			resultUpIF=getFunction(resultUpIFJ);
			resultDownIFJ=jObject.getJSONObject("resultDownIF");
			resultDownIF=getFunction(resultDownIFJ);
			
			String attribute=null;
			String siid1=null;
			String siid2=null;
			String attribute1=null;
			String attribute2=null;
			int num=0;
			int day=0;
			String area=null;
			String concept=null;
			String industry=null;
			double up=0;
			double down=0;
			List<String> stockList1=null;
			List<String> stockList2=null;
			int sign=0;
			String standardAttr=null;
			double percent=0;
			double standard=0;
			double v1=0;
			double v2=0;
			List<Double> valueList=null;
			int mm=0;
			int loc=0;
			
			Function attributeF=null;
			Function siid1F=null;
			Function siid2F=null;
			Function attribute1F=null;
			Function attribute2F=null;
			Function numF=null;
			Function dayF=null;
			Function areaF=null;
			Function conceptF=null;
			Function industryF=null;
			Function upF=null;
			Function downF=null;
			Function stockList1F=null;
			Function stockList2F=null;
			Function signF=null;
			Function standardF=null;
			Function percentF=null;
			Function v1F=null;
			Function v2F=null;
			Function valueListF=null;
			Function mmF=null;
			Function locF=null;
			
			JSONObject attributeFJ=null;
			JSONObject siid1FJ=null;
			JSONObject siid2FJ=null;
			JSONObject attribute1FJ=null;
			JSONObject attribute2FJ=null;
			JSONObject numFJ=null;
			JSONObject dayFJ=null;
			JSONObject areaFJ=null;
			JSONObject conceptFJ=null;
			JSONObject industryFJ=null;
			JSONObject upFJ=null;
			JSONObject downFJ=null;
			JSONObject stockList1FJ=null;
			JSONObject stockList2FJ=null;
			JSONObject signFJ=null;
			JSONObject standardFJ=null;
			JSONObject percentFJ=null;
			JSONObject v1FJ=null;
			JSONObject v2FJ=null;
			JSONObject valueListFJ=null;
			JSONObject mmFJ=null;
			JSONObject locFJ=null;
			
			switch(function)
			{
			//choose
			case "Pair":
				siid = (String)jObject.get("siid");
				siidFJ = jObject.getJSONObject("siidF");
				siidF = getFunction(siidFJ);
				num = jObject.getInt("num");
				numFJ = jObject.getJSONObject("numF");
				numF =getFunction(numFJ);
				return new PairFunction(new PairVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, siid, siidF, num, numF));
			case "Area":
				area=(String)jObject.get("area");
				areaFJ=jObject.getJSONObject("areaF");
				areaF=getFunction(areaFJ);
				return new AreaFunction(new AreaVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, area, areaF));
			case "Concept":
				concept=(String)jObject.get("concept");
				conceptFJ=jObject.getJSONObject("conceptF");
				conceptF=getFunction(conceptFJ);
				return new ConceptFunction(new ConceptVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, concept, conceptF));
			case "Industry":
				industry=(String)jObject.get("industry");
				industryFJ=jObject.getJSONObject("industryFJ");
				industryF=getFunction(industryFJ);
				return new IndustryFunction(new IndustryVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, industry, industryF));
			case "Intersection":
				try{
					stockList1 = jObject.getJSONArray("stockList1");
				} catch(Exception e14)
				{
					System.err.println("JsonExchangeTool==>e14 stockList1 is null");
				}
				stockList1FJ = jObject.getJSONObject("stockList1F");
				stockList1F = getFunction(stockList1FJ);
				try{
					stockList2 = jObject.getJSONArray("stockList2");
				} catch(Exception e15)
				{
					System.err.println("JsonExchangeTool==>e15 stockList2 is null");
				}
				stockList2FJ = jObject.getJSONObject("stockList2F");
				stockList2F = getFunction(stockList2FJ);
				return new IntersectionFunction(new IntersectionVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, stockList1, stockList1F, stockList2, stockList2F));
			case "Attribute":
				try{
					up = jObject.getDouble("up");
				} catch(Exception e16)
				{
					System.err.println("JsonExchangeTool==>e16 json exception");
				}
				upFJ = jObject.getJSONObject("upF");
				upF = getFunction(upFJ);
				try{
					down = jObject.getDouble("down");
				} catch(Exception e17)
				{
					System.err.println("JsonExchangeTool==>e17 json exception");
				}
				downFJ = jObject.getJSONObject("downF");
				downF = getFunction(upFJ);
				attribute = (String)jObject.get("attribute");
				attributeFJ = jObject.getJSONObject("attributeF");
				attributeF = getFunction(attributeFJ);
				return new AttributeFunction(new AttributeVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, up, upF, down, downF, attribute2, attributeF));
				
			//risk	
			case "StandardPercent":
				try{
					sign=jObject.getInt("sign");
				} catch(Exception e18)
				{
					System.err.println("JsonExchangeTool==>e18 json exception");
				}
				signFJ=jObject.getJSONObject("signF");
				signF=getFunction(signFJ);
				siid=(String)jObject.get("siid");
				siidFJ=jObject.getJSONObject("siidF");
				siidF=getFunction(siidFJ);
				attribute=(String)jObject.get("attribute");
				attributeFJ=jObject.getJSONObject("attributeF");
				attributeF=getFunction(attributeFJ);
				standardAttr=(String)jObject.get("standard");
				standardFJ=jObject.getJSONObject("standardF");
				standardF=getFunction(standardFJ);
				try{
					percent=jObject.getDouble("percent");
				} catch(Exception e19)
				{
					System.err.println("JsonExchangeTool==>e19 json exception");
				}
				percentFJ=jObject.getJSONObject("percentF");
				percentF=getFunction(percentFJ);
				return new StandardPercentFunction(new StandardPercentVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, sign, signF, siid, siidF, attribute, attributeF, standardAttr, standardF, percent, percentF));
				
			//flag	
			case "Trend":
				siid = (String) jObject.get("siid");
				siidFJ = jObject.getJSONObject("siidF");
				siidF = getFunction(siidFJ);
				attribute = (String) jObject.get("attribute");
				attributeFJ = jObject.getJSONObject("attributeF");
				attributeF = getFunction(attributeFJ);
				try{
					day = jObject.getInt("day");
				} catch(Exception e20)
				{
					System.err.println("JsonExchangeTool==>e20 json exception");
				}
				dayFJ = jObject.getJSONObject("dayF");
				dayF = getFunction(dayFJ);
				try{
					standard = jObject.getDouble("standard");
				} catch(Exception e21)
				{
					System.err.println("JsonExchangeTool==>e21 json exception");
				}
				standardFJ = jObject.getJSONObject("standardF");
				standardF = getFunction(standardFJ);
				return new TrendFunction(new TrendVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, siid, siidF, attribute, attributeF, day, dayF, standard, standardF));
			case "UpTrend":
				siid = (String) jObject.get("siid");
				siidFJ = jObject.getJSONObject("siidF");
				siidF = getFunction(siidFJ);
				attribute = (String) jObject.get("attribute");
				attributeFJ = jObject.getJSONObject("attributeF");
				attributeF = getFunction(attributeFJ);
				try{
					day = jObject.getInt("day");
				} catch(Exception e22)
				{
					System.err.println("JsonExchangeTool==>e22 json exception");
				}
				dayFJ = jObject.getJSONObject("dayF");
				dayF = getFunction(dayFJ);
				try{
					standard = jObject.getDouble("standard");
				} catch(Exception e23)
				{
					System.err.println("JsonExchangeTool==>e23 json exception");
				}
				standardFJ = jObject.getJSONObject("standardF");
				standardF = getFunction(standardFJ);
				return new UpTrendFunction(new TrendVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, siid, siidF, attribute, attributeF, day, dayF, standard, standardF));
			case "DownTrend":
				siid = (String) jObject.get("siid");
				siidFJ = jObject.getJSONObject("siidF");
				siidF = getFunction(siidFJ);
				attribute = (String) jObject.get("attribute");
				attributeFJ = jObject.getJSONObject("attributeF");
				attributeF = getFunction(attributeFJ);
				try{
					day = jObject.getInt("day");
				} catch(Exception e24)
				{
					System.err.println("JsonExchangeTool==>e24 json exception");
				}
				dayFJ = jObject.getJSONObject("dayF");
				dayF = getFunction(dayFJ);
				try{
					standard = jObject.getDouble("standard");
				} catch(Exception e25)
				{
					System.err.println("JsonExchangeTool==>e25 json exception");
				}
				standardFJ = jObject.getJSONObject("standardF");
				standardF = getFunction(standardFJ);
				return new DownTrendFunction(new TrendVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, siid, siidF, attribute, attributeF, day, dayF, standard, standardF));
			case "Cross":
				siid1 = (String) jObject.get("siid1");
				siid1FJ = jObject.getJSONObject("siid1F");
				siid1F = getFunction(siid1FJ);
				siid2 = (String) jObject.get("siid2");
				siid2FJ = jObject.getJSONObject("siid2F");
				siid2F = getFunction(siid2FJ);
				attribute1 = (String) jObject.get("attribute1");
				attribute1FJ = jObject.getJSONObject("attribute1F");
				attribute1F = getFunction(attribute1FJ);
				attribute2 = (String) jObject.get("attribute2");
				attribute2FJ = jObject.getJSONObject("attribute2F");
				attribute2F = getFunction(attribute2FJ);
				try{
					day = jObject.getInt("day");
				} catch(Exception e26)
				{
					System.err.println("JsonExchangeTool==>e26 json exception");
				}
				dayFJ = jObject.getJSONObject("dayF");
				dayF = getFunction(dayFJ);
				return new CrossFunction(new CrossVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, siid1, siid1F, attribute1, attribute1F, siid2, siid2F, attribute2, attribute2F, day, dayF));
			case "CrossPoint":
				siid1 = (String) jObject.get("siid1");
				siid1FJ = jObject.getJSONObject("siid1F");
				siid1F = getFunction(siid1FJ);
				siid2 = (String) jObject.get("siid2");
				siid2FJ = jObject.getJSONObject("siid2F");
				siid2F = getFunction(siid2FJ);
				attribute1 = (String) jObject.get("attribute1");
				attribute1FJ = jObject.getJSONObject("attribute1F");
				attribute1F = getFunction(attribute1FJ);
				attribute2 = (String) jObject.get("attribute2");
				attribute2FJ = jObject.getJSONObject("attribute2F");
				attribute2F = getFunction(attribute2FJ);
				try{
					day = jObject.getInt("day");
				} catch(Exception e27)
				{
					System.err.println("JsonExchangeTool==>e27 json exception");
				}
				dayFJ = jObject.getJSONObject("dayF");
				dayF = getFunction(dayFJ);
				return new CrossPointFunction(new CrossVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, siid1, siid1F, attribute1, attribute1F, siid2, siid2F, attribute2, attribute2F, day, dayF));
			case "MaxMin":
				siid=(String)jObject.get("siid");	
				siidFJ=jObject.getJSONObject("siidF");
				siidF=getFunction(siidFJ);
				attribute=jObject.getString("attribute");
				attributeFJ=jObject.getJSONObject("attributeF");
				attributeF=getFunction(attributeFJ);
				try{
					mm=jObject.getInt("mm");
				} catch(Exception e27)
				{
					System.err.println("JsonExchangeTool==>e27 json exception");
				}
				mmFJ=jObject.getJSONObject("mmF");
				mmF=getFunction(mmFJ);
				try{
					num=jObject.getInt("num");
				} catch(Exception e28)
				{
					System.err.println("JsonExchangeTool==>e28 json exception");
				}
				numFJ=jObject.getJSONObject("numF");
				numF=getFunction(numFJ);
				try{
					loc=jObject.getInt("loc");
				} catch(Exception e29)
				{
					System.err.println("JsonExchangeTool==>e29 json exception");
				}
				locFJ=jObject.getJSONObject("locF");
				locF=getFunction(locFJ);
				return new MaxMinFunction(new MaxMinVO(siid, siidF, resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, attribute, attributeF, mm, mmF, num, numF, loc, locF));
			case "Data":
				siid=(String)jObject.get("siid");
				siidFJ=jObject.getJSONObject("siidF");
				siidF=getFunction(siidFJ);
				attribute=(String)jObject.get("attribute");
				attributeFJ=jObject.getJSONObject("attributeF");
				attributeF=getFunction(attributeFJ);
				try{
					day=jObject.getInt("day");
				} catch(Exception e30)
				{
					System.err.println("JsonExchangeTool==>e30 json exception");
				}
				dayFJ=jObject.getJSONObject("dayF");
				dayF=getFunction(dayFJ);
				return new DataFunction(new DataVO(resultUpI, resultUpIF, resultDownI, resultDownIF, resultUpO, resultUpOF, resultDownO, resultDownOF, siid, siidF, attribute, attributeF, day, dayF));

			//tool
			case "Add":
				try{
					v1=jObject.getDouble("v1");
				} catch(Exception e31)
				{
					System.err.println("JsonExchangeTool==>e31 json exception");
				}
				v1FJ=jObject.getJSONObject("v1F");
				v1F=getFunction(v1FJ);
				try{
					v2=jObject.getDouble("v2");
				} catch(Exception e32)
				{
					System.err.println("JsonExchangeTool==>e32 json exception");
				}
				v2FJ=jObject.getJSONObject("v2F");
				v2F=getFunction(v2FJ);
				return new AddFunction(v1, v1F, v2, v2F);
			case "Minus":
				try{
					v1=jObject.getDouble("v1");
				} catch(Exception e33)
				{
					System.err.println("JsonExchangeTool==>e33 json exception");
				}
				v1FJ=jObject.getJSONObject("v1F");
				v1F=getFunction(v1FJ);
				try{
					v2=jObject.getDouble("v2");
				} catch(Exception e34)
				{
					System.err.println("JsonExchangeTool==>e34 json exception");
				}
				v2FJ=jObject.getJSONObject("v2F");
				v2F=getFunction(v2FJ);
				return new MinusFunction(v1, v1F, v2, v2F);
			case "Multiple":
				try{
					v1=jObject.getDouble("v1");
				} catch(Exception e35)
				{
					System.err.println("JsonExchangeTool==>e35 json exception");
				}
				v1FJ=jObject.getJSONObject("v1F");
				v1F=getFunction(v1FJ);
				try{
					v2=jObject.getDouble("v2");
				} catch(Exception e36)
				{
					System.err.println("JsonExchangeTool==>e36 json exception");
				}
				v2FJ=jObject.getJSONObject("v2F");
				v2F=getFunction(v2FJ);
				return new MultipleFunction(v1, v1F, v2, v2F);
			case "Divide":
				try{
					v1=jObject.getDouble("v1");
				} catch(Exception e37)
				{
					System.err.println("JsonExchangeTool==>e37 json exception");
				}
				v1FJ=jObject.getJSONObject("v1F");
				v1F=getFunction(v1FJ);
				try{
					v2=jObject.getDouble("v2");
				} catch(Exception e38)
				{
					System.err.println("JsonExchangeTool==>e38 json exception");
				}
				v2FJ=jObject.getJSONObject("v2F");
				v2F=getFunction(v2FJ);
				return new DivideFunction(v1, v1F, v2, v2F);
			case "Mean":
				try{
					valueList=jObject.getJSONArray("valueList");
				} catch(Exception e39)
				{
					System.err.println("JsonExchangeTool==>e39 valueList is null");
				}
				valueListFJ=jObject.getJSONObject("valueListF");
				valueListF=getFunction(valueListFJ);
				return new MeanFunction(valueList, valueListF);
			default:
				return null;
			}
		}
		else
		{
			System.err.println("JsonExchangeTool==>e40:jObject is null");
			return null;
		}
	}
	
	/**得到方法列表*/
	public static List<List<Function>> getFunctionList(String json)
	{
		List<List<Function>> list=null;
		JSONArray jArrayOut=null;
		try{
			jArrayOut=JSONArray.fromObject(json);
		} catch(Exception e41)
		{
			System.err.println("JsonExchangeTool==>e41 jArrayOut is null");
			return null;
		}
		if(jArrayOut==null||jArrayOut.toString().equals("null")||jArrayOut.get(0).toString().equals("null"))
		{
			System.err.println("JsonExchangeTool==>e42 jArrayIn is null");
			return null;
		}
		list=new ArrayList<List<Function>>();
		for(int j=0;j<jArrayOut.size();j++)
		{
			list.add(new ArrayList<Function>());
			JSONArray jArrayIn=null;
			try{
				jArrayIn=jArrayOut.getJSONArray(j);
			}catch(Exception e43)
			{
				System.err.println("JsonExchangeTool==>e43 jArrayIn is null");
			}
			if(jArrayIn==null||jArrayIn.toString().equals("null"))
			{
				continue;
			}
			else
			{
				for(int i=0;i<jArrayIn.size();i++)
				{
					Function f=getFunction(jArrayIn.getJSONObject(i));
					if(f!=null)
					{
						list.get(j).add(f);
					}
				}
			}
		}
		return list;
	}
	
	/**得到订单*/
	public static Function getOrder(String json)
	{
		JSONObject jObject=JSONObject.fromObject(json);
		if(jObject.toString().equals("null"))
		{
			System.err.println("JsonExchangeTool==>e43.5 jObject is null");
			return null;
		}
		String function=(String)jObject.get("function");
		switch(function)
		{
		case "Share":
			ShareFunction share=new ShareFunction();
			share.setFunction(function);
			try{
				share.setShare(jObject.getDouble("share"));
			} catch(Exception e44)
			{
				System.err.println("JsonExchangeTool==>e44 json exception");
			}
			share.setShareF(getFunction(jObject.getJSONObject("shareF")));
			share.setSiid((String)jObject.get("siid"));
			share.setSiidF(getFunction(jObject.getJSONObject("siidF")));
			return share;
		case "SharePercent":
			SharePercentFunction sharePercent=new SharePercentFunction();
			sharePercent.setFunction(function);
			try{
				sharePercent.setPercent(jObject.getDouble("percent"));
			} catch(Exception e45)
			{
				System.err.println("JsonExchangeTool==>e45 json exception");
			}
			sharePercent.setPercentF(getFunction(jObject.getJSONObject("percentF")));
			sharePercent.setSiid((String)jObject.get("siid"));
			sharePercent.setSiidF(getFunction(jObject.getJSONObject("siidF")));
			return sharePercent;
		case "ShareTarget":
			ShareTargetFunction shareTarget=new ShareTargetFunction();
			shareTarget.setFunction(function);
			try{
				shareTarget.setShare(jObject.getDouble("share"));
			} catch(Exception e46)
			{
				System.err.println("JsonExchangeTool==>e46 json exception");
			}
			shareTarget.setShareF(getFunction(jObject.getJSONObject("shareF")));
			shareTarget.setSiid((String)jObject.get("siid"));
			shareTarget.setSiidF(getFunction(jObject.getJSONObject("siidF")));
			return shareTarget;
		case "Value":
			ValueFunction value=new ValueFunction();
			value.setFunction(function);
			try{
				value.setValue(jObject.getDouble("value"));
			} catch(Exception e47)
			{
				System.err.println("JsonExchangeTool==>e47 json exception");
			}
			value.setValueF(getFunction(jObject.getJSONObject("valueF")));
			value.setSiid((String)jObject.get("siid"));
			value.setSiidF(getFunction(jObject.getJSONObject("siidF")));
			return value;
		case "ValuePercent":
			ValuePercentFunction valuePercent=new ValuePercentFunction();
			valuePercent.setFunction(function);
			try{
				valuePercent.setPercent(jObject.getDouble("percent"));
			} catch(Exception e48)
			{
				System.err.println("JsonExchangeTool==>e48 json exception");
			}
			valuePercent.setPercentF(getFunction(jObject.getJSONObject("percentF")));
			valuePercent.setSiid(jObject.getString("siid"));
			valuePercent.setSiidF(getFunction(jObject.getJSONObject("siidF")));
			return valuePercent;
		case "ValueTarget":
			ValueTargetFunction valueTarget=new ValueTargetFunction();
			valueTarget.setFunction(function);
			try{
				valueTarget.setValue(jObject.getDouble("value"));
			} catch(Exception e49)
			{
				System.err.println("JsonExchangeTool==>e49 json exception");
			}	
			valueTarget.setValueF(getFunction(jObject.getJSONObject("valueF")));
			valueTarget.setSiid((String)jObject.get("siid"));
			valueTarget.setSiidF(getFunction(jObject.getJSONObject("siidF")));
			return valueTarget;
		}
		return null;
	}
	
	/**得到实测数据*/
	public static RealTestVO getRealTest(String json)
	{
		RealTestVO vo=new RealTestVO();
		JSONObject jObject=JSONObject.fromObject(json);
		if(jObject.toString().equals("null"))
		{
			System.err.println("JsonExchangeTool==>e50 jObject is null");
			return null;
		}
		try{
			vo.setCash(jObject.getDouble("cash"));
		} catch(Exception e51)
		{
			System.err.println("JsonExchangeTool==>e51 json exception");
		}
		try{
			vo.setN(jObject.getInt("n"));
		} catch(Exception e52)
		{
			System.err.println("JsonExchangeTool==>e52 json exception");
		}
			List<DateDouble> capital=new ArrayList<DateDouble>();
			JSONArray jCapital=(JSONArray)jObject.get("capital");
			if(jCapital!=null)
			{
				for(int i=0;i<jCapital.size();i++)
				{
					JSONObject jDateDouble=(JSONObject) jCapital.get(i);
					try{
						capital.add(new DateDouble(jDateDouble.getLong("date"),jDateDouble.getDouble("value")));
					} catch(Exception e53)
					{
						System.err.println("JsonExchangeTool==>e53 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e54 jCapital is null");
			}
			vo.setCapital(capital);//有问题则返回空列表
			List<Integer> numList=new ArrayList<Integer>();
			JSONArray jNum=(JSONArray) jObject.get("numList");
			if(jNum!=null)
			{
				for(int i=0;i<jNum.size();i++)
				{
					try{
						numList.add(jNum.getInt(i));
					} catch(Exception e55)
					{
						System.err.println("JsonExchangeTool==>e55 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e56 jNum is null");
			}
			vo.setNumList(numList);//有问题则返回空列表
			JSONArray jHistory=(JSONArray) jObject.get("history");
			List<String> history=new ArrayList<String>();
			if(jHistory!=null)
			{
				for(int i=0;i<jHistory.size();i++)
				{
					try{
						history.add(jHistory.getString(i));
					} catch(Exception e57)
					{
						System.err.println("JsonExchangeTool==>e57 json exception");
					}	
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e58 jNum is null");
			}
			vo.setHistory(history);//有问题则返回空列表
		return vo;
	}
	
	/**得到回测报告*/
	public static TestReport getReport(String report) {
		JSONObject jObject=JSONObject.fromObject(report);
		if(!jObject.toString().equals("null"))
		{
			int n=0;
			double risklessReturns=0;
			double annualizedReturns=0;
			double benchmarkReturns=0;
			double alpha=0;
			double beta=0;
			double sharpeRatio=0;
			double volatility=0;
			double informationRatio=0;
			double maxDrawdown=0;
			double turnoverRate=0;
			try{
				n=jObject.getInt("n");
			} catch(Exception e59)
			{
				System.err.println("JsonExchangeTool==>e59 json exception");
			}
			try{
				risklessReturns=jObject.getDouble("risklessReturns");
			} catch(Exception e60)
			{
				System.err.println("JsonExchangeTool==>e60 json exception");
			}
			try{
				annualizedReturns=jObject.getDouble("annualizedReturns");
			} catch(Exception e61)
			{
				System.err.println("JsonExchangeTool==>e61 json exception");
			}
			try{
				benchmarkReturns=jObject.getDouble("benchmarkReturns");
			} catch(Exception e62)
			{
				System.err.println("JsonExchangeTool==>e62 json exception");
			}
			try{
				alpha=jObject.getDouble("alpha");
			} catch(Exception e63)
			{
				System.err.println("JsonExchangeTool==>e63 json exception");
			}
			try{
				beta=jObject.getDouble("beta");
			} catch(Exception e64)
			{
				System.err.println("JsonExchangeTool==>e64 json exception");
			}
			try{
				sharpeRatio=jObject.getDouble("sharpeRatio");
			} catch(Exception e65)
			{
				System.err.println("JsonExchangeTool==>e65 json exception");
			}
			try{
				volatility=jObject.getDouble("volatility");
			} catch(Exception e66)
			{
				System.err.println("JsonExchangeTool==>e66 json exception");
			}
			try{
				informationRatio=jObject.getDouble("informationRatio");
			} catch(Exception e67)
			{
				System.err.println("JsonExchangeTool==>e67 json exception");
			}
			try{
				maxDrawdown=jObject.getDouble("maxDrawdown");
			} catch(Exception e68)
			{
				System.err.println("JsonExchangeTool==>e68 json exception");
			}
			try{
				turnoverRate=jObject.getDouble("turnoverRate");
			} catch(Exception e69)
			{
				System.err.println("JsonExchangeTool==>e69 json exception");
			}
			
			List<DateDouble> cumlist=new ArrayList<DateDouble>();
			List<DateDouble> bCumlist=new ArrayList<DateDouble>();
			List<DateDouble> capital=new ArrayList<DateDouble>();
			List<DateDouble> bCapital=new ArrayList<DateDouble>();
			List<Double> inPrice=new ArrayList<Double>();
			List<Double> outPrice=new ArrayList<Double>();
			
			JSONArray jCumlist=(JSONArray) jObject.get("cumlist");
			JSONArray jBCumlist=(JSONArray) jObject.get("bCumlist");
			JSONArray jCapital=(JSONArray) jObject.get("capital");
			JSONArray jBCapital=(JSONArray) jObject.get("bCapital");
			JSONArray jInPrice=(JSONArray) jObject.get("inPrice");
			JSONArray jOutPrice=(JSONArray) jObject.get("outPrice");
			if(jCumlist!=null)
			{
				for(int i=0;i<jCumlist.size();i++)
				{
					try{
						JSONObject jobject=(JSONObject)jCumlist.get(i);
						cumlist.add(new DateDouble(jobject.getLong("date"),jobject.getDouble("value")));
					} catch(Exception e70)
					{
						System.err.println("JsonExchangeTool==>e70 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e70.5 jCumlist is null");
			}
			if(jBCumlist!=null)
			{
				for(int i=0;i<jBCumlist.size();i++)
				{
					try{
						JSONObject jobject=jBCumlist.getJSONObject(i);
						bCumlist.add(new DateDouble(jobject.getLong("date"),jobject.getDouble("value")));
					} catch(Exception e71)
					{
						System.err.println("JsonExchangeTool==>e71 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e71.5 jBCumlist is null");
			}
			if(jCapital!=null)
			{
				for(int i=0;i<jCapital.size();i++)
				{
					try{
						JSONObject jobject=jCapital.getJSONObject(i);
						capital.add(new DateDouble(jobject.getLong("date"),jobject.getDouble("value")));
					} catch(Exception e72)
					{
						System.err.println("JsonExchangeTool==>e72 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e72.5 jCapital is null");
			}
			if(jBCapital!=null)
			{
				for(int i=0;i<jBCapital.size();i++)
				{
					try{
						JSONObject jobject=jBCapital.getJSONObject(i);
						bCapital.add(new DateDouble(jobject.getLong("date"),jobject.getDouble("value")));
					} catch(Exception e73)
					{
						System.err.println("JsonExchangeTool==>e73 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e73.5 jBCapital is null");
			}
			if(jInPrice!=null)
			{
				for(int i=0;i<jInPrice.size();i++)
				{
					try{
						inPrice.add(jInPrice.getDouble(i));
					} catch(Exception e74)
					{
						System.err.println("JsonExchangeTool==>e74 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e74.5 jInPrice is null");
			}
			if(jOutPrice!=null)
			{
				for(int i=0;i<jOutPrice.size();i++)
				{
					try{	
						outPrice.add(jOutPrice.getDouble(i));
					} catch(Exception e75)
					{
						System.err.println("JsonExchangeTool==>e75 json exception");
					}
				}
			}
			else
			{
				System.err.println("JsonExchangeTool==>e75.5 jOutPrice is null");
			}
			TestReport testReport=new TestReport(n, risklessReturns, capital, bCapital, inPrice, outPrice, annualizedReturns, benchmarkReturns, alpha, beta, sharpeRatio, volatility, informationRatio, maxDrawdown, turnoverRate, cumlist, bCumlist);
			return testReport;
		}
		else
		{
			System.err.println("JsonExchangeTool==>e6 jObject is null");
			return null;	
		}
	}
}
