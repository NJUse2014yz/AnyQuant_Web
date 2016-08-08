package mapper;

import java.util.List;

import po.HistoryData;
import po.HistoryDataPack;
import po.BlockHistoryData;

public interface ConceptLatestMapper {
	/**查找该概念对应的所有股票最新历史信息*/
	public List<BlockHistoryData> selectHistoryData_concept(String cname) throws Exception;
}
