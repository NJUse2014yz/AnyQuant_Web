package bl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import po.HistoryData;
import po.QuotaData;
//import po.RealTimeData;
import tool.DateExchangeTool;
import vo.AllBigDealInf;
import vo.BigDealInf;
import vo.KgraInf;
import vo.LinegraInf;
//import vo.RealTimeInf;
import vo.StockListInf;
import vo.StrategyRecInf;

public class DataHelper {
	public static StockListInf TurnStockListInf(HistoryData historyData, String stockid, String sname) {
		StockListInf stockListInf = new StockListInf();
		stockListInf.date = DateExchangeTool.dateToString1(historyData.getDate());
		stockListInf.open = historyData.getOpen();
		stockListInf.close = historyData.getClose();
		stockListInf.increase = historyData.getIncrease();
		stockListInf.incrPer = historyData.getIncrPer();
		stockListInf.low = historyData.getLow();
		stockListInf.high = historyData.getHigh();
		stockListInf.volume = historyData.getVolume();
		stockListInf.amount = (long)historyData.getAmount();
		stockListInf.turnover = historyData.getTurnover();
		stockListInf.stockId = stockid;
		stockListInf.name = sname;
		return stockListInf;
	}

//	public static RealTimeInf TurnRealTimeInf(RealTimeData realData) {
//		RealTimeInf realtimeInf = new RealTimeInf();
//		realtimeInf.date = DateExchangeTool.dateToString1(realData.getDate());
//		realtimeInf.time = DateExchangeTool.timeToString(realData.getTime());
//		realtimeInf.increase = realData.getIncrease();
//		realtimeInf.increPer = realData.getIncrePer();
//		realtimeInf.name = realData.getName();
//		realtimeInf.todayStartPri = realData.getTodayStartPri();
//		realtimeInf.yestodEndPri = realData.getYestodEndPri();
//		realtimeInf.nowPri = realData.getNowPri();
//		realtimeInf.todayMax = realData.getTodayMax();
//		realtimeInf.todayMin = realData.getTodayMin();
//		return realtimeInf;
//	}

	public static ArrayList<KgraInf> TurnKgraInf(List<HistoryData> list_h, List<QuotaData> list_q) {
		ArrayList<KgraInf> result = new ArrayList<KgraInf>();
		// 判断日期是否对应
		int i, j = 0;
		for (i = 0; i < Math.min(list_h.size(),list_q.size()); i++) {
			j = i;
			// for (; j < list_q.size(); j++) {
			// if (DateExchangeTool.dateToString1(list_h.get(i).getDate())
			// .equals(DateExchangeTool.dateToString1(list_q.get(i).getDate())))
			// {
			KgraInf inf = new KgraInf();
			inf.date = DateExchangeTool.dateToString1(list_h.get(i).getDate());
			inf.increase = list_h.get(i).getIncrease();
			inf.increPer = list_h.get(i).getIncrPer();
			inf.openPrice = list_h.get(i).getOpen();
			inf.closePrice = list_h.get(i).getClose();
			inf.highPrice = list_h.get(i).getHigh();
			inf.lowPrice = list_h.get(i).getLow();
			inf.volume = list_h.get(i).getVolume();
			inf.m5 = controldigit(list_q.get(j).getM5());
			inf.m10 = controldigit(list_q.get(j).getM10());
			inf.m20 = controldigit(list_q.get(j).getM20());
			inf.m30 = controldigit(list_q.get(j).getM30());
			result.add(inf);
			// break;
		}
		// }
		// }
		return result;

	}

	public static ArrayList<LinegraInf> TurnLinegraInf(String id, List<QuotaData> list_q) {
		ArrayList<LinegraInf> result = new ArrayList<LinegraInf>();
		for (int i = 0; i < list_q.size(); i++) {
			QuotaData temp = list_q.get(i);
			LinegraInf inf = new LinegraInf();
			inf.id = id;
			inf.date = DateExchangeTool.dateToString1(temp.getDate());
			inf.bias5 = controldigit(temp.getBias5());
			inf.bias10 = controldigit(temp.getBias10());
			inf.bias20 = controldigit(temp.getBias20());
			inf.boll1 = controldigit(temp.getBoll1());
			inf.boll2 = controldigit(temp.getBoll2());
			inf.boll3 = controldigit(temp.getBoll3());
			inf.rsi = controldigit(temp.getRsi());
			inf.rsi5 = controldigit(temp.getRsi5());
			inf.rsi10 = controldigit(temp.getRsi10());
			inf.rsi20 = controldigit(temp.getRsi20());
			inf.vr = controldigit(temp.getVr());
			inf.rsv = controldigit(temp.getRsv());
			inf.k = controldigit(temp.getK());
			inf.j = controldigit(temp.getJ());
			inf.d = controldigit(temp.getD());
			inf.ema12 = controldigit(temp.getEma12());
			inf.ema26 = controldigit(temp.getEma26());
			inf.ema50 = controldigit(temp.getEma50());
			inf.ema5 = controldigit(temp.getEma5());
			inf.ema35 = controldigit(temp.getEma35());
			inf.ema10 = controldigit(temp.getEma10());
			inf.ema60 = controldigit(temp.getEma60());
			inf.diff = controldigit(temp.getDiff());
			inf.dea = controldigit(temp.getDea());
			inf.macd = controldigit(temp.getMacd());

			inf.dmh = controldigit(temp.getDmh());
			inf.dml = controldigit(temp.getDml());
			inf.tr = controldigit(temp.getTr());
			inf.dmh12 = controldigit(temp.getDmh12());
			inf.dml12 = controldigit(temp.getDml12());
			inf.tr12 = controldigit(temp.getTr12());
			inf.dih = controldigit(temp.getDih());
			inf.dil = controldigit(temp.getDil());
			inf.dih12 = controldigit(temp.getDih12());
			inf.dil12 = controldigit(temp.getDil12());
			inf.dx = controldigit(temp.getDx());
			inf.adx = controldigit(temp.getAdx());
			inf.adxr = controldigit(temp.getAdxr());
			inf.obv = controldigit(temp.getObv());
			inf.roc12 = controldigit(temp.getRoc12());
			inf.roc25 = controldigit(temp.getRoc25());

			result.add(inf);
		}
		return result;
	}
	
	public static AllBigDealInf turnDeal(String result){
		AllBigDealInf vo=new AllBigDealInf();
		int buy=0;
		int sell=0;
		int mid=0;
		result = "{\"head\":" + result + "}";
		JSONObject obj = JSONObject.fromObject(result);

		JSONArray jsonArray = obj.getJSONArray("head");
		ArrayList<BigDealInf> relist = new ArrayList<BigDealInf>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject temp = (JSONObject) jsonArray.get(i);
			BigDealInf inf = new BigDealInf();
			inf.code=temp.getString("code");
			inf.name = temp.getString("name");
			inf.time = temp.getString("time");
			inf.price = DataHelper.controldigit(temp.getDouble("price"));
			inf.preprice = DataHelper.controldigit(temp.getDouble("preprice"));
			inf.volume= temp.getInt("volume");
			inf.type=temp.getString("type");
			if(inf.type.equals("买盘")){
				buy+=inf.volume;
			}
			if(inf.type.equals("卖盘")){
				sell+=inf.volume;
			}
			if(inf.type.equals("中性盘")){
				mid+=inf.volume;
			}
//			System.out.println(i+" "+inf.volume+" "+inf.type);
			relist.add(inf);
		}
		vo.SumBuy=buy;
		vo.SumMid=mid;
		vo.SumSell=sell;
		vo.list=relist;
		return vo;
	}

	public static double controldigit(double original) {
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.parseDouble(df.format(original));
	}
	

}
