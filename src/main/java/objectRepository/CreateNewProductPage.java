package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name="productname")
	private WebElement productNameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="productcategory")
	private WebElement categoryDD;
	
	@FindBy(name="manufacturer")
	private WebElement manufacturerDD;
		
	//Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductNameEdt()
	{
		return productNameEdt;
		
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
		
	}
	public WebElement getCategoryDD()
	{
		return categoryDD;
	}
	
	public WebElement getManufacturerDD()
	{
		return manufacturerDD;
	}
	
	//Business library
	/**
	 * This method creates contact with mandatory fields
	 * @param productName
	 */
	public void createNewProduct(String PRODUCTNAME)
	{
		productNameEdt.sendKeys(PRODUCTNAME);
		saveBtn.click();
		System.out.println(PRODUCTNAME+"Product created successfullly");
	}
	
	/**
	 * This method creates product with category
	 * @param PRODUCTNAME
	 * @param CATEGORY
	 */
	public void createNewProduct(String PRODUCTNAME, String CATEGORY)
	{
		productNameEdt.sendKeys(PRODUCTNAME);
		handleDropdown(categoryDD, CATEGORY);
		saveBtn.click();
		System.out.println(PRODUCTNAME+"Product created successfully");
	}
	
	/**
	 * This method creates new product with category and manufacturer
	 * @param PRODUCTNAME
	 * @param CATEGORY
	 * @param MANUFACTURER
	 */
	public void createNewProduct(String PRODUCTNAME, String CATEGORY, String MANUFACTURER)
	{
		productNameEdt.sendKeys(PRODUCTNAME);
		handleDropdown(categoryDD, CATEGORY);
		handleDropdown(manufacturerDD, MANUFACTURER);
		saveBtn.click();
		System.out.println(PRODUCTNAME+"Product created successfully");

	}
	

}
