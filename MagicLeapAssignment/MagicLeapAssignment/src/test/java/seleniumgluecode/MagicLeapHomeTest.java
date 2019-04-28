//DevelopedBy: Cagatay Ince (cagatayince@gmail.com)
package seleniumgluecode;

import pages.MagicLeapHome;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MagicLeapHomeTest {

	public static WebDriver driver;
	MagicLeapHome objHome;

	@Before
	public void setup() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^User is on homepage$")
	public void user_is_on_homepage() throws Throwable {

		objHome = new MagicLeapHome(driver);
		driver.get("https://www.magicleap.com");
		driver.manage().window().maximize();
	}

	@Given("^Magic Leap One Creation Edition is exist$")
	public void MagicLeapOneCreationExist() throws Throwable {

		objHome.ScrollMagicLeapOneCreator();
		Assert.assertTrue(objHome.MagicLeapOneCreatorIsExist());
	}

	@When("^User navigates to Keep In Touch Segment$")
	public void user_navigatestoKeepInTouchSegment() throws Throwable {

		objHome.ScrollKeepInTouchSegment();

	}

	@When("^User enters Email as \"([^\"]*)\"$")
	public void user_enters_email(String email) throws Throwable {
		objHome.setEmail(email);
	}

	@When("^User enters Name as \"([^\"]*)\"$")
	public void user_enters_name(String name) throws Throwable {
		objHome.setNickname(name);

	}

	@When("^User select the InterestedIn as \"([^\"]*)\"$")
	public void user_selectInterestedin(String interestedin) throws Throwable {
		objHome.SelectInterestedin(interestedin);
	}

	@When("^User Click Submit$")
	public void ClickSubmit() throws Throwable {
		objHome.ClickSubmit();

	}

	@Then("^User should see the success message$")
	public void success_message_is_displayed() throws Throwable {
		String exp_message = "🎉Thanks! See ya soon!";
		String actual = objHome.getThanksMessage();
		Assert.assertEquals(exp_message, actual);

	}

	@Then("^User should not see the wrong success message$")
	public void false_message_isnot_displayed() throws Throwable {
		String exp_message = "Calling all developers";
		String actual = objHome.getThanksMessage();
		Assert.assertNotEquals(exp_message, actual);
		
	}
	@After
	public void quit() throws Throwable {
		driver.quit();
	}
	
}