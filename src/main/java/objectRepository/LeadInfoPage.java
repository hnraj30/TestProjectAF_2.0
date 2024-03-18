package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadHeader;
	
	public LeadInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getLeadHeader()
	{
		return leadHeader;
	}
	
	//Business library
	/**
	 * This method captures text from lead header
	 * @return 
	 */
	public String getTextFormLeadHeader()
	{
		return leadHeader.getText();
	}
}
