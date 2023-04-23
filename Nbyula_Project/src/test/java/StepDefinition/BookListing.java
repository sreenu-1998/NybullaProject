package StepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.WebDriverSession;
import WebPages.HomePage;
import WebPages.ListingPage;
import WebPages.LoginPage;
import io.cucumber.java.en.*;

public class BookListing {
	WebDriver driver;
	HomePage hp;
	ListingPage lp;
	LoginPage lop;
	

	public BookListing() throws IOException{
		driver = WebDriverSession.getWebDriver();
		hp = new HomePage(driver);
		lp = new ListingPage(driver);
		lop = new LoginPage(driver);
		
	}

@Given("user navigates to {string}")
public void user_navigates_to(String string) {
 hp.get(string);

}

@And("cicks on signin button.")
public void cicks_on_signin_button() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(hp.homepage_signinButton_btn)).click();

}

@And("user clicks on see other login options in the pop up")
public void user_clicks_on_see_other_login_options_in_the_pop_up() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(hp.homepage_seeOtherLoginOptions_Optn)).click();
}

@And("user provides {string} and clicks on Continue")
public void user_provides_polukurisrinivasreddy1998_gmail_com_and_clicks_on_continue(String string) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(lop.login_email_Txtbox)).sendKeys(string);
	 driver.findElement(lop.login_continue_btn).click();
}

@When("user provides {string} and clciks on Continue")
public void user_provides_srinivas_and_clciks_on_continue(String string) throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(lop.login_password_Txtbox).sendKeys(string);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(lop.login_continue_btn)).click();

}

@And("user logs in to application succcessfully")
public void user_logs_in_to_application_succcessfully() throws InterruptedException {
	Thread.sleep(2000);
	System.out.println(hp.getTitle());
    }

@And("user is on booking page and clicks on book a seat")
public void user_is_on_booking_page_and_clicks_on_book_a_seat() {
	hp.get("https://nby.la/rdJuXp ");
    hp.screenShot();
}

@And("user clicks on Proceed")
public void user_clicks_on_proceed() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(lp.ListingPage_Proceed_Btn)).click();
}

@And("user clicks on Confirm free booking")
public void user_clicks_on_confirm_free_booking() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(lp.ListingPage_ConfirmFreeBooking_Btn)).click();
}

@When("user provides {string} and clicks continue")
public void user_provides_and_clicks_continue(String string) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(lp.ListingPage_MobileNo_TxtBox)).sendKeys(string);
	 wait.until(ExpectedConditions.elementToBeClickable(lp.ListingPage_Continue_Btn)).click();
}

@Then("Listing is booked successfuly")
public void listing_is_booked_successfuly() throws InterruptedException {
 Thread.sleep(2000);
 hp.screenShot();
}


}
