package playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordVideo {
	
	public static void main(String[] args) {
		
		Playwright playeright = Playwright.create();
		
		BrowserType browserType = playeright.chromium();
		LaunchOptions browser = new BrowserType.LaunchOptions().setHeadless(false);
		
		Browser tyep = browserType.launch(browser);
		
		BrowserContext videoSettingd = tyep.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		

		Page page = videoSettingd.newPage();
	
		page.navigate("https://www.amazon.in/");	
		page.locator("//a[normalize-space()='MX Player']").click();
		String mx = page.locator("//span[contains(@class,'AppNavbar_active__croed AppNavbar_navItem__SnsLh')]").textContent();
		System.out.println(mx);
		page.goBack();
		page.locator("//a[normalize-space()='Sell']").click();
		page.goBack();
		
		
	page.close();
;		
		

		
}
	
	
	

}
