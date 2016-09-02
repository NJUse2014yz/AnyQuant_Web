package vo;

public enum Attribute {
	open("open"),
	openW("openW"),
	openM("openM"),
	close("close"),
	closeW("closeW"),
	closeM("closeM"),
	increase("increase"),
	increaseW("increaseW"),
	increaseM("increaseM"),
	incrPer("incrPer"),
	incrPerW("incrPerW"),
	incrPerM("incrPerM"),
	low("low"),
	lowW("lowW"),
	lowM("lowM"),
	high("high"),
	highW("highW"),
	highM("highM"),
	volume("volume"),
	volumeW("volumeW"),
	volumeM("volumeM"),
	amount("amount"),
	amountW("amountW"),
	amountM("amountM"),
	turnover("turnover"),
	m5("m5"),
	m5W("m5W"),
	m5M("m5M"),
	m10("m10"),
	m10W("m10W"),
	m10M("m10M"),
	m20("m20"),
	m20W("m20W"),
	m20M("m20M"),
	m30("m30"),
	m30W("m30W"),
	m30M("m30M"),
	bias5("bias5"),
	bias5W("bias5W"),
	bias5M("bias5M"),
	bias10("bias10"),
	bias10W("bias10W"),
	bias10M("bias10M"),
	bias20("bias20"),
	bias20W("bias20W"),
	bias20M("bias20M"),
	boll1("boll1"),
	boll1W("boll1W"),
	boll1M("boll1M"),
	boll2("boll2"),
	boll2W("boll2W"),
	boll2M("boll2M"),
	boll3("boll3"),
	boll3W("boll3W"),
	boll3M("boll3M"),
	rsi("rsi"),
	rsiW("rsiW"),
	rsiM("rsiM"),
	rsi5("rsi5"),
	rsi5W("rsi5W"),
	rsi5M("rsi5M"),
	rsi10("rsi10"),
	rsi10W("rsi10W"),
	rsi10M("rsi10M"),
	rsi20("rsi20"),
	rsi20W("rsi20W"),
	rsi20M("rsi20M"),
	vr("vr"),
	vrW("vrW"),
	vrM("vrM"),
	rsv("rsv"),
	rsvW("rsvW"),
	rsvM("rsvM"),
	k("k"),
	kW("kW"),
	kM("kM"),
	d("d"),
	dW("dW"),
	dM("dM"),
	j("j"),
	jW("jW"),
	jM("jM"),
	ema12("ema12"),
	ema12W("ema12W"),
	ema12M("ema12M"),
	ema26("ema26"),
	ema26W("ema26W"),
	ema26M("ema26M"),
	ema50("ema50"),
	ema50W("ema50W"),
	ema50M("ema50M"),
	ema5("ema5"),
	ema5W("ema5W"),
	ema5M("ema5M"),
	ema10("ema10"),
	ema10W("ema10W"),
	ema10M("ema10M"),
	ema60("ema60"),
	ema60W("ema60W"),
	ema60M("ema60M"),
	diff("diff"),
	diffW("diffW"),
	diffM("diffM"),
	dea("dea"),
	deaW("deaW"),
	deaM("deaM"),
	macd("macd"),
	macdW("macdW"),
	macdM("macdM"),
	dmh("dmh"),
	dml("dml"),
	dmlW("dmlW"),
	dmlM("dmlM"),
	tr("tr"),
	trW("trW"),
	trM("trM"),
	dmh12("dmh12"),
	dmh12W("dmh12W"),
	dmh12M("dmh12M"),
	dml12("dml12"),
	dml12W("dml12W"),
	dml12M("dml12M"),
	tr12("tr12"),
	tr12W("tr12W"),
	tr12M("tr12M"),
	dih("dih"),
	dihW("dihW"),
	dihM("dihM"),
	dil("dil"),
	dilW("dilW"),
	dilM("dilM"),
	dih12("dih12"),
	dih12W("dih12W"),
	dih12M("dih12M"),
	dil12("dil12"),
	dil12W("dil12W"),
	dil12M("dil12M"),
	dx("dx"),
	dxW("dxW"),
	dxM("dxM"),
	adx("adx"),
	adxW("adxW"),
	adxM("adxM"),
	adxr("adxr"),
	adxrW("adxrW"),
	adxrM("adxrM"),
	obv("obv"),
	obvW("obvW"),
	obvM("obvM"),
	roc12("roc12"),
	roc12W("roc12W"),
	roc12M("roc12M"),
	roc25("roc25"),
	roc25W("roc25W"),
	roc25M("roc25M");
	
	private String code;
	
	private Attribute(String code)
	{
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Attribute getEnum(String code)
	{
		switch(code)
		{
		case "open":
			return open;
		case "openW":
			return openW;
		case "openM":
			return openM;
		case "close":
			return close;
		case "closeW":
			return closeW;
		case "closeM":
			return closeM;
		case "increase":
			return increase;
		case "increaseW":
			return increaseW;
		case "increaseM":
			return increaseM;
		case "incrPer":
			return incrPer;
		case "incrPerW":
			return incrPerW;
		case "incrPerM":
			return incrPerM;
		case "low":
			return low;
		case "lowW":
			return lowW;
		case "lowM":
			return lowM;
		case "high":
			return high;
		case "highW":
			return highW;
		case "highM":
			return highM;
		case "volume":
			return volume;
		case "volumeW":
			return volumeW;
		case "volumeM":
			return volumeM;
		case "amount":
			return amount;
		case "amountW":
			return amountW;
		case "amountM":
			return amountM;
		case "turnover":
			return turnover;
		case "m5":
			return m5;
		case "m5W":
			return m5W;
		case "m5M":
			return m5M;
		case "m10":
			return m10;
		case "m10W":
			return m10W;
		case "m10M":
			return m10M;
		case "m20":
			return m20;
		case "m20W":
			return m20W;
		case "m20M":
			return m20M;
		case "m30":
			return m30;
		case "m30W":
			return m30W;
		case "m30M":
			return m30M;
		case "bias5":
			return bias5;
		case "bias5W":
			return bias5W;
		case "bias5M":
			return bias5M;
		case "bias10":
			return bias10;
		case "bias10W":
			return bias10W;
		case "bias10M":
			return bias10M;
		case "bias20":
			return bias20;
		case "bias20W":
			return bias20W;
		case "bias20M":
			return bias20M;
		case "boll1":
			return boll1;
		case "boll1W":
			return boll1W;
		case "boll1M":
			return boll1M;
		case "boll2":
			return boll2;
		case "boll2W":
			return boll2W;
		case "boll2M":
			return boll2M;
		case "boll3":
			return boll3;
		case "boll3W":
			return boll3W;
		case "boll3M":
			return boll3M;
		case "rsi":
			return rsi;
		case "rsiW":
			return rsiW;
		case "rsiM":
			return rsiM;
		case "rsi5":
			return rsi5;
		case "rsi5W":
			return rsi5W;
		case "rsi5M":
			return rsi5M;
		case "rsi10":
			return rsi10;
		case "rsi10W":
			return rsi10W;
		case "rsi10M":
			return rsi10M;
		case "rsi20":
			return rsi20;
		case "rsi20W":
			return rsi20W;
		case "rsi20M":
			return rsi20M;
		case "vr":
			return vr;
		case "vrW":
			return vrW;
		case "vrM":
			return vrM;
		case "rsv":
			return rsv;
		case "rsvW":
			return rsvW;
		case "rsvM":
			return rsvW;
		case "k":
			return k;
		case "kW":
			return kW;
		case "kM":
			return kM;
		case "d":
			return d;
		case "dW":
			return dW;
		case "dM":
			return dM;
		case "j":
			return j;
		case "jW":
			return jW;
		case "jM":
			return jM;
		case "ema12":
			return ema12;
		case "ema12W":
			return ema12W;
		case "ema12M":
			return ema12M;
		case "ema26":
			return ema26;
		case "ema26W":
			return ema26W;
		case "ema26M":
			return ema26M;
		case "ema50":
			return ema50;
		case "ema50W":
			return ema50W;
		case "ema50M":
			return ema50M;
		case "ema5":
			return ema5;
		case "ema5W":
			return ema5W;
		case "ema5M":
			return ema5M;
		case "ema10":
			return ema10;
		case "ema10W":
			return ema10W;
		case "ema10M":
			return ema10M;
		case "ema60":
			return ema60;
		case "ema60W":
			return ema60W;
		case "ema60M":
			return ema60M;
		case "diff":
			return diff;
		case "diffW":
			return diffW;
		case "diffM":
			return diffM;
		case "dea":
			return dea;
		case "deaW":
			return deaW;
		case "deaM":
			return deaM;
		case "macd":
			return macd;
		case "macdW":
			return macdW;
		case "macdM":
			return macdM;
		case "dmh":
			return dmh;
		case "dml":
			return dml;
		case "dmlW":
			return dmlW;
		case "dmlM":
			return dmlM;
		case "tr":
			return tr;
		case "trW":
			return trW;
		case "trM":
			return trM;
		case "dmh12":
			return dmh12;
		case "dmh12W":
			return dmh12W;
		case "dmh12M":
			return dmh12M;
		case "dml12":
			return dml12;
		case "dml12W":
			return dml12W;
		case "dml12M":
			return dml12M;
		case "tr12":
			return tr12;
		case "tr12W":
			return tr12W;
		case "tr12M":
			return tr12M;
		case "dih":
			return dih;
		case "dihW":
			return dihW;
		case "dihM":
			return dihM;
		case "dil":
			return dil;
		case "dilW":
			return dilW;
		case "dilM":
			return dilM;
		case "dih12":
			return dih12;
		case "dih12W":
			return dih12W;
		case "dih12M":
			return dih12M;
		case "dil12":
			return dil12;
		case "dil12W":
			return dil12W;
		case "dil12M":
			return dil12M;
		case "dx":
			return dx;
		case "dxW":
			return dxW;
		case "dxM":
			return dxM;
		case "adx":
			return adx;
		case "adxW":
			return adxW;
		case "adxM":
			return adxM;
		case "adxr":
			return adxr;
		case "adxrW":
			return adxrW;
		case "adxrM":
			return adxrM;
		case "obv":
			return obv;
		case "obvW":
			return obvW;
		case "obvM":
			return obvM;
		case "roc12":
			return roc12;
		case "roc12W":
			return roc12W;
		case "roc12M":
			return roc12M;
		case "roc25":
			return roc25;
		case "roc25W":
			return roc25W;
		case "roc25M":
			return roc25M;
		default:
			return null;
		}
	}
	
	
	
//case "open":
//case "openW":
//case "openM":
//case "close":
//case "closeW":
//case "closeM":
//case "increase":
//case "increaseW":
//case "increaseM":
//case "incrPer":
//case "incrPerW":
//case "incrPerM":
//case "low":
//case "lowW":
//case "lowM":
//case "high":
//case "highW":
//case "highM":
//case "volume":
//case "volumeW":
//case "volumeM":
//case "amount":
//case "amountW":
//case "amountM":
//case "turnover":
//case "m5":
//case "m5W":
//case "m5M":
//case "m10":
//case "m10W":
//case "m10M":
//case "m20":
//case "m20W":
//case "m20M":
//case "m30":
//case "m30W":
//case "m30M":
//case "bias5":
//case "bias5W":
//case "bias5M":
//case "bias10":
//case "bias10W":
//case "bias10M":
//case "bias20":
//case "bias20W":
//case "bias20M":
//case "boll1":
//case "boll1W":
//case "boll1M":
//case "boll2":
//case "boll2W":
//case "boll2M":
//case "boll3":
//case "boll3W":
//case "boll3M":
//case "rsi":
//case "rsiW":
//case "rsiM":
//case "rsi5":
//case "rsi5W":
//case "rsi5M":
//case "rsi10":
//case "rsi10W":
//case "rsi10M":
//case "rsi20":
//case "rsi20W":
//case "rsi20M":
//case "vr":
//case "vrW":
//case "vrM":
//case "rsv":
//case "rsvW":
//case "rsvM":
//case "k":
//case "kW":
//case "kM":
//case "d":
//case "dW":
//case "dM":
//case "j":
//case "jW":
//case "jM":
//case "ema12":
//case "ema12W":
//case "ema12M":
//case "ema26":
//case "ema26W":
//case "ema26M":
//case "ema50":
//case "ema50W":
//case "ema50M":
//case "ema5":
//case "ema5W":
//case "ema5M":
//case "ema10":
//case "ema10W":
//case "ema10M":
//case "ema60":
//case "ema60W":
//case "ema60M":
//case "diff":
//case "diffW":
//case "diffM":
//case "dea":
//case "deaW":
//case "deaM":
//case "macd":
//case "macdW":
//case "macdM":
//case "dmh":
//case "dml":
//case "dmlW":
//case "dmlM":
//case "tr":
//case "trW":
//case "trM":
//case "dmh12":
//case "dmh12W":
//case "dmh12M":
//case "dml12":
//case "dml12W":
//case "dml12M":
//case "tr12":
//case "tr12W":
//case "tr12M":
//case "dih":
//case "dihW":
//case "dihM":
//case "dil":
//case "dilW":
//case "dilM":
//case "dih12":
//case "dih12W":
//case "dih12M":
//case "dil12":
//case "dil12W":
//case "dil12M":
//case "dx":
//case "dxW":
//case "dxM":
//case "adx":
//case "adxW":
//case "adxM":
//case "adxr":
//case "adxrW":
//case "adxrM":
//case "obv":
//case "obvW":
//case "obvM":
//case "roc12":
//case "roc12W":
//case "roc12M":
//case "roc25":
//case "roc25W":
//case "roc25M":
}
