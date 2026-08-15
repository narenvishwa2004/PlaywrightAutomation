package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightSampleTest {

    @Test
    public void verifyGoogleTitle() {
        // 1. Initialize Playwright
        Playwright playwright = Playwright.create();

        // 2. Launch Chromium in headless mode
        Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(true)
        );

        // 3. Open a new page and navigate
        Page page = browser.newPage();
        page.navigate("https://www.google.com");

        // 4. Verify title
        String title = page.title();
        System.out.println("Loaded page title: " + title);
        Assert.assertTrue(title.contains("Google"), "Title did not match!");

        // 5. Cleanup
        browser.close();
        playwright.close();
    }
}