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
