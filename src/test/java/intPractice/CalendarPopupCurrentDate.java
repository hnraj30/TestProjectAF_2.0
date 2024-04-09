package intPractice;

import java.time.Duration;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupCurrentDate {
	public static void main(String[]args) throws InterruptedException
	{
		Date date = new Date();
		System.out.println(date);			//Thu Apr 04 10:22:04 IST 2024
		String[] dArray = date.toString().split(" ");
		String formattedDate = dArray[0]+" "+dArray[1]+" "+dArray[2]+" "+dArray[5];
		System.out.println(formattedDate);	//Thu Apr 04 2024

		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(7000);
		//select present date in DOM
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='"+formattedDate+"']")).click();
	
		Thread.sleep(3000);
		driver.close();
	
	}

}
