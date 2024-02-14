package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice 
{
	public static void main(String[]args) throws IOException

	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		System.out.println(USERNAME);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		System.out.println(LASTNAME);

		JavaUtility jUtil = new JavaUtility();
		int r = jUtil.getrandomNumber();
		System.out.println(r);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);

		
		
		
		
		
		
	}
	

}
