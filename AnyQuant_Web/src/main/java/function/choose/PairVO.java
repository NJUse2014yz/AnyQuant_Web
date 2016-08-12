package function.choose;

public class PairVO {
	/**主动配对的股票代码*/
	public String siid;
	/**配对股票数（1或2或3）*/
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
