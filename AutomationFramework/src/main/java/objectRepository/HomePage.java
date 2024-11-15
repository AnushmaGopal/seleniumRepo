
package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	//declaration
	@FindBy(linkText = "Books")
	private WebElement booksLink;


	@FindBy(linkText = "Computers")
	private WebElement computerLink;

	@FindBy(linkText = "Electronics")
	private WebElement electronicsLink;

	@FindBy(linkText = "Gift Cards")
	private WebElement giftcardLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;


	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputerLink() {
		return computerLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getGiftcardLink() {
		return giftcardLink;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}

}

