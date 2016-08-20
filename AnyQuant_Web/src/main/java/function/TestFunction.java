package function;

import java.sql.Date;
import java.util.Random;

public class TestFunction extends Function{
	
	public TestFunction()
	{
		this.function="Test";
	}
	@Override
	public FunctionResult getResult(Date date) {
		int i=(int) new Random().nextInt(2);
		FunctionResult result=new FunctionResult();
		result.location.add(ResultType.INT);
		result.rI=i;
		return result;
	}
	@Override
	public String toString() {
		return "OrderFunction [function=" + function + ", resultUpI=" + resultUpI
				+ ", resultDownI=" + resultDownI + ", resultUpO=" + resultUpO
				+ ", resultDownO=" + resultDownO + "]";
	}
}
