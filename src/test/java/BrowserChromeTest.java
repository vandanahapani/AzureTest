import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BrowserChromeTest {
	public WebDriver driver;
	public static String browser;
	

	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("Launching Chrome browser");
		
		browser="chrome"; //Temp
		if (browser.equalsIgnoreCase("chrome")) {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		    
		    ChromeOptions options = new ChromeOptions();

		    options.addArguments("--disable-gpu");
		    options.addArguments("--remote-allow-origins=*");
		    
		    options.setExperimentalOption("prefs", chromePrefs);
		    options.addArguments("disable-infobars");
		    options.addArguments("disable-extensions");
		    options.addArguments("--headless");
		    options.addArguments("window-size=1920x1080");
		    options.addArguments("--start-maximized");
		    options.addArguments("--incognito");
		    options.addArguments("--ignore-ssl-errors=yes");
		    options.addArguments("--ignore-certificate-errors");
		    System.out.println("This is azure env");
		    
		
		    driver = new ChromeDriver(options);
			// driver = initChromeDriverIncognito();
		} else if (browser.equalsIgnoreCase("Edge")) {
//		    System.setProperty("webdriver.edge.driver", "Lib\\MicrosoftWebDriver.exe");
//		    DesiredCapabilities capabilities = DesiredCapabilities.edge();
//		    driver = new EdgeDriver(capabilities);
		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "Lib\\geckodriver.exe");
//		    driver = new FirefoxDriver();
		}
		
	}
	@Test
	public void TestBrowser() {
		driver.get("http://google.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title : " + strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			System.out.println("Closing Chrome browser");
			driver.quit();
		}
	}

}
