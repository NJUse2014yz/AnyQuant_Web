package po;

public class FunctionDisRnk {
	public String name;
	public String discription;
	public String type;
	public int rank;
	public FunctionDisRnk(String name, String discription, String type, int rank) {
		super();
		this.name = name;
		this.discription = discription;
		this.type = type;
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "FunctionDisRnk [name=" + name + ", discription=" + discription
				+ ", type=" + type + ", rank=" + rank + "]";
	}
}
