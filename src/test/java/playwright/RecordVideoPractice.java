package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;

public class RecordVideoPractice {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
		BrowserType browser = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
	Browser type = browser.launch(headless);
BrowserContext recorvd = type.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("video/")));	

	
	}

}
