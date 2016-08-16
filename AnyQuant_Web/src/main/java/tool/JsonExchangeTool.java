package tool;

import java.util.ArrayList;
import java.util.List;

import function.Function;
import function.FunctionResult;
import function.choose.ChooseStock;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.TrendVO;
import function.flag.UpTrendFunction;
import net.sf.json.JSONArray;
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
				JSONObject jObject=null;
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
	
}
