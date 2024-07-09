package selenium.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseTest {

	public static WebDriver driver;
	public BasePage app;
	@Parameters({"appURL"})
	@BeforeClass(alwaysRun = true)
	public void setup(String url) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		app = new BasePage(driver);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);//bad practice
		//driver.close();//inchide tab-ul curent
		driver.quit();//inchide fereastra de browser
		
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result ) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot obj = (TakesScreenshot) driver;
			File picture = obj.getScreenshotAs(OutputType.FILE);
			String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			try {
				
				Files.copy(picture, new File("screenshots/"+result.getName()+"-"+ time+".png"));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
