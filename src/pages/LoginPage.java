package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.LoginTesting;

public class LoginPage {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	// WEB ELEMENTS CREATION
	
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(className="rememberMe")
	WebElement Rememberme;
	
	@FindBy(name="btn_login")
	WebElement Login;
	
	@FindBy(id="msg_box")
	WebElement ErrorMsg;
	
	
	
	//CONSTRUCTOR
	
	public LoginPage() {
		driver = LoginTesting.driver;
		report = LoginTesting.report;
		test = LoginTesting.test;
		
		//Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	//METHODS
	
	public void login(String uname,String pass) {
		
		test = report.startTest("Login Test Case");
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Login page loaded successfully");
		
		WebDriverWait wait = new WebDriverWait(driver,30);		
		wait.until(ExpectedConditions.elementToBeClickable(UserName));
		
		UserName.sendKeys(uname);
		test.log(LogStatus.PASS, "Successfully provided user name");
		
		Password.sendKeys(pass);
		test.log(LogStatus.PASS, "Successfully provided password");
		
		Rememberme.click();
	
		Login.click();
		test.log(LogStatus.PASS, "Successfully clicked on Login Button");
		
		String ActMsg = ErrorMsg.getText();
		System.out.println("ActMsg:" + ActMsg);
		String ExpMsg = "The email or password you have entered is invalid.";

		Assert.assertEquals(ActMsg, ExpMsg);
	}
	
}


