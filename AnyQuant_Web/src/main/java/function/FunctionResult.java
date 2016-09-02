package function;

import java.util.ArrayList;
import java.util.List;

/**工具方法的通用返回结果*/
public class FunctionResult {
	public List<Integer> location;
	public boolean rB;
	public int rI;
	public double rD;
	public String rS;
	public long rL;
	public List<Integer> rLI;
	public List<Double> rLD;
	public List<String> rLS;
	public List<Long> rLL;
	
	public FunctionResult()
	{
		this.location=new ArrayList<Integer>();//只有这个是在构造函数里初始化为空列表的
		this.rB=false;
		this.rI=0;
		this.rD=0;
		this.rS=null;
		this.rL=0;
		this.rLI=null;
		this.rLD=null;
		this.rLS=null;
		this.rLL=null;
	}
	public List<Integer> getLocation() {
		return location;
	}
	public void setLocation(List<Integer> location) {
		this.location = location;
	}
	public boolean isrB() {
		return rB;
	}
	public void setrB(boolean rB) {
		this.rB = rB;
	}
	public int getrI() {
		return rI;
	}
	public void setrI(int rI) {
		this.rI = rI;
	}
	public double getrD() {
		return rD;
	}
	public void setrD(double rD) {
		this.rD = rD;
	}
	public String getrS() {
		return rS;
	}
	public void setrS(String rS) {
		this.rS = rS;
	}
	public List<Integer> getrLI() {
		return rLI;
	}
	public void setrLI(List<Integer> rLI) {
		this.rLI = rLI;
	}
	public List<Double> getrLD() {
		return rLD;
	}
	public void setrLD(List<Double> rLD) {
		this.rLD = rLD;
	}
	public List<String> getrLS() {
		return rLS;
	}
	public void setrLS(List<String> rLS) {
		this.rLS = rLS;
	}
	public long getrL() {
		return rL;
	}
	public void setrL(long rL) {
		this.rL = rL;
	}
	public List<Long> getrLL() {
		return rLL;
	}
	public void setrLL(List<Long> rLL) {
		this.rLL = rLL;
	}
	@Override
	public String toString() {
		return "FunctionResult [location=" + location + ", rB=" + rB + ", rI="
				+ rI + ", rD=" + rD + ", rS=" + rS + ", rL=" + rL + ", rLI="
				+ rLI + ", rLD=" + rLD + ", rLS=" + rLS + ", rLL=" + rLL + "]";
	}
}
