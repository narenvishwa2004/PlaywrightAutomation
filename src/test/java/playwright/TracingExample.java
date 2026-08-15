package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TracingExample {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions type = new BrowserType.LaunchOptions().setHeadless(false);
		
		 Page page = playwright.chromium().launch(type).newPage();
	
		page.navigate("https://www.amazon.in/");
		
		page.locator("//input[@id='twotabsearchtextbox']").click();
		page.locator("//input[@id='twotabsearchtextbox']").fill("iphone 17");
		page.locator("//input[@id='nav-search-submit-button']").click();
		String assertion = page.locator("//h2[normalize-space()='Results']").textContent();
		
		System.out.println(assertion);
		
		page.goBack();
		
		Locator search2 = page.locator("//input[@id='twotabsearchtextbox']");
		search2.clear();
		search2.fill("oppo");
		page.locator("//input[@id='nav-search-submit-button']").click();
		
		playwright.close();
			
		
		
		
		
		
	}

}
