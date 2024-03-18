package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

/**
 * 
 * @author hnraj
 *
 */
@Listeners(genericUtilities.ListenersImplimentationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass
{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	
	public void createContactWithOrganizationTest()  throws IOException, InterruptedException 
	{
		//Read All required data		
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3)+jUtil.getrandomNumber();
		System.out.println("Organization Name: "+ORGNAME);
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2);
		System.out.println("Last Name: "+LASTNAME);
		
		//Navigate to Organizations link 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Click on Create Organization look Up Image 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//Create Organization with Mandatory fields 
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		{
			System.out.println("OrgHeader: "+orgHeader);
		}
		
		//Click on contacts link
		hp.clickOnContactsLink();
		
		//Click on create new contact Button
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//Create contact using mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		
		//Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeaderText();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		{
			System.out.println("Contact Header"+contactHeader);
		}
				
	}
		
		

}
