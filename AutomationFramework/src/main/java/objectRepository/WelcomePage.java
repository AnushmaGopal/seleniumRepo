package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {


	// declaration
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement LoginLink;

	// Initialization
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// getters
	public WebElement getLoginLink() {
		return LoginLink;
	}
}

