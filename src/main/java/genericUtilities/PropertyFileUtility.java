package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods to read data from property file.
 * @author hnraj
 *
 */

public class PropertyFileUtility 
{
	/**
	 * This method will read data from property file and returns it to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String value = p.getProperty(key);
		return value;
		
	}

}
