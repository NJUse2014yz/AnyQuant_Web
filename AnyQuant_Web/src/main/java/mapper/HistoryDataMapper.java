package mapper;

import java.sql.Date;
import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.HistoryDataPack;
/**
 * @table historydata_${sid} historydata_${iid} historydatatrack
 * @po historydata
 * @function 创删表、插删查信息(查询数据如果没有数据一般返回为null，如果股票代码错误等抛异常)
 * @author YU Fan
 * @date 2016年5月19日
 */
public interface HistoryDataMapper {
	
	/**查找最近历史数据-siid*/
	public HistoryData selectHistoryData_new_single(String siid) throws Exception;
	/**查找最近历史数据-list(顺序与list中代码的顺序对应)*/
	public List<HistoryData> selectHistoryData_new_list(List<String> list) throws Exception;
	
	/**查找一个时间范围内有多少条数据-datePack.date1 datePack.date2*/
	public int countHistoryData_b_date(DatePack datePack) throws Exception;
	/**查找历史基本数据-一个日期之前固定条数-datePack.num datePack.siid datePack.date1(时间早的在前)*/
	public List<HistoryData> selectHistoryData_num_date(DatePack datePack) throws Exception;	
	/**查找历史基本数据-一个id之前固定条数-datePack.num datePack.siid datePack.id1(时间早的在前)*/
	public List<HistoryData> selectHistoryData_num_id(DatePack datePack) throws Exception;
	
	/**查找历史基本数据-=DatePack.date*/
	public HistoryData selectHistoryData_e_date(DatePack datePack) throws Exception;
	/**查找历史基本数据->=DatePack.date*/
	public List<HistoryData> selectHistoryData_ge_date(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=DatePack.date*/
	public List<HistoryData> selectHistoryData_le_date(DatePack datePack) throws Exception;
	/**查找历史基本数据->DatePack.date*/
	public List<HistoryData> selectHistoryData_g_date(DatePack datePack) throws Exception;
	/**查找历史基本数据-<DatePack.date*/
	public List<HistoryData> selectHistoryData_l_date(DatePack datePack) throws Exception;
	/**查找历史基本数据-(包括)边界*/
	public List<HistoryData> selectHistoryData_b_date(DatePack datePack) throws Exception;
	
	/**查找日期*/
	public List<Date> selectDate_b_date(DatePack datePack) throws Exception;
	/**查找open*/
	public List<Double> selectOpen_b_date(DatePack datePack) throws Exception;
	/**查找close*/
	public List<Double> selectClose_b_date(DatePack datePack) throws Exception;
	/**查找increase*/
	public List<Double> selectIncrease_b_date(DatePack datePack) throws Exception;
	/**查找incrPer*/
	public List<Double> selectIncrPer_b_date(DatePack datePack) throws Exception;
	/**查找low*/
	public List<Double> selectLow_b_date(DatePack datePack) throws Exception;
	/**查找high*/
	public List<Double> selectHigh_b_date(DatePack datePack) throws Exception;
	/**查找volume*/
	public List<Double> selectVolume_b_date(DatePack datePack) throws Exception;
	/**查找amount*/
	public List<Double> selectAmount_b_date(DatePack datePack) throws Exception;
	/**查找turnover*/
	public List<Double> selectTurnover_b_date(DatePack datePack) throws Exception;

	/**查找历史基本数据-=DatePack.id1*/
	public HistoryData selectHistoryData_e_id(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=DatePack.id1*/
	public List<HistoryData> selectHistoryData_le_id(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=>DatePack.id1*/
	public List<HistoryData> selectHistoryData_b_id(DatePack datePack) throws Exception;
	
	/**查找历史基本数据最近周id-datePack.siid*/
	public int selectHistoryDataWeekid(DatePack datePack) throws Exception;
	/**查找历史基本数据-=weekid*/
	public List<HistoryData> selectHistoryData_e_weekid(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=weekid*/
	public List<HistoryData> selectHistoryData_le_weekid(DatePack datePack) throws Exception;
	/**查找历史基本数据->=weekid*/
	public List<HistoryData> selectHistoryData_ge_weekid(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=>weekid*/
	public List<HistoryData> selectHistoryData_b_weekid(DatePack datePack) throws Exception;
	
	/**查找历史基本数据最近月id*/
	public int selectHistoryDataMonthid(DatePack datePack) throws Exception;
	/**查找历史基本数据-=monthid*/
	public List<HistoryData> selectHistoryData_e_monthid(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=monthid*/
	public List<HistoryData> selectHistoryData_le_monthid(DatePack datePack) throws Exception;
	/**查找历史基本数据->=monthid*/
	public List<HistoryData> selectHistoryData_ge_monthid(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=>monthid*/
	public List<HistoryData> selectHistoryData_b_monthid(DatePack datePack) throws Exception;
	
	/**查找历史基本数据最近年id*/
	public int selectHistoryDataYearid(DatePack datePack) throws Exception;
	/**查找历史基本数据-=yearid*/
	public List<HistoryData> selectHistoryData_e_yearid(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=yearid*/
	public List<HistoryData> selectHistoryData_le_yearid(DatePack datePack) throws Exception;
	/**查找历史基本数据->=yearid*/
	public List<HistoryData> selectHistoryData_ge_yearid(DatePack datePack) throws Exception;
	/**查找历史基本数据-<=>yearid*/
	public List<HistoryData> selectHistoryData_b_yearid(DatePack datePack) throws Exception;
	
	/**查找历史基本数据close-datePack.num datePack.date1*/
	public List<Double> selectHistoryDataClose_num_date(DatePack datePack) throws Exception;
	/**查找历史基本数据close-datePack.num datePack.id1*/
	public List<Double> selectHistoryDataClose_num_id(DatePack datePack) throws Exception;
	/**查找历史基本数据increase-datePack.num datePack.date1*/
	public List<Double> selectHistoryDataIncrease_num_date(DatePack datePack) throws Exception;
	/**查找历史基本数据increase-datePack.num datePack.id1*/
	public List<Double> selectHistoryDataIncrease_num_id(DatePack datePack) throws Exception;
	/**查找历史基本数据volume-datePack.num datePack.date1*/
	public List<Long> selectHistoryDataVolume_num_date(DatePack datePack) throws Exception;
	/**查找历史基本数据volume-datePack.num datePack.id1*/
	public List<Long> selectHistoryDataVolume_num_id(DatePack datePack) throws Exception;

}
