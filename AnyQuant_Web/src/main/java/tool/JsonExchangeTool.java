package tool;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import backtest.DateDouble;
import vo.Flag;
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
	public static List<Flag> getFlag(String json)
	{
		List<Flag> flags=new ArrayList<Flag>();
		JSONArray jArray=JSONArray.fromObject(json);
		for(int i=0;i<jArray.size();i++)
		{
			JSONObject jObject=(JSONObject) jArray.get(i);
			flags.add(new Flag(getOrder(jObject.get("orderType").toString()),getFunction(jObject.get("flagList").toString())));
		}
		return flags;
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
				int day=0;
				double standard=0;
				String function=(String) jObject.get("function");
				switch(function)
				{
				case "Pair":
					siid=(String)jObject.get("siid");
					num=jObject.getInt("num");
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
					upFRI.setrD(upFRJI.getDouble("rD"));
					downFRI.setrD(downFRJI.getDouble("rD"));
					upFRO.setrD(upFRJO.getDouble("rD"));
					downFRO.setrD(downFRJO.getDouble("rD"));
					siid=(String)jObject.get("siid");
					attribute=(String)jObject.get("attribute");
					day=jObject.getInt("day");
					standard=jObject.getDouble("standard");
					list.get(i).add(new UpTrendFunction(new TrendVO(upFRI,downFRI,upFRO,downFRI,siid,attribute,day,standard)));
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
			share.setOrder(jObject.getInt("order"));
			share.setShare(jObject.getInt("share"));
			share.setSiid(jObject.getString("siid"));
			return share;
		case "SharePercent":
			SharePercentFunction sharePercent=new SharePercentFunction();
			sharePercent.setFunction(function);
			sharePercent.setOrder(jObject.getInt("order"));
			sharePercent.setPercent(jObject.getInt("percent"));
			sharePercent.setSiid(jObject.getString("siid"));
			return sharePercent;
		case "ShareTarget":
			ShareTargetFunction shareTarget=new ShareTargetFunction();
			shareTarget.setFunction(function);
			shareTarget.setShare(jObject.getInt("share"));
			shareTarget.setSiid(jObject.getString("siid"));
			return shareTarget;
		case "Value":
			ValueFunction value=new ValueFunction();
			value.setFunction(function);
			value.setOrder(jObject.getInt("order"));
			value.setValue(jObject.getInt("value"));
			value.setSiid(jObject.getString("siid"));
			return value;
		case "ValuePercent":
			ValuePercentFunction valuePercent=new ValuePercentFunction();
			valuePercent.setFunction(function);
			valuePercent.setOrder(jObject.getInt("order"));
			valuePercent.setPercent(jObject.getInt("percent"));
			valuePercent.setSiid(jObject.getString("siid"));
			return valuePercent;
		case "ValueTarget":
			ValueTargetFunction valueTarget=new ValueTargetFunction();
			valueTarget.setFunction(function);
			valueTarget.setValue(jObject.getInt("value"));
			valueTarget.setSiid(jObject.getString("siid"));
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
			vo.setCash(jObject.getDouble("cash"));
			vo.setN(jObject.getInt("n"));
//			vo.orderType=getOrder(jObject.get("orderType").toString());
//			vo.stockList=getStock(jObject.get("stockList").toString());
			List<DateDouble> capital=new ArrayList<DateDouble>();
			JSONArray jCapital=(JSONArray)jObject.get("capital");
			for(int i=0;i<jCapital.size();i++)
			{
				JSONObject jDateDouble=(JSONObject) jCapital.get(i);
				capital.add(new DateDouble(jDateDouble.getLong("date"),jDateDouble.getDouble("value")));
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
