package ups.actions;

import org.openqa.selenium.WebDriver;

import ups.pages.UpsLoginPageElements;

public class UpsLoginPageActions {
	UpsLoginPageElements loginPage;

	public UpsLoginPageActions(WebDriver driver) {
		this.loginPage = new UpsLoginPageElements(driver);

	}

	public void user() {
		loginPage.userID().sendKeys("Hello");
	}

	public void pass() {
		loginPage.password().sendKeys("world");

	}

	public void login() {
		loginPage.login().click();
	}

	public boolean msg() {
		boolean str = loginPage.errorMsg().isDisplayed();
		return str;
	}

}
