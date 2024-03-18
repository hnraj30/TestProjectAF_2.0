package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation 
{
	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		/*driver.get("https://www.facebook.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement alllinks:links)
		{
			System.out.println(alllinks.getText());
		}
		
		driver.findElement(By.cssSelector(""));
		*/
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 12");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String price = driver.findElement(By.xpath("(//span[text()='OnePlus 12 (Flowy Emerald, 12 GB RAM, 256GB)'])[1]/../../../../..//span[@class='a-price-whole']")).getText();
		Thread.sleep(3000);
		System.out.println(price);
		
		driver.findElement(By.xpath("//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']")).click();
		
		
		
		
	}

}
