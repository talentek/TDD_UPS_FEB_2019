package multi.windows.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ups.actions.UpsLoginPageActions;
import ups.driver.UpsDriver;

public class MultiWIndows extends UpsDriver {
	WebDriver driver;
	UpsLoginPageActions upsLoginTest;
	public static final String URL = "http://www.popuptest.com/";

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		driver = getChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void handleMultiWindows() {
		WebElement click = driver.findElement(By.linkText("Multi-PopUp Test #2"));
		click.click();

		// This will return the parent window name as a String
		String parent = driver.getWindowHandle();

		// This will return the number of windows opened by WebDriver
		Set<String> s1 = driver.getWindowHandles();

		// Now we will iterate using Iterator
		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}
		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
