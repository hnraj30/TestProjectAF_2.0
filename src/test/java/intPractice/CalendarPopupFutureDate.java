package intPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupFutureDate {
	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(7000);
		
		//Selecting future date in calendar
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		for(;;)
		{
			try
			{
				//try to click on future date
				driver.findElement(By.xpath("//div[@aria-label='Wed Jul 10 2024']")).click();
				break;
			}
			
			catch(Exception e)
			{
				System.out.println("Exception");
				//Click on next month navigation button
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		
	}

}
