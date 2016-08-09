package ServiceTool;

public class UserRankHelper {
	public static int getRank(long score) {
		if(score<1000){
			return 1;
		}
		if(score<5000){
			return 2;
		}
		if(score<30000){
			return 3;
		}
		return 4;
	}
}
