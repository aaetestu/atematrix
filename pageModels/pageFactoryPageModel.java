package pageModels;

import org.openqa.selenium.WebElement;

public class pageFactoryPageModel {

	
	
	// Functions

	
	public pageFactoryPageModel clickLink(WebElement link) throws Exception {
		link.click();
		return this;
	}
	
	public pageFactoryPageModel setSearchKeyword(WebElement searchBar, String keyword) throws Exception {
		searchBar.clear();
		searchBar.click();
		searchBar.sendKeys(keyword);
		return this;
	}
	

}
