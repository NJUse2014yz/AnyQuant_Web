package mapper;

import java.util.List;

import po.DatePack;
import po.HistoryData;
import po.QuotaData;
import po.QuotaDataPack;
import po.StockInf;

/**
 * @table quotadata_${siid} historydata_${siid}
 * @po quotadata
 * @function 创删表、插删查信息
 * @author YU Fan
 * @date 2016年5月21日
 */
public interface QuotaDataMapper {
	/**查找一个时间范围内有多少条数据*/
	public int countQuotaData_b_date(DatePack datePack) throws Exception;
	
	/**查找最新指标数据*/
	public QuotaData selectQuotaData_new(String siid) throws Exception;
	public QuotaData selectQuotaData_latest(DatePack datePack) throws Exception;
	
	/**查找历史基本数据-一个日期之前固定条数*/
	public List<QuotaData> selectQuotaData_num_date(DatePack datePack) throws Exception;
	/**查找指标数据-=date*/
	public QuotaData selectQuotaData_e_date(DatePack datePack) throws Exception;
	/**查找指标数据->=date*/
	public List<QuotaData> selectQuotaData_ge_date(DatePack datePack) throws Exception;
	/**查找指标数据-<=date*/
	public List<QuotaData> selectQuotaData_le_date(DatePack datePack) throws Exception;
	/**查找指标数据->date*/
	public List<QuotaData> selectQuotaData_g_date(DatePack datePack) throws Exception;
	/**查找指标数据-<date*/
	public List<QuotaData> selectQuotaData_l_date(DatePack datePack) throws Exception;
	/**查找指标数据-(包括)边界*/
	public List<QuotaData> selectQuotaData_b_date(DatePack datePack) throws Exception;
	
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

	/**查找历史基本数据-一个id之前固定条数*/
	public List<QuotaData> selectQuotaData_num_id(DatePack datePack) throws Exception;
	/**查找指标数据-=id*/
	public QuotaData selectQuotaData_e_id(DatePack datePack) throws Exception;
	/**查找指标数据-<=id*/
	public List<QuotaData> selectQuotaData_le_id(DatePack datePack) throws Exception;
	/**查找指标数据-<=>id*/
	public List<QuotaData> selectQuotaData_b_id(DatePack datePack) throws Exception;
	
	/**查找bias5历史最大值*/
	public double selectBias5Max_b_date(DatePack datePack) throws Exception;
	/**查找bias5历史最小值*/
	public double selectBias5Min_b_date(DatePack datePack) throws Exception;
	
	/**查找bias10历史最大值*/
	public double selectBias10Max_b_date(DatePack datePack) throws Exception;
	/**查找bias10历史最小值*/
	public double selectBias10Min_b_date(DatePack datePack) throws Exception;
	
	/**查找bias20历史最大值*/
	public double selectBias20Max_b_date(DatePack datePack) throws Exception;
	/**查找bias20历史最小值*/
	public double selectBias20Min_b_date(DatePack datePack) throws Exception;
	
	/**查找正值bias5按从小到大排序*/
	public List<Double> selectBias5Posi_12_b_date(DatePack datePack) throws Exception;
	/**查找正值bias5按从大到小排序*/
	public List<Double> selectBias5Posi_21_b_date(DatePack datePack) throws Exception;
	/**查找负值bias5按从小到大排序*/
	public List<Double> selectBias5Nega_12_b_date(DatePack datePack) throws Exception;
	/**查找负值bias5按从大到小排序*/
	public List<Double> selectBias5Nega_21_b_date(DatePack datePack) throws Exception;
	
	/**查找正值bias10按从小到大排序*/
	public List<Double> selectBias10Posi_12_b_date(DatePack datePack) throws Exception;
	/**查找正值bias10按从大到小排序*/
	public List<Double> selectBias10Posi_21_b_date(DatePack datePack) throws Exception;
	/**查找负值bias10按从小到大排序*/
	public List<Double> selectBias10Nega_12_b_date(DatePack datePack) throws Exception;
	/**查找负值bias10按从大到小排序*/
	public List<Double> selectBias10Nega_21_b_date(DatePack datePack) throws Exception;
	
	/**查找正值bias20按从小到大排序*/
	public List<Double> selectBias20Posi_12_b_date(DatePack datePack) throws Exception;
	/**查找正值bias20按从大到小排序*/
	public List<Double> selectBias20Posi_21_b_date(DatePack datePack) throws Exception;
	/**查找负值bias20按从小到大排序*/
	public List<Double> selectBias20Nega_12_b_date(DatePack datePack) throws Exception;
	/**查找负值bias20按从大到小排序*/
	public List<Double> selectBias20Nega_21_b_date(DatePack datePack) throws Exception;
	
	/**查找rsi从小到大排序*/
	public List<Double> selectRsi_12_b_date(DatePack datePack) throws Exception;
	/**查找rsi5从小到大排序*/
	public List<Double> selectRsi5_12_b_date(DatePack datePack) throws Exception;
	/**查找rsi10从小到大排序*/
	public List<Double> selectRsi10_12_b_date(DatePack datePack) throws Exception;
	/**查找rsi20从小到大排序*/
	public List<Double> selectRsi20_12_b_date(DatePack datePack) throws Exception;
	
	/**查找obv-自一个日期往前一定数量*/
	public List<Double> selectObv_num_date(DatePack datePack) throws Exception;
	public List<Double> selectObv_num_id(DatePack datePack) throws Exception;
	/**查找boll1-自一个日期往前一定数量*/
	public List<Double> selectBoll1_num_date(DatePack datePack) throws Exception;
	public List<Double> selectBoll1_num_id(DatePack datePack) throws Exception;
	/**查找boll2-自一个日期往前一定数量*/
	public List<Double> selectBoll2_num_date(DatePack datePack) throws Exception;
	public List<Double> selectBoll2_num_id(DatePack datePack) throws Exception;
	/**查找boll3-自一个日期往前一定数量*/
	public List<Double> selectBoll3_num_date(DatePack datePack) throws Exception;
	public List<Double> selectBoll3_num_id(DatePack datePack) throws Exception;
	
	/**查找roc12-自一个日期往前一定数量*/
	public List<Double> selectRoc12_num_date(DatePack datePack) throws Exception;
	public List<Double> selectRoc12_num_id(DatePack datePack) throws Exception;
	public List<Double> selectRoc12_12_b_date(DatePack datePack) throws Exception;
	/**查找roc25-自一个日期往前一定数量*/
	public List<Double> selectRoc25_num_date(DatePack datePack) throws Exception;
	public List<Double> selectRoc25_num_id(DatePack datePack) throws Exception;
	public List<Double> selectRoc25_12_b_date(DatePack datePack) throws Exception;
	/**查找dmh-自一个日期往前一定数量*/
	public List<Double> selectDmh_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDmh_num_id(DatePack datePack) throws Exception;
	/**查找dml-自一个日期往前一定数量*/
	public List<Double> selectDml_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDml_num_id(DatePack datePack) throws Exception;
	/**查找dih-自一个日期往前一定数量*/
	public List<Double> selectDih_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDih_num_id(DatePack datePack) throws Exception;
	/**查找dil-自一个日期往前一定数量*/
	public List<Double> selectDil_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDil_num_id(DatePack datePack) throws Exception;
	/**查找dih12-自一个日期往前一定数量*/
	public List<Double> selectDih12_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDih12_num_id(DatePack datePack) throws Exception;
	/**查找dil12-自一个日期往前一定数量*/
	public List<Double> selectDil12_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDil12_num_id(DatePack datePack) throws Exception;
	/**查找dx-自一个日期往前一定数量*/
	public List<Double> selectDx_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDx_num_id(DatePack datePack) throws Exception;
	/**查找adx-自一个日期往前一定数量*/
	public List<Double> selectAdx_num_date(DatePack datePack) throws Exception;
	public List<Double> selectAdx_num_id(DatePack datePack) throws Exception;
	/**查找adxr-自一个日期往前一定数量*/
	public List<Double> selectAdxr_num_date(DatePack datePack) throws Exception;
	public List<Double> selectAdxr_num_id(DatePack datePack) throws Exception;
	/**查找diff-自一个日期往前一定数量*/
	public List<Double> selectDiff_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDiff_num_id(DatePack datePack) throws Exception;
	/**查找dea-自一个日期往前一定数量*/
	public List<Double> selectDea_num_date(DatePack datePack) throws Exception;
	public List<Double> selectDea_num_id(DatePack datePack) throws Exception;
	/**查找macd-自一个日期往前一定数量*/
	public List<Double> selectMacd_num_date(DatePack datePack) throws Exception;
	public List<Double> selectMacd_num_id(DatePack datePack) throws Exception;
	
	/**查找vr从小到大排序*/
	public List<Double> selectVr_12_b_date(DatePack datePack) throws Exception;
}

