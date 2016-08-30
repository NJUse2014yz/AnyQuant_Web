package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.HistoryDataPack;

public interface WeekHDataMapper {
	/**查找周历史基本数据-一个weekid之前固定条数*/
	public List<HistoryData> selectWeekHData_num_weekid(DatePack datePack) throws Exception;
	/**查找周历史基本数据-=weekid*/
	public HistoryData selectWeekHData_e_weekid(DatePack datePack) throws Exception;
	/**查找周历史基本数据-<=weekid*/
	public List<HistoryData> selectWeekHData_le_weekid(DatePack datePack) throws Exception;
	
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

	
	/**查找周历史基本数据-(包括)边界*/
	public List<HistoryData> selectWeekHData_b_date(DatePack datePack) throws Exception;
}
