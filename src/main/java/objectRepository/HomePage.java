package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration
	@FindBy(xpath="//a[text()='Calendar']")
	private WebElement calendarTab;
	
	@FindBy(xpath="(//a[text()='Leads'])[1]")
	private WebElement leadsTab;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsTab;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationsTab;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productsTab;
	
	@FindBy(xpath="(//a[text()='Opportunities'])[1]")
	private WebElement opportunitiesTab;

	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentsTab;
	
	@FindBy(xpath="//a[text()='Email']")
	private WebElement emailTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") 
	private WebElement adminIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']") 
	private WebElement signOutlink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getCalendarTab() {
		return calendarTab;
	}
	
	public WebElement getLeadsTab() {
		return leadsTab;
	}
	
	public WebElement getContactsTab() {
		return contactsTab;
	}

	public WebElement getOrganizationsTab() {
		return organizationsTab;
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
	
	public WebElement getOpportunitiesTab() {
		return opportunitiesTab;
	}
	
	public WebElement getDocumentsTab() {
		return documentsTab;
	}
	
	public WebElement getEmailTab() {
		return emailTab;
	}
	
	
	//Business library
	/**
	 * This method clicks on calendar link
	 */
	public void clickOnCalendarLink()
	{
		calendarTab.click();
	}
	
	/**
	 * This method clicks on leads link
	 */
	public void clickOnLeadsLink()
	{
		leadsTab.click();
	}
	
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
	 * This method clicks on Products link
	 */
	//Business library
	public  void clickOnProductsTab()
	{
		productsTab.click();
	}
	
	/**
	 * This method clicks on opportunities link
	 */
	//Business library
	public  void clickOnOpprtunitiesTab()
	{
		opportunitiesTab.click();
	}
	
	/**
	 * This method clicks on documents link
	 */
	public  void clickOnDocumentsTab()
	{
		documentsTab.click();
	}
	
	/**
	 * This method clicks on email link
	 */
	public  void clickOnEmailTab()
	{
		emailTab.click();
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
}
