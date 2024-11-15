package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;


public class BaseClass {
	
	public static ExtentReports extReport;
	public  static ExtentTest test;
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	public JavaUtility jLib = new JavaUtility();
	public WebdriverUtility wLib  = new WebdriverUtility();
	public FileUtility fLib = new FileUtility();
	public Excelutility eLib = new Excelutility();
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	
	@BeforeSuite
	public void configReport()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_report/extentReport_"+jLib.getSystemTime()+".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		sdriver = driver;
		wLib.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  //this also we can add in webdriver utility and reuse the method
		driver.get(fLib.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fLib.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fLib.getDataFromProperty("password"));
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout()
	{
		hp = new HomePage(driver);
		hp.getLogoutLink();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup()
	{
		extReport.flush();
	}
}
