package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;

public class Tracing {
	
	
	public static void main(String[] args) {
		
		
		Playwright playwright = Playwright.create();
		BrowserType browsertype = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browsertype.launch();
		BrowserContext context = browser.newContext();
		
		context.tracing();
		
		
		
		
		 
		
		
		
		
		
		
		
		
	}

}
