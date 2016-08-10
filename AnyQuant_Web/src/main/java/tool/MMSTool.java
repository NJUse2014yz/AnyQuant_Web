package tool;

import java.util.ArrayList;
import java.util.List;

import bl.TrendPoint;
import po.HistoryData;

public class MMSTool {
	/**历史数据列表中最低价的最低*/
	public static double min_low(List<HistoryData> list)
	{
		double min=list.get(0).getLow();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getLow()<=min)
			{
				min=list.get(i).getLow();
			}
		}
		return min;
	}
	
	/**历史数据列表中最高价的最高*/
	public static double max_high(List<HistoryData> list)
	{
		double max=list.get(0).getHigh();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getHigh()>=max)
			{
				max=list.get(i).getHigh();
			}
		}
		return max;
	}
	
	/**历史数据列表中成交量的总和*/
	public static long sum_vol(List<HistoryData> list)
	{
		long sum=0;
		for(int i=0;i<list.size();i++)
		{
			sum+=list.get(i).getVolume();
		}
		return sum;
	}
	
	/**历史数据列表中成交额的总和*/
	public static double sum_amo(List<HistoryData> list)
	{
		double sum=0;
		for(int i=0;i<list.size();i++)
		{
			sum+=list.get(i).getAmount();
		}
		return sum;
	}
	
	/**总和*/
	public static double sum_double(List<Double> list)
	{
		double sum=0;
		for(int i=0;i<list.size();i++)
		{
			sum+=list.get(i);
		}
		return sum;
	}
	
	/**最低值-double*/
	public static double min_double(List<Double> list)
	{
		double min=list.get(0);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i)<=min)
			{
				min=list.get(i);
			}
		}
		return min;
	}
	
	/**最低值-trendpoint*/
	public static TrendPoint min_trendpoint(List<TrendPoint> list)
	{
		TrendPoint min=list.get(0);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).value<=min.value)
			{
				min=list.get(i);
			}
		}
		return min;
	}
	
	/**最高值-double*/
	public static double max(List<Double> list)
	{
		double max=list.get(0);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i)>=max)
			{
				max=list.get(i);
			}
		}
		return max;
	}
	
	/**最高值-trendpoint*/
	public static TrendPoint max_trendpoint(List<TrendPoint> list)
	{
		TrendPoint max=list.get(0);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).value>=max.value)
			{
				max=list.get(i);
			}
		}
		return max;
	}
	
	/**平均值-double*/
	public static double mean(List<Double> list)
	{
		double sum=0;
		double count=0;
		for(int i=0;i<list.size();i++)
		{
			double num=list.get(i);
			sum+=num;
			count++;
		}
		return sum/count;
	}
	
	/**绝对值平均值-double*/
	public static double absmean_double(List<Double> list)
	{
		double sum=0;
		for(int i=0;i<list.size();i++)
		{
			double num=Math.abs(list.get(i));
			sum+=num;
		}
		return sum/list.size();
	}
	
	/**平均值-long*/
	public static double mean_long(List<Long> list)
	{
		long sum=0;
		for(int i=0;i<list.size();i++)
		{
			long num=list.get(i);
			sum+=num;
		}
		return sum/list.size();
	}
	
	/**样本方差-double*/
	public static double variance_sample(List<Double> list)
	{
		double sum=0;
		double mean=mean(list);
		for(int i=0;i<list.size();i++)
		{
			sum+=Math.pow(list.get(i)-mean,2);
		}
		return sum/(list.size()-1);
	}
	
	/**原始方差-double*/
	public static double variance(List<Double> list)
	{
		double sum=0;
		double mean=mean(list);
		for(int i=0;i<list.size();i++)
		{
			sum+=Math.pow(list.get(i)-mean,2);
		}
		return sum/list.size();
	}
	
	/**协方差-double*/
	public static double cov(List<Double> list1,List<Double> list2)
	{
		List<Double> multilist=new ArrayList<Double>();
		for(int i=0;i<Math.min(list1.size(),list2.size());i++)
				multilist.add(list1.get(i)*list2.get(i));
		
		return mean(multilist)-mean(list1)*mean(list2);
//		List<Double> list11=new ArrayList<Double>();
//		List<Double> list22=new ArrayList<Double>();
//		for(int i=0;i<list1.size();i++)
//		{
//			list11.add(list1.get(i)-mean(list1));
//			list22.add(list2.get(i)-mean(list2));
//			multilist.add(list11.get(i)*list22.get(i));
//		}
//		return mean(multilist);
	}
	
	/**相关系数*/
	public static double rou(List<Double> list1,List<Double> list2)
	{
		return cov(list1,list2)/Math.sqrt(variance(list1))/Math.sqrt(variance(list2));
	}
	
}
