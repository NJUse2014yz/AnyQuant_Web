package tool;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.DatePack;
import po.StockInf;
import mapper.HistoryDataMapper;
import mapper.QuotaDataMapper;
import mapper.StockInfMapper;

public class ListTool {
	public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static HistoryDataMapper historyDataMapper=((HistoryDataMapper) applicationContext.getBean("historyDataMapper"));
	public static QuotaDataMapper quotaDataMapper=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper"));
	public List<Double> getList(String siid,String attribute,Date start,Date end)
	{
		List<Double> list=null;
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(start);
		datePack.setDate2(end);
		try {
			switch(attribute)
			{
			case "open":
				list=historyDataMapper.selectOpen_b_date(datePack);
				break;
			case "close":
				list=historyDataMapper.selectClose_b_date(datePack);
				break;
			case "increase":
				list=historyDataMapper.selectIncrease_b_date(datePack);
				break;
			case "incrPer":
				list=historyDataMapper.selectIncrPer_b_date(datePack);
				break;
			case "low":
				list=historyDataMapper.selectLow_b_date(datePack);
				break;
			case "high":
				list=historyDataMapper.selectHigh_b_date(datePack);
				break;
			case "volume":
				list=historyDataMapper.selectVolume_b_date(datePack);
				break;
			case "amount":
				list=historyDataMapper.selectAmount_b_date(datePack);
				break;
			case "turnover":
				list=historyDataMapper.selectTurnover_b_date(datePack);
				break;
			case "m5":
				list=quotaDataMapper.selectM5(datePack);
				break;
			case "m10":
				list=quotaDataMapper.selectM10(datePack);
				break;
			case "m20":
				list=quotaDataMapper.selectM20(datePack);
				break;
			case "m30":
				list=quotaDataMapper.selectM30(datePack);
				break;
			case "bias5":
				list=quotaDataMapper.selectBias5(datePack);
				break;
			case "bias10":
				list=quotaDataMapper.selectBias10(datePack);
				break;
			case "bias20":
				list=quotaDataMapper.selectBias20(datePack);
				break;
			case "boll1":
				list=quotaDataMapper.selectBoll1(datePack);
				break;
			case "boll2":
				list=quotaDataMapper.selectBoll2(datePack);
				break;
			case "boll3":
				list=quotaDataMapper.selectBoll3(datePack);
				break;
			case "rsi":
				list=quotaDataMapper.selectRsi(datePack);
				break;
			case "rsi5":
				list=quotaDataMapper.selectRsi5(datePack);
				break;
			case "rsi10":
				list=quotaDataMapper.selectRsi10(datePack);
				break;
			case "rsi20":
				list=quotaDataMapper.selectRsi20(datePack);
				break;
			case "vr":
				list=quotaDataMapper.selectVr(datePack);
				break;
			case "rsv":
				list=quotaDataMapper.selectRsv(datePack);
				break;
			case "k":
				list=quotaDataMapper.selectK(datePack);
				break;
			case "d":
				list=quotaDataMapper.selectD(datePack);
				break;
			case "j":
				list=quotaDataMapper.selectJ(datePack);
				break;
			case "ema12":
				list=quotaDataMapper.selectEma12(datePack);
				break;
			case "ema26":
				list=quotaDataMapper.selectEma26(datePack);
				break;
			case "ema50":
				list=quotaDataMapper.selectEma50(datePack);
				break;
			case "ema5":
				list=quotaDataMapper.selectEma5(datePack);
				break;
			case "ema10":
				list=quotaDataMapper.selectEma10(datePack);
				break;
			case "ema60":
				list=quotaDataMapper.selectEma60(datePack);
				break;
			case "diff":
				list=quotaDataMapper.selectDiff(datePack);
				break;
			case "dea":
				list=quotaDataMapper.selectDea(datePack);
				break;
			case "macd":
				list=quotaDataMapper.selectMacd(datePack);
				break;
			case "dmh":
				list=quotaDataMapper.selectDmh(datePack);
				break;
			case "dml":
				list=quotaDataMapper.selectDml(datePack);
				break;
			case "tr":
				list=quotaDataMapper.selectTr(datePack);
				break;
			case "dmh12":
				list=quotaDataMapper.selectDmh12(datePack);
				break;
			case "dml12":
				list=quotaDataMapper.selectDml12(datePack);
				break;
			case "tr12":
				list=quotaDataMapper.selectTr12(datePack);
				break;
			case "dih":
				list=quotaDataMapper.selectDih(datePack);
				break;
			case "dil":
				list=quotaDataMapper.selectDil(datePack);
				break;
			case "dih12":
				list=quotaDataMapper.selectDih12(datePack);
				break;
			case "dil12":
				list=quotaDataMapper.selectDil12(datePack);
				break;
			case "dx":
				list=quotaDataMapper.selectDx(datePack);
				break;
			case "adx":
				list=quotaDataMapper.selectAdx(datePack);
				break;
			case "adxr":
				list=quotaDataMapper.selectAdxr(datePack);
				break;
			case "obv":
				list=quotaDataMapper.selectObv(datePack);
				break;
			case "roc12":
				list=quotaDataMapper.selectRoc12(datePack);
				break;
			case "roc25":
				list=quotaDataMapper.selectRoc25(datePack);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<String> getPair(String siid,int num)
	{
		List<String> list=new ArrayList<String>();
		StockInf stockInf=null;
		try {
			stockInf = ((StockInfMapper) applicationContext.getBean("stockInfMapper")).selectStockInf_e_sid(siid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.add(stockInf.getPartner1());
		list.add(stockInf.getPartner2());
		list.add(stockInf.getPartner3());
		return list;
	}
}
