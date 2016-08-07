package bl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.HaltStockInf;
import vo.NewStockInf;
import vo.StockTopInf;

public class SpecStocksHelper {
	public static List<NewStockInf> getNew(String result){
		result=result.substring(1);
		result=result.substring(result.indexOf('['));
		result = "{\"head\":" + result + "}";
		System.out.println(result);
		JSONObject obj = JSONObject.fromObject(result);

		JSONArray jsonArray = obj.getJSONArray("head");
		 for (int i = 0; i < jsonArray.size(); i++) {
		 System.out.println("element " + i + " :" + jsonArray.get(i));
		 }
		ArrayList<NewStockInf> relist = new ArrayList<NewStockInf>();
		for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject temp=(JSONObject) jsonArray.get(i);
				NewStockInf inf=new NewStockInf();
				//忽略json null异常
				try{
				inf.name=temp.getString("name");
				inf.code=temp.getString("code");
				inf.ipo_date=temp.getString("ipo_date");
				inf.issue_date=temp.getString("issue_date");
				inf.price=temp.getDouble("price");
				inf.pe=temp.getDouble("pe");
				inf.limit=temp.getDouble("limit");
				inf.funds=temp.getDouble("funds");
				inf.ballot=Double.toString(temp.getDouble("ballot"))+"%";
				inf.amount=temp.getInt("amount");
				inf.markets=temp.getInt("markets");
				relist.add(inf);
				}catch(Exception e){
//					e.printStackTrace();
				}
		}
//		System.out.println("size="+relist.size());
		return relist;
	}
	public static List<HaltStockInf> getHalt(String result){
		result = "{\"head\":" + result + "}";
		JSONObject obj = JSONObject.fromObject(result);

		JSONArray jsonArray = obj.getJSONArray("head");
//		 for (int i = 0; i < jsonArray.size(); i++) {
//		 System.out.println("element " + i + " :" + jsonArray.get(i));
//		 }
		ArrayList<HaltStockInf> relist = new ArrayList<HaltStockInf>();
		for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject temp=(JSONObject) jsonArray.get(i);
				HaltStockInf inf=new HaltStockInf();
				inf.name=temp.getString("name");
				inf.code=temp.getString("code");
				inf.oDate=temp.getString("oDate");
				inf.tDate=temp.getString("tDate");
				relist.add(inf);
		}
//		System.out.println("size="+relist.size());
		return relist;
	}
}
