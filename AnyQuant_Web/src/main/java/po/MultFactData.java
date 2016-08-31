package po;

import java.util.ArrayList;

public class MultFactData {

	public String attribute;
	public ArrayList<String> stolist;
	public double incPerc;
	public int days;
	public int sumsto;

	public MultFactData(String attribute, ArrayList<String> stolist, double incPerc, int days, int sumsto) {
		super();
		this.attribute = attribute;
		this.stolist = stolist;
		this.incPerc = incPerc;
		this.days = days;
		this.sumsto = sumsto;
	}
	
	public MultFactData(){
		this.attribute = null;
		this.stolist = null;
		this.incPerc = 0.0;
		this.days = 0;
		this.sumsto = 0;
	}

}
