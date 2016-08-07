package mapper;

import java.util.List;

import po.IndustryInf;
import po.IndustryInf;
import po.IndustryInfPack;

public interface IndustryInfMapper {
	/**创建股票行业表*/
	public void createIndustryInfTable() throws Exception;
	/**初始化行业表*/
	public void initIndustryInfTable(IndustryInfPack industryInfPack) throws Exception;
	
	/**删除行业部分股票*/
	public void deleteIndustryInf_st() throws Exception;
	public void deleteIndustryInf_single(String sid) throws Exception;
	
	/**查找所有信息*/
	public List<IndustryInf> selectIndustryInf_all() throws Exception;
	/**查找所有行业名称*/
	public List<String> selectIndustryInfCname_all() throws Exception;
	/**查找所有股票代码*/
	public List<String> selectIndustryInfSid_all() throws Exception;
	
	/**查找某行业的信息-cname*/
	public List<IndustryInf> selectIndustryInf_cname(IndustryInfPack industryInfPack) throws Exception;
	/**查找某股票的信息*/
	public List<IndustryInf> selectIndustryInf_sid(IndustryInfPack industryInfPack) throws Exception;
	
}
