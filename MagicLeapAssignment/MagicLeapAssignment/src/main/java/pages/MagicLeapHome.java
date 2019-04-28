//DevelopedBy: Cagatay Ince (cagatayince@gmail.com)
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagicLeapHome {

	// Specify the locators of element
	WebDriver driver;
	By email = By.id("footer_email");
	By nickname = By.id("footer_nickname");
	By interestedin = By.id("footer_i_am_a");
	By submit = By.xpath("//form[@id='home-sign-up']/div/div[4]/button/div");
	By thanksmessage = By.id("cta-thanks-text");
	By KeepInTouchSegment = By.xpath("//form[@id='home-sign-up']");
	// In the request it is written that verify that the words “Magic Leap One CREATOR EDITION” but text is not available only image exist
	By MagicLeapOneCreator = By.xpath("//img[@data-id='gyro-logo']"); 

	// Constructor method
	public MagicLeapHome(WebDriver driver) {

		this.driver = driver;

	}

	//Scroll Method to Element which selenium does not support is handled with javascript.
	public void Scroll(By by) throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
		Thread.sleep(1000);

	}

	//Scroll Method to MagicLeapOneCreator
	public void ScrollMagicLeapOneCreator() throws InterruptedException {
		Scroll(MagicLeapOneCreator);
	}

	//Scroll Method to KeepInTouchSegment
	public void ScrollKeepInTouchSegment() throws InterruptedException {

		Scroll(KeepInTouchSegment);

	}

	//Method to check existence of KeepInTouchSegment
	public boolean MagicLeapOneCreatorIsExist() {

		//explicit wait for the image element 
		new WebDriverWait(driver, 70).until(ExpectedConditions.presenceOfElementLocated(MagicLeapOneCreator));
		boolean result = driver.findElement(MagicLeapOneCreator).isDisplayed();

		return result;
	}

	// Set email

	public void setEmail(String strEmail) {

		driver.findElement(email).sendKeys(strEmail);

	}
	// Set Name 

	public void setNickname(String strnickname) {

		driver.findElement(nickname).sendKeys(strnickname);

	}

	// Select Interested In from Combo

	public void SelectInterestedin(String strinterestedin) {

		driver.findElement(interestedin).click();
		Select Interestedin = new Select(driver.findElement(interestedin));
		Interestedin.selectByVisibleText(strinterestedin);
	
	}

	public void ClickSubmit() {
		driver.findElement(submit).click();
	}

	// Get the Submit Message

	public String getThanksMessage() {

		return driver.findElement(thanksmessage).getText();

	}

}