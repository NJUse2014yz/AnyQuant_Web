package tool;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import backtest.DateDouble;
import vo.RealTestVO;
import function.Function;
import function.FunctionResult;
import function.choose.ChooseStock;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.TrendVO;
import function.flag.UpTrendFunction;
import function.order.ShareFunction;
import function.order.SharePercentFunction;
import function.order.ShareTargetFunction;
import function.order.ValueFunction;
import function.order.ValuePercentFunction;
import function.order.ValueTargetFunction;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class JsonExchangeTool {
	public static List<ChooseStock> getStock(String json)
	{
		List<ChooseStock> list=new ArrayList<ChooseStock>();
		JSONArray jArray=null;
		JSONObject jObject=null;
		jArray=JSONArray.fromObject(json);
		for(int i=0;i<jArray.size();i++)
		{
			jObject=(JSONObject) jArray.get(i);
//			System.out.println(jObject);
			String siid=(String)jObject.get("siid");
			Double percent=(Double)jObject.get("percent");
			list.add(new ChooseStock(siid,percent));
		}
		return list;
	}
	public static List<List<Function>> getFunction(String json)
	{
		List<List<Function>> list=new ArrayList<List<Function>>();
		JSONArray jArrayOut=null;
		
		jArrayOut=JSONArray.fromObject(json);
		for(int j=0;j<jArrayOut.size();j++)
		{
			list.add(new ArrayList<Function>());
			JSONArray jArrayIn=null;
			jArrayIn=(JSONArray) jArrayOut.get(j);
			for(int i=0;i<jArrayIn.size();i++)
			{
				JSONObject jObject=(JSONObject) jArrayIn.get(i);
				String siid=null;
				String siid1=null;
				String siid2=null;
				String attribute=null;
				String attribute1=null;
				String attribute2=null;
				int num=0;
				JSONObject upFRJI=null;
				JSONObject downFRJI=null;
				JSONObject upFRJO=null;
				JSONObject downFRJO=null;
				JSONArray upLocationJAI=null;
				JSONArray downLocationJAI=null;
				JSONArray upLocationJAO=null;
				JSONArray downLocationJAO=null;
				List<Integer> upLocationAI=null;
				List<Integer> downLocationAI=null;
				List<Integer> upLocationAO=null;
				List<Integer> downLocationAO=null;
				FunctionResult upFRI=null;
				FunctionResult downFRI=null;
				FunctionResult upFRO=null;
				FunctionResult downFRO=null;
				long start=0;
				long end=0;
				double standard=0;
				String function=(String) jObject.get("function");
				switch(function)
				{
				case "Pair":
					siid=(String)jObject.get("siid");
					num=(int)jObject.get("num");
					list.get(i).add(new PairFunction(new PairVO(siid,num)));
					break;
				case "Trend":
					upFRJI=(JSONObject)jObject.get("resultUpI");
					downFRJI=(JSONObject)jObject.get("resultDownI");
					upFRI=new FunctionResult();
					downFRI=new FunctionResult();
					upFRJO=(JSONObject)jObject.get("resultUpO");
					downFRJO=(JSONObject)jObject.get("resultDownO");
					upFRO=new FunctionResult();
					downFRO=new FunctionResult();
					upLocationJAI=(JSONArray)upFRJI.get("location");
					downLocationJAI=(JSONArray)downFRJI.get("location");
					upLocationJAO=(JSONArray)upFRJO.get("location");
					downLocationJAO=(JSONArray)downFRJO.get("location");
					upLocationAI=new ArrayList<Integer>();
					downLocationAI=new ArrayList<Integer>();
					upLocationAO=new ArrayList<Integer>();
					downLocationAO=new ArrayList<Integer>();
					for(int k=0;k<upLocationAI.size();k++)
					{
						upLocationAI.add((int)upLocationJAI.get(k));	
						downLocationAI.add((int)downLocationJAI.get(k));
						upLocationAO.add((int)upLocationJAO.get(k));	
						downLocationAO.add((int)downLocationJAO.get(k));
					}
					upFRI.setrD((double)upFRJI.get("rD"));
					downFRI.setrD((double)downFRJI.getDouble("rD"));
					upFRO.setrD((double)upFRJO.get("rD"));
					downFRO.setrD((double)downFRJO.getDouble("rD"));
					siid=(String)jObject.get("siid");
					attribute=(String)jObject.get("attribute");
					start=(long)jObject.get("start");
					end=(long)jObject.get("end");
					standard=(double)jObject.get("standard");
					list.get(i).add(new UpTrendFunction(new TrendVO(upFRI,downFRI,upFRO,downFRI,siid,attribute,start,end,standard)));
					break;
				case "UpTrend":
				case "DownTrend":
				case "Cross":
				case "CrossPoint":
				}
			}
		}
		return list;
	}
	public static Function getOrder(String json)
	{
		JSONObject jObject=JSONObject.fromObject(json);
		String function=(String)jObject.get("function");
		switch(function)
		{
		case "Share":
			ShareFunction share=new ShareFunction();
			share.setFunction(function);
			share.setOrder((int)jObject.get("order"));
			share.setShare((int)jObject.get("share"));
			share.setSiid((String)jObject.get("siid"));
			return share;
		case "SharePercent":
			SharePercentFunction sharePercent=new SharePercentFunction();
			sharePercent.setFunction(function);
			sharePercent.setOrder((int)jObject.get("order"));
			sharePercent.setPercent((int)jObject.get("percent"));
			sharePercent.setSiid((String)jObject.get("siid"));
			return sharePercent;
		case "ShareTarget":
			ShareTargetFunction shareTarget=new ShareTargetFunction();
			shareTarget.setFunction(function);
			shareTarget.setShare((int)jObject.get("share"));
			shareTarget.setSiid((String)jObject.get("siid"));
			return shareTarget;
		case "Value":
			ValueFunction value=new ValueFunction();
			value.setFunction(function);
			value.setOrder((int)jObject.get("order"));
			value.setValue((int)jObject.get("value"));
			value.setSiid((String)jObject.get("siid"));
			return value;
		case "ValuePercent":
			ValuePercentFunction valuePercent=new ValuePercentFunction();
			valuePercent.setFunction(function);
			valuePercent.setOrder((int)jObject.get("order"));
			valuePercent.setPercent((int)jObject.get("percent"));
			valuePercent.setSiid((String)jObject.get("siid"));
			return valuePercent;
		case "ValueTarget":
			ValueTargetFunction valueTarget=new ValueTargetFunction();
			valueTarget.setFunction(function);
			valueTarget.setValue((int)jObject.get("value"));
			valueTarget.setSiid((String)jObject.get("siid"));
			return valueTarget;
		}
		return null;
	}
	public static RealTestVO getRealTest(String json)
	{
		RealTestVO vo=new RealTestVO();
		try
		{
			JSONObject jObject=JSONObject.fromObject(json);
			vo.setCash((double)jObject.getDouble("cash"));
			vo.setN((int)jObject.get("n"));
//			vo.orderType=getOrder(jObject.get("orderType").toString());
//			vo.stockList=getStock(jObject.get("stockList").toString());
			List<DateDouble> capital=new ArrayList<DateDouble>();
			JSONArray jCapital=(JSONArray)jObject.get("capital");
			for(int i=0;i<jCapital.size();i++)
			{
				JSONObject jDateDouble=(JSONObject) jCapital.get(i);
				capital.add(new DateDouble((long)jDateDouble.get("date"),(double)jDateDouble.getDouble("value")));
			}
			vo.setCapital(capital);
//			List<List<Function>> flagList=getFunction(jObject.get("flagList").toString());
//			vo.flagList=flagList;
			List<Integer> numList=new ArrayList<Integer>();
			JSONArray jNum=(JSONArray) jObject.get("numList");
			for(int i=0;i<jNum.size();i++)
			{
				numList.add((int)jNum.get(i));
			}
			vo.setNumList(numList);
		} catch(JSONException e)
		{
			return new RealTestVO();
		}
		return vo;
	}

}
