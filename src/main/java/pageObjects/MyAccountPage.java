package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="username")
	public WebElement userField;
	
	@FindBy(id="password")
	public WebElement passField;
	
	@FindBy(name="login")
	public WebElement submitButton;
	
	public void loginInApp(String user, String pass) {
		
		sendKeys(userField, user);
		sendKeys(passField, pass);
		click(submitButton);
		
	}
	
	

}
