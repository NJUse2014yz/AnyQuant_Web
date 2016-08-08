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

