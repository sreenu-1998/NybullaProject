package StepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.WebDriverSession;
import WebPages.HomePage;
import WebPages.QuestPage;
import io.cucumber.java.en.*;

public class VerifyQuestSD {
	WebDriver driver;
	HomePage hp;
	QuestPage qp;

	public VerifyQuestSD() throws IOException{
		driver = WebDriverSession.getWebDriver();
		hp = new HomePage(driver);
		qp = new QuestPage(driver);
	}
	
	@Given("user is one homepage {string}")
	public void user_is_one_homepage(String string) {
	    hp.get(string);
	}

	@And("hovers to explore button and clicks on quest")
	public void hovers_to_explore_button_and_clicks_on_quest() throws InterruptedException {
		By hoverLocator = hp.homepage_explore_Hover;
		By questLocator = hp.homepage_explore_quest_Optn;
		hp.hoverDropDown(hoverLocator,questLocator );

	}

	@When("atleast one quest found")
	public void atleast_one_quest_found() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(qp.quest_xpath));
        List<WebElement> quests = driver.findElements(By.xpath("//*[contains(@id,\"quest-card\")]"));
	    int count = quests.size();
	    System.out.println(count);
	    if(count>1) {
	    	System.out.println("Atleat 1 quest is available");
	    }else
	    	System.out.println("No quests found");
	    
	}

	@Then("user closes website")
	public void user_closes_website() {
	    driver.quit();
	}
}
