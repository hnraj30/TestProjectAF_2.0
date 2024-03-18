package organizationTests;

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
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
@Listeners(genericUtilities.ListenersImplimentationClass.class)

public class CreateOrganizationWithIndustryTest extends BaseClass
{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	
	public void createOrganizationWithIndustryTest() throws IOException, InterruptedException 
	{			
		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 4, 2)+jUtil.getrandomNumber();
		System.out.println("Organization Name: "+ORGNAME);
		String INDUSTRY = eUtil.readDataFromExcelFile("Organization", 4, 3);
		System.out.println("Industry : "+INDUSTRY);
		
		//Navigate to Organizations link 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Click on Create Organization look Up Image 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//Create Organization with Mandatory fields 
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		//Validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
				
		Thread.sleep(2000);
		//Logout application
		
	}
	

}
