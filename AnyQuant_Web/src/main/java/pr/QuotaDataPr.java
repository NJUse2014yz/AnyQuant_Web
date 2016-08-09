package pr;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.DatePack;
import po.HistoryData;
import po.QuotaData;
import mapper.HistoryDataMapper;
import mapper.IndiceInfMapper;
import mapper.MonthHDataMapper;
import mapper.MonthQDataMapper;
import mapper.QuotaDataMapper;
import mapper.StockInfMapper;
import mapper.WeekHDataMapper;
import mapper.WeekQDataMapper;

public class QuotaDataPr {
	public static ApplicationContext applicationContext;
	public static HistoryDataMapper historyDataMapper;
	public static QuotaDataMapper quotaDataMapper;
	public static WeekHDataMapper weekHDataMapper;
	public static WeekQDataMapper weekQDataMapper;
	public static MonthHDataMapper monthHDataMapper;
	public static MonthQDataMapper monthQDataMapper;
	public static StockInfMapper stockInfMapper;
	public static IndiceInfMapper indiceInfMapper;
	public static List<HistoryData> hisList;//全部历史数据
	public static List<QuotaData> quoList;//已有全部指标数据
	public static List<QuotaData> newquoList;
	public static int quoid;
	public static int hisid;
	
	/**创建对象时为mapper注入对象*/
	public QuotaDataPr()
	{
		applicationContext =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
		quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");
		weekHDataMapper=(WeekHDataMapper) applicationContext.getBean("weekHDataMapper");
		weekQDataMapper=(WeekQDataMapper) applicationContext.getBean("weekQDataMapper");
		monthHDataMapper=(MonthHDataMapper) applicationContext.getBean("monthHDataMapper");
		monthQDataMapper=(MonthQDataMapper) applicationContext.getBean("monthQDataMapper");
		stockInfMapper=(StockInfMapper) applicationContext.getBean("stockInfMapper");
		indiceInfMapper=(IndiceInfMapper) applicationContext.getBean("indiceInfMapper");
		hisList=null;
		quoList=null;
		newquoList=new ArrayList<QuotaData>();
		quoid=-1;
		hisid=-1;
	}
	
	/**获取最新指标数据*/
	public static QuotaData getQuotaData_new(String type,String siid) throws Exception
	{
		Date date=null;
		if(type.equals("s"))
		{
			date=stockInfMapper.selectStockInf_e_sid(siid).getDate();
		}
		else if(type.equals("i"))
		{
			date=indiceInfMapper.selectIndiceInf_e_iid(siid).getDate();
		}
		if(date==null)
		{
			return null;
		}
		
		DatePack datePack=new DatePack();
		datePack.setSiid(siid);
		datePack.setDate1(date);
		return quotaDataMapper.selectQuotaData_e_date(datePack);
	}
}
