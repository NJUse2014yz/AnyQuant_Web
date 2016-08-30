package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.HistoryDataPack;

public interface MonthHDataMapper {
	/**查找月历史基本数据-一个monthid之前固定条数*/
	public List<HistoryData> selectMonthHData_num_monthid(DatePack datePack) throws Exception;
	/**查找月历史基本数据-=monthid*/
	public HistoryData selectMonthHData_e_monthid(DatePack datePack) throws Exception;
	/**查找月历史基本数据-<=monthid*/
	public List<HistoryData> selectMonthHData_le_monthid(DatePack datePack) throws Exception;

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

	
	/**查找月历史基本数据-(包括)边界-date*/
	public List<HistoryData> selectMonthHData_b_date(DatePack datePack) throws Exception;
}
