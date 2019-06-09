package ups.driver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ups.actions.UpsLoginPageActions;

public class UpsLoginPageDriver {

	protected WebDriver driver;
	public static final String URL = "https://www.ups.com/lasso/login";

	public UpsLoginPageDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	@BeforeClass
	public void beforeClass() {
		this.driver.get(URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public UpsLoginPageActions testLogin() {
		return new UpsLoginPageActions(this.driver);
	}

	@Test
	public void loginTest() {
		testLogin().user();
		testLogin().pass();
		testLogin().login();
		boolean fool = false;
		boolean bool = testLogin().msg();
		Assert.assertEquals(bool, false);

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
