package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	//Declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductBtn;
	
	//Initialization 
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilizatiom
	public WebElement getCreateProductBtn()
	{
		return createProductBtn;
		
	}
	
	//Buisiness library
	public void clickOnCreateProdBtn()
	{
		createProductBtn.click();
	}
	

}
