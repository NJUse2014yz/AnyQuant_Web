package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.QuotaData;
import po.QuotaDataPack;
import po.StockInf;

/**
 * @table weekqdata_${siid} weekqdata_${siid}
 * @po quotadata
 * @function 创删表、插删查信息
 * @author YU Fan
 * @date 2016年5月21日
 */
public interface WeekQDataMapper {
	/**查找一个时间范围内有多少条数据*/
	public int countWeekQData_b_date(DatePack datePack) throws Exception;
	/**查找历史基本数据-一个日期之前固定条数*/
	public List<QuotaData> selectWeekQData_num_date(DatePack datePack) throws Exception;
	
	/**查找周指标数据-=date*/
	public QuotaData selectWeekQData_e_date(DatePack datePack) throws Exception;
	/**查找周指标数据->=date*/
	public List<QuotaData> selectWeekQData_ge_date(DatePack datePack) throws Exception;
	/**查找周指标数据-<=date*/
	public List<QuotaData> selectWeekQData_le_date(DatePack datePack) throws Exception;
	/**查找周指标数据->date*/
	public List<QuotaData> selectWeekQData_g_date(DatePack datePack) throws Exception;
	/**查找周指标数据-<date*/
	public List<QuotaData> selectWeekQData_l_date(DatePack datePack) throws Exception;
	/**查找周指标数据-(包括)边界*/
	public List<QuotaData> selectWeekQData_b_date(DatePack datePack) throws Exception;
	
	/**查找历史基本数据-一个id之前固定条数*/
	public List<QuotaData> selectWeekQData_num_weekid(DatePack datePack) throws Exception;
	/**查找周指标数据-=id*/
	public QuotaData selectWeekQData_e_weekid(DatePack datePack) throws Exception;
	/**查找周指标数据-<=id*/
	public List<QuotaData> selectWeekQData_le_weekid(DatePack datePack) throws Exception;
	/**查找周指标数据-<=>id*/
	public List<QuotaData> selectWeekQData_b_weekid(DatePack datePack) throws Exception;
	
	/**查找m5*/
	public List<Double> selectM5(DatePack datePack) throws Exception;
	/**查找m10*/
	public List<Double> selectM10(DatePack datePack) throws Exception;
	/**查找m20*/
	public List<Double> selectM20(DatePack datePack) throws Exception;
	/**查找m30*/
	public List<Double> selectM30(DatePack datePack) throws Exception;
	/**查找bias5*/
	public List<Double> selectBias5(DatePack datePack) throws Exception;
	/**查找bias10*/
	public List<Double> selectBias10(DatePack datePack) throws Exception;
	/**查找bias20*/
	public List<Double> selectBias20(DatePack datePack) throws Exception;
	/**查找boll1*/
	public List<Double> selectBoll1(DatePack datePack) throws Exception;
	/**查找boll2*/
	public List<Double> selectBoll2(DatePack datePack) throws Exception;
	/**查找boll3*/
	public List<Double> selectBoll3(DatePack datePack) throws Exception;
	/**查找rsi*/
	public List<Double> selectRsi(DatePack datePack) throws Exception;
	/**查找rsi5*/
	public List<Double> selectRsi5(DatePack datePack) throws Exception;
	/**查找rsi10*/
	public List<Double> selectRsi10(DatePack datePack) throws Exception;
	/**查找rsi20*/
	public List<Double> selectRsi20(DatePack datePack) throws Exception;
	/**查找vr*/
	public List<Double> selectVr(DatePack datePack) throws Exception;
	/**查找rsv*/
	public List<Double> selectRsv(DatePack datePack) throws Exception;
	/**查找k*/
	public List<Double> selectK(DatePack datePack) throws Exception;
	/**查找d*/
	public List<Double> selectD(DatePack datePack) throws Exception;
	/**查找j*/
	public List<Double> selectJ(DatePack datePack) throws Exception;
	/**查找ema12*/
	public List<Double> selectEma12(DatePack datePack) throws Exception;
	/**查找ema26*/
	public List<Double> selectEma26(DatePack datePack) throws Exception;
	/**查找ema50*/
	public List<Double> selectEma50(DatePack datePack) throws Exception;
	/**查找ema5*/
	public List<Double> selectEma5(DatePack datePack) throws Exception;
	/**查找ema35*/
	public List<Double> selectEma35(DatePack datePack) throws Exception;
	/**查找ema10*/
	public List<Double> selectEma10(DatePack datePack) throws Exception;
	/**查找ema60*/
	public List<Double> selectEma60(DatePack datePack) throws Exception;
	/**查找diff*/
	public List<Double> selectDiff(DatePack datePack) throws Exception;
	/**查找dea*/
	public List<Double> selectDea(DatePack datePack) throws Exception;
	/**查找macd*/
	public List<Double> selectMacd(DatePack datePack) throws Exception;
	/**查找dmh*/
	public List<Double> selectDmh(DatePack datePack) throws Exception;
	/**查找dml*/
	public List<Double> selectDml(DatePack datePack) throws Exception;
	/**查找tr*/
	public List<Double> selectTr(DatePack datePack) throws Exception;
	/**查找dmh12*/
	public List<Double> selectDmh12(DatePack datePack) throws Exception;
	/**查找dml12*/
	public List<Double> selectDml12(DatePack datePack) throws Exception;
	/**查找tr12*/
	public List<Double> selectTr12(DatePack datePack) throws Exception;
	/**查找dih*/
	public List<Double> selectDih(DatePack datePack) throws Exception;
	/**查找dil*/
	public List<Double> selectDil(DatePack datePack) throws Exception;
	/**查找dih12*/
	public List<Double> selectDih12(DatePack datePack) throws Exception;
	/**查找dil12*/
	public List<Double> selectDil12(DatePack datePack) throws Exception;
	/**查找dx*/
	public List<Double> selectDx(DatePack datePack) throws Exception;
	/**查找adx*/
	public List<Double> selectAdx(DatePack datePack) throws Exception;
	/**查找adxr*/
	public List<Double> selectAdxr(DatePack datePack) throws Exception;
	/**查找obv*/
	public List<Double> selectObv(DatePack datePack) throws Exception;
	/**查找roc12*/
	public List<Double> selectRoc12(DatePack datePack) throws Exception;
	/**查找roc25*/
	public List<Double> selectRoc25(DatePack datePack) throws Exception;

}
