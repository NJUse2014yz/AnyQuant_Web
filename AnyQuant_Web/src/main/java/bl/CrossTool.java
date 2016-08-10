package bl;

import java.util.ArrayList;
import java.util.List;

import bl.CrossResult;
import tool.MMSTool;
import bl.TrendFlag;
import bl.TrendPoint;

public class CrossTool {
	public List<Double> activelist;
	public List<Double> passivelist;
	public CrossResult result;
	/**主动线，被动线*/
	public CrossTool(List<Double> activelist,List<Double> passivelist)
	{
		this.activelist=activelist;
		this.passivelist=passivelist;
		this.result=new CrossResult();
	}
	/**交叉判断
	 * 两线趋势达到一定差值
	 * 头尾情况相反
	 */
	public CrossResult cross()
	{
		List<TrendPoint> activetrend=new ArrayList<TrendPoint>();
		List<TrendPoint> passivetrend=new ArrayList<TrendPoint>();
		activetrend.add(new TrendPoint(0,activelist.get(0)));
		passivetrend.add(new TrendPoint(0,passivelist.get(0)));
		List<Double> activeincrease=new ArrayList<Double>();
		List<Double> passiveincrease=new ArrayList<Double>();
		for(int i=1;i<activelist.size();i++)
		{
			activetrend.add(new TrendPoint(i,activelist.get(i)));
			passivetrend.add(new TrendPoint(i,passivelist.get(i)));
			activeincrease.add(activelist.get(i)-activelist.get(i-1));
			passiveincrease.add(passivelist.get(i)-passivelist.get(i-1));
		}
		
		TrendFlag activeflag=new TrendTool(MMSTool.absmean_double(activeincrease),activetrend).trend();
		TrendFlag passiveflag=new TrendTool(MMSTool.absmean_double(passiveincrease),passivetrend).trend();
		result.activeflag=activeflag;
		result.passiveflag=passiveflag;
		double cross=activeflag.trend-passiveflag.trend;
		if(Math.abs(cross)>Math.PI/20)
		{
			if(cross>0)//上穿
			{
				for(int i=activelist.size()-1;i>=0;i--)
				{
					if(activelist.get(i)<=passivelist.get(i))
					{
						result.cross=1;
						result.crosspoint=i;
						break;
					}
				}
			}
			else//下穿
			{
				for(int i=activelist.size()-1;i>=0;i--)
				{
					if(activelist.get(i)>=passivelist.get(i))
					{
						result.cross=-1;
						result.crosspoint=i;
						break;
					}
				}
			}
		}
		else
		{
			result.cross=0;
		}
		
		return result;
	}
	public static void main(String[] args)
	{
		List<Double> list1=new ArrayList<Double>();
		list1.add(0.0);
		list1.add(1.0);
		list1.add(1.0);
		list1.add(2.0);
		list1.add(3.0);
		list1.add(2.0);
		list1.add(2.0);
		list1.add(3.0);
		list1.add(4.0);
		
		List<Double> list2=new ArrayList<Double>();
		list2.add(2.0);
		list2.add(2.0);
		list2.add(2.0);
		list2.add(2.0);
		list2.add(2.0);
		list2.add(1.0);
		list2.add(1.0);
		list2.add(1.0);
		list2.add(1.0);
		
		System.out.println(new CrossTool(list1,list2).cross());
	}
}
