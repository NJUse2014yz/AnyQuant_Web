package tool;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CookieHelper {
	public static final String USER_NAME="userName";
	public static final String PASSWORD="password";
	public static final String IS_LIKE="isLike";

	/**
	 * Cookie的实现  
	 */  
	public static void addCookie(String name, String value,HttpServletResponse response, HttpServletRequest request){ 
	        //创建Cookie  
	        Cookie nameCookie;
			try {
				nameCookie = new Cookie(name,URLEncoder.encode(value,"utf-8"));
				//设置Cookie的父路径  
		        nameCookie.setPath(request.getContextPath());  
		          
		        //保存Cookie的时间长度，单位为秒 ,保留两个星期 
		         nameCookie.setMaxAge(14*24*60*60);  
		      
		        //加入Cookie到响应头  
		        response.addCookie(nameCookie); 
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	          
	        
	   }  
	  
	
	public static String getCookie(HttpServletRequest request,String name){
		 
	    String value="";  
 
	    Cookie[] cookies= request.getCookies();  
	    if(cookies!=null&&cookies.length>0){   
	        //遍历Cookie  
	        for(int i=0;i<cookies.length;i++){  
	            Cookie cookie=cookies[i];  
	            //此处类似与Map有name和value两个字段,name相等才赋值,并处理编码问题   
	            if(name.equals(cookie.getName())){  
	                try {
						value=URLDecoder.decode(cookie.getValue(),"utf-8");
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}  
	            } 

	        }  
	    }
	   
	    return value;
	}
	
	/**
	 * 设置cookie保存时间为0
	 * @param name
	 * @param response
	 * 2016年5月15日
	 */
	public static void deleteCookie(String name,HttpServletRequest request,HttpServletResponse response){
		Cookie cookie=new Cookie(name, "");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		cookie.setPath(request.getContextPath()); 
	}
	
	
}
