package vo;

import java.io.Serializable;

public class StrategyRecInf implements Serializable{
	public int id;
	public double open;
	public double close;
	public double volumn;
	public double turnover;
	
	public StrategyRecInf() {
		this.id = 0;
		this.open = 0;
		this.close = 0;
		this.volumn = 0;
		this.turnover = 0;
	}
	public StrategyRecInf(int index, double open, double close, double volumn,
			double turnover) {
		this.id = index;
		this.open = open;
		this.close = close;
		this.volumn = volumn;
		this.turnover = turnover;
	}
	public int getId() {
		return id;
	}
	public void setId(int index) {
		this.id = index;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getVolumn() {
		return volumn;
	}
	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}
	public double getTurnover() {
		return turnover;
	}
	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}
	@Override
	public String toString() {
		return id + " " + open + " "+ close + " " + volumn + " " + turnover ;
	}
}
