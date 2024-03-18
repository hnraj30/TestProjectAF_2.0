package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
@Listeners(genericUtilities.ListenersImplimentationClass.class)

public class createOrganization2Test extends BaseClass{
	
	@Test(groups="RegressionSuite")
	
	public void createOrganization2Test() throws EncryptedDocumentException, IOException
	{
		//Read all required data
		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 1, 2)+jUtil.getrandomNumber();
		
		//Click on Org tab
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Click on create new org button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//Create organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver); 
		Assert.assertTrue(oip.getHeaderText().contains(ORGNAME));
		{
			System.out.println("Organization created successfully");
		}
		
		
		
		
	}

}
