package leadTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateLeadPage;
import objectRepository.HomePage;
import objectRepository.LeadInfoPage;
import objectRepository.LeadsPage;
@Listeners(genericUtilities.ListenersImplimentationClass.class)

public class LeadTest extends BaseClass{
	@Test(groups="RegressionSuite")
	
	public void createLeadTest() throws EncryptedDocumentException, IOException {
		String LASTNAME = eUtil.readDataFromExcelFile("Leads", 1, 2);
		String COMPANY = eUtil.readDataFromExcelFile("Leads", 1, 3);

		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();
		Reporter.log("Clicked on leads link");
		
		LeadsPage lp =new LeadsPage(driver);
		lp.clickonCreateLeadButton();
		Reporter.log("Clicked on create new lead lookup icon");
		
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.createLead(LASTNAME, COMPANY);
		Reporter.log("Lead created with last name and company");
		
		//Validation
		LeadInfoPage lip = new LeadInfoPage(driver);
		String leadHeader = lip.getTextFormLeadHeader();
		Assert.assertTrue(leadHeader.contains(LASTNAME));
		System.out.println(leadHeader);

	}
	@Test
	
	public void createLeadWithLeadSourceTest() throws EncryptedDocumentException, IOException {
		String LASTNAME = eUtil.readDataFromExcelFile("Leads", 4, 2);
		String COMPANY = eUtil.readDataFromExcelFile("Leads", 4, 3);
		String LEADSOURCE = eUtil.readDataFromExcelFile("Leads", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();
		Reporter.log("Clicked on leads link");
		
		LeadsPage lp =new LeadsPage(driver);
		lp.clickonCreateLeadButton();
		Reporter.log("Clicked on create new lead lookup icon");
		
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.createLead(LASTNAME, COMPANY,LEADSOURCE);
		Reporter.log("Lead created with last name, company and lead source");
		
		//Validation
		LeadInfoPage lip = new LeadInfoPage(driver);
		String leadHeader = lip.getTextFormLeadHeader();
		Assert.assertTrue(leadHeader.contains(LASTNAME));
		System.out.println(leadHeader);

	}

}
