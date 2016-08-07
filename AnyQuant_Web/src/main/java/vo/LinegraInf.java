package vo;

public class LinegraInf {
	public String id;
	public String date;
	/**5日乖离率*/
	public double bias5;
	/**10日乖离率*/
	public double bias10;
	/**20日乖离率*/
	public double bias20;
	/**布林线1*/
	public double boll1;
	/**布林线2*/
	public double boll2;
	/**布林线3*/
	public double boll3;
	/**相对强弱指标*/
	public double rsi;
	//新增
	public double rsi5;//
	public double rsi10;//要不要多选几个
	public double rsi20;//
	
	
	/**成交量变异率*/
	public double vr;
	/**未成熟随机值*/
	public double rsv;
	/**随机指标*/
	public double k;
	public double j;
	public double d;
	/**指数平均数指标*/
	public double ema12;
	public double ema26;
	public double ema50;
	public double ema5;
	public double ema35;
	public double ema10;
	public double ema60;
	/**指数平滑异同平均线*/
	public double diff;
	public double dea;
	public double macd;
	/**动向指标*/
	public double dmh;
	public double dml;
	public double tr;
	public double dmh12;
	public double dml12;
	public double tr12;
	public double dih;
	public double dil;
	public double dih12;//
	public double dil12;//
	public double dx;
	public double adx;//
	public double adxr;//
	/**能量潮*/
	public double obv;
	/**变动速率指标*/
	public double roc12;
	public double roc25;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	
	
}
