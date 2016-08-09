package tool;

import java.util.ArrayList;
import java.util.List;

import mapper.QuotaDataMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.DatePack;
import po.QuotaData;
import pr.QuotaDataPr;
import tool.MMSTool;
import tool.TrendFlag;
import tool.TrendPoint;

public class TrendTool {
	public TrendFlag flag;
	public double standard;
	public TrendTool(double standard,List<TrendPoint> list)
	{
		this.standard=standard;
		this.flag=new TrendFlag(list);
	}
	/**判断趋势：迭代判断，
	 * 涨点形成的曲线上升且跌点形成的曲线上升为上升势
	 * 	趋势开口为波动变大
	 * 	趋势闭口为波动变小
	 * 	更不明显的一条趋势决定速度
	 * 涨点形成的曲线下降且跌点形成的曲线下降为下降势
	 * 	趋势开口为波动变大
	 * 	趋势闭口为波动变小
	 * 	更不明显的一条趋势决定速度
	 * 涨点形成的曲线上升且跌点形成的曲线下降为非上升下降势且波动增大
	 * 涨点形成的曲线下降且跌点形成的曲线上升为非上升下降势且波动减小
	 */
	public TrendFlag trend()
	{
		//只剩一点或没有，迭代终止，升点、降点、总趋势均为0
		if(flag.list.size()<=1)
		{
			flag.trend=flag.uptrend=flag.downtrend=0;
			return flag;
		}
		//只剩两点，迭代终止，升点、降点、总趋势均为倾斜角度
		else if(flag.list.size()==2)
		{
			flag.trend=flag.uptrend=flag.downtrend=Math.atan((flag.list.get(1).value-flag.list.get(0).value)/(flag.list.get(1).index-flag.list.get(0).index)/standard);
//			System.out.println("trend ("+flag.list.get(1).value+"-"+flag.list.get(0).value+")/("+flag.list.get(1).index+"-"+flag.list.get(0).index+")/"+standard);
//			flag.trend=flag.uptrend=flag.downtrend=(flag.list.get(1).value-flag.list.get(0).value)/(flag.list.get(1).index-flag.list.get(0).index)/standard;
			return flag;
		}
		//三点及三点以上，取升点、降点求趋势再求总趋势
		else
		{
			List<TrendPoint> up=new ArrayList<TrendPoint>();
			List<TrendPoint> down=new ArrayList<TrendPoint>();
		
			for(int i=1;i<flag.list.size();i++)
			{
				//升点
				if(flag.list.get(i).value-flag.list.get(i-1).value>0)
				{
					up.add(flag.list.get(i));
				}
				//降点
				else if(flag.list.get(i).value-flag.list.get(i-1).value<0)
				{
					down.add(flag.list.get(i));
				}
			}
//			System.out.println(up);
//			System.out.println(down);
			flag.uptrend=new TrendTool(standard,up).trend().trend;
			flag.downtrend=new TrendTool(standard,down).trend().trend;
			flag.trend=(flag.uptrend*up.size()+flag.downtrend*down.size())/(up.size()+down.size());
			return flag;
		}
	}

	public static void main(String[] args)
	{
		try{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		QuotaDataMapper quotaDataMapper=(QuotaDataMapper) applicationContext.getBean("quotaDataMapper");
			
		QuotaData quotaData_new=new QuotaDataPr().getQuotaData_new("s","sh600000");
		DatePack datePack=new DatePack();
		datePack.setSiid("sh600000");
		datePack.setId1(quotaData_new.getId()-230);
		System.out.println(quotaData_new.getId()-230);
		datePack.setNum(5);
		
		List<Double> dihlist10=quotaDataMapper.selectDih12_num_id(datePack);
		List<Double> dillist10=quotaDataMapper.selectDil12_num_id(datePack);
		
		List<Double> dihincrease10=new ArrayList<Double>();
		List<Double> dilincrease10=new ArrayList<Double>();
		List<TrendPoint> dihtrend10=new ArrayList<TrendPoint>();
		List<TrendPoint> diltrend10=new ArrayList<TrendPoint>();
		dihtrend10.add(new TrendPoint(0,dihlist10.get(0)));
		diltrend10.add(new TrendPoint(0,dillist10.get(0)));
		for(int i=1;i<dihlist10.size();i++)
		{
			dihincrease10.add(dihlist10.get(i)-dihlist10.get(i-1));
			dilincrease10.add(dillist10.get(i)-dillist10.get(i-1));
			dihtrend10.add(new TrendPoint(i,dihlist10.get(i)));
			diltrend10.add(new TrendPoint(i,dillist10.get(i)));
		}
		System.out.println(dihtrend10);
		System.out.println(diltrend10);
		System.out.println(new TrendTool(MMSTool.absmean_double(dihincrease10),dihtrend10).trend());
		System.out.println(new TrendTool(MMSTool.absmean_double(dilincrease10),diltrend10).trend());
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
