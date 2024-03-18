package practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpDrive2 {
	public static void main(String[]args)
	{
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("nvidea");
		List<WebElement> list = driver.findElements(By.xpath("//li[@data-view-type='1']"));
		
		for(WebElement n:list)
		{
			System.out.println(n);
		}
		WebElement ele = driver.findElement(By.xpath("//iframe[@name='callout']"));

		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//button[@aria-label='Stay signed out']")).click();
		
		
	}

}
