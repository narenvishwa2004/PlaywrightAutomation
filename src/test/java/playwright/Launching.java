package playwright;
import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Launching {
	
	public static void main(String[] args) {
		
//		Playwright playwright = Playwright.create();
//		LaunchOptions browser = new BrowserType.LaunchOptions().setHeadless(false);
//		
//		Page page = playwright.chromium().launch(browser).newPage();
//		page.navigate(null);
		
		
		
		Playwright playwright = Playwright.create();
		LaunchOptions browser = new BrowserType.LaunchOptions().setHeadless(false);
		
		 Page page = playwright.chromium().launch(browser).newPage();
		 page.navigate("https://www.amazon.in/");
		 page.locator("//input[@id='twotabsearchtextbox']").fill("iphone");
		 page.locator("//input[@id='nav-search-submit-button']").click();
	    
		 String phone = page.locator("(//span[@class='a-size-medium a-color-base'][normalize-space()='Apple'])[1]").textContent();
		 System.out.println(phone);
		
		 page.locator("//a[normalize-space()='2']").scrollIntoViewIfNeeded();
		 page.goBack();
		 page.close();
	
		
		
			
		

}
}