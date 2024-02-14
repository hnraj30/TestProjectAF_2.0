package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 
{
	public static void main(String[]args)
	{
		//Launch Browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organizations link
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		//Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Decathlon1");
		
		//Select "Chemicals" in the industry drop down
		WebElement industryDD = driver.findElement(By.name("industry"));
		Select s =  new Select(industryDD);
		s.selectByValue("Chemicals");
		
		//Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validation
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(orgHeader.contains("Decathlon"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Logout
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a  = new Actions(driver);
		a.moveToElement(adminIcon).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.close();
		
		
		
	}

}
