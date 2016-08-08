package mapper;

import java.util.List;

import po.HistoryData;
import po.HistoryDataPack;
import po.BlockHistoryData;

public interface AreaLatestMapper {
	/**查找该地域对应的所有股票最新历史信息*/
	public List<BlockHistoryData> selectHistoryData_area(String area) throws Exception;
}
