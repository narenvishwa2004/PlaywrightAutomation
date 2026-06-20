package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserTypePractice {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
		
		
		
		 Browser browser = playwright.chromium().launch(options);
		 
		Page page1 = browser.newPage();
		 
		
//		page.navigate("https://www.amazon.in/");
//		page.locator("//input[@id='twotabsearchtextbox']").fill("iphone");
//		page.locator("//input[@id='nav-search-submit-button']").click();
//		String text = page.locator("(//span[@class='a-size-medium a-color-base'][normalize-space()='Apple'])[1]").textContent();
//		
//		System.out.println(text);
//		
		
		
		
		LaunchOptions browser2 = new BrowserType.LaunchOptions().setHeadless(false);
		
		Page page2 = playwright.chromium().launch(browser2).newPage();
		page2.navigate("https://www.amazon.in/");
		page2.locator("//a[normalize-space()='MX Player']").click();
		String mx = page2.locator("//span[contains(@class,'AppNavbar_active__croed AppNavbar_navItem__SnsLh')]").textContent();
		System.out.println(mx);
		
		page2.bringToFront();
		page2.locator("//input[@id='twotabsearchtextbox']").fill("moto");
		
		
		
		
		
	}

}
