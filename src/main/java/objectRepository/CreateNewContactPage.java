package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name ="lastname") 
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img") 
	private WebElement orgNameLookupIcon;

	@FindAll({@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]"),@FindBy(xpath = "(//input[@type='submit'])[1]")}) 
	private WebElement saveBtn;
	
	@FindBy(id= "search_txt") 
	private WebElement orgSearchEdt;
	
	@FindBy(name="search") 
	private WebElement orgSearchBtn;
	@FindBy(name="leadsource")
	private WebElement leadSourceDD;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookupIcon() {
		return orgNameLookupIcon;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement leadSourceDD() {
		return leadSourceDD;
	}
		
	//Business library
	
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
		System.out.println("Contact created ");

	}
	
	public void createNewContact(String LASTNAME,String ORGNAME,WebDriver driver)
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgNameLookupIcon.click();
		
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		System.out.println("Contact created with lead Organization: "+ORGNAME);

	}
	public void createNewContact(String LASTNAME,String LEADSOURCE)
	{
		lastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDD, LEADSOURCE);
		saveBtn.click();
		System.out.println("Contact created with lead source: "+LEADSOURCE);
	}

}
