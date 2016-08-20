package mapper;

import java.util.List;

import function.Function;
import po.AreaInf;
import po.AreaInfPack;
import po.FunctionDisRnk;

public interface StrategyInfMapper {
	/**查找方法描述和等级*/
	public FunctionDisRnk selectStrategyInf(String name) throws Exception;
	/**查找某个等级的所有方法*/
	public List<FunctionDisRnk> selectRank(int rank) throws Exception;
	/**查找某个类别的所有方法*/
	public List<FunctionDisRnk> selectType(String type) throws Exception;
	/**查找某个等级中某个类别的所有方法*/
	public List<FunctionDisRnk> selectTypeRank(FunctionDisRnk fdr) throws Exception;
	
}
