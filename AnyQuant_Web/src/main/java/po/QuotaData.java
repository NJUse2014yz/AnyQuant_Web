package po;

import java.sql.Date;

public class QuotaData {
	/**编号*/
	private int id;
	/**日期*/
	private Date date;
	/**5日均线*/
	private double m5;
	/**10日均线*/
	private double m10;
	/**20日均线*/
	private double m20;
	/**30日均线*/
	private double m30;
	/**5日乖离率*/
	private double bias5;
	/**10日乖离率*/
	private double bias10;
	/**20日乖离率*/
	private double bias20;
	/**布林线1*/
	private double boll1;
	/**布林线2*/
	private double boll2;
	/**布林线3*/
	private double boll3;
	/**相对强弱指标*/
	private double rsi;
	private double rsi5;//
	private double rsi10;//要不要多选几个
	private double rsi20;//
	/**成交量变异率*/
	private double vr;
	/**未成熟随机值*/
	private double rsv;
	/**随机指标*/
	private double k;
	private double j;
	private double d;
	/**指数平均数指标*/
	private double ema12;
	private double ema26;
	private double ema50;
	private double ema5;
	private double ema35;
	private double ema10;
	private double ema60;
	/**指数平滑异同平均线*/
	public double diff;
	private double dea;
	private double macd;
	/**动向指标*/
	private double dmh;
	private double dml;
	private double tr;
	private double dmh12;
	private double dml12;
	private double tr12;
	private double dih;
	private double dil;
	private double dih12;
	private double dil12;
	private double dx;
	private double adx;
	private double adxr;
	/**能量潮*/
	private double obv;
	/**变动速率指标*/
	private double roc12;
	private double roc25;
	
//	/**中间意愿指标*/
//	private double cr1;//2C+H+L
//	private double cr2;//C+H+L+O
//	private double cr3;//C+H+L
//	private double cr4;//H+L
//	/**宝塔线 */
//	private double tow;
	
	public QuotaData() {
		super();
		this.id=-1;
		this.date = null;
		this.m5 = 0;
		this.m10 = 0;
		this.m20 = 0;
		this.m30 = 0;
		this.bias5 = 0;
		this.bias10 = 0;
		this.bias20 = 0;
		this.boll1 = 0;
		this.boll2 = 0;
		this.boll3 = 0;
		this.rsi = 100;
		this.rsi5 = 100;
		this.rsi10 = 100;
		this.rsi20 = 100;
		this.vr = 0;
		this.rsv = 100;
		this.k = 50;
		this.j = 50;
		this.d = 50;
		this.ema12=0;
		this.ema26=0;
		this.ema50=0;
		this.ema5 = 0;
		this.ema35 = 0;
		this.ema10=0;
		this.ema60=0;
		this.diff=0;		
		this.dea=0;
		this.macd = 0;
		
		this.dmh = 0;
		this.dml = 0;
		this.tr = 0;
		this.dmh12 = 0;
		this.dml12 = 0;
		this.tr12 = 0;
		this.dih = 0;
		this.dil = 0;
		this.dih12 = 0;
		this.dil12 = 0;
		this.dx = 0;
		this.adx = 0;
		this.adxr = 0;

		this.obv = 0;
		this.roc12 = 0;
		this.roc25=0;
	}
	public QuotaData(int id, Date date, double m5, double m10, double m20,
			double m30, double bias5, double bias10, double bias20, double boll1,
			double boll2, double boll3,double vr, double rsv, 
			double rsi, double rsi5, double rsi10, double rsi20,
			double k, double j, double d, double ema12, double ema26, double ema50,
			double ema5, double ema35, double ema10, double ema60, double diff,
			double dea, double macd, double dmh, double dml, double tr,
			double dmh12, double dml12, double tr12, double dih, double dil,
			double dih12, double dil12, double dx, double adx, double adxr,
			double obv, double roc12, double roc25) {
		super();
		this.id = id;
		this.date = date;
		this.m5 = m5;
		this.m10 = m10;
		this.m20 = m20;
		this.m30 = m30;
		this.bias5 = bias5;
		this.bias10 = bias10;
		this.bias20 = bias20;
		this.boll1 = boll1;
		this.boll2 = boll2;
		this.boll3 = boll3;
		this.rsi = rsi;
		this.rsi5 = rsi5;
		this.rsi10 = rsi10;
		this.rsi20 = rsi20;
		this.vr = vr;
		this.rsv = rsv;
		this.k = k;
		this.j = j;
		this.d = d;
		this.ema12 = ema12;
		this.ema26 = ema26;
		this.ema50 = ema50;
		this.ema5 = ema5;
		this.ema35 = ema35;
		this.ema10 = ema10;
		this.ema60 = ema60;
		this.diff = diff;
		this.dea = dea;
		this.macd = macd;
		this.dmh = dmh;
		this.dml = dml;
		this.tr = tr;
		this.dmh12 = dmh12;
		this.dml12 = dml12;
		this.tr12 = tr12;
		this.dih = dih;
		this.dil = dil;
		this.dih12 = dih12;
		this.dil12 = dil12;
		this.dx = dx;
		this.adx = adx;
		this.adxr = adxr;
		this.obv = obv;
		this.roc12 = roc12;
		this.roc25 = roc25;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getM5() {
		return m5;
	}
	public void setM5(double m5) {
		this.m5 = m5;
	}
	public double getM10() {
		return m10;
	}
	public void setM10(double m10) {
		this.m10 = m10;
	}
	public double getM20() {
		return m20;
	}
	public void setM20(double m20) {
		this.m20 = m20;
	}
	public double getM30() {
		return m30;
	}
	public void setM30(double m30) {
		this.m30 = m30;
	}
	public double getBias5() {
		return bias5;
	}
	public void setBias5(double bias5) {
		this.bias5 = bias5;
	}
	public double getBias10() {
		return bias10;
	}
	public void setBias10(double bias10) {
		this.bias10 = bias10;
	}
	public double getBias20() {
		return bias20;
	}
	public void setBias20(double bias20) {
		this.bias20 = bias20;
	}
	public double getBoll1() {
		return boll1;
	}
	public void setBoll1(double boll1) {
		this.boll1 = boll1;
	}
	public double getBoll2() {
		return boll2;
	}
	public void setBoll2(double boll2) {
		this.boll2 = boll2;
	}
	public double getBoll3() {
		return boll3;
	}
	public void setBoll3(double boll3) {
		this.boll3 = boll3;
	}
	public double getRsi() {
		return rsi;
	}
	public void setRsi(double rsi) {
		this.rsi = rsi;
	}
	public double getRsi5() {
		return rsi5;
	}
	public void setRsi5(double rsi5) {
		this.rsi5 = rsi5;
	}
	public double getRsi10() {
		return rsi10;
	}
	public void setRsi10(double rsi10) {
		this.rsi10 = rsi10;
	}
	public double getRsi20() {
		return rsi20;
	}
	public void setRsi20(double rsi20) {
		this.rsi20 = rsi20;
	}
	public double getVr() {
		return vr;
	}
	public void setVr(double vr) {
		this.vr = vr;
	}
	public double getRsv() {
		return rsv;
	}
	public void setRsv(double rsv) {
		this.rsv = rsv;
	}
	public double getK() {
		return k;
	}
	public void setK(double k) {
		this.k = k;
	}
	public double getJ() {
		return j;
	}
	public void setJ(double j) {
		this.j = j;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public double getEma12() {
		return ema12;
	}
	public void setEma12(double ema12) {
		this.ema12 = ema12;
	}
	public double getEma26() {
		return ema26;
	}
	public void setEma26(double ema26) {
		this.ema26 = ema26;
	}
	public double getEma50() {
		return ema50;
	}
	public void setEma50(double ema50) {
		this.ema50 = ema50;
	}
	public double getEma5() {
		return ema5;
	}
	public void setEma5(double ema5) {
		this.ema5 = ema5;
	}
	public double getEma35() {
		return ema35;
	}
	public void setEma35(double ema35) {
		this.ema35 = ema35;
	}
	public double getEma10() {
		return ema10;
	}
	public void setEma10(double ema10) {
		this.ema10 = ema10;
	}
	public double getEma60() {
		return ema60;
	}
	public void setEma60(double ema60) {
		this.ema60 = ema60;
	}
	public double getDiff() {
		return diff;
	}
	public void setDiff(double diff) {
		this.diff = diff;
	}
	public double getDea() {
		return dea;
	}
	public void setDea(double dea) {
		this.dea = dea;
	}
	public double getMacd() {
		return macd;
	}
	public void setMacd(double macd) {
		this.macd = macd;
	}
	public double getDmh() {
		return dmh;
	}
	public void setDmh(double dmh) {
		this.dmh = dmh;
	}
	public double getDml() {
		return dml;
	}
	public void setDml(double dml) {
		this.dml = dml;
	}
	public double getTr() {
		return tr;
	}
	public void setTr(double tr) {
		this.tr = tr;
	}
	public double getDmh12() {
		return dmh12;
	}
	public void setDmh12(double dmh12) {
		this.dmh12 = dmh12;
	}
	public double getDml12() {
		return dml12;
	}
	public void setDml12(double dml12) {
		this.dml12 = dml12;
	}
	public double getTr12() {
		return tr12;
	}
	public void setTr12(double tr12) {
		this.tr12 = tr12;
	}
	public double getDih() {
		return dih;
	}
	public void setDih(double dih) {
		this.dih = dih;
	}
	public double getDil() {
		return dil;
	}
	public void setDil(double dil) {
		this.dil = dil;
	}
	public double getDih12() {
		return dih12;
	}
	public void setDih12(double dih12) {
		this.dih12 = dih12;
	}
	public double getDil12() {
		return dil12;
	}
	public void setDil12(double dil12) {
		this.dil12 = dil12;
	}
	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public double getAdx() {
		return adx;
	}
	public void setAdx(double adx) {
		this.adx = adx;
	}
	public double getAdxr() {
		return adxr;
	}
	public void setAdxr(double adxr) {
		this.adxr = adxr;
	}
	public double getObv() {
		return obv;
	}
	public void setObv(double obv) {
		this.obv = obv;
	}
	public double getRoc12() {
		return roc12;
	}
	public void setRoc12(double roc12) {
		this.roc12 = roc12;
	}
	public double getRoc25() {
		return roc25;
	}
	public void setRoc25(double roc25) {
		this.roc25 = roc25;
	}
	@Override
	public String toString() {
		return "QuotaData [id=" + id + ", date=" + date + ", m5=" + m5
				+ ", m10=" + m10 + ", m20=" + m20 + ", m30=" + m30 + ", bias5="
				+ bias5 + ", bias10=" + bias10 + ", bias20=" + bias20
				+ ", boll1=" + boll1 + ", boll2=" + boll2 + ", boll3=" + boll3
				+ ", rsi=" + rsi + ", rsi6=" + rsi5 + ", rsi12=" + rsi10
				+ ", rsi24=" + rsi20 + ", vr=" + vr + ", rsv=" + rsv + ", k="
				+ k + ", j=" + j + ", d=" + d + ", ema12=" + ema12 + ", ema26="
				+ ema26 + ", ema50=" + ema50 + ", ema5=" + ema5 + ", ema35="
				+ ema35 + ", ema10=" + ema10 + ", ema60=" + ema60 + ", diff="
				+ diff + ", dea=" + dea + ", macd=" + macd + ", dmh=" + dmh
				+ ", dml=" + dml + ", tr=" + tr + ", dmh12=" + dmh12
				+ ", dml12=" + dml12 + ", tr12=" + tr12 + ", dih=" + dih
				+ ", dil=" + dil + ", dih12=" + dih12 + ", dil12=" + dil12
				+ ", dx=" + dx + ", adx=" + adx + ", adxr=" + adxr + ", obv="
				+ obv + ", roc12=" + roc12 + ", roc25=" + roc25 + "]";
	}
}
