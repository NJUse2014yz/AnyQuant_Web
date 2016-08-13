//package backtest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import vo.TradeSignal;
//import bl.QuotaAnalyse;
///**
// * 根据多指标交易时某股的多指标分析结果和对应交易信号
// */
//public class AnalyseSignalPack {
//	/**多指标分析结果*/
//	public List<QuotaAnalyse> analyses;
//	/**多指标对应的交易信号*/
//	public List<TradeSignal> signals;
//	
//	public AnalyseSignalPack(List<QuotaAnalyse> analyses)
//	{
//		this.analyses=analyses;
//		this.signals = new ArrayList<TradeSignal>();
//		for(int i=0;i<analyses.size();i++)
//		{
//			signals.add(new TradeSignal());
//		}
//	}
//	public AnalyseSignalPack(List<QuotaAnalyse> analyses,
//			List<TradeSignal> signals) {
//		this.analyses = analyses;
//		this.signals = signals;
//	}
//
//	public List<QuotaAnalyse> getAnalyses() {
//		return analyses;
//	}
//
//	public void setAnalyses(List<QuotaAnalyse> analyses) {
//		this.analyses = analyses;
//	}
//
//	public List<TradeSignal> getSignals() {
//		return signals;
//	}
//
//	public void setSignals(List<TradeSignal> signals) {
//		this.signals = signals;
//	}
//
//	@Override
//	public String toString() {
//		return "AnalyseSignalPack [analyses=" + analyses + ", signals="
//				+ signals + "]";
//	}
//}
