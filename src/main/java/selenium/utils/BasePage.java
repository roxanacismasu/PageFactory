package selenium.utils;

import org.openqa.selenium.WebDriver;
import pageObjects.*;
public class BasePage extends SeleniumWrappers{

	public BasePage(WebDriver driver) {
		super(driver);
		
	}
	
	public MenuPage menuPage = new MenuPage(driver);
	public MyAccountPage myAccPage = new MyAccountPage(driver);
	public ContactPage contactPage =  new ContactPage(driver);


}
