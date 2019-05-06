package tj.linkedin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import tj.linkedin.utils.TestUtil;

public class TestBase {
   	
	public static WebDriver driver;
	public static Properties prop;

// Load Global Environment Variables using Configuration Properties
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java"
					+ "/tj/linkedin/config/config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace ();
			}
}
// Initialize WebDriver and Launch Browser
    public static void initialization() throws InterruptedException {
    String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
	    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
   }
	else 
		System.out.println ("Driver only configured for Chrome");
    }
	


}