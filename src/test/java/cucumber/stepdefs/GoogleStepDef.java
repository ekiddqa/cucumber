package cucumber.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDef {
	
	private static WebDriver driver;
	private static WebElement targ;
	
	@Before
	public static void setUp() {
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver(chromeCfg());
	}
	
	
	@After
	public static void tearDown() {
		driver.quit();
	}
	
	@Given("That I can access {string}")
	public void that_I_can_access(String string) throws Throwable {
	    driver.get("http://"+string);
	}

	@When("I search for {string}")
	public void i_search_for(String string) throws Throwable {
	   targ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input)"));
	   
	   targ.sendKeys(string);
	   targ.submit();
	}

	@When("I select the images tab")
	public void i_select_the_images_tab() throws Throwable {
	 targ = driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a"));
	 targ.click();
	}

	@Then("I should be able to view images of {string}")
	public void i_should_be_able_to_view_images_of_kittens(String string) throws Throwable {
		assertEquals(string + " - Google Search", driver.getTitle());
	}
	
	public static ChromeOptions chromeCfg() {
	     Map<String, Object> prefs = new HashMap<String, Object>();
	     ChromeOptions cOptions = new ChromeOptions();
	      
	     // Settings
	     prefs.put("profile.default_content_setting_values.cookies", 2);
	     prefs.put("network.cookie.cookieBehavior", 2);
	     prefs.put("profile.block_third_party_cookies", true);

	     // Create ChromeOptions to disable Cookies pop-up
	     cOptions.setExperimentalOption("prefs", prefs);
	     // cOptions.setHeadless(headless);

	     return cOptions;
    }


}
