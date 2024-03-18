package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	//Declaration
	@FindBy(id="dtlview_Product Name")
	private WebElement productHeader;
	
	//Initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public WebElement getProductHeader()
	{
		return productHeader;
	}
	
	//Buisiness library
	/**
	 * This method captures header text and returns it to the caller
	 * @return
	 */
	public String getHeaderText()
	{
		return productHeader.getText();
		
	}

}
