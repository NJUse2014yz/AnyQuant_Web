package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.Choose;
import function.Flag;
import function.Function;
import function.FunctionInfo;

public interface FunctionService {
	public List<FunctionInfo> choose(Choose choose);
	public List<FunctionInfo> flag(Flag flag);
	

}
