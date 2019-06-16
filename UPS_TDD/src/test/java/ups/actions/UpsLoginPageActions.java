package ups.actions;

import org.openqa.selenium.WebDriver;

import ups.pages.UpsLoginPageElements;

public class UpsLoginPageActions {
	UpsLoginPageElements loginPage;

	public UpsLoginPageActions(WebDriver driver) {
		this.loginPage = new UpsLoginPageElements(driver);
	}

	public void userID() {
		loginPage.userID().sendKeys("Hello");
	}

	public void password() {
		loginPage.password().sendKeys("world");
	}

	public void login() {
		loginPage.login().click();
	}

	public boolean loginErrormsg() {
		boolean str = loginPage.errorMsg().isDisplayed();
		return str;
	}

}
