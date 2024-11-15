package books;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.Listenerutility;
import objectRepository.HomePage;
@Listeners(Listenerutility.class)
public class TC_DWS_005_Test extends BaseClass {

	@Test
	public void clickOnBooks() throws IOException 
	{
		test = extReport.createTest("clickOnBooks");
		hp = new HomePage(driver);
		hp.getBooksLink().click();
		
		Assert.assertEquals(driver.getTitle(), eLib.getStringDataFromExcel("Books", 1, 0),"Book page is not displayed");
		test.log(Status.PASS, "Book page is displayed");
	}
}
