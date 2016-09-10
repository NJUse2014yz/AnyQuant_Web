package mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.MultFactDataPack;

public class MultFactStockRecommendTest{
	private static MultFactStockRecommendMapper instance;
	public static void selectGroup(){
		ApplicationContext applicationContext1 =new ClassPathXmlApplicationContext("classpath:configure/spring/applicationContext-dao.xml");
		instance=(MultFactStockRecommendMapper) applicationContext1.getBean("multFactStockRecommendMapper");
		MultFactDataPack pack=new MultFactDataPack();
		pack.setAttribute("turnover");
		pack.setDays(30);
		pack.setSumsto(15);
		
		String stolist=null;
		try {
			stolist = instance.selectGroup(pack);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(stolist);
	}
	public static void main(String[] args)
	{
		MultFactStockRecommendTest.selectGroup();
	}
}
