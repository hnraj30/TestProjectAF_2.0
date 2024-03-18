package genericUtilities;
/**
 * 
 */
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass 
{
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	
	//Used in listeners
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("------------------Database connection successful-------------------");
	}
	
	//@Parameters("browser")
	//@BeforeTest()
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser launched ");
		}
		else if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched ");
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser launched ");	
		}
		
		else
		{
			System.out.println("Invalid browser ");

		}
		
		//open application
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//Used in listeners
		sdriver =driver;

		driver.get(URL);
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login successfull");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logOut(driver);
		System.out.println("Logout successfull");
	}
	
	@AfterClass(alwaysRun=true)
	//@AfterTest
	public void acConfig()
	{
		driver.close();
		System.out.println("Browser closed ");

	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("------------------Database connection closed-------------------");
	}
	
	//Test line added for testing full operation
	public void demo()
	{
		System.out.print("pull test");
	}

}
