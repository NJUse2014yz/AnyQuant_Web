package mapper;

import po.ModifyPack;
import po.UserInf;

public interface UserInfMapper {
	/**用户注册*/
	public void signUp(UserInf userInf) throws Exception;
	/**用户查询*/
	public UserInf select(String userName) throws Exception;
	/**修改用户名*/
	public void modifyUserName(ModifyPack modifyPack) throws Exception;
	/**修改密码*/
	public void modifyPassword(ModifyPack modifyPack) throws Exception;
}
