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
			jObject=(JSONObject) jArray.get(i);
			String function=(String) jObject.get("function");
			switch(function)
			{
			case "Pair":
				siid=(String)jObject.get("siid");
				num=(int)jObject.get("num");
				list.add(new PairFunction(new PairVO(siid,num)));
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
				for(int j=0;i<upLocationAI.size();j++)
				{
					upLocationAI.add((int)upLocationJAI.get(j));	
					downLocationAI.add((int)downLocationJAI.get(j));
					upLocationAO.add((int)upLocationJAO.get(j));	
					downLocationAO.add((int)downLocationJAO.get(j));
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
				list.add(new UpTrendFunction(new TrendVO(upFRI,downFRI,upFRO,downFRI,siid,attribute,start,end,standard)));
				break;
			case "UpTrend":
			case "DownTrend":
			case "Cross":
			case "CrossPoint":
			}
		}
		return list;
	}
	
}
