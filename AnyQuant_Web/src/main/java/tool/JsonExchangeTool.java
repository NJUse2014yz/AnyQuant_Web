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
import function.choose.ChooseStock;
import function.choose.PairFunction;
import function.choose.PairVO;
import function.flag.TrendFunction;
import function.flag.TrendVO;
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
		JSONObject jObject=null;
		
//		System.out.println(json);
		jArray=JSONArray.fromObject(json);
		for(int i=0;i<jArray.size();i++)
		{
			jObject=(JSONObject) jArray.get(i);
			String function=(String) jObject.get("function");
			switch(function)
			{
			case "Pair":
				String siid=(String)jObject.get("siid");
				int num=(int)jObject.get("num");
				list.add(new PairFunction(new PairVO(siid,num)));
				break;
			case "Trend":
				String sid=(String)jObject.get("siid");
				String attribute=(String)jObject.get("attribute");
				long start=(long)jObject.get("start");
				long end=(long)jObject.get("end");
				double standard=(double)jObject.get("standard");
				list.add(new TrendFunction(new TrendVO(sid,attribute,start,end,standard)));
				break;
			}
		}
		return list;
	}
	
}
