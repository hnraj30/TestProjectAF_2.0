package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
@Listeners(genericUtilities.ListenersImplimentationClass.class)

public class CreateOrganizationWithIndustryTest extends BaseClass

{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createOrgWithIndustryAndTypeTest() throws EncryptedDocumentException, IOException
	{
		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 7, 2)+jUtil.getrandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelFile("Organization", 7, 3);
		String TYPE = eUtil.readDataFromExcelFile("Organization", 7, 4);
		
		
		System.out.println("OrgaName: "+ORGNAME+"Industry: "+INDUSTRY+"Type: "+TYPE);
		
		
		//navigate to org link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//click on create new organization look up icon
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//create new organization
		CreateNewOrganizationPage cnop =new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY, TYPE);
		
		//Validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println("OrgHeader:"+orgHeader);
		
	}
	
	

}
