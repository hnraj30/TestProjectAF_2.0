package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 
{
	public static void main(String[]args) throws InterruptedException
	{
		//Launch Browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Login to application with valid credentials
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("NH");
		
		
		//Select the Organization from organization look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> child = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		for(String c:child)
		{
			driver.switchTo().window(c);
		}
		driver.findElement(By.id("search_txt")).sendKeys("Decathlon");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='Decathlon']")).click();
		
		
		
		driver.switchTo().window(parent);
		
		//Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		
		if(contactHeader.contains("NH"))
		{
			System.out.println("Pass");
		}
		
		else
		{
			System.out.println("Fail");
		}
		
		//Logout
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(adminIcon).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
