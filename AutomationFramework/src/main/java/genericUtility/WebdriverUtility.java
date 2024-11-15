package genericUtility;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * @author anushma
 */
public class WebdriverUtility {

	public void maximizeWindow(WebDriver driver)
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is uesd to capture size of a window
	 * @param driver
	 * @return
	 */
	public Dimension getSize(WebDriver driver)
	{
		return driver.manage().window().getSize();
	}
	
	/**
	 * This method is used to switch driver control to window based on url
	 * @param driver
	 * @param url
	 */
	
	public void swithToWindow(WebDriver driver, String url) 
	{
		//step1: capture the window ids
		Set<String> allWids = driver.getWindowHandles();
		//step2: navigate through all the windows
		for (String id : allWids) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(url)) {
				break;
			}
		}
		
	}
	/**
	 * This method is used to right click
	 * @param driver
	 */
	public void rightclick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		 act.contextClick().perform();
	}
	/**
	 * This method is used to click and hold on webElement
	 * @param driver
	 */
	public void clickAndhold(WebDriver driver, WebElement elem)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(elem).perform();

	}
	/**
	 *  This method is used to mouse hover on webElement
	 * @param driver
	 * @param elem
	 */
	
	public void mouseHover(WebDriver driver, WebElement elem) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(elem).perform();

	}
	public void mouseHover(WebDriver driver, int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x,y).perform();
	}
	/**
	 * This method is used to drag and drop
	 * @param driver
	 * @param elem
	 */
	public void dragAndDrop(WebDriver driver, WebElement elem)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(elem, elem);
	}
	
	/**
	 * These methods are used to switch to frame
	 * @param driver
	 * @param index
	 */
	public void switchToframe(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	public void switchBackToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * These methods are used for performing actions on dropdown (select class)
	 * @param elem
	 */
	public void dropDownByIndex(WebElement elem, int index)
	{
		Select select = new Select(elem);
		select.selectByIndex(index);
	}
	public void dropDownByValue(WebElement elem, String value)
	{
		Select select = new Select(elem);
		select.selectByValue(null);;

	}
	
	public void dropDownByVisibleText(WebElement elem, String text)
	{
		Select select = new Select(elem);
		select.selectByVisibleText(text);

	}
	
	/**
	 * These methods are used to switch to alert
	 * @param driver
	 * @return
	 */
	public Alert switchToAlert(WebDriver driver)
	{
		return driver.switchTo().alert();
	}
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDissmis(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertAndSendkeys(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	public  void jsScroll(WebDriver driver, int x, int y) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scollBy("+x+","+y+")");
	}
	

}
