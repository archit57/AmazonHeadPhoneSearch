package sanitySuite;

import org.testng.annotations.Test;

import base.TestBase;
import pages.AmazonSearch;

public class TestCaseAmazonSearch extends TestBase {

	AmazonSearch objAmazonSearch;

	@Test(priority = 1, description = "Amazon Test case")
	public void openAmazonAddtocart() {
		log.info("Open Amazon home Page.");
		driver.navigate().to(data.getProperty("base.url"));
		log.info("Get input string from properties file and put it into the search box.");
		objAmazonSearch = new AmazonSearch(driver);
		objAmazonSearch.searchByFirstOption(data.getProperty("TestCase_1.searchString_1"));
		log.info("Checking the count of Best Seller of Headphones");
		log.info("Adding Headphones having best Seller tag into cart");
		objAmazonSearch.addtocart(data.getProperty("filter.param"), data.getProperty("base.url"));
		objAmazonSearch.pageRefresh();

	}

}
