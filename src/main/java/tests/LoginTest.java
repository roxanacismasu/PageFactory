package tests;

import org.testng.annotations.Test;

import framework.utils.PropertiesFileProcessor;
import pageObjects.MenuPage;
import pageObjects.MyAccountPage;
import selenium.utils.BaseTest;

public class LoginTest extends BaseTest{

	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");
	
	@Test
	public void loginTest() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.myAccountLink);
		
		MyAccountPage myAccPage = new MyAccountPage(driver);
		myAccPage.loginInApp(USER, PASS);
		
		
	}
	

}
