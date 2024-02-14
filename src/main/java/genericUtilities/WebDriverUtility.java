package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.command.CopyFileFromContainerCmd;
import com.google.common.io.Files;

/**
 * This class consists of all methods related to web driver actions
 * @author hnraj
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait till page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait until particular element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	
	/**
	 * This method will move cursor to the element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will move cursor based on offset and clicks on the web page
	 * @param driver
	 */
	public void moveAndClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}
	
	/**
	 * This method will perform right click
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform double click
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param ele1
	 * @param ele2
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement destEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, destEle).perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by name or ID
	 * @param driver
	 * @param index
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame by web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will scroll down webpage by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	
	/**
	 * This method will scroll up web page by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500);", "");
	}
	
	/**
	 * This method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will fetch the text from alert and return it to the caller
	 * @param driver
	 * @return
	 */
	public String getTextFromAlert(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This method will capture screenshot and returns file path to the caller
	 * @param driver
	 * @param screenshotName 
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);// Temporary location
		File dest = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);					//Scenario1.png
		return dest.getAbsolutePath();// Used for extent reports
	}
	
	/**
	 * This method will switch windows
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//Capture all window Ids
		Set<String> allWinIds = driver.getWindowHandles();
		
		//navigate through all window Ids
		for(String winID:allWinIds)
		{
			//capture page title
			String title = driver.switchTo().window(winID).getTitle();
			
			//Compare page title with partial title
			if(title.contains(partialTitle))
			{
				break;
			}
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
