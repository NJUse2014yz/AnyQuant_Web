package function;

import java.util.ArrayList;
import java.util.List;

import backtest.DateDouble;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonExchangeToolTest {
	public static void main(String[] args)
	{
//		JSONArray jArray1=JSONArray.fromObject("null");//数组如果为null报错,必须以[开始
		
//		JSONArray jArray2=JSONArray.fromObject("[]");
//		System.out.println(jArray2.toString());//数组为[]则转化为空数组[]
//		List<Integer> array2=jArray2;
//		System.out.println(array2);//空数组复制给list仍为空
		
//		List<Integer> array3=null;
//		System.out.println(array3);//如果为null Pointer数组则打印null
		
//		JSONObject jObject1=JSONObject.fromObject("null");
//		System.out.println(jObject1.toString());//对象如果为null则就为null
//		if(jObject1==null)
//		{
//			System.out.println("jObject is null Pointer");
//		}
//		else
//		{
//			System.out.println("jObject isn't null Pointer");//正确
//		}
//		if(jObject1.equals(null))
//		{
//			System.out.println("jObject is null Object");
//		}
//		if(jObject1.equals("null"))
//		{
//			System.out.println("jObject is 'null' String");
//		}
//		if(jObject1.toString().equals("null"))
//		{
//			System.out.println("jObject.toString() is 'null' String");//正确
//		}
//		if(jObject1.get("1")==null)
//		{
//			System.out.println("jObject isn't null Pointer");
//		}
//		//jObject虽然是null Pointer但!=null
		
//		JSONObject jObject2=JSONObject.fromObject("{data:5}");
//		System.out.println(jObject2.toString());//{data:5}
//		int i1=jObject2.getInt("data");//正常情况
//		System.out.println(i1);//5
//		boolean b1=jObject2.getBoolean("data");//get类型不对报错 net.sf.json.JSONException
//		boolean b2=(boolean)jObject2.get("data");//强制转换类型不对报错 java.lang.ClassCastException
//		double d1=jObject2.getDouble("data");//int可以用double来解析
//		System.out.println(d1);//5.0
//		double d2=(double)jObject2.get("data");//int强制转换为double报错
//		Object o1=jObject2.get("key");//解析不存在的属性返回null Pointer
//		if(jObject2.get("key")==null)
//		{
//			System.out.println("解析不存在的属性返回null Pointer");//正确
//		}
//		if(o1==null)
//		{
//			System.out.println("解析不存在的属性返回null Pointer");//正确
//		}
//		System.out.println(o1);//null
//		int i2=jObject2.getInt("key");//解析不存在的属性并get给基础类型报错 net.sf.json.JSONException
//		float f1=(float)jObject2.get("key");//解析不存在的属性并强制类型转换为基础类型报错 java.lang.NullPointerException
//		String s1=jObject2.getString("key");//解析不存在的属性并get给对象类型报错 net.sf.json.JSONException
//		String s2=(String)jObject2.get("key");//解析不存在的属性并强制类型转换为对象类型则赋值null
//		System.out.println(s2);//null
		
		
	}
}
