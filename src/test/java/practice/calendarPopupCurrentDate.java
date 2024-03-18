package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarPopupCurrentDate {
	public static void main(String[]args) throws InterruptedException
	{
		Date d = new Date();
		System.out.println(d);       		 //Thu Feb 29 13:01:55 IST 2024
		String[] dArray = d.toString().split(" ");
		String currentDate = dArray[0]+" "+dArray[1]+" "+dArray[2]+" "+dArray[5];
		System.out.println(currentDate);  	 //Thu Feb 29 2024
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();

		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		
		
	}
	

}
