package tool;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.AreaInf;
import po.AreaInfPack;
import po.DatePack;
import po.HistoryData;
import po.QuotaData;
import po.StockInf;
import mapper.AreaInfMapper;
import mapper.ConceptInfMapper;
import mapper.HistoryDataMapper;
import mapper.IndiceInfMapper;
import mapper.IndustryInfMapper;
import mapper.MonthHDataMapper;
import mapper.MonthQDataMapper;
import mapper.QuotaDataMapper;
import mapper.StockInfMapper;
import mapper.StrategyMapper;
import mapper.UserInfMapper;
import mapper.WeekHDataMapper;
import mapper.WeekQDataMapper;

public class ListTool {
	public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static HistoryDataMapper historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
	public static QuotaDataMapper quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");
	public static WeekHDataMapper weekHDataMapper=(WeekHDataMapper) applicationContext.getBean("weekHDataMapper");
	public static WeekQDataMapper weekQDataMapper=(WeekQDataMapper) applicationContext.getBean("weekQDataMapper");
	public static MonthHDataMapper monthHDataMapper=(MonthHDataMapper) applicationContext.getBean("monthHDataMapper");
	public static MonthQDataMapper monthQDataMapper=(MonthQDataMapper) applicationContext.getBean("monthQDataMapper");
	public static AreaInfMapper areaInfMapper=(AreaInfMapper) applicationContext.getBean("areaInfMapper");
	public static ConceptInfMapper conceptInfMapper=(ConceptInfMapper) applicationContext.getBean("conceptInfMapper");
	public static IndustryInfMapper industryInfMapper=(IndustryInfMapper) applicationContext.getBean("industryInfMapper");
	public static StockInfMapper stockInfMapper=(StockInfMapper)applicationContext.getBean("stockInfMapper");
	public static IndiceInfMapper indiceInfMapper=(IndiceInfMapper)applicationContext.getBean("indiceInfMapper");
	public static StrategyMapper strategyMapper=(StrategyMapper)applicationContext.getBean("strategyMapper");
	public static UserInfMapper userInfMapper=(UserInfMapper)applicationContext.getBean("userInfMapper");
	
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
			case "openW":
				list=weekHDataMapper.selectOpen_b_date(datePack);
				break;
			case "openM":
				list=monthHDataMapper.selectOpen_b_date(datePack);
				break;
			case "close":
				list=historyDataMapper.selectClose_b_date(datePack);
				break;
			case "closeW":
				list=weekHDataMapper.selectClose_b_date(datePack);
				break;
			case "closeM":
				list=monthHDataMapper.selectClose_b_date(datePack);
				break;
			case "increase":
				list=historyDataMapper.selectIncrease_b_date(datePack);
				break;
			case "increaseW":
				list=weekHDataMapper.selectIncrease_b_date(datePack);
				break;
			case "increaseM":
				list=monthHDataMapper.selectIncrease_b_date(datePack);
				break;
			case "incrPer":
				list=historyDataMapper.selectIncrPer_b_date(datePack);
				break;
			case "incrPerW":
				list=weekHDataMapper.selectIncrPer_b_date(datePack);
				break;
			case "incrPerM":
				list=monthHDataMapper.selectIncrPer_b_date(datePack);
				break;
			case "low":
				list=historyDataMapper.selectLow_b_date(datePack);
				break;
			case "lowW":
				list=weekHDataMapper.selectLow_b_date(datePack);
				break;
			case "lowM":
				list=monthHDataMapper.selectLow_b_date(datePack);
				break;
			case "high":
				list=historyDataMapper.selectHigh_b_date(datePack);
				break;
			case "highW":
				list=weekHDataMapper.selectHigh_b_date(datePack);
				break;
			case "highM":
				list=monthHDataMapper.selectHigh_b_date(datePack);
				break;
			case "volume":
				list=historyDataMapper.selectVolume_b_date(datePack);
				break;
			case "volumeW":
				list=weekHDataMapper.selectVolume_b_date(datePack);
				break;
			case "volumeM":
				list=monthHDataMapper.selectVolume_b_date(datePack);
				break;
			case "amount":
				list=historyDataMapper.selectAmount_b_date(datePack);
				break;
			case "amountW":
				list=weekHDataMapper.selectAmount_b_date(datePack);
				break;
			case "amountM":
				list=monthHDataMapper.selectAmount_b_date(datePack);
				break;
			case "turnover":
				list=historyDataMapper.selectTurnover_b_date(datePack);
				break;

			case "m5":
				list=quotaDataMapper.selectM5(datePack);
				break;
			case "m5W":
				list=weekQDataMapper.selectM5(datePack);
				break;
			case "m5M":
				list=monthQDataMapper.selectM5(datePack);
				break;
			case "m10":
				list=quotaDataMapper.selectM10(datePack);
				break;
			case "m10W":
				list=weekQDataMapper.selectM10(datePack);
				break;
			case "m10M":
				list=monthQDataMapper.selectM10(datePack);
				break;
			case "m20":
				list=quotaDataMapper.selectM20(datePack);
				break;
			case "m20W":
				list=weekQDataMapper.selectM20(datePack);
				break;
			case "m20M":
				list=monthQDataMapper.selectM20(datePack);
				break;
			case "m30":
				list=quotaDataMapper.selectM30(datePack);
				break;
			case "m30W":
				list=weekQDataMapper.selectM30(datePack);
				break;
			case "m30M":
				list=monthQDataMapper.selectM30(datePack);
				break;
			case "bias5":
				list=quotaDataMapper.selectBias5(datePack);
				break;
			case "bias5W":
				list=weekQDataMapper.selectBias5(datePack);
				break;
			case "bias5M":
				list=monthQDataMapper.selectBias5(datePack);
				break;
			case "bias10":
				list=quotaDataMapper.selectBias10(datePack);
				break;
			case "bias10W":
				list=weekQDataMapper.selectBias10(datePack);
				break;
			case "bias10M":
				list=monthQDataMapper.selectBias10(datePack);
				break;
			case "bias20":
				list=quotaDataMapper.selectBias20(datePack);
				break;
			case "bias20W":
				list=weekQDataMapper.selectBias20(datePack);
				break;
			case "bias20M":
				list=monthQDataMapper.selectBias20(datePack);
				break;
			case "boll1":
				list=quotaDataMapper.selectBoll1(datePack);
				break;
			case "boll1W":
				list=weekQDataMapper.selectBoll1(datePack);
				break;
			case "boll1M":
				list=monthQDataMapper.selectBoll1(datePack);
				break;
			case "boll2":
				list=quotaDataMapper.selectBoll2(datePack);
				break;
			case "boll2W":
				list=weekQDataMapper.selectBoll2(datePack);
				break;
			case "boll2M":
				list=monthQDataMapper.selectBoll2(datePack);
				break;
			case "boll3":
				list=quotaDataMapper.selectBoll3(datePack);
				break;
			case "boll3W":
				list=weekQDataMapper.selectBoll3(datePack);
				break;
			case "boll3M":
				list=monthQDataMapper.selectBoll3(datePack);
				break;
			case "rsi":
				list=quotaDataMapper.selectRsi(datePack);
				break;
			case "rsiW":
				list=weekQDataMapper.selectRsi(datePack);
				break;
			case "rsiM":
				list=monthQDataMapper.selectRsi(datePack);
				break;
			case "rsi5":
				list=quotaDataMapper.selectRsi5(datePack);
				break;
			case "rsi5W":
				list=weekQDataMapper.selectRsi5(datePack);
				break;
			case "rsi5M":
				list=monthQDataMapper.selectRsi5(datePack);
				break;
			case "rsi10":
				list=quotaDataMapper.selectRsi10(datePack);
				break;
			case "rsi10W":
				list=weekQDataMapper.selectRsi10(datePack);
				break;
			case "rsi10M":
				list=monthQDataMapper.selectRsi10(datePack);
				break;
			case "rsi20":
				list=quotaDataMapper.selectRsi20(datePack);
				break;
			case "rsi20W":
				list=weekQDataMapper.selectRsi20(datePack);
				break;
			case "rsi20M":
				list=monthQDataMapper.selectRsi20(datePack);
				break;
			case "vr":
				list=quotaDataMapper.selectVr(datePack);
				break;
			case "vrW":
				list=weekQDataMapper.selectVr(datePack);
				break;
			case "vrM":
				list=monthQDataMapper.selectVr(datePack);
				break;
			case "rsv":
				list=quotaDataMapper.selectRsv(datePack);
				break;
			case "rsvW":
				list=weekQDataMapper.selectRsv(datePack);
				break;
			case "rsvM":
				list=monthQDataMapper.selectRsv(datePack);
				break;
			case "k":
				list=quotaDataMapper.selectK(datePack);
				break;
			case "kW":
				list=weekQDataMapper.selectK(datePack);
				break;
			case "kM":
				list=weekQDataMapper.selectK(datePack);
				break;
			case "d":
				list=quotaDataMapper.selectD(datePack);
				break;
			case "dW":
				list=weekQDataMapper.selectD(datePack);
				break;
			case "dM":
				list=monthQDataMapper.selectD(datePack);
				break;
			case "j":
				list=quotaDataMapper.selectJ(datePack);
				break;
			case "jW":
				list=weekQDataMapper.selectJ(datePack);
				break;
			case "jM":
				list=monthQDataMapper.selectJ(datePack);
				break;
			case "ema12":
				list=quotaDataMapper.selectEma12(datePack);
				break;
			case "ema12W":
				list=weekQDataMapper.selectEma12(datePack);
				break;
			case "ema12M":
				list=monthQDataMapper.selectEma12(datePack);
				break;
			case "ema26":
				list=quotaDataMapper.selectEma26(datePack);
				break;
			case "ema26W":
				list=weekQDataMapper.selectEma26(datePack);
				break;
			case "ema26M":
				list=monthQDataMapper.selectEma26(datePack);
				break;
			case "ema50":
				list=quotaDataMapper.selectEma50(datePack);
				break;
			case "ema50W":
				list=weekQDataMapper.selectEma50(datePack);
				break;
			case "ema50M":
				list=monthQDataMapper.selectEma50(datePack);
				break;
			case "ema5":
				list=quotaDataMapper.selectEma5(datePack);
				break;
			case "ema5W":
				list=weekQDataMapper.selectEma5(datePack);
				break;
			case "ema5M":
				list=monthQDataMapper.selectEma5(datePack);
				break;
			case "ema10":
				list=quotaDataMapper.selectEma10(datePack);
				break;
			case "ema10W":
				list=weekQDataMapper.selectEma10(datePack);
				break;
			case "ema10M":
				list=monthQDataMapper.selectEma10(datePack);
				break;
			case "ema60":
				list=quotaDataMapper.selectEma60(datePack);
				break;
			case "ema60W":
				list=weekQDataMapper.selectEma60(datePack);
				break;
			case "ema60M":
				list=monthQDataMapper.selectEma60(datePack);
				break;
			case "diff":
				list=quotaDataMapper.selectDiff(datePack);
				break;
			case "diffW":
				list=weekQDataMapper.selectDiff(datePack);
				break;
			case "diffM":
				list=monthQDataMapper.selectDiff(datePack);
				break;
			case "dea":
				list=quotaDataMapper.selectDea(datePack);
				break;
			case "deaW":
				list=weekQDataMapper.selectDea(datePack);
				break;
			case "deaM":
				list=monthQDataMapper.selectDea(datePack);
				break;
			case "macd":
				list=quotaDataMapper.selectMacd(datePack);
				break;
			case "macdW":
				list=weekQDataMapper.selectMacd(datePack);
				break;
			case "macdM":
				list=monthQDataMapper.selectMacd(datePack);
				break;
			case "dmh":
				list=quotaDataMapper.selectDmh(datePack);
				break;
			case "dml":
				list=quotaDataMapper.selectDml(datePack);
				break;
			case "dmlW":
				list=weekQDataMapper.selectDml(datePack);
				break;
			case "dmlM":
				list=monthQDataMapper.selectDml(datePack);
				break;
			case "tr":
				list=quotaDataMapper.selectTr(datePack);
				break;
			case "trW":
				list=weekQDataMapper.selectTr(datePack);
				break;
			case "trM":
				list=monthQDataMapper.selectTr(datePack);
				break;
			case "dmh12":
				list=quotaDataMapper.selectDmh12(datePack);
				break;
			case "dmh12W":
				list=weekQDataMapper.selectDmh12(datePack);
				break;
			case "dmh12M":
				list=monthQDataMapper.selectDmh12(datePack);
				break;
			case "dml12":
				list=quotaDataMapper.selectDml12(datePack);
				break;
			case "dml12W":
				list=weekQDataMapper.selectDml12(datePack);
				break;
			case "dml12M":
				list=monthQDataMapper.selectDml12(datePack);
				break;
			case "tr12":
				list=quotaDataMapper.selectTr12(datePack);
				break;
			case "tr12W":
				list=weekQDataMapper.selectTr12(datePack);
				break;
			case "tr12M":
				list=monthQDataMapper.selectTr12(datePack);
				break;
			case "dih":
				list=quotaDataMapper.selectDih(datePack);
				break;
			case "dihW":
				list=weekQDataMapper.selectDih(datePack);
				break;
			case "dihM":
				list=monthQDataMapper.selectDih(datePack);
				break;
			case "dil":
				list=quotaDataMapper.selectDil(datePack);
				break;
			case "dilW":
				list=weekQDataMapper.selectDil(datePack);
				break;
			case "dilM":
				list=monthQDataMapper.selectDil(datePack);
				break;
			case "dih12":
				list=quotaDataMapper.selectDih12(datePack);
				break;
			case "dih12W":
				list=weekQDataMapper.selectDih12(datePack);
				break;
			case "dih12M":
				list=monthQDataMapper.selectDih12(datePack);
				break;
			case "dil12":
				list=quotaDataMapper.selectDil12(datePack);
				break;
			case "dil12W":
				list=weekQDataMapper.selectDil12(datePack);
				break;
			case "dil12M":
				list=monthQDataMapper.selectDil12(datePack);
				break;
			case "dx":
				list=quotaDataMapper.selectDx(datePack);
				break;
			case "dxW":
				list=weekQDataMapper.selectDx(datePack);
				break;
			case "dxM":
				list=monthQDataMapper.selectDx(datePack);
				break;
			case "adx":
				list=quotaDataMapper.selectAdx(datePack);
				break;
			case "adxW":
				list=weekQDataMapper.selectAdx(datePack);
				break;
			case "adxM":
				list=monthQDataMapper.selectAdx(datePack);
				break;
			case "adxr":
				list=quotaDataMapper.selectAdxr(datePack);
				break;
			case "adxrW":
				list=weekQDataMapper.selectAdxr(datePack);
				break;
			case "adxrM":
				list=monthQDataMapper.selectAdxr(datePack);
				break;
			case "obv":
				list=quotaDataMapper.selectObv(datePack);
				break;
			case "obvW":
				list=weekQDataMapper.selectObv(datePack);
				break;
			case "obvM":
				list=monthQDataMapper.selectObv(datePack);
				break;
			case "roc12":
				list=quotaDataMapper.selectRoc12(datePack);
				break;
			case "roc12W":
				list=weekQDataMapper.selectRoc12(datePack);
				break;
			case "roc12M":
				list=monthQDataMapper.selectRoc12(datePack);
				break;
			case "roc25":
				list=quotaDataMapper.selectRoc25(datePack);
				break;
			case "roc25W":
				list=weekQDataMapper.selectRoc25(datePack);
				break;
			case "roc25M":
				list=monthQDataMapper.selectRoc25(datePack);
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
	
	public List<String> getArea(String area)
	{
		List<String> list=null;
		try {
			list=areaInfMapper.selectSid_area(area);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getConcept(String concept)
	{
		List<String> list=null;
		try {
			list=conceptInfMapper.selectSid_concept(concept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getIndustry(String industry)
	{
		List<String> list=null;
		try {
			list=industryInfMapper.selectSid_industry(industry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public double getNew(String siid,String attribute)
	{
		double value=0;
		HistoryData hd=null;
		QuotaData qd=null;
		try {
			hd=historyDataMapper.selectHistoryData_new_single(siid);
			qd=quotaDataMapper.selectQuotaData_new(siid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			switch(attribute)
			{
			case "open":
				value=hd.getOpen();
				break;
			case "close":
				value=hd.getClose();
				break;
			case "increase":
				value=hd.getIncrease();
				break;
			case "incrPer":
				value=hd.getIncrPer();
				break;
			case "low":
				value=hd.getLow();
				break;
			case "high":
				value=hd.getHigh();
				break;
			case "volume":
				value=hd.getVolume();
				break;
			case "amount":
				value=hd.getAmount();
				break;
			case "turnover":
				value=hd.getTurnover();
				break;
			case "m5":
				value=qd.getM5();
				break;
			case "m10":
				value=qd.getM10();
				break;
			case "m20":
				value=qd.getM20();
				break;
			case "m30":
				value=qd.getM30();
				break;
			case "bias5":
				value=qd.getBias5();
				break;
			case "bias10":
				value=qd.getBias10();
				break;
			case "bias20":
				value=qd.getBias20();
				break;
			case "boll1":
				value=qd.getBoll1();
				break;
			case "boll2":
				value=qd.getBoll2();
				break;
			case "boll3":
				value=qd.getBoll3();
				break;
			case "rsi":
				value=qd.getRsi();
				break;
			case "rsi5":
				value=qd.getRsi5();
				break;
			case "rsi10":
				value=qd.getRsi10();
				break;
			case "rsi20":
				value=qd.getRsi20();
				break;
			case "vr":
				value=qd.getVr();
				break;
			case "rsv":
				value=qd.getRsv();
				break;
			case "k":
				value=qd.getK();
				break;
			case "d":
				value=qd.getD();
				break;
			case "j":
				value=qd.getJ();
				break;
			case "ema12":
				value=qd.getEma12();
				break;
			case "ema26":
				value=qd.getEma26();
				break;
			case "ema50":
				value=qd.getEma50();
				break;
			case "ema5":
				value=qd.getEma5();
				break;
			case "ema10":
				value=qd.getEma10();
				break;
			case "ema60":
				value=qd.getEma60();
				break;
			case "diff":
				value=qd.getDiff();
				break;
			case "dea":
				value=qd.getDea();
				break;
			case "macd":
				value=qd.getMacd();
				break;
			case "dmh":
				value=qd.getDmh();
				break;
			case "dml":
				value=qd.getDml();
				break;
			case "tr":
				value=qd.getTr();
				break;
			case "dmh12":
				value=qd.getDmh12();
				break;
			case "dml12":
				value=qd.getDml12();
				break;
			case "tr12":
				value=qd.getTr12();
				break;
			case "dih":
				value=qd.getDih();
				break;
			case "dil":
				value=qd.getDil();
				break;
			case "dih12":
				value=qd.getDih12();
				break;
			case "dil12":
				value=qd.getDil12();
				break;
			case "dx":
				value=qd.getDx();
				break;
			case "adx":
				value=qd.getAdx();
				break;
			case "adxr":
				value=qd.getAdxr();
				break;
			case "obv":
				value=qd.getObv();
				break;
			case "roc12":
				value=qd.getRoc12();
				break;
			case "roc25":
				value=qd.getRoc25();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
