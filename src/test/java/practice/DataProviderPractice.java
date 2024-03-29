package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider = "getData")
	
	public void addProductToCart(String name, int price, int quantity, String model)
	{
		System.out.print("Phone name: "+name +"Price: "+price+"quantity: "+quantity+"model: "+model);
	}
	
	@DataProvider()
	
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "Samsung";
		data[0][1] = 10000;
		data[0][2] = 20;
		data[0][3] = "A80";
		
		data[1][0] = "Nokia";
		data[1][1] = 150000;
		data[1][2] = 10;
		data[1][3] = "M30";
		
		data[2][0] = "Iphone";
		data[2][1] = 100000;
		data[2][2] = 25;
		data[2][3] = "15+";
		
		
		return data;
	}
	

}
