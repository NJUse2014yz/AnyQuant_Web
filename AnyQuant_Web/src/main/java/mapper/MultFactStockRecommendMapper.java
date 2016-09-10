package mapper;

import java.util.List;

import po.MultFactDataPack;

/**暂时只提供一次插入（初始化）*/
public interface MultFactStockRecommendMapper {
	public String selectGroup(MultFactDataPack pack) throws Exception;
}
