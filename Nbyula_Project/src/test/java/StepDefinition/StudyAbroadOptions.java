package StepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.WebDriverSession;
import WebPages.HomePage;
import WebPages.LoginPage;
import io.cucumber.java.en.*;

public class StudyAbroadOptions {

	WebDriver driver;
	HomePage hp;
	LoginPage lop;

	public StudyAbroadOptions() throws IOException{
		driver = WebDriverSession.getWebDriver();
		hp = new HomePage(driver);
		lop = new LoginPage(driver);
	}

	@Given("User navigates to {string} and clicks on signin button")
	public void user_navigates_to_and_clicks_on_signin_button(String string) {
	    hp.get(string);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(hp.homepage_signinButton_btn)).click();
	}

	@And("user logins with valid {string} and {string}")
	public void user_logins_with_valid_and(String string, String string2) throws InterruptedException {
	    lop.Login(string, string2);
	}

	@When("user scrolls down and hovers on StudyAbroad")
	public void user_scrolls_down_and_hovers_on_study_abroad() throws InterruptedException {
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	   hp.hover(hp.homepage_StudyAbroad_Hover);
	   hp.screenShot();
	}

	@Then("User retrives all options")
	public void user_retrives_all_options() {
		List<WebElement> dropdownElements = driver.findElements(By.xpath("//a[contains(@href, \"/category/Study Abroad/\")]"));
		List<String> dropdownNames = new ArrayList<String>();
		for (WebElement dropdownElement : dropdownElements) {
		    dropdownNames.add(dropdownElement.getText());
		    System.out.println(dropdownNames);
		}

}
}
