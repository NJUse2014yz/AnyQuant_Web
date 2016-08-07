package mapper;

import java.util.List;

import po.StockInf;
/**
 * @table stockinf
 * @po StockInf
 * @function 创删表、插删查信息
 * @author YU Fan
 * @date 2016年5月19日
 */
public interface StockInfMapper {
	/**创建股票表*/
	public void createStockInfTable() throws Exception;
	/**删除股票表*/
	public void dropStockInfTable() throws Exception;
	/**初始化股票表-清空*/
	public void initStockInfTable() throws Exception;
	
	/**插入股票信息-单条*/
	public void insertStockInf_single(StockInf stockInf) throws Exception;
	/**插入股票信息-多条*/
	public void insertStockInf_list(List<StockInf> list) throws Exception;
	
	/**删除股票信息-=id*/
	public void deleteStockInf_e_id(int id) throws Exception;
	/**删除股票信息-=sid*/
	public void deleteStockInf_e_sid(String sid) throws Exception;
	/**删除股票信息-=sname*/
	public void deleteStockInf_e_sname(String sname) throws Exception;
	
	/**更新股票信息date hisid weekid monthid-=sid*/
	public void updateStockInfDateHWMid_e_sid(StockInf stockInf) throws Exception;
	/**更新股票信息quoid-=sid*/
	public void updateStockInfQuoid_e_sid(StockInf stockInf) throws Exception;
	/**更新股票信息weekhisid-=sid*/
	public void updateStockInfWeekhisid_e_sid(StockInf stockInf) throws Exception;
	/**更新股票信息weekquoid-=sid*/
	public void updateStockInfWeekquoid_e_sid(StockInf stockInf) throws Exception;
	/**更新股票信息monthhisid-=sid*/
	public void updateStockInfMonthhisid_e_sid(StockInf stockInf) throws Exception;
	/**更新股票信息monthquoid-=sid*/
	public void updateStockInfMonthquoid_e_sid(StockInf stockInf) throws Exception;
	
	/**查找股票数量*/
	public int countStockInf() throws Exception;
	/**查找股票信息-=id*/
	public StockInf selectStockInf_e_id(int id) throws Exception;
	/**查找股票信息-=sid*/
	public StockInf selectStockInf_e_sid(String sid) throws Exception;
	/**查找股票信息-=sname*/
	public StockInf selectStockInf_e_sname(String sname) throws Exception;
	/**查找股票信息->=id*/
	public List<StockInf> selectStockInf_ge_id(int id) throws Exception;
	/**查找股票信息-<=id*/
	public List<StockInf> selectStockInf_le_id(int id) throws Exception;
	/**查找股票信息->id*/
	public List<StockInf> selectStockInf_g_id(int id) throws Exception;
	/**查找股票信息-<id*/
	public List<StockInf> selectStockInf_l_id(int id) throws Exception;
	/**查找股票信息-全部*/
	public List<StockInf> selectStockInf_all() throws Exception;
	/**查找股票信息-sid*/
	public List<String> selectStockInf_sid() throws Exception;
	
}
