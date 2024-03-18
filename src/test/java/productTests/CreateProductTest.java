package productTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductsPage;

public class CreateProductTest extends BaseClass{
	@Test(groups="RegressionSuite")
	
	public void createProductTest() throws IOException, InterruptedException
	{
		//Read all required data
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Products", 1, 2);		
		//Click on products link
		HomePage hp = new HomePage(driver);
		hp.clickOnProductsTab();
		Reporter.log("Clicked on products link");
		
		//Click on Create new product button
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProdBtn();
		Reporter.log("Clicked on create new product image");
		
		//Create product
		CreateNewProductPage cnp = new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME);
		Reporter.log("Product created");
		
		//validation
		ProductInfoPage pip = new ProductInfoPage(driver);
		String headerText = pip.getHeaderText();
		
		Assert.assertTrue(headerText.contains(PRODUCTNAME));
		System.out.println(headerText);
		Reporter.log("Product header validated");
		
		Thread.sleep(3000);
	}
	@Test
	
	public void createProductWithCategory() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Products", 4, 2);
		String CATEGORY = eUtil.readDataFromExcelFile("Products", 4, 3);
		HomePage hp = new HomePage(driver);
		hp.clickOnProductsTab();
		Reporter.log("Clicked on products link");
		
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProdBtn();
		Reporter.log("Clicked on create new product image");

		CreateNewProductPage cnp = new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME, CATEGORY);
		Reporter.log("Product created");

		//validation
		ProductInfoPage pip = new ProductInfoPage(driver);
		String headerText = pip.getHeaderText();
		
		Assert.assertTrue(headerText.contains(PRODUCTNAME));
		System.out.println(headerText);
		Reporter.log("Product header validated");
		
		Thread.sleep(3000);
	} 
	@Test
	
	public void createProductWithCategoryAndManufactr() throws EncryptedDocumentException, IOException
	{
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Products", 7, 2);
		String CATEGORY = eUtil.readDataFromExcelFile("Products", 7, 3);
		String MANUFACTURER = eUtil.readDataFromExcelFile("Products", 7, 4);

		HomePage hp = new HomePage(driver);
		hp.clickOnProductsTab();
		Reporter.log("Clicked on Products tab");
		
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProdBtn();
		Reporter.log("Clicked on create new product look up image");
		
		CreateNewProductPage cnp = new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME, CATEGORY, MANUFACTURER);
		Reporter.log("Product created");
		//validation
		ProductInfoPage pip = new ProductInfoPage(driver);
		String headerText = pip.getHeaderText();
		
		Assert.assertTrue(headerText.contains(PRODUCTNAME));
		System.out.println(headerText);
		Reporter.log("Product header validated");
		
	}

}
