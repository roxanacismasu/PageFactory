package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.utils.PropertiesFileProcessor;
import pageObjects.MenuPage;
import pageObjects.MyAccountPage;
import selenium.utils.BaseTest;
import selenium.utils.TestNgListener;

@Listeners(TestNgListener.class)

public class LoginTest extends BaseTest{

	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");
	
	@Test(priority=1)
	public void loginTest() {
		
		//MenuPage menuPage = new MenuPage(driver);
		app.click(app.menuPage.myAccountLink);
		
		//MyAccountPage myAccPage = new MyAccountPage(driver);
		app.myAccPage.loginInApp(USER, PASS);
		
		assertTrue(app.myAccPage.myAccountContent.isDisplayed());
		
		assertTrue(app.myAccPage.isElementDisplayed
				(app.myAccPage.myAccountContent));
		
		
		app.click(app.myAccPage.logoutBtn);
		
	}
	@Test(priority=2)
	public void invalidLoginTest() {
		
		//MenuPage menuPage = new MenuPage(driver);
		app.click(app.menuPage.myAccountLink);
		
		//MyAccountPage myAccPage = new MyAccountPage(driver);
		app.myAccPage.loginInApp("test", PASS);
		
		assertTrue(app.myAccPage.myAccountContent.isDisplayed());
		
		assertTrue(app.myAccPage.isElementDisplayed
				(app.myAccPage.myAccountContent));
		
	}

}
