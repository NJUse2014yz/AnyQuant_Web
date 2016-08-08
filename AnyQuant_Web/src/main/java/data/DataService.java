package data;

import java.sql.Date;
import java.util.List;

import po.AreaInf;
import po.ConceptInf;
import po.HistoryData;
import po.IndiceInf;
import po.IndustryInf;
import po.QuotaData;
import po.BlockHistoryData;
import po.StockInf;

public interface DataService {
	/**股票列表*/
	public List<StockInf> getStockList() throws Exception;
	/**指数列表*/
	public List<IndiceInf> getIndiceList() throws Exception;
	/**行业列表*/
	public List<String> getIndustryList() throws Exception;
	/**概念列表*/
	public List<String> getConceptList() throws Exception;
	/**地域列表*/
	public List<String> getAreaList() throws Exception;
	
	/**由sid得到sname*/
	public StockInf getStockInf_sid(String sid) throws Exception;
	/**由iid得到iname*/
	public IndiceInf getIndiceInf_iid(String iid) throws Exception;
	
	/**最新的日历史数据 type="s"(股票)或"i"(指数)*/
	public HistoryData getHistoryData_new(String type,String gid) throws Exception;
	/**最新的日历史数据 */
	public HistoryData getHistoryData_new_single(String siid) throws Exception;
	/**最新的日历史数据 */
	public List<HistoryData> getHistoryData_new_list(List<String> list) throws Exception;
	/**由股票代码获取一段时间的基本历史数据,大盘为sh000001和sz399001*/
	public List<HistoryData> getHistoryStockData_siidTime(String siid,Date startdate,Date enddate) throws Exception;
	/**由代码和日期获得周历史数据*/
	public List<HistoryData> getWeekHData(String siid,Date startdate,Date enddate) throws Exception;
	/**由代码和日期获得月历史数据*/
	public List<HistoryData> getMonthHData(String siid,Date startdate,Date enddate) throws Exception;
	
	/**由sid获得行业股票信息*/
	public List<IndustryInf> getIndustryInf_sid(String sid) throws Exception;
	/**由行业名字获得行业股票信息*/
	public List<IndustryInf> getIndustryInf_cname(String cname) throws Exception;
	/**由行业名字获得所有该行业所有股票的历史信息*/
	public List<BlockHistoryData> getHistoryData_industry(String cname) throws Exception;
	
	/**由sid获得概念股票信息*/
	public List<ConceptInf> getConceptInf_sid(String sid) throws Exception;
	/**由概念名字获得概念股票信息*/
	public List<ConceptInf> getConceptInf_cname(String cname) throws Exception;
	/**由概念名字获得所有该行业所有股票的历史信息*/
	public List<BlockHistoryData> getHistoryData_concept(String cname) throws Exception;
	
	/**由sid获得地域股票信息*/
	public List<AreaInf> getAreaInf_sid(String sid) throws Exception;
	/**由地域名字获得地域股票信息*/
	public List<AreaInf> getAreaInf_area(String area) throws Exception;
	/**由地域名字获得所有该行业所有股票的历史信息*/
	public List<BlockHistoryData> getHistoryData_area(String area) throws Exception;
	
	/**由siid和日期范围获得日指标数据*/
	public List<QuotaData> getDayQData(String siid,Date startdate,Date enddate) throws Exception;
	/**由siid和日期范围获得周指标数据*/
	public List<QuotaData> getWeekQData(String siid,Date startdate,Date enddate) throws Exception;
	/**由siid和日期范围获得月指标数据*/
	public List<QuotaData> getMonthQData(String siid,Date startdate,Date enddate) throws Exception;
}
