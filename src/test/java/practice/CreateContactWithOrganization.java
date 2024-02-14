package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Create all the required object
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Read All required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3)+jUtil.getrandomNumber();
		System.out.println("Organization Name: "+ORGNAME);
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2);
		System.out.println("Last Name: "+LASTNAME);
		
		//Launch browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser launched");
		}
		else
		{
			System.out.println("Invalid browser name");
		}	
		
		//Load the application 
		driver.get(URL);
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organizations link 
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Create Organization with Mandatory fields 
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		
		//Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Validation
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		
		if (orgHeader.contains(ORGNAME))
		{
			System.out.println("Pass");
			System.out.println(ORGNAME+"Organization created successfully");
		}
		else
		{
			System.out.println("Fail");
		}
				
		Thread.sleep(2000);		
		
		//Create contact using newly created Organization
		//Navigate to Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Click on Organization lookup image
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		//Switch to child window
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		
		//Switch to main window
		wUtil.switchToWindow(driver, "Contacts");
		
		//Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("Pass");
			System.out.println("Contact created successfully");
		}
		
		else
		{
			System.out.println("Fail");
		}
		
		Thread.sleep(3000);

		//Logout
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, adminIcon);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("Sign Out successfull");
	
		
		
		driver.close();				
				
		
		
		
		
	}

}
