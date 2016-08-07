package data;

import java.sql.Date;
import java.util.List;

import po.QuotaData;

public interface QuotaService {
	/**由siid和日期范围获得日指标数据*/
	public List<QuotaData> getDayQData(String siid,Date startdate,Date enddate) throws Exception;
	/**由siid和日期范围获得周指标数据*/
	public List<QuotaData> getWeekQData(String siid,Date startdate,Date enddate) throws Exception;
	/**由siid和日期范围获得月指标数据*/
	public List<QuotaData> getMonthQData(String siid,Date startdate,Date enddate) throws Exception;

}
