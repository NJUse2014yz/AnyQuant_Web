package function;
/**所有的工具方法的接口*/
public abstract class Function {
	public String function;
	public FunctionResult upFRI;
	public FunctionResult downFRI;
	public FunctionResult upFRO;
	public FunctionResult downFRO;
	public abstract FunctionResult getResult();
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public FunctionResult getUpFRI() {
		return upFRI;
	}
	public void setUpFRI(FunctionResult upFRI) {
		this.upFRI = upFRI;
	}
	public FunctionResult getDownFRI() {
		return downFRI;
	}
	public void setDownFRI(FunctionResult downFRI) {
		this.downFRI = downFRI;
	}
	public FunctionResult getUpFRO() {
		return upFRO;
	}
	public void setUpFRO(FunctionResult upFRO) {
		this.upFRO = upFRO;
	}
	public FunctionResult getDownFRO() {
		return downFRO;
	}
	public void setDownFRO(FunctionResult downFRO) {
		this.downFRO = downFRO;
	}
	
}
