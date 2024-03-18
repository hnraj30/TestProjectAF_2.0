package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class consists of generic methods related to java
 * @author hnraj
 *
 */
public class JavaUtility
{
	/**
	 * This method will generate random number for every run and returns it to the caller
	 * @return
	 */
	public int getrandomNumber()
	{
		Random ran = new Random();
		int r = ran.nextInt(10000);
		return r;
	}
	
	/**
	 * This method will capture system date in required format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("d-M-Y-H-m-S");
		String date = formatter.format(d);
		return date;
		
	}

}
