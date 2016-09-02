package po;

import java.util.List;
/**
 * @for 历史数据的包装
 * @member 要用的代码 siid,要用的历史基本数据列表 list,要用的单条历史基本数据 或 下界 historyStockData1,上界 historyStockData2
 * @author YU Fan
 * @date 2016年5月19日
 */
public class HistoryDataPack {
	/**要用的代码*/
	private String siid;
	/**要用的历史基本数据列表*/
	private List<HistoryData> list;
	/**要用的单条历史基本数据 或 下界*/
	private HistoryData historyData1;
	/**上界*/
	private HistoryData historyData2;
	
	public HistoryDataPack()
	{
		super();
		this.siid = null;
		this.list = null;
		this.historyData1 = null;
		this.historyData2 = null;
	}
	public HistoryDataPack(String siid, List<HistoryData> list,
			HistoryData historyData1, HistoryData historyData2) {
		this();
		this.siid = siid;
		this.list = list;
		this.historyData1 = historyData1;
		this.historyData2 = historyData2;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public List<HistoryData> getList() {
		return list;
	}
	public void setList(List<HistoryData> list) {
		this.list = list;
	}
	public HistoryData getHistoryData1() {
		return historyData1;
	}
	public void setHistoryData1(HistoryData historyData1) {
		this.historyData1 = historyData1;
	}
	public HistoryData getHistoryData2() {
		return historyData2;
	}
	public void setHistoryData2(HistoryData historyData2) {
		this.historyData2 = historyData2;
	}

	@Override
	public String toString() {
		return "HistoryDataPack [siid=" + siid + ", list=" + list
				+ ", historyData1=" + historyData1 + ", historyData2="
				+ historyData2 + "]";
	}
}
