package function;
/**所有的工具方法的接口*/
public abstract class Function {
	public String function;
	public FunctionResult upFR;
	public FunctionResult downFR;
	public abstract FunctionResult getResult();
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public FunctionResult getUpFR() {
		return upFR;
	}
	public void setUpFR(FunctionResult upFR) {
		this.upFR = upFR;
	}
	public FunctionResult getDownFR() {
		return downFR;
	}
	public void setDownFR(FunctionResult downFR) {
		this.downFR = downFR;
	}
}
