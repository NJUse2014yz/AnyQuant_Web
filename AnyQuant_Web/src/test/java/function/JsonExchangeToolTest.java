package function;

import java.util.ArrayList;
import java.util.List;

import backtest.DateDouble;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonExchangeToolTest {
	public static void main(String[] args)
	{
		List<Integer> list=new ArrayList<Integer>();
		list.add(ResultType.BOOLEAN.getCode());
		String jlist=JSONArray.fromObject(list).toString();
		String json=JSONObject.fromObject(new DateDouble(0,0.0)).toString();
		System.out.println(json);
		System.out.println(JSONObject.fromObject(json).get("date"));
		System.out.println(JSONObject.fromObject(json).get("data"));
		list=JSONArray.fromObject(jlist);
		System.out.println(list);
//		ResultType type=(ResultType) JSONArray.fromObject(JSONArray.fromObject(list).toString()).get(0);
//		System.out.println(type);
//		System.out.println(ResultType.getEnum(1));
	}
}
