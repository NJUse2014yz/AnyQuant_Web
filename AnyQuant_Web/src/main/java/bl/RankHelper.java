package bl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.StockTopInf;

public class RankHelper {

	public static List<StockTopInf> toList(String result) {
		result = "{\"head\":" + result + "}";
		JSONObject obj = JSONObject.fromObject(result);

		// 数组array结果：[{"id":"123","name":"haha"},{"id":"456","name":"hehe"}]
		JSONArray jsonArray = obj.getJSONArray("head");
//		 for (int i = 0; i < jsonArray.size(); i++) {
//		 System.out.println("element " + i + " :" + jsonArray.get(i));
//		 }
		ArrayList<StockTopInf> relist = new ArrayList<StockTopInf>();
		int count = -1;
		for (int i = 0; i < jsonArray.size(); i++) {
			//第一个或者是新的
			if ((i == 0) || (!(((JSONObject) jsonArray.get(i)).getString("code"))
					.equals(((JSONObject) jsonArray.get(i - 1)).getString("code")))) {
				count++;
				JSONObject temp=(JSONObject) jsonArray.get(i);
				StockTopInf inf=new StockTopInf();
				inf.stockId=temp.getString("code");
				inf.name=temp.getString("name");
				inf.pchange=temp.getString("pchange")+"%";
				inf.amount=temp.getDouble("amount");
				inf.buy=temp.getDouble("buy");
				inf.sell=temp.getDouble("sell");
				inf.bratio=temp.getDouble("bratio");
				inf.sratio=temp.getDouble("sratio");
				inf.reason=temp.getString("reason");
				inf.date=temp.getString("date");
				relist.add(inf);
			}else{
				relist.get(count).reason=relist.get(count).reason+","+((JSONObject) jsonArray.get(i)).getString("reason");
			}
		}
//		System.out.println("size="+relist.size());
		return relist;
	}
}
