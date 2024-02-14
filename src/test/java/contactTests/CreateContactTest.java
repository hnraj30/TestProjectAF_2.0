package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateContactTest extends BaseClass
{
	@Test(groups = "SmokeSuite")
	
	public void createContactTest() throws IOException, InterruptedException
	{		
		//Read all required data
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		System.out.println("LastName: "+LASTNAME);
		
		//Click on contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Click on create new contact Button
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//Create contact using mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
		
		
	}
	
	
	

}
