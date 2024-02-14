package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsTab;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationsTab;
	
	@FindBy(xpath="//a[text()='Leads']")
	private WebElement leadsTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") 
	private WebElement adminIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']") 
	private WebElement signOutlink;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productsTab;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getContactsTab() {
		return contactsTab;
	}

	public WebElement getOrganizationsTab() {
		return organizationsTab;
	}

	public WebElement getLeadsTab() {
		return leadsTab;
	}

	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getSignOutlink() {
		return signOutlink;
	}

	public WebElement getProductsTab() {
		return productsTab;
	}
	
	
	//Generic methods
	/**
	 * This method clicks on Organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationsTab.click();
	}
	
	/**
	 * This method clicks on Contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsTab.click();
	}
	
	/**
	 * This method performs logout operation
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logOut(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, adminIcon);
		Thread.sleep(2000);
		signOutlink.click();
	}
	
	/**
	 * This method clicks on Products button
	 */
	//Business library
	public  void clickOnProductsTab()
	{
		productsTab.click();
	}
	
	

}
