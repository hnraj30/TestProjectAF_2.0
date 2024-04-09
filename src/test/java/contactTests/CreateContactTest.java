package contactTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplimentationClass.class)
public class CreateContactTest extends BaseClass
{
	@Test(groups="RegressionSuite")
	
	public void createContactTest() throws IOException, InterruptedException
	{		
		
		//Read all required data
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		System.out.println("LastName: "+LASTNAME);
		
		//Click on contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Clicked on contacts link");
		//Click on create new contact Button
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Clicked on create new contact button");
		
		//Create contact using mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Contact created");
		
		//Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeaderText();
		Reporter.log("Header captured");
		
		//Assert.fail();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
	}
	
/*
	
	@Test(retryAnalyzer=genericUtilities.RetraAnalyzerImplementationClass.class)
	public void demo()
	{
		Assert.fail();
		
	}
	
	*/

}
