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
import function.flag.CrossFunction;
import function.flag.CrossPointFunction;
import function.flag.CrossVO;
import function.flag.DownTrendFunction;
import function.flag.TrendFunction;
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
				upFRI.setrB(upFRJI.getBoolean("rB"));
				downFRI.setrB(downFRJI.getBoolean("rB"));
				upFRO.setrB(upFRJO.getBoolean("rB"));
				downFRO.setrB(downFRJO.getBoolean("rB"));
				upFRI.setrI(upFRJI.getInt("rI"));
				downFRI.setrI(downFRJI.getInt("rI"));
				upFRO.setrI(upFRJO.getInt("rI"));
				downFRO.setrI(downFRJO.getInt("rI"));
				upFRI.setrD(upFRJI.getDouble("rD"));
				downFRI.setrD(downFRJI.getDouble("rD"));
				upFRO.setrD(upFRJO.getDouble("rD"));
				downFRO.setrD(downFRJO.getDouble("rD"));
				
				JSONArray jArrayupFRJIrLI=(JSONArray)upFRJI.get("rLI");
				List<Integer> upFRJIrLI=new ArrayList<Integer>();
				for(int l=0;l<jArrayupFRJIrLI.size();l++)
				{
					upFRJIrLI.add(jArrayupFRJIrLI.getInt(l));
				}
				upFRI.setrLI(upFRJIrLI);
				JSONArray jArraydownFRJIrLI=(JSONArray)downFRJI.get("rLI");
				List<Integer> downFRJIrLI=new ArrayList<Integer>();
				for(int l=0;l<jArraydownFRJIrLI.size();l++)
				{
					downFRJIrLI.add(jArraydownFRJIrLI.getInt(l));
				}
				downFRI.setrLI(downFRJIrLI);
				JSONArray jArrayupFRJOrLI=(JSONArray)upFRJO.get("rLI");
				List<Integer> upFRJOrLI=new ArrayList<Integer>();
				for(int l=0;l<jArrayupFRJOrLI.size();l++)
				{
					upFRJOrLI.add(jArrayupFRJOrLI.getInt(l));
				}
				upFRO.setrLI(upFRJOrLI);
				JSONArray jArraydownFRJOrLI=(JSONArray)downFRJO.get("rLI");
				List<Integer> downFRJOrLI=new ArrayList<Integer>();
				for(int l=0;l<jArraydownFRJOrLI.size();l++)
				{
					downFRJOrLI.add(jArraydownFRJOrLI.getInt(l));
				}
				downFRO.setrLI(downFRJOrLI);
				
				JSONArray jArrayupFRJIrLD=(JSONArray)upFRJI.get("rLD");
				List<Double> upFRJIrLD=new ArrayList<Double>();
				for(int l=0;l<jArrayupFRJIrLD.size();l++)
				{
					upFRJIrLD.add(jArrayupFRJIrLD.getDouble(l));
				}
				upFRI.setrLD(upFRJIrLD);
				JSONArray jArraydownFRJIrLD=(JSONArray)downFRJI.get("rLD");
				List<Double> downFRJIrLD=new ArrayList<Double>();
				for(int l=0;l<jArraydownFRJIrLD.size();l++)
				{
					downFRJIrLD.add(jArraydownFRJIrLD.getDouble(l));
				}
				downFRI.setrLD(downFRJIrLD);
				JSONArray jArrayupFRJOrLD=(JSONArray)upFRJO.get("rLD");
				List<Double> upFRJOrLD=new ArrayList<Double>();
				for(int l=0;l<jArrayupFRJOrLD.size();l++)
				{
					upFRJOrLD.add(jArrayupFRJOrLD.getDouble(l));
				}
				upFRO.setrLD(upFRJOrLD);
				JSONArray jArraydownFRJOrLD=(JSONArray)downFRJO.get("rLD");
				List<Double> downFRJOrLD=new ArrayList<Double>();
				for(int l=0;l<jArraydownFRJOrLD.size();l++)
				{
					downFRJOrLD.add(jArraydownFRJOrLD.getDouble(l));
				}
				downFRO.setrLD(downFRJOrLD);
				
				JSONArray jArrayupFRJIrLS=(JSONArray)upFRJI.get("rLS");
				List<String> upFRJIrLS=new ArrayList<String>();
				for(int l=0;l<jArrayupFRJIrLS.size();l++)
				{
					upFRJIrLS.add(jArrayupFRJIrLS.getString(l));
				}
				upFRI.setrLS(upFRJIrLS);
				JSONArray jArraydownFRJIrLS=(JSONArray)downFRJI.get("rLS");
				List<String> downFRJIrLS=new ArrayList<String>();
				for(int l=0;l<jArraydownFRJIrLS.size();l++)
				{
					downFRJIrLS.add(jArraydownFRJIrLS.getString(l));
				}
				downFRI.setrLS(downFRJIrLS);
				JSONArray jArrayupFRJOrLS=(JSONArray)upFRJO.get("rLS");
				List<String> upFRJOrLS=new ArrayList<String>();
				for(int l=0;l<jArrayupFRJOrLS.size();l++)
				{
					upFRJOrLS.add(jArrayupFRJOrLS.getString(l));
				}
				upFRO.setrLS(upFRJOrLS);
				JSONArray jArraydownFRJOrLS=(JSONArray)downFRJO.get("rLS");
				List<String> downFRJOrLS=new ArrayList<String>();
				for(int l=0;l<jArraydownFRJOrLS.size();l++)
				{
					downFRJOrLS.add(jArraydownFRJOrLS.getString(l));
				}
				downFRO.setrLS(downFRJOrLS);
				
				switch(function)
				{
				case "Pair":
					siid=(String)jObject.get("siid");
					num=jObject.getInt("num");
					list.get(i).add(new PairFunction(new PairVO(siid,num)));
					break;
					
				case "Trend":
					siid=(String)jObject.get("siid");
					attribute=(String)jObject.get("attribute");
					day=jObject.getInt("day");
					standard=jObject.getDouble("standard");
					list.get(i).add(new TrendFunction(new TrendVO(upFRI,downFRI,upFRO,downFRI,siid,attribute,day,standard)));
					break;
				case "UpTrend":
					siid=(String)jObject.get("siid");
					attribute=(String)jObject.get("attribute");
					day=jObject.getInt("day");
					standard=jObject.getDouble("standard");
					list.get(i).add(new UpTrendFunction(new TrendVO(upFRI,downFRI,upFRO,downFRI,siid,attribute,day,standard)));
					break;
				case "DownTrend":
					siid=(String)jObject.get("siid");
					attribute=(String)jObject.get("attribute");
					day=jObject.getInt("day");
					standard=jObject.getDouble("standard");
					list.get(i).add(new DownTrendFunction(new TrendVO(upFRI,downFRI,upFRO,downFRI,siid,attribute,day,standard)));
					break;
				case "Cross":
					siid1=(String)jObject.get("siid1");
					attribute1=(String)jObject.get("attribute1");
					siid2=(String)jObject.get("siid2");
					attribute2=(String)jObject.get("attribute2");
					day=jObject.getInt("day");
					list.get(i).add(new CrossFunction(new CrossVO(upFRI,downFRI,upFRO,downFRI,siid1,attribute1,siid2,attribute2,day)));
					break;
				case "CrossPoint":
					siid1=(String)jObject.get("siid1");
					attribute1=(String)jObject.get("attribute1");
					siid2=(String)jObject.get("siid2");
					attribute2=(String)jObject.get("attribute2");
					day=jObject.getInt("day");
					list.get(i).add(new CrossPointFunction(new CrossVO(upFRI,downFRI,upFRO,downFRI,siid1,attribute1,siid2,attribute2,day)));
					break;
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
