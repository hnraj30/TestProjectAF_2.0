package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {
	public static void main(String[]args) throws InterruptedException
	{
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("HP1234");
		driver.findElement(By.name("button")).click();

		//Validation
		String headerText = driver.findElement(By.id("dtlview_Product Name")).getText();
		System.out.println(headerText);
		if(headerText.contains("HP1234"))
		{
		System.out.println("Product created successfully");

		}
		else
		{
		System.out.println("Failed......! Product not created");
		}



		Thread.sleep(3000);
		driver.close();







	}

}
