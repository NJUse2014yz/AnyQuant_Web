package mapper;

import java.util.List;

import po.HistoryData;
import po.HistoryDataPack;
import po.BlockHistoryData;

public interface IndustryLatestMapper {
	public void createLatestDataTable() throws Exception;
	public void initLatestData() throws Exception;
	public void updateLatestData(HistoryDataPack historyDataPack) throws Exception;
	/**查找该行业对应的所有股票最新历史信息*/
	public List<BlockHistoryData> selectHistoryData_industry(String cname) throws Exception;
}
