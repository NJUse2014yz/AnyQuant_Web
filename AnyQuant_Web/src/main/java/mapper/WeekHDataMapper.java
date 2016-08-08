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
	
	/**查找周历史基本数据-(包括)边界*/
	public List<HistoryData> selectWeekHData_b_date(DatePack datePack) throws Exception;
}
