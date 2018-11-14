package tests;

import org.testng.annotations.Test;

import businessModels.pageFactoryBusinessModel;
import tools.SetupDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class pageFactoryTests {

	protected WebDriver driver;

	@Test
	public void testHomePageHeaderText() throws Exception {
		pageFactoryBusinessModel model = new pageFactoryBusinessModel(driver);
		model.openSeleniumhqSite(driver);
		Assert.assertEquals(model.getHomePageHeaderText(), "What is Selenium?");
	}

	@Test
	public void testDownloadsPageHeaderText() throws Exception {
		pageFactoryBusinessModel model = new pageFactoryBusinessModel(driver);
		model.openSeleniumhqSite(driver);
		model.openSeleniumhqSiteDownloadPage(driver);
		Assert.assertEquals(model.getDownloadPageHeaderText(), "Downloads");
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		SetupDriver test = new SetupDriver(driver);
		driver = test.driver(driver);
		test.launchWebDriver(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
