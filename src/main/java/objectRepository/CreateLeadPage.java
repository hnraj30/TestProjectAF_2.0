package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class CreateLeadPage extends BaseClass{
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="company")
	private WebElement companyEdt;	
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDD;	
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLastNameEdt()
	{
		return lastNameEdt;
	}
	
	public WebElement getCompanyEdt()
	{
		return companyEdt;
	}
	
	public WebElement getLeadSourceDD()
	{
		return leadSourceDD;
	}
	
	public WebElement getIndustryDD()
	{
		return industryDD;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	//Business library
	/**
	 * This method creates lead
	 * @param LASTNAME
	 * @param COMPANY
	 */
	public void createLead(String LASTNAME,String COMPANY)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyEdt.sendKeys(COMPANY);
		saveBtn.click();
	}
	
	/**
	 * This method creates lead with lead source
	 * @param LASTNAME
	 * @param COMPANY
	 * @param LEADSOURCE
	 * @param leadSource
	 */
	public void createLead(String LASTNAME,String COMPANY, String LEADSOURCE)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyEdt.sendKeys(COMPANY);
		wUtil.handleDropdown(leadSourceDD, LEADSOURCE);
		saveBtn.click();
	}
	
	/**
	 * This method create lead with lead source and industry
	 * @param LASTNAME
	 * @param COMPANY
	 * @param LEADSOURCE
	 * @param leadSource
	 * @param INDUSTRY
	 */
	public void createLead(String LASTNAME,String COMPANY, String LEADSOURCE, WebElement leadSource, String INDUSTRY)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyEdt.sendKeys(COMPANY);
		wUtil.handleDropdown(leadSource, LEADSOURCE);
		wUtil.handleDropdown(industryDD, INDUSTRY);
		saveBtn.click();
	}

}
