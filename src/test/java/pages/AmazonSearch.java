package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/*******************************************************************************************
 * Page Factory class Template
 * @author Shirish Kawatkar
 *******************************************************************************************/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class AmazonSearch extends PageBase {

	public AmazonSearch(WebDriver driver) {
		super(driver);
	}

	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	/*******************************************************************************************
	 * All Methods for performing actions
	 * 
	 * @return
	 *******************************************************************************************/

	public void enter_text(String Search_text) {

		log.info("Enter text to search: " + Search_text);
		searchBox.sendKeys(Search_text);
		pressEnter();
	}

	public int getApperanceCount(String SearchString) {

		log.info("Enter text to search: " + SearchString);
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[contains(text(),'" + SearchString + "')]"));
		System.out.println("Number of products with best sellers are " + listOfElements.size());
		return (listOfElements.size());
	}

	public void addtocart(String SearchString, String homepageurl) {
		int size = getApperanceCount(SearchString);
		for (int i = 1; i <= size; i++) {
			driver.findElement(By.xpath("(//*[contains(text(),'" + SearchString + "')])[" + i
					+ "]/../../../../../../../../../div[2]/div[2]/div/div[1]")).click();
			driver.findElement(By.id("add-to-cart-button")).click();
			wait(1);
			navigateback(2);
			if (driver.getCurrentUrl().equals(homepageurl)) {
				navigateForward(1);
			}
		}
	}

	/*******************************************************************************************
	 * This POM method will be exposed in test case
	 * 
	 * @param
	 *******************************************************************************************/

	public void searchByFirstOption(String text_to_search) {
		enter_text(text_to_search);

	}

}
