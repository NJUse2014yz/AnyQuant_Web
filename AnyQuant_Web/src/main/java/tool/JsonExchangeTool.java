package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.AnnotationIntrospector.Pair;

import function.Choose;
import function.Flag;
import function.Function;
import function.FunctionResult;
import function.choose.ChooseStock;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.CrossFunction;
import function.flag.CrossVO;
import function.flag.DownTrendFunction;
import function.flag.TrendFunction;
import function.flag.TrendVO;
import function.flag.UpTrendFunction;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import po.AreaInf;
import po.ConceptInf;
import po.HistoryData;
import po.IndustryInf;
import po.StockInf;
import vo.StockPair;

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
	public static List<Function> getFunction(String json)
	{
		List<Function> list=new ArrayList<Function>();
		JSONArray jArray=null;
		
		jArray=JSONArray.fromObject(json);
		for(int i=0;i<jArray.size();i++)
		{
			JSONObject jObject=null;
			String siid=null;
			String siid1=null;
			String siid2=null;
			String attribute=null;
			String attribute1=null;
			String attribute2=null;
			int num=0;
			JSONObject upFRJ=null;
			JSONObject downFRJ=null;
			JSONArray upLocationJA=null;
			JSONArray downLocationJA=null;
			List<Integer> upLocationA=null;
			List<Integer> downLocationA=null;
			FunctionResult upFR=null;
			FunctionResult downFR=null;
			long start=0;
			long end=0;
			double standard=0;
			jObject=(JSONObject) jArray.get(i);
			String function=(String) jObject.get("function");
			switch(function)
			{
			case "Pair":
				siid=(String)jObject.get("siid");
				num=(int)jObject.get("num");
				list.add(new PairFunction(new PairVO(siid,num)));
				break;
			case "UpTrend":
				upFRJ=(JSONObject)jObject.get("resultUp");
				downFRJ=(JSONObject)jObject.get("resultDown");
				upFR=new FunctionResult();
				downFR=new FunctionResult();				
				upLocationJA=(JSONArray)jObject.get("location");
				downLocationJA=(JSONArray)jObject.get("location");
				upLocationA=new ArrayList<Integer>();
				downLocationA=new ArrayList<Integer>();
				for(int j=0;i<upLocationA.size();j++)
				{
					upLocationA.add((int)upLocationJA.get(j));	
					downLocationA.add((int)downLocationJA.get(j));
				}
				upFR.setrD((double)upFRJ.get("rD"));
				downFR.setrD((double)downFRJ.getDouble("rD"));
				siid=(String)jObject.get("siid");
				attribute=(String)jObject.get("attribute");
				start=(long)jObject.get("start");
				end=(long)jObject.get("end");
				standard=(double)jObject.get("standard");
				list.add(new UpTrendFunction(new TrendVO(upFR,downFR,siid,attribute,start,end,standard)));
				break;
			case "DownTrend":
				upFRJ=(JSONObject)jObject.get("resultUp");
				downFRJ=(JSONObject)jObject.get("resultDown");
				upFR=new FunctionResult();
				downFR=new FunctionResult();				
				upLocationJA=(JSONArray)jObject.get("location");
				downLocationJA=(JSONArray)jObject.get("location");
				upLocationA=new ArrayList<Integer>();
				downLocationA=new ArrayList<Integer>();
				for(int j=0;i<upLocationA.size();j++)
				{
					upLocationA.add((int)upLocationJA.get(j));	
					downLocationA.add((int)downLocationJA.get(j));
				}
				upFR.setrD((double)upFRJ.get("rD"));
				downFR.setrD((double)downFRJ.getDouble("rD"));
				siid=(String)jObject.get("siid");
				attribute=(String)jObject.get("attribute");
				start=(long)jObject.get("start");
				end=(long)jObject.get("end");
				standard=(double)jObject.get("standard");
				list.add(new DownTrendFunction(new TrendVO(upFR,downFR,siid,attribute,start,end,standard)));
				break;
			case "Trend":
				upFRJ=(JSONObject)jObject.get("resultUp");
				downFRJ=(JSONObject)jObject.get("resultDown");
				upFR=new FunctionResult();
				downFR=new FunctionResult();				
				upLocationJA=(JSONArray)jObject.get("location");
				downLocationJA=(JSONArray)jObject.get("location");
				upLocationA=new ArrayList<Integer>();
				downLocationA=new ArrayList<Integer>();
				for(int j=0;i<upLocationA.size();j++)
				{
					upLocationA.add((int)upLocationJA.get(j));	
					downLocationA.add((int)downLocationJA.get(j));
				}
				upFR.setrD((double)upFRJ.get("rD"));
				downFR.setrD((double)downFRJ.getDouble("rD"));
				siid=(String)jObject.get("siid");
				attribute=(String)jObject.get("attribute");
				start=(long)jObject.get("start");
				end=(long)jObject.get("end");
				standard=(double)jObject.get("standard");
				list.add(new TrendFunction(new TrendVO(upFR,downFR,siid,attribute,start,end,standard)));
				break;
			case "Cross":
				upFRJ=(JSONObject)jObject.get("resultUp");
				downFRJ=(JSONObject)jObject.get("resultDown");
				upFR=new FunctionResult();
				downFR=new FunctionResult();				
				upLocationJA=(JSONArray)jObject.get("location");
				downLocationJA=(JSONArray)jObject.get("location");
				upLocationA=new ArrayList<Integer>();
				downLocationA=new ArrayList<Integer>();
				for(int j=0;i<upLocationA.size();j++)
				{
					upLocationA.add((int)upLocationJA.get(j));	
					downLocationA.add((int)downLocationJA.get(j));
				}
				upFR.setrI((int)upFRJ.get("rI"));
				downFR.setrI((int)downFRJ.getDouble("rI"));
				siid1=(String)jObject.get("siid1");
				attribute1=(String)jObject.get("attribute1");
				siid2=(String)jObject.get("siid2");
				attribute2=(String)jObject.get("attribute2");
				start=(long)jObject.get("start");
				end=(long)jObject.get("end");
				list.add(new CrossFunction(new CrossVO(upFR,downFR,siid1,attribute1,siid2,attribute2,start,end)));
				break;
			case "CrossPoint":
				upFRJ=(JSONObject)jObject.get("resultUp");
				downFRJ=(JSONObject)jObject.get("resultDown");
				upFR=new FunctionResult();
				downFR=new FunctionResult();				
				upLocationJA=(JSONArray)jObject.get("location");
				downLocationJA=(JSONArray)jObject.get("location");
				upLocationA=new ArrayList<Integer>();
				downLocationA=new ArrayList<Integer>();
				for(int j=0;i<upLocationA.size();j++)
				{
					upLocationA.add((int)upLocationJA.get(j));	
					downLocationA.add((int)downLocationJA.get(j));
				}
				upFR.setrI((int)upFRJ.get("rI"));
				downFR.setrI((int)downFRJ.getDouble("rI"));
				siid1=(String)jObject.get("siid1");
				attribute1=(String)jObject.get("attribute1");
				siid2=(String)jObject.get("siid2");
				attribute2=(String)jObject.get("attribute2");
				start=(long)jObject.get("start");
				end=(long)jObject.get("end");
				list.add(new CrossFunction(new CrossVO(upFR,downFR,siid1,attribute1,siid2,attribute2,start,end)));
				break;
			}
		}
		return list;
	}
	
}
