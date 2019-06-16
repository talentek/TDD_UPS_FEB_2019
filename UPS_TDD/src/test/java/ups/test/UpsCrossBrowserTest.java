package ups.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ups.actions.UpsLoginPageActions;
import ups.driver.UpsCrossBrowserDriver;

public class UpsCrossBrowserTest extends UpsCrossBrowserDriver {
	WebDriver driver;
	UpsLoginPageActions upsLoginTest;
	public static final String URL = "https://www.ups.com/lasso/login";

	@BeforeClass(alwaysRun = true)
	@Parameters(value = { "browser" })
	public void beforeClass(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = getChromeDriver();
			upsLoginTest = new UpsLoginPageActions(driver);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = getFirefoxDriver();
			upsLoginTest = new UpsLoginPageActions(driver);
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(groups = { "upstest" }, priority = 2)
	public void verifyLoginError() {
		upsLoginTest.userID();
		upsLoginTest.password();
		upsLoginTest.login();
		boolean bool = upsLoginTest.loginErrormsg();
		Assert.assertEquals(bool, true);
	}

	@Test(groups = { "funtest" }, priority = 1)
	public void funLoginMsg() {
		System.out.println("UPS Login: Test is Fun");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
