package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class ContactFormTest extends BaseTest{

	@Test(priority=1)
	public void sendValidMessage() {
				
		app.click(app.menuPage.contactPageLink);
		app.contactPage.sendMessage("Ion", 
				"ion@ion.com", 
				"Salut ", 
				"Salut! Eu sunt Ion!");
		
		
		assertEquals(app.getElementText(app.contactPage.sentMsgTxt),
				"Thank you for your message. It has been sent.");
		
		assertEquals(app.contactPage.sentMsgTxt.getText(),
				"Thank you for your message. It has been sent.");
		
	}
	
	@Test(priority=2)
	public void sendInvalidMessage() {
		
		app.click(app.menuPage.contactPageLink);
		app.contactPage.sendMessage("Ion", 
				"", 
				"Salut ", 
				"Salut! Eu sunt Ion!");
		
		assertEquals(app.contactPage.sentMsgTxt.getText(),
				"Thank you for your message. It has been sent.");
		
	}
	
}
