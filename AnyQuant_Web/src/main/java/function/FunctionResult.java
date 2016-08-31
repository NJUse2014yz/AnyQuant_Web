package function;

import java.util.ArrayList;
import java.util.List;

/**工具方法的通用返回结果*/
public class FunctionResult {
	public List<Integer> location=new ArrayList<Integer>();
	public boolean rB=false;
	public int rI=0;
	public double rD=0;
	public String rS=null;
	public long rL=0;
	public List<Integer> rLI=null;
	public List<Double> rLD=null;
	public List<String> rLS=null;
	public List<Long> rLL=null;
	
	public FunctionResult()
	{
		
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
