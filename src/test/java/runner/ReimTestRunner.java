package runner;

import java.io.File;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import pages.RAppPage;



@Suite
@Tag("CucumberTests")
@IncludeTags("CucumberTests")
public class ReimTestRunner {
	
	//runner set up
	public static WebDriver driver;
	public static RAppPage rap;
	
	
}
