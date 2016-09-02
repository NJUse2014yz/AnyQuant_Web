package po;

import java.util.List;

public class QuotaDataPack {
	/**要用的代码*/
	private String siid;
	/**要用的指标数据列表*/
	private List<QuotaData> list;
	/**要用的单条指标数据 或 下界*/
	private QuotaData quotaData1;
	/**上界*/
	private QuotaData quotaData2;
	
	public QuotaDataPack() {
		this.siid = null;
		this.list = null;
		this.quotaData1 = null;
		this.quotaData2 = null;
	}
	public QuotaDataPack(String siid, List<QuotaData> list,
			QuotaData quotaData1, QuotaData quotaData2) {
		this();
		this.siid = siid;
		this.list = list;
		this.quotaData1 = quotaData1;
		this.quotaData2 = quotaData2;
	}
	
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public List<QuotaData> getList() {
		return list;
	}
	public void setList(List<QuotaData> list) {
		this.list = list;
	}
	public QuotaData getQuotaData1() {
		return quotaData1;
	}
	public void setQuotaData1(QuotaData quotaData1) {
		this.quotaData1 = quotaData1;
	}
	public QuotaData getQuotaData2() {
		return quotaData2;
	}
	public void setQuotaData2(QuotaData quotaData2) {
		this.quotaData2 = quotaData2;
	}
	
	@Override
	public String toString() {
		return "QuotaDataPack [siid=" + siid + ", list=" + list
				+ ", quotaData1=" + quotaData1 + ", quotaData2=" + quotaData2
				+ "]";
	}
}
