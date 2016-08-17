package mapper;

import po.ModifyPack;
import po.UserInf;

public interface UserInfMapper {
	/**用户注册*/
	public void signUp(UserInf userInf) throws Exception;
	/**用户查询*/
	public UserInf select(String userName) throws Exception;
	/**修改用户名，原用户名传入str_key，新用户名传入str_new*/
	public void modifyUserName(ModifyPack modifyPack) throws Exception;
	/**修改密码，用户名传入userName，新密码传入password*/
	public void modifyPassword(UserInf userInf) throws Exception;
	/**修改积分和等级，用户名传入userName，新积分传入score，新等级传入rank（及时没有提高等级也要将旧值传入）*/
	public void modifyScoreRank(UserInf userInf) throws Exception;
	/**修改关注的股票*/
	public void modifyStocks(UserInf userInf) throws Exception;
}
