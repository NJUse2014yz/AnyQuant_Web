package function;

import java.sql.Date;
import java.util.Calendar;

import function.flag.MaxMinFunction;

public class MaxMinFunctionTest {
	public MaxMinFunction instance;
	public void getResult()
	{
		instance=new MaxMinFunction();
		instance.siid="sh600000";
		instance.attribute="close";
		instance.mm=1;
		instance.num=5;
		System.out.println(instance.getResult(new Date(Calendar.getInstance().getTimeInMillis())).rLD);
	}
	public static void main(String[] args)
	{
		new MaxMinFunctionTest().getResult();
	}
}
