package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonUtils.CommonMethods;

public class QuestPage extends CommonMethods{

	public QuestPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   public By quest_xpath = By.xpath("//*[contains(@id,'quest-card')]");
}
