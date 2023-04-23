package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Assertion {
	public boolean testCaseStatus = true;
	private WebDriver driver;
	private File file;
	private String testScreenshotDir;
	boolean testStatus;

	public Assertion(WebDriver driver) {
		file = new File("");
		testScreenshotDir = file.getAbsoluteFile()
				+ "//src//test//java//Output//";
		this.driver = driver;
		
	}

	
	public String screenShot() {
		String screenshotPath = "screenshot" + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
		.format(new GregorianCalendar().getTime())
		+ ".png";

		System.out.println(screenshotPath);
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File( testScreenshotDir + screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			screenshotPath = "";
		}
		return screenshotPath;
	}
	
	
	public void screenShot(String message) {
		String screenshotPath = message+ "screenshot" + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
		.format(new GregorianCalendar().getTime())+
		".png";

		System.out.println(screenshotPath);
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File( testScreenshotDir + screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			screenshotPath = "";
		}
	}

	
	
	public boolean verifyEquals(Object actual, Object expected, String message) {
		testStatus=true;
		
		try {
			Assert.assertEquals(actual, expected, message);
			screenShot();

		} catch (AssertionError e) {
		
			testStatus = false; 
			screenShot();
			
					}
		return testStatus;
	}
}