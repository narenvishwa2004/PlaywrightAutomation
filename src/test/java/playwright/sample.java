package playwright;


import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class sample {
	
	public static void main(String[] args) {
		
		
		Playwright playwright = Playwright.create();
		LaunchOptions browser = new BrowserType.LaunchOptions().setHeadless(false);
		
		Page page = playwright.chromium().launch(browser).newPage();
		page.navigate(null);
		
		
		
		
	}
	

	
}
