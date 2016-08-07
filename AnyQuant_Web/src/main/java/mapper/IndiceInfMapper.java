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
	/**创建指数表*/
	public void createIndiceInfTable() throws Exception;
	/**删除指数表*/
	public void dropIndiceInfTable() throws Exception;
	/**初始化指数表-清空*/
	public void deleteIndiceInfTable() throws Exception;
	/**初始化指数表-插入*/
	public void initIndiceInfTable() throws Exception;
	
	/**插入指数信息-单条*/
	public void insertIndiceInf_single(IndiceInf indiceInf) throws Exception;
	/**插入指数信息-多条*/
	public void insertIndiceInf_list(List<IndiceInf> list) throws Exception;
	
	/**删除指数信息-=id*/
	public void deleteIndiceInf_e_id(int id) throws Exception;
	/**删除指数信息-=iid*/
	public void deleteIndiceInf_e_iid(String iid) throws Exception;
	/**删除指数信息-=iname*/
	public void deleteIndiceInf_e_iname(String iname) throws Exception;
	
	/**更新指数信息date hisid weekid monthid-=iid*/
	public void updateIndiceInfDateHWMid_e_iid(IndiceInf indiceInf) throws Exception;
	/**更新指数信息quoid-=IndiceInf.iid IndiceInf.quoid*/
	public void updateIndiceInfQuoid_e_iid(IndiceInf indiceInf) throws Exception;
	/**更新指数信息weekhisid-=IndiceInf.iid IndiceInf.weekhisid*/
	public void updateIndiceInfWeekhisid_e_iid(IndiceInf indiceInf) throws Exception;
	/**更新指数信息weekquoid-=IndiceInf.iid IndiceInf.weekquoid*/
	public void updateIndiceInfWeekquoid_e_iid(IndiceInf indiceInf) throws Exception;
	/**更新指数信息monthhisid-=IndiceInf.iid IndiceInf.monthhisid*/
	public void updateIndiceInfMonthhisid_e_iid(IndiceInf indiceInf) throws Exception;
	/**更新指数信息monthquoid-=IndiceInf.iid IndiceInf.monthquoid*/
	public void updateIndiceInfMonthquoid_e_iid(IndiceInf indiceInf) throws Exception;
	
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
