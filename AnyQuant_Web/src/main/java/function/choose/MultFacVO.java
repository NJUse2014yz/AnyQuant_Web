package function.choose;

public class MultFacVO {
	public String attribute;
	public int days;
	public int stosum;

	public MultFacVO(String attribute) {
		super();
		this.attribute = attribute;
	}
	@Override
	public String toString() {
		return "AttributeVO [attribute="
				+ attribute + "]";
	}
}
