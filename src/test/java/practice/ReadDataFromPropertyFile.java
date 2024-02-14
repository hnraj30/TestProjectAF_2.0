package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		//Open the file in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Create an object of property file
		Properties p = new Properties();
		
		//Load file input stream into the properties
		p.load(fis);
		String BROWSER = p.getProperty("url");
		System.out.println(BROWSER);

		
		
		
	}

}
