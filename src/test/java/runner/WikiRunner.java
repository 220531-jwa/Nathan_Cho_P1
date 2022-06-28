package runner;

import java.io.File;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
//normally avoid this because there could be 100's but in this case there's 2
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.WikiPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "steps")
public class WikiRunner {
	//Example: this is the class that will run the tests and what-not
	//We'll need a driver and an instance of our WikiPage POM
	public static WebDriver driver;
	public static WikiPage wikiPage;
	
	@BeforeAll
	public static void setup() {
		//information we set up in our 1st Selenium class is now needed in the test runner.
		//We need to locate our driver executable file and set our system property.
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		wikiPage = new WikiPage(driver);
		System.out.println("beforeeach");
	}
	
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
