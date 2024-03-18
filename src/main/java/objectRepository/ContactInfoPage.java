package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	//Declaration
	@FindBy(id="mouseArea_Last Name") 
	private WebElement contactHeader;
	
	//initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactHeader() {
		return contactHeader;
	}
	
	//Business library
	/**
	 * This method capture header text from contact header and returns it to the caller
	 * @return
	 */
	public String getContactHeaderText()
	{
		return contactHeader.getText();
	}
		

}
