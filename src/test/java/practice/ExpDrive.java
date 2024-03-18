package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpDrive {
	public static void main(String[]args)
	{
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.flipkart.com/");
		WebElement ele = driver.findElement(By.xpath("//span[.='Mobiles']"));
		System.out.println(ele.getText());
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		System.out.println(x+" "+y);
		
		Dimension size = ele.getSize();
		int h = size.getHeight();
		int w = size.getWidth();
		
		System.out.println(h+"  "+w);
		
		
		System.out.println(ele);
		
		
	}
	

}
