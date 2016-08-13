package backtest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import po.HistoryData;
import po.QuotaData;

public class HisQuoPack {
	public List<HistoryData> hislist;
	public List<QuotaData> quolist;
	
	public HisQuoPack() 
	{
		super();
		this.hislist = new ArrayList<HistoryData>();
		this.quolist = new ArrayList<QuotaData>();
	}
	public HisQuoPack(List<HistoryData> hislist, List<QuotaData> quolist) {
		super();
		this.hislist = hislist;
		this.quolist = quolist;
	}
	@Override
	public String toString() {
		return "HisQuoPack [hislist=" + hislist
				+ ", quolist=" + quolist + "]";
	}
	
}
