package mapper;

import java.util.List;

import po.AreaInf;
import po.AreaInfPack;

public interface AreaInfMapper {
	/**创建股票地域表*/
	public void createAreaInfTable() throws Exception;
	/**初始化地域表-areaInfPack.areaInfList*/
	public void initAreaInfTable(AreaInfPack areaInfPack) throws Exception;
	
	/**删除地域部分股票*/
	public void deleteAreaInf_st() throws Exception;
	public void deleteAreaInf_single(String sid) throws Exception;
	
	/**查找所有信息*/
	public List<AreaInf> selectAreaInf_all() throws Exception;
	/**查找所有地域名称*/
	public List<String> selectAreaInfCname_all() throws Exception;
	/**查找所有股票代码*/
	public List<String> selectAreaInfSid_all() throws Exception;
	
	/**查找某地域的信息-areaInfPack.area*/
	public List<AreaInf> selectAreaInf_area(AreaInfPack areaInfPack) throws Exception;
	/**查找某股票的信息-areaInfPack.sid*/
	public List<AreaInf> selectAreaInf_sid(AreaInfPack areaInfPack) throws Exception;
}
