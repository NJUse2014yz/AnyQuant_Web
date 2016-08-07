package mapper;

import java.util.List;

import po.ConceptInf;
import po.ConceptInfPack;
import po.IndustryInf;
import po.IndustryInfPack;

public interface ConceptInfMapper {
	/**创建股票概念表*/
	public void createConceptInfTable() throws Exception;
	/**初始化概念表-conceptInfPack.conceptInfList*/
	public void initConceptInfTable(ConceptInfPack conceptInfPack) throws Exception;
	
	/**删除地域部分股票*/
	public void deleteConceptInf_st() throws Exception;
	public void deleteConceptInf_single(String sid) throws Exception;
	
	/**查找所有信息*/
	public List<ConceptInf> selectConceptInf_all() throws Exception;
	/**查找所有概念名称*/
	public List<String> selectConceptInfCname_all() throws Exception;
	/**查找所有股票代码*/
	public List<String> selectConceptInfSid_all() throws Exception;
	
	/**查找某概念的信息-conceptInfPack.cname*/
	public List<ConceptInf> selectConceptInf_cname(ConceptInfPack conceptInfPack) throws Exception;
	/**查找某股票的信息-conceptInfPack.sid*/
	public List<ConceptInf> selectConceptInf_sid(ConceptInfPack conceptInfPack) throws Exception;
	
	
}
