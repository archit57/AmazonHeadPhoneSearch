package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;

public abstract class PageBase {

	/**
	 * The Driver.
	 */
	protected WebDriver driver = null;
	public Logger log = TestBase.log;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Wait
	 */
	public static void wait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sample action code
	 */
	public void pressEnter() {
		try {
			Thread.sleep(500);
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ENTER).perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void navigateback(int count) {
		for (int i = 1; i <= count; i++) {
			driver.navigate().back();
			wait(1);
		}
	}

	public void navigateForward(int count) {
		for (int i = 1; i <= count; i++) {
			driver.navigate().forward();
			wait(1);
		}

	}

	public void pageRefresh() {
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.F5).perform();
	}

}
