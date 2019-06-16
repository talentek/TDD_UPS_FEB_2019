package ups.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ups.actions.UpsLoginPageActions;
import ups.driver.UpsDriver;

public class UpsLoginPageTest extends UpsDriver{

	WebDriver driver;
	UpsLoginPageActions upsLoginTest;
	public static final String URL = "https://www.ups.com/lasso/login";

	public UpsLoginPageTest() {
		this.driver = getChromeDriver();
		upsLoginTest = new UpsLoginPageActions(this.driver);
	}

	@BeforeClass
	public void beforeClass() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void verifyLoginError() {
		upsLoginTest.userID();
		upsLoginTest.password();
		upsLoginTest.login();
		boolean bool = upsLoginTest.loginErrormsg();
		Assert.assertEquals(bool, true);
	}
	
	@Test
	public void funLoginMsg(){
		System.out.println("UPS Login: Test is Fun");
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
