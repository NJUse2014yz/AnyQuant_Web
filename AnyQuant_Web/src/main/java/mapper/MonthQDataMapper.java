package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.QuotaData;
import po.QuotaDataPack;

/**
 * @table monthqdata_${siid} monthhdata_${siid}
 * @po quotadata
 * @function 创删表、插删查信息
 * @author YU Fan
 * @date 2016年5月21日
 */
public interface MonthQDataMapper {
	/**查找一个时间范围内有多少条数据*/
	public int countMonthQData_b_date(DatePack datePack) throws Exception;
	/**查找历史基本数据-一个日期之前固定条数*/
	public List<QuotaData> selectMonthQData_num_date(DatePack datePack) throws Exception;
	
	/**查找月指标数据-=date*/
	public QuotaData selectMonthQData_e_date(DatePack datePack) throws Exception;
	/**查找月指标数据->=date*/
	public List<QuotaData> selectMonthQData_ge_date(DatePack datePack) throws Exception;
	/**查找月指标数据-<=date*/
	public List<QuotaData> selectMonthQData_le_date(DatePack datePack) throws Exception;
	/**查找月指标数据->date*/
	public List<QuotaData> selectMonthQData_g_date(DatePack datePack) throws Exception;
	/**查找月指标数据-<date*/
	public List<QuotaData> selectMonthQData_l_date(DatePack datePack) throws Exception;
	/**查找月指标数据-(包括)边界*/
	public List<QuotaData> selectMonthQData_b_date(DatePack datePack) throws Exception;
	
	/**查找历史基本数据-一个id之前固定条数*/
	public List<QuotaData> selectMonthQData_num_monthid(DatePack datePack) throws Exception;
	/**查找月指标数据-=id*/
	public QuotaData selectMonthQData_e_monthid(DatePack datePack) throws Exception;
	/**查找月指标数据-<=id*/
	public List<QuotaData> selectMonthQData_le_monthid(DatePack datePack) throws Exception;
	/**查找月指标数据-<=>id*/
	public List<QuotaData> selectMonthQData_b_monthid(DatePack datePack) throws Exception;
	
}
