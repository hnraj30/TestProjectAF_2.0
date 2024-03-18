package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplimentationClass.class)
public class CreatecontactWithLeadSourceTest extends BaseClass 
{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	
	public void createcontactWithLeadSourceTest() throws EncryptedDocumentException, IOException
	{
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcelFile("Contacts", 4, 3);

		//Click on contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Clicked on contacts link");
		
		//Click on create new contact lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Clicked on create new contact lookup image");

		//Create contact with lead source
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);
		Reporter.log("Contact created with lead source");

		//Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeaderText();
		Reporter.log("Header captured");

		//Assert.fail();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		Reporter.log("Header validated");

		
	}

}
