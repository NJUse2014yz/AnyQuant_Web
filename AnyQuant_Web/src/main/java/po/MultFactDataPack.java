package po;

import java.util.ArrayList;

import net.sf.json.JSONArray;

public class MultFactDataPack {
	public String attribute;
	public String stolist;
	public double incPerc;
	public int days;
	public int sumsto;

	public MultFactDataPack(MultFactData data)
	{
		this.attribute = data.attribute;
		this.stolist = JSONArray.fromObject(data.stolist).toString();
		this.incPerc = data.incPerc;
		this.days = data.days;
		this.sumsto = data.sumsto;
	}
	
	public MultFactDataPack(String attribute, String stolist, double incPerc, int days, int sumsto) {
		super();
		this.attribute = attribute;
		this.stolist = stolist;
		this.incPerc = incPerc;
		this.days = days;
		this.sumsto = sumsto;
	}
	
	public MultFactDataPack(){
		this.attribute = null;
		this.stolist = null;
		this.incPerc = 0.0;
		this.days = 0;
		this.sumsto = 0;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getStolist() {
		return stolist;
	}

	public void setStolist(String stolist) {
		this.stolist = stolist;
	}

	public double getIncPerc() {
		return incPerc;
	}

	public void setIncPerc(double incPerc) {
		this.incPerc = incPerc;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getSumsto() {
		return sumsto;
	}

	public void setSumsto(int sumsto) {
		this.sumsto = sumsto;
	}
	
}
