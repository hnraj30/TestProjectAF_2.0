package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webTablesPrintAllOrgNames {
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
		
		try
		{
			
			for(;;)
			{
				 List<WebElement> orgName = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
				
				for(WebElement n:orgName)
				{
					System.out.println(n.getText());

				}
				
				driver.findElement(By.xpath("(//img[@src='themes/images/next.gif'])[2]")).click();
				Thread.sleep(10000);
			}
			
			

		}
		
		catch(Exception e)
		{
			
		}
		
		
		
		
		
		/*
		try
		{
			for(;;)
			{
				for(int i=3;i<=22;i++)
				{
					String orgName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+i+"]/td[3]")).getText();
					System.out.println(orgName);
				}
				driver.findElement(By.xpath("(//img[@src='themes/images/next.gif'])[2]")).click();
			}
		}
		catch(Exception e)
		{
			Thread.sleep(2000);
			//System.out.println("End of table");
		}
		*/
		
		//driver.close();
		
		
	}
	

}
