package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.QuotaData;
import po.QuotaDataPack;
import po.StockInf;

/**
 * @table weekqdata_${siid} weekqdata_${siid}
 * @po quotadata
 * @function 创删表、插删查信息
 * @author YU Fan
 * @date 2016年5月21日
 */
public interface WeekQDataMapper {
	public void dropAll(List<String> list) throws Exception;
	
	/**创建周指标数据表*/
	public void createWeekQDataTable(String siid) throws Exception;
	/**删除周指标数据表*/
	public void dropWeekQDataTable(String siid) throws Exception;
	
	/**插入周指标数据-单条*/
	public void insertWeekQData_single(QuotaDataPack quotaDataPack) throws Exception;
	/**插入周指标数据-多条*/
	public void insertWeekQData_list(QuotaDataPack quotaDataPack) throws Exception;
	
	/**删除周指标数据-=date*/
	public void deleteWeekQData_e_date(DatePack datePack) throws Exception;
	
	/**查找一个时间范围内有多少条数据*/
	public int countWeekQData_b_date(DatePack datePack) throws Exception;
	/**查找历史基本数据-一个日期之前固定条数*/
	public List<QuotaData> selectWeekQData_num_date(DatePack datePack) throws Exception;
	
	/**查找周指标数据-=date*/
	public QuotaData selectWeekQData_e_date(DatePack datePack) throws Exception;
	/**查找周指标数据->=date*/
	public List<QuotaData> selectWeekQData_ge_date(DatePack datePack) throws Exception;
	/**查找周指标数据-<=date*/
	public List<QuotaData> selectWeekQData_le_date(DatePack datePack) throws Exception;
	/**查找周指标数据->date*/
	public List<QuotaData> selectWeekQData_g_date(DatePack datePack) throws Exception;
	/**查找周指标数据-<date*/
	public List<QuotaData> selectWeekQData_l_date(DatePack datePack) throws Exception;
	/**查找周指标数据-(包括)边界*/
	public List<QuotaData> selectWeekQData_b_date(DatePack datePack) throws Exception;
	
	/**查找历史基本数据-一个id之前固定条数*/
	public List<QuotaData> selectWeekQData_num_weekid(DatePack datePack) throws Exception;
	/**查找周指标数据-=id*/
	public QuotaData selectWeekQData_e_weekid(DatePack datePack) throws Exception;
	/**查找周指标数据-<=id*/
	public List<QuotaData> selectWeekQData_le_weekid(DatePack datePack) throws Exception;
	/**查找周指标数据-<=>id*/
	public List<QuotaData> selectWeekQData_b_weekid(DatePack datePack) throws Exception;
	
}
