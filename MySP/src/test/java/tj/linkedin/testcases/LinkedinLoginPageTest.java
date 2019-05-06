package tj.linkedin.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import tj.linkedin.base.TestBase;
import tj.linkedin.pages.LinkedinLoginPage;

public class LinkedinLoginPageTest extends TestBase  {
	LinkedinLoginPage linkedinLoginPage;
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		linkedinLoginPage = new LinkedinLoginPage();
	}
	
	@Test(priority=2)
	public void validateLinkedImgExistTest(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='lazy-loaded']")));
		boolean flag = linkedinLoginPage.validateLinkedImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("LinkedIn: Log In or Sign Up"));
		String title = linkedinLoginPage.validateLoginPageTitle();
		softAssert.assertTrue(title.contains("LinkedIn: Log In or Sign Up"));
   }

  	@Test(priority=3)
	public void loginTest() {
		linkedinLoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}