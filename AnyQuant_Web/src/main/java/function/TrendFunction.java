package function;

import java.sql.Date;
import java.util.List;

import mapper.HistoryDataMapper;
import mapper.QuotaDataMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.DatePack;
import vo.FunctionResult;

public class TrendFunction implements Function{
	public ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public HistoryDataMapper historyDataMapper;
	public List<Double> list;
	public TrendFunction(String siid,String attribute,Date start,Date end)
	{
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(start);
		datePack.setDate2(end);
		try {
			switch(attribute)
			{
			case "open":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectOpen_b_date(datePack);
				break;
			case "close":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectClose_b_date(datePack);
				break;
			case "increase":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectIncrease_b_date(datePack);
				break;
			case "incrPer":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectIncrPer_b_date(datePack);
				break;
			case "low":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectLow_b_date(datePack);
				break;
			case "high":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectHigh_b_date(datePack);
				break;
			case "volume":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectVolume_b_date(datePack);
				break;
			case "amount":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectAmount_b_date(datePack);
				break;
			case "turnover":
				list=((HistoryDataMapper) applicationContext.getBean("historyDataMapper")).selectTurnover_b_date(datePack);
				break;
			case "m5":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectM5(datePack);
				break;
			case "m10":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectM10(datePack);
				break;
			case "m20":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectM20(datePack);
				break;
			case "m30":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectM30(datePack);
				break;
			case "bias5":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectBias5(datePack);
				break;
			case "bias10":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectBias10(datePack);
				break;
			case "bias20":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectBias20(datePack);
				break;
			case "boll1":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectBoll1(datePack);
				break;
			case "boll2":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectBoll2(datePack);
				break;
			case "boll3":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectBoll3(datePack);
				break;
			case "rsi":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectRsi(datePack);
				break;
			case "rsi5":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectRsi5(datePack);
				break;
			case "rsi10":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectRsi10(datePack);
				break;
			case "rsi20":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectRsi20(datePack);
				break;
			case "vr":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectVr(datePack);
				break;
			case "rsv":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectRsv(datePack);
				break;
			case "k":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectK(datePack);
				break;
			case "d":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectD(datePack);
				break;
			case "j":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectJ(datePack);
				break;
			case "ema12":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectEma12(datePack);
				break;
			case "ema26":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectEma26(datePack);
				break;
			case "ema50":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectEma50(datePack);
				break;
			case "ema5":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectEma5(datePack);
				break;
			case "ema10":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectEma10(datePack);
				break;
			case "ema60":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectEma60(datePack);
				break;
			case "diff":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDiff(datePack);
				break;
			case "dea":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDea(datePack);
				break;
			case "macd":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectMacd(datePack);
				break;
			case "dmh":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDmh(datePack);
				break;
			case "dml":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDml(datePack);
				break;
			case "tr":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectTr(datePack);
				break;
			case "dmh12":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDmh12(datePack);
				break;
			case "dml12":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDml12(datePack);
				break;
			case "tr12":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectTr12(datePack);
				break;
			case "dih":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDih(datePack);
				break;
			case "dil":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDil(datePack);
				break;
			case "dih12":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDih12(datePack);
				break;
			case "dil12":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDil12(datePack);
				break;
			case "dx":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectDx(datePack);
				break;
			case "adx":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectAdx(datePack);
				break;
			case "adxr":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectAdxr(datePack);
				break;
			case "obv":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectObv(datePack);
				break;
			case "roc12":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectRoc12(datePack);
				break;
			case "roc25":
				list=((QuotaDataMapper) applicationContext.getBean("quotaDataMapper")).selectRoc25(datePack);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public FunctionResult getResult() {
		
		return null;
	}
	
}
