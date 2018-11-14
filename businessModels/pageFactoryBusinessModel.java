package businessModels;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import pageModels.pageFactoryPageModel;

	
	
	public class pageFactoryBusinessModel {
		

		// Locators
		@FindBy(id="lst-ib")
		WebElement googleSearchField;
		
		@FindBy(xpath="//*[@id=\"sbtc\"]/div[2]/div[2]/div[1]/div/ul/li[11]/div/span[1]/span/input")
		WebElement googleSearchButton;

		@FindBy(xpath="//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/div[1]/a[1]/h3")
		WebElement seleniumSiteLink;
		
		@FindBy(xpath="//*[@id=\"mainContent\"]/h2[1]")
		WebElement homePageHeader;
		
		@FindBy(xpath="//*[@id=\"menu_download\"]/a")
		WebElement downloadPageLink;
		
		@FindBy(xpath="//*[@id=\"mainContent\"]/h2")
		WebElement downloadsPageHeader;
	

 public pageFactoryBusinessModel(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
		
		// Functions

		pageFactoryPageModel page = new pageFactoryPageModel();
		
		
		public pageFactoryBusinessModel openSeleniumhqSite(WebDriver driver) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.urlToBe("https://www.google.com/?gws_rd=ssl"));
			page.clickLink(googleSearchField);
			page.setSearchKeyword(googleSearchField, "Selenium");
			page.clickLink(googleSearchButton);
			page.clickLink(seleniumSiteLink);
			return this;
		}
		
		public pageFactoryBusinessModel openSeleniumhqSiteDownloadPage(WebDriver driver) throws Exception {
			page.clickLink(downloadPageLink);
			return this;
		}
		
		public String getHomePageHeaderText() throws Exception {
			String text = homePageHeader.getText();
			return text;
		}
		
		public String getDownloadPageHeaderText() throws Exception {
			String text = downloadsPageHeader.getText();
			return text;
		}
	}



