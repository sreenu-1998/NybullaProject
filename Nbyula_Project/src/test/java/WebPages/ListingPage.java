package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonUtils.CommonMethods;

public class ListingPage extends CommonMethods{

	public ListingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public By ListingPage_Proceed_Btn = By.xpath("//*[@id=\"skylift-proceed-to-purchase\"]");
public By ListingPage_ConfirmFreeBooking_Btn = By.xpath("//*[@id=\"continue-to-pay-zero-dollar\"]");
public By ListingPage_MobileNo_TxtBox = By.xpath("//*[@id=\"modal\"]/div[2]/div[2]/section/div[2]/div/input");
public By ListingPage_Continue_Btn = By.xpath("//*[@id=\"modal\"]/div[2]/div[2]/section/div[3]/button");


}
