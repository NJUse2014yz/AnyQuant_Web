package po;
/**用于修改数据库的类型
 * *_key表示在数据库中以*类型为关键字来查找
 * *_old表示修改的*类型的原值（不太用得到）
 * *_new表示修改的*类型的新值
 * */
public class ModifyPack {
	/**String类型的关键字*/
	public String str_key;
	/**int类型的关键字*/
	public int i_key;
	/**double类型的关键字*/
	public double d_key;
	/**String类型的旧值*/
	public String str_old;
	/**String类型的新值*/
	public String str_new;
	/**int类型的旧值*/
	public int i_old;
	/**int类型的新值*/
	public int i_new;
	/**double类型的旧值*/
	public double d_old;
	/**double类型的新值*/
	public double d_new;
	
	public String getStr_key() {
		return str_key;
	}
	public void setStr_key(String str_key) {
		this.str_key = str_key;
	}
	public int getI_key() {
		return i_key;
	}
	public void setI_key(int i_key) {
		this.i_key = i_key;
	}
	public double getD_key() {
		return d_key;
	}
	public void setD_key(double d_key) {
		this.d_key = d_key;
	}
	public String getStr_old() {
		return str_old;
	}
	public void setStr_old(String str_old) {
		this.str_old = str_old;
	}
	public String getStr_new() {
		return str_new;
	}
	public void setStr_new(String str_new) {
		this.str_new = str_new;
	}
	public int getI_old() {
		return i_old;
	}
	public void setI_old(int i_old) {
		this.i_old = i_old;
	}
	public int getI_new() {
		return i_new;
	}
	public void setI_new(int i_new) {
		this.i_new = i_new;
	}
	public double getD_old() {
		return d_old;
	}
	public void setD_old(double d_old) {
		this.d_old = d_old;
	}
	public double getD_new() {
		return d_new;
	}
	public void setD_new(double d_new) {
		this.d_new = d_new;
	}
	
}
