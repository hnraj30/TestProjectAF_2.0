package intPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesScenario_5 {
	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		Thread.sleep(2000);
		
		//modify table
		//capture web elements related to org name in 8th row
		WebElement ele = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td[3]/a[@title='Organizations']"));
		
		System.out.println(ele.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td[1]/input[@name='selected_id']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.close();
	}
	

}
