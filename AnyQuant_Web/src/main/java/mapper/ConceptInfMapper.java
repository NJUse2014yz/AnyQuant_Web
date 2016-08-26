package mapper;

import java.util.List;

import po.ConceptInf;
import po.ConceptInfPack;
import po.IndustryInf;
import po.IndustryInfPack;

public interface ConceptInfMapper {
	/**查找所有信息*/
	public List<ConceptInf> selectConceptInf_all() throws Exception;
	/**查找所有概念名称*/
	public List<String> selectConceptInfCname_all() throws Exception;
	/**查找所有股票代码*/
	public List<String> selectConceptInfSid_all() throws Exception;
	/**查找某概念的所有股票代码*/
	public List<String> selectSid_concept(String concrpt) throws Exception;
	
	/**查找某概念的信息-conceptInfPack.cname*/
	public List<ConceptInf> selectConceptInf_cname(ConceptInfPack conceptInfPack) throws Exception;
	/**查找某股票的信息-conceptInfPack.sid*/
	public List<ConceptInf> selectConceptInf_sid(ConceptInfPack conceptInfPack) throws Exception;
	
	
}
