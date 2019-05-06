package tj.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tj.linkedin.base.TestBase;

public class LinkedinMainPage extends TestBase {
	
	@FindBy(xpath="//*[contains(@class,'profile-photo')]")
	WebElement profilepicimage;

	//Initialize Page Objects
		public LinkedinMainPage() {
			PageFactory.initElements(driver, this);
		}
		
    //Validate Profile Image Available
		public boolean validateProfileImgExist() {
			return profilepicimage.isDisplayed();
		}
}