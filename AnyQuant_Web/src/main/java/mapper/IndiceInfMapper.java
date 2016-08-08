package mapper;

import java.util.List;

import po.IndiceInf;
import po.StockInf;

/**
 * @table indiceinf
 * @po IndiceInf
 * @function 创删表、插删查信息
 * @author YU Fan
 * @date 2016年5月19日
 */
public interface IndiceInfMapper {
	/**查找指数数量*/
	public int countIndiceInf() throws Exception;
	/**查找指数信息-=id*/
	public IndiceInf selectIndiceInf_e_id(int id) throws Exception;
	/**查找指数信息-=iid*/
	public IndiceInf selectIndiceInf_e_iid(String iid) throws Exception;
	/**查找指数信息-=iname*/
	public IndiceInf selectIndiceInf_e_iname(String iname) throws Exception;
	/**查找指数信息->=id*/
	public List<IndiceInf> selectIndiceInf_ge_id(int id) throws Exception;
	/**查找指数信息-<=id*/
	public List<IndiceInf> selectIndiceInf_le_id(int id) throws Exception;
	/**查找指数信息->id*/
	public List<IndiceInf> selectIndiceInf_g_id(int id) throws Exception;
	/**查找指数信息-<id*/
	public List<IndiceInf> selectIndiceInf_l_id(int id) throws Exception;
	/**查找指数信息-全部*/
	public List<IndiceInf> selectIndiceInf_all() throws Exception;
}
