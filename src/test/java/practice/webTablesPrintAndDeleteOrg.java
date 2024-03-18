package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webTablesPrintAndDeleteOrg {
	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		
		String orgName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td[3]")).getText();
		System.out.println(orgName);
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td[1]")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		driver.switchTo().alert().accept();
		
		Thread.sleep(10000);
		String orgName2 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td[3]")).getText();
		System.out.println(orgName2);
	}
	

}
