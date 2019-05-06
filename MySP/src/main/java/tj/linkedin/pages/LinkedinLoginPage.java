package tj.linkedin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tj.linkedin.base.TestBase;

public class LinkedinLoginPage extends TestBase {

	//Build Object Repository for Page Objects
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement signInBtn;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement clickSignBtn;
	
	@FindBy(xpath="//*[contains(@class,'lazy-loaded')]")
	WebElement linkedlogo;
		
	//Initialize Page Objects
	public LinkedinLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Header_Logo
	public boolean validateLinkedImage(){
		return linkedlogo.isDisplayed();
	}
	
	//LINKEDIN Page Title
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	//Login
	public void Login(String usr, String pwd) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", signInBtn);
    	username.sendKeys(usr);
		password.sendKeys(pwd);
		js.executeScript("arguments[0].click();", clickSignBtn);
		
	}
	
}
