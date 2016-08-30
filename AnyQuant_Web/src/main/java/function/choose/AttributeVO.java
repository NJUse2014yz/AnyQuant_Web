package function.choose;

public class AttributeVO {
	public double up;
	public double down;
	public String attribute;

	public AttributeVO(double up, double down, String attribute) {
		super();
		this.up = up;
		this.down = down;
		this.attribute = attribute;
	}
	public double getUp() {
		return up;
	}
	public void setUp(double up) {
		this.up = up;
	}
	public double getDown() {
		return down;
	}
	public void setDown(double down) {
		this.down = down;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	@Override
	public String toString() {
		return "AttributeVO [up=" + up + ", down=" + down + ", attribute="
				+ attribute + "]";
	}
}
