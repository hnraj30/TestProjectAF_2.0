package practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtilityPractice {
	public static void main(String[]args)
	{
		//Generating random number
		Random ran = new Random();
		int randomNumber = ran.nextInt(10000);
		System.out.println("Random Number: "+randomNumber);
		
		//Generating system date in required format
		Date d = new Date();
		System.out.println("Raw Date: "+ d);
		SimpleDateFormat formatter = new SimpleDateFormat("d-M-y-H:m:s");
		String formattedDate = formatter.format(d);
		System.out.println("Formatted Date: "+formattedDate);
		
		//Generating date for scripts to click date in calendar
		//Date d = new Date
		String[] dArray = d.toString().split(" ");
		String formattedDate2 = dArray[0]+" "+dArray[1]+" "+dArray[2]+" "+dArray[5];
		System.out.println("Formatted Date2: "+formattedDate2);

	}
	

}
