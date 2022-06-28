package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WikiPage;
import runner.WikiRunner;

public class WikiLangStepImpl {

	
	private static WebDriver driver = WikiRunner.driver;
	private static WikiPage wikiPage = WikiRunner.wikiPage;
	
	//this is where we'll use our driver to run these tests
	@Given("the user is on wikipedia home page")
	public void the_user_is_on_wikipedia_home_page() {
		//setting up the required state of our application such that... >> @When
	    driver.get("https://www.wikipedia.org");
	}

	@When("the user clicks on the")
	public void the_user_clicks_on_the() {
		//two ways to do this
		
		//manual
		//WebElement english = driver.findElement(By.id("js-link-box-en"));
		
		//other
		wikiPage.englishLink.click(); //click() comes from selenium and clicks a visible element
									  //click() needs what its clicking on to be visible, so you might have to make it wait a bit.
	}

	@Then("the title of the web page should be Wikepedia, the free encyclopedia")
	public void the_title_of_the_web_page_should_be_wikepedia_the_free_encyclopedia() {
		assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
	}
}
