package data.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import mapper.AreaInfMapper;
import mapper.AreaLatestMapper;
import mapper.ConceptInfMapper;
import mapper.ConceptLatestMapper;
import mapper.HistoryDataMapper;
import mapper.IndiceInfMapper;
import mapper.IndustryInfMapper;
import mapper.IndustryLatestMapper;
import mapper.MonthHDataMapper;
import mapper.MonthQDataMapper;
import mapper.QuotaDataMapper;
//import mapper.RealTimeDataMapper;
import mapper.StockInfMapper;
import mapper.WeekHDataMapper;
import mapper.WeekQDataMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.AreaInf;
import po.AreaInfPack;
import po.ConceptInf;
import po.ConceptInfPack;
import po.DatePack;
import po.HistoryData;
import po.IndiceInf;
import po.IndustryInf;
import po.IndustryInfPack;
import po.QuotaData;
//import po.RealTimeData;
import po.BlockHistoryData;
import po.StockInf;
import pr.HistoryDataPr;
import data.DataService;

public class DataServiceImpl implements DataService {
	private ApplicationContext applicationContext;
	
	private StockInfMapper stockInfMapper;
	private IndiceInfMapper indiceInfMapper;
	private IndustryInfMapper industryInfMapper;
	private ConceptInfMapper conceptInfMapper;
	private AreaInfMapper areaInfMapper;
	private IndustryLatestMapper industryLatestMapper;
	private ConceptLatestMapper conceptLatestMapper;
	private AreaLatestMapper areaLatestMapper;
	
//	private RealTimeDataMapper realTimeDataMapper;
	
	private HistoryDataMapper historyDataMapper;
	private WeekHDataMapper weekHDataMapper;
	private MonthHDataMapper monthHDataMapper;

	private HistoryDataPr historyDataPr;
	
	private QuotaDataMapper quotaDataMapper;
	private WeekQDataMapper weekQDataMapper;
	private MonthQDataMapper monthQDataMapper;
	
	/**创建对象时为mapper注入对象*/
	public DataServiceImpl()
	{
		applicationContext =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		
//		realTimeDataMapper=(RealTimeDataMapper) applicationContext.getBean("realTimeDataMapper");
		
		stockInfMapper=(StockInfMapper)applicationContext.getBean("stockInfMapper");
		indiceInfMapper=(IndiceInfMapper)applicationContext.getBean("indiceInfMapper");
		industryInfMapper=(IndustryInfMapper)applicationContext.getBean("industryInfMapper");
		conceptInfMapper=(ConceptInfMapper)applicationContext.getBean("conceptInfMapper");
		areaInfMapper=(AreaInfMapper)applicationContext.getBean("areaInfMapper");
		industryLatestMapper=(IndustryLatestMapper)applicationContext.getBean("industryLatestMapper");
		conceptLatestMapper=(ConceptLatestMapper)applicationContext.getBean("conceptLatestMapper");
		areaLatestMapper=(AreaLatestMapper)applicationContext.getBean("areaLatestMapper");
		
		historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
		weekHDataMapper=(WeekHDataMapper) applicationContext.getBean("weekHDataMapper");
		monthHDataMapper=(MonthHDataMapper) applicationContext.getBean("monthHDataMapper");
		
		historyDataPr=new HistoryDataPr();
		

		quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");
		weekQDataMapper=(WeekQDataMapper) applicationContext.getBean("weekQDataMapper");
		monthQDataMapper=(MonthQDataMapper) applicationContext.getBean("monthQDataMapper");
	}
	
//	@Override
//	public List<RealTimeData> getRealTimeData_siid(String siid) throws Exception {
//		DatePack datePack=new DatePack();
//		datePack.setSiid(siid);
//		return realTimeDataMapper.selectRealTimeData_all(datePack);
//	}

	@Override
	public List<HistoryData> getHistoryStockData_siidTime(String siid,
			Date startdate, Date enddate) throws Exception {
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		return historyDataMapper.selectHistoryData_b_date(datePack);
	}
	
	@Override
	public HistoryData getHistoryData_new(String type,String gid) throws Exception {
		return historyDataPr.getHistoryData_new(type, gid);
	}

	@Override
	public HistoryData getHistoryData_new_single(String siid) throws Exception {
		return historyDataMapper.selectHistoryData_new_single(siid);
	}
	
	@Override 
	public List<HistoryData> getHistoryData_new_list(List<String> list) throws Exception
	{
		return historyDataMapper.selectHistoryData_new_list(list);
	}
	
	@Override
	public List<StockInf> getStockList() throws Exception {
		return stockInfMapper.selectStockInf_all();
	}

	@Override
	public List<IndiceInf> getIndiceList() throws Exception {
		return indiceInfMapper.selectIndiceInf_all();
	}

	@Override
	public List<String> getIndustryList() throws Exception {
		return industryInfMapper.selectIndustryInfCname_all();
	}

	@Override
	public List<String> getConceptList() throws Exception {
		return conceptInfMapper.selectConceptInfCname_all();
	}

	@Override
	public List<String> getAreaList() throws Exception {
		return areaInfMapper.selectAreaInfCname_all();
	}
	
	@Override
	public StockInf getStockInf_sid(String sid) throws Exception {
		return stockInfMapper.selectStockInf_e_sid(sid);
	}

	@Override
	public IndiceInf getIndiceInf_iid(String iid) throws Exception {
		return indiceInfMapper.selectIndiceInf_e_iid(iid);
	}
	
	@Override
	public List<HistoryData> getWeekHData(String siid, Date startdate,
			Date enddate) throws Exception {
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		return weekHDataMapper.selectWeekHData_b_date(datePack);
	}

	@Override
	public List<HistoryData> getMonthHData(String siid, Date startdate,
			Date enddate) throws Exception {
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		return monthHDataMapper.selectMonthHData_b_date(datePack);
	}

	@Override
	public List<IndustryInf> getIndustryInf_sid(String sid) throws Exception {
		IndustryInfPack industryInfPack=new IndustryInfPack();
		industryInfPack.setSid(sid);
		return industryInfMapper.selectIndustryInf_sid(industryInfPack);
	}

	@Override
	public List<IndustryInf> getIndustryInf_cname(String cname)
			throws Exception {
		IndustryInfPack industryInfPack=new IndustryInfPack();
		industryInfPack.setCname(cname);
		return industryInfMapper.selectIndustryInf_cname(industryInfPack);
	}

	@Override
	public List<ConceptInf> getConceptInf_sid(String sid) throws Exception {
		ConceptInfPack conceptInfPack=new ConceptInfPack();
		conceptInfPack.setSid(sid);
		return conceptInfMapper.selectConceptInf_sid(conceptInfPack);
	}

	@Override
	public List<ConceptInf> getConceptInf_cname(String cname) throws Exception {
		ConceptInfPack conceptInfPack=new ConceptInfPack();
		conceptInfPack.setCname(cname);
		return conceptInfMapper.selectConceptInf_cname(conceptInfPack);
	}

	@Override
	public List<AreaInf> getAreaInf_sid(String sid) throws Exception {
		AreaInfPack areaInfPack=new AreaInfPack();
		areaInfPack.setSid(sid);
		return areaInfMapper.selectAreaInf_sid(areaInfPack);
	}

	@Override
	public List<AreaInf> getAreaInf_area(String area) throws Exception {
		AreaInfPack areaInfPack=new AreaInfPack();
		areaInfPack.setArea(area);
		return areaInfMapper.selectAreaInf_area(areaInfPack);
	}
	
	@Override
	public List<QuotaData> getDayQData(String siid, Date startdate, Date enddate)
			throws Exception {
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		return quotaDataMapper.selectQuotaData_b_date(datePack);
	}

	@Override
	public List<QuotaData> getWeekQData(String siid, Date startdate,
			Date enddate) throws Exception {
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		return weekQDataMapper.selectWeekQData_b_date(datePack);
	}

	@Override
	public List<QuotaData> getMonthQData(String siid, Date startdate,
			Date enddate) throws Exception {
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(startdate);
		datePack.setDate2(enddate);
		return monthQDataMapper.selectMonthQData_b_date(datePack);
	}

	@Override
	public List<BlockHistoryData> getHistoryData_industry(String cname)
			throws Exception {
		return industryLatestMapper.selectHistoryData_industry(cname);
	}

	@Override
	public List<BlockHistoryData> getHistoryData_concept(String cname)
			throws Exception {
		return conceptLatestMapper.selectHistoryData_concept(cname);
	}

	@Override
	public List<BlockHistoryData> getHistoryData_area(String area) throws Exception {
		return areaLatestMapper.selectHistoryData_area(area);
	}
}
