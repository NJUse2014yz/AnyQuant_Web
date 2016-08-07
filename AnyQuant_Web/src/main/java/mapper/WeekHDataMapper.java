package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.HistoryDataPack;

public interface WeekHDataMapper {
	public void dropAll(List<String> list) throws Exception;
	/**创建周历史数据表*/
	public void createWeekHDataTable(String siid);
	/**删除周历史数据表*/
	public void dropWeekHDataTable(String siid);
	
	/**插入周历史数据_list*/
	public void insertWeekHData_list(HistoryDataPack historyDataPack) throws Exception;
	
	/**删除周历史基本数据-=weekid*/
	public void deleteWeekHData_e_weekid(DatePack datePack) throws Exception;
	
	/**查找周历史基本数据-一个weekid之前固定条数*/
	public List<HistoryData> selectWeekHData_num_weekid(DatePack datePack) throws Exception;
	/**查找周历史基本数据-=weekid*/
	public HistoryData selectWeekHData_e_weekid(DatePack datePack) throws Exception;
	/**查找周历史基本数据-<=weekid*/
	public List<HistoryData> selectWeekHData_le_weekid(DatePack datePack) throws Exception;
	
	/**查找周历史基本数据-(包括)边界*/
	public List<HistoryData> selectWeekHData_b_date(DatePack datePack) throws Exception;
}
