package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import mapper.IndiceInfMapper;
import mapper.StockInfMapper;
import mapper.HistoryDataMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.DatePack;
import po.HistoryData;
import po.HistoryDataPack;
import po.IndiceInf;
import po.StockInf;

public class HistoryDataPr {
	private ApplicationContext applicationContext;
	private HistoryDataMapper historyDataMapper;
	private StockInfMapper stockInfMapper;
	private IndiceInfMapper indiceInfMapper;
	
	/**创建对象时为mapper注入对象*/
	public HistoryDataPr()
	{
		applicationContext =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		historyDataMapper=(HistoryDataMapper) applicationContext.getBean("historyDataMapper");
		stockInfMapper=(StockInfMapper)applicationContext.getBean("stockInfMapper");
		indiceInfMapper=(IndiceInfMapper)applicationContext.getBean("indiceInfMapper");
	}
	
	
	/**获取最近的历史数据 */
	public HistoryData getHistoryData_new(String type,String siid) throws Exception
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
		return historyDataMapper.selectHistoryData_e_date(datePack);
	}
}
