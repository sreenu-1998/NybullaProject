package WebPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.CommonMethods;

public class LoginPage extends CommonMethods{
	WebDriver driver = null;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public By login_email_Txtbox = By.xpath("//*[@id=\"text-input-1\"]");
	public By login_continue_btn = By.xpath("//*[@id=\"login-custom\"]");
	public By login_continue_with_google = By.xpath( "//*[@id=\"login-google\"]/span[2]");
	public By login_with_linkdIn = By.xpath("//*[@id=\"login-linkedin\"]/span[1]/svg");
	public By login_whatsapp_btn = By.xpath("//*[@id=\"whatsapp-login-button\"]");
	public By login_password_Txtbox = By.xpath("//input[@type=\"password\"]");
	public By login_submit_btn = By.xpath("//*[@id=\"login-custom\"]");
	
	public void Login(String email, String password) throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("See other login options")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(login_email_Txtbox)).sendKeys(email);
		 driver.findElement(By.xpath("//*[@id=\"login-custom\"]")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(login_password_Txtbox)).sendKeys(password);
		 wait.until(ExpectedConditions.elementToBeClickable(login_submit_btn)).click();
	}
}
