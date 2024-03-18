package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarPopupFutureDate {
	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='calc60']"));
		for(WebElement n:list1)
		{
			if (n.getText().contains("Bengaluru"))
			{
				n.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");
		
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='calc60']"));
		for(WebElement n:list2)
		{
			if(n.getText().contains("Delhi"))
			{
				n.click();
				break;
			}
		}
		Thread.sleep(2000);

		for(;;)
		{
			try
			{
				//click on date
				driver.findElement(By.xpath("//div[@aria-label='Thu Jun 20 2024']")).click();
				break;
			}
			catch(Exception e)
			{
				//click on next month button
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			
		}
		
		System.out.println("Date selected");
		Thread.sleep(2000);
		driver.close();
		
	}

}
