package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonUtils.CommonMethods;

public class HomePage extends CommonMethods{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By homepage_globalSearchBox_TxtBox = By.xpath("//*[@id=\"global-search-bar\"]");
	public By homepage_explore_Hover = By.xpath("//*[@id=\"navigation__mobile__top\"]/div/div[3]/div[1]/div[1]");
	public By homepage_becomeMember_btn = By.xpath("//*[@id=\"navigation__mobile__top\"]/div/div[3]/div[2]/a/div");
	public By homepage_pageSearchBox_TxtBox = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[3]/div/div/div/input");
	public By homepage_searchButton_Btn = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[3]/div/div/button");
	public By homepage_explore_quest_Optn = By.xpath("//li[text()='Quest']");
	public By homepage_signinButton_btn = By.xpath("//*[@id=\"navbar-sign-in\"]/span");
	public By homepage_seeOtherLoginOptions_Optn = By.partialLinkText("See other login options");
	public By homepage_StudyAbroad_Hover = By.xpath("//*[@id=\"_category-navigation-bar\"]/div/div/div[2]/div[1]/div[1]/a/div");
}
