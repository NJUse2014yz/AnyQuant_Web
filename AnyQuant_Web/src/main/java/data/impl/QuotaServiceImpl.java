package data.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.MonthQDataMapper;
import mapper.QuotaDataMapper;
import mapper.WeekQDataMapper;
import po.DatePack;
import po.QuotaData;
import data.QuotaService;

public class QuotaServiceImpl implements QuotaService {
	private ApplicationContext applicationContext;
	private QuotaDataMapper quotaDataMapper;
	private WeekQDataMapper weekQDataMapper;
	private MonthQDataMapper monthQDataMapper;
	
	public QuotaServiceImpl()
	{
		applicationContext =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		
		quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");
		weekQDataMapper=(WeekQDataMapper) applicationContext.getBean("weekQDataMapper");
		monthQDataMapper=(MonthQDataMapper) applicationContext.getBean("monthQDataMapper");
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

}
