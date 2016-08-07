package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.HistoryDataPack;

public interface MonthHDataMapper {
	public void dropAll(List<String> list) throws Exception;
	/**创建月历史数据表*/
	public void createMonthHDataTable(String siid);
	/**删除月历史数据表*/
	public void dropMonthHDataTable(String siid);
	
	/**插入月历史数据_list*/
	public void insertMonthHData_list(HistoryDataPack historyDataPack) throws Exception;
	
	/**删除月历史基本数据-=monthid*/
	public void deleteMonthHData_e_monthid(DatePack datePack) throws Exception;
	
	/**查找月历史基本数据-一个monthid之前固定条数*/
	public List<HistoryData> selectMonthHData_num_monthid(DatePack datePack) throws Exception;
	/**查找月历史基本数据-=monthid*/
	public HistoryData selectMonthHData_e_monthid(DatePack datePack) throws Exception;
	/**查找月历史基本数据-<=monthid*/
	public List<HistoryData> selectMonthHData_le_monthid(DatePack datePack) throws Exception;

	/**查找月历史基本数据-(包括)边界-date*/
	public List<HistoryData> selectMonthHData_b_date(DatePack datePack) throws Exception;
}
