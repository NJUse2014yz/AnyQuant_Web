package function;
/**目前没有使用*/
public class FunctionInfo {
	/**参数名*/
	public String name;
	/**参数类型*/
	public Class type;
	public FunctionInfo(String name, Class type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getType() {
		return type;
	}
	public void setType(Class type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "FunctionInfo [name=" + name + ", type=" + type + "]";
	}
}
