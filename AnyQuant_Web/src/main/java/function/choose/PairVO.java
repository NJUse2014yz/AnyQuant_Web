package function.choose;

public class PairVO {
	public String siid;
	public int num;
	public PairVO(String siid, int num) {
		super();
		this.siid = siid;
		this.num = num;
	}
	public String getSiid() {
		return siid;
	}
	public void setSiid(String siid) {
		this.siid = siid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "PairVO [siid=" + siid + ", num=" + num + "]";
	}
}
