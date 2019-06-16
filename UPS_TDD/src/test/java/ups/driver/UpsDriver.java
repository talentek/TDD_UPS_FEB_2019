package ups.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UpsDriver {

	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
