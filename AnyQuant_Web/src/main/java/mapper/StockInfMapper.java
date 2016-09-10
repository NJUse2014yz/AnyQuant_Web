package mapper;

import java.util.List;

import po.StockInf;
import po.StockPair;
/**
 * @table stockinf
 * @po StockInf
 * @function 创删表、插删查信息
 * @author YU Fan
 * @date 2016年5月19日
 */
public interface StockInfMapper {
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
	/**查找配对性最好的股票对*/
	public StockPair selectStockPair() throws Exception;
	
}
