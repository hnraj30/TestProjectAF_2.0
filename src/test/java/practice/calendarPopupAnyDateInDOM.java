package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarPopupAnyDateInDOM {
	public static void main(String[]args)
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='calc60']"));
		WebElement link = null;
		for(WebElement n:list)
		{
			if(n.getText().contains("Bengaluru"))
			{
				link = n;
				break;
			}
		}
		link.click();
		
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
		
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='calc60']"));
		WebElement link2 = null;
		for(WebElement n2:list2)
		{
			if(n2.getText().contains("Mumbai"))
			{
				link2 = n2;
				break;
			}
		}
		link2.click();
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Apr 10 2024']")).click();
		
	}

}
