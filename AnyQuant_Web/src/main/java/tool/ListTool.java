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
import mapper.QuotaDataMapper;
import mapper.StockInfMapper;
import mapper.StrategyMapper;
import mapper.UserInfMapper;

public class ListTool {
	public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
	public static HistoryDataMapper historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
	public static QuotaDataMapper quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");
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
