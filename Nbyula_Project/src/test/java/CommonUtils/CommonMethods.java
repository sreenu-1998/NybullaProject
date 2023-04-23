package CommonUtils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends Assertion{
       WebDriver driver;
	public CommonMethods(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	public void get(String url){
		driver.get(url);
	}


	
	public void navigate(String url){
		driver.navigate().to(url);
	}

	
	public void clickOnElementUsingActions(By element){
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element));
		actions.click().perform();
	}
	
	
	
	public void clickOnElementUsingJs(By element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement webElement = driver.findElement(element);
		js.executeScript("arguments[0].click();", webElement);
	}


	
	public String getTitle(){
		return driver.getTitle();
	}

	
	public void waitForPageToLoad(String PageName) {
		String pageLoadStatus;
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		pageLoadStatus = (String)js.executeScript("return document.readyState");
		System.out.println(pageLoadStatus);
		}


		public Boolean isElementPresent(By targetElement) throws InterruptedException{
		Boolean isPresent = driver.findElements(targetElement).size() > 0;
		return isPresent;
	}


	
	public Boolean isElementNotPresent(By targetElement) throws InterruptedException{
		Boolean isPresent = (driver.findElements(targetElement).size() == 0);
		return isPresent;
	}


	
	public boolean waitForVisibility(By targetElement) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is not visible: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}

	
	public boolean waitForElementToBeClickable(By targetElement) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is not clickable: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}


	
	public boolean waitForInvisibility(By targetElement) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
			return true;
		}
		catch(TimeoutException e ){
			System.out.println("Element is still visible: " + targetElement );
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}


	
	public WebElement findElement(By locator){
		try {
			WebElement element = driver.findElement(locator);
			return element;
		}
		catch (NoSuchElementException e){
			System.out.println("Element Not Found");
			throw new NoSuchElementException(e.getMessage());
		}
	}

	
	public List<WebElement> findElements(By locator){
		try {
			List<WebElement> element = driver.findElements(locator);
			return element;
		}
		catch (NoSuchElementException e){
			System.out.println("Element Not Found");
			throw new NoSuchElementException(e.getMessage());
		}
	}

	
	public void acceptAlert(){
		try {
			Alert alert = driver.switchTo().alert(); 
			alert.accept();

		} catch (NoAlertPresentException e){
			throw new NoAlertPresentException();
		}	
	}


	
	public String getAlertText() 
	{ 
		try {
			Alert alert = driver.switchTo().alert(); 
			String alertText = alert.getText(); 
			return alertText; 
		} catch (NoAlertPresentException e){
			throw new NoAlertPresentException();
		}
	}   

	
	public boolean isAlertPresent() 
	{ 
		try 
		{ 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true; 
		}   
		catch (NoAlertPresentException e) 
		{   
			throw new NoAlertPresentException(); 
		}   
	}   

public void hoverDropDown(By hoverLocator, By optionLocator) throws InterruptedException {
	WebElement dropdown = driver.findElement(hoverLocator);
	Actions action = new Actions(driver);
	action.moveToElement(dropdown).perform();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
	WebElement optionToClick = dropdown.findElement(optionLocator);
	optionToClick.click();
	
}
	
	public void selectValuefromDropdownviaIndex(By selectLocator, int valueToBeSelectedindex){
		Select  selectFromDropdown = new Select(findElement(selectLocator));
		selectFromDropdown.selectByIndex(valueToBeSelectedindex);

	}
	public void scrollTo(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
	}
	public void hover(By hoverelement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(hoverelement));
		WebElement dropdown = driver.findElement(hoverelement);
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).perform();
	}
}

