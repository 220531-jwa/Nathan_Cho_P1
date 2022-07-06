package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.ThreadLocalRandom;

import pages.RAppPage;
import runner.ReimTestRunner;

public class ReimbursementApp_Steps {

	
	
	public static WebDriver driver = ReimTestRunner.driver;
	public static RAppPage rap = ReimTestRunner.rap;
	
	
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		rap = new RAppPage(driver);
	}
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
	
//--------------------------Login Page------------------------------------
	
	@Given("I am on the Login page")
	public void i_am_on_the_login_page() {
	    driver.get("http://localhost:8081/loginPage.html");
	}
	
	
	@When("I click on the Create Account Link")
	public void i_click_on_the_create_account_link() {
		
		WebElement link = driver.findElement(By.id("calink"));
		link.click();
	}
	@Then("I am on the Create Account Page")
	public void i_am_on_the_create_account_page() {
		
	    assertEquals("New Account Creation", driver.getTitle());
	}
	
	@When("the  User types in their {string} and {string} and clicks the Login Button")
	public void the_user_types_in_their_and_and_clicks_the_login_button(String username, String password) {
	    rap.usernameInput.sendKeys(username);
	    rap.passwordInput.sendKeys(password);
	    rap.signIn.click();
	}

	@Then("the User should be on the Home page")
	public void the_user_should_be_on_the_home_page() {
	    
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Reimbursement Home Page"));
	
		assertEquals("Reimbursement Home Page", driver.getTitle());
	}

	@Then("the User should be on the Admin page")
	public void the_user_should_be_on_the_admin_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Manager Page"));
	
		assertEquals("Manager Page", driver.getTitle());
	}
	
	@When("the User types an invalid username and password")
	public void the_user_types_an_invalid_username_and_password() {
	    rap.usernameInput.sendKeys("fndsalkf");
	    rap.passwordInput.sendKeys("r324r123");
	}
	
	@Then("Login Error Appears")
	public void login_error_appears() {
	    rap.loginError.isDisplayed();
	}
	
//----------------------------- Home Page --------------------------------------------	
	
	@Given("I am on the Home page")
	public void i_am_on_the_home_page() {
		
		driver.get("http://localhost:8081/loginPage.html");
		rap.usernameInput.sendKeys("josh");
	    rap.passwordInput.sendKeys("josh");
	    rap.signIn.click();
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Reimbursement Home Page"));
	    
	}
	
	@When("I press on View Requests")
	public void i_press_on_view_requests() {
	    rap.viewRequests.click();
	}
	
	@Then("I am on the View Requests page")
	public void i_am_on_the_view_requests_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Employee Requests"));
	
		assertEquals("Employee Requests", driver.getTitle());
	}
	
	@When("I press on Submit a new Request")
	public void i_press_on_submit_a_new_request() {
	    rap.submitNewRequest.click();
	}

	@Then("I am on the Submit New Request page")
	public void i_am_on_the_submit_new_request_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("New Reimbursement Request Submission"));
	
		assertEquals("New Reimbursement Request Submission", driver.getTitle());
	}
	
	@When("I press on Log Out")
	public void i_press_on_log_out() {
	    rap.logOut.click();
	}
	
//---------------------View Requests -----------------------------------------------------
	
	@Given("I am logged in And I am on View Requests")
	public void i_am_logged_in_and_i_am_on_view_requests() {
		driver.get("http://localhost:8081/loginPage.html");
		rap.usernameInput.sendKeys("josh");
	    rap.passwordInput.sendKeys("josh");
	    rap.signIn.click();
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Reimbursement Home Page"));
	    
	    rap.viewRequests.click();
	}
	
	@When("I press on Back to Home")
	public void i_press_on_back_to_home() {
	    rap.backToHome.click();
	}
	
	@When("the User types {string} in Request ID and pressed View More")
	public void the_user_types_in_request_id_and_pressed_view_more(String reqNum) {
	    rap.reqIDinput.sendKeys(reqNum);
	    rap.viewMore.click();
	}
	
	@Then("I am on the Single Request Page")
	public void i_am_on_the_single_request_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Request Information"));
	
		assertEquals("Request Information", driver.getTitle());
	}
	
	@When("the User types a random ticket number")
	public void the_user_types_a_random_ticket_number() {
	    rap.reqIDinput.sendKeys("4514132");
	    rap.viewMore.click();
	}
	
	@Then("an invalid ticket error appears")
	public void an_invalid_ticket_error_appears() {
	    rap.reqError.isDisplayed();
	}
	
	@When("the User types no ticket number")
	public void the_user_types_no_ticket_number() {
	    rap.viewMore.click();
	}
	
// ----------------------- Submit New Request ------------------------
	@Given("the User is on Submit New Request page")
	public void the_user_is_on_submit_new_request_page() {
		driver.get("http://localhost:8081/loginPage.html");
		rap.usernameInput.sendKeys("josh");
	    rap.passwordInput.sendKeys("josh");
	    rap.signIn.click();
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Reimbursement Home Page"));
	    
	    rap.submitNewRequest.click();
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("New Reimbursement Request Submission"));
	}

	@When("the User creates a good ticket")
	public void the_user_creates_a_good_ticket() {
	    rap.nrsub.sendKeys("Selenium Test Ticket");
	    rap.nrcost.sendKeys("100");
	    rap.nrdate.sendKeys("07012022");
	    rap.submitNewButton.click();
	}

	@Then("the User is taken to Single Ticket View")
	public void the_user_is_taken_to_single_ticket_view() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Request Information"));
		
		assertEquals("Request Information", driver.getTitle());
	}
	
	@When("the User creates a bad ticket")
	public void the_user_creates_a_bad_ticket() {
	    rap.submitNewButton.click();
	}

	@Then("the field error is shown")
	public void the_field_error_is_shown() {
	    assertTrue(rap.fieldErrorSubmit.isDisplayed());
	}
	
// -------------------------- Single Request Employee View ----------------------------------
	@Given("the User is on the Single Request Page")
	public void the_user_is_on_the_single_request_page() {
		driver.get("http://localhost:8081/loginPage.html");
		rap.usernameInput.sendKeys("josh");
	    rap.passwordInput.sendKeys("josh");
	    rap.signIn.click();
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Reimbursement Home Page"));
	    rap.viewRequests.click();
	    
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Employee Requests"));
	    
	    rap.reqIDinput.sendKeys("20");
	    rap.viewMore.click();
	    
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Request Information"));
	}
	
	@When("the User goes to View All Requests")
	public void the_user_goes_to_view_all_requests() {
	    rap.srVarbutton.click();
	}
	
	@Then("the User is on View All Requests Page")
	public void the_user_is_on_view_all_requests_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Employee Requests"));
		
		assertEquals("Employee Requests", driver.getTitle());
	}

	@When("the User goes to Return to Home")
	public void the_user_goes_to_return_to_home() {

		rap.srRthbutton.click();
		
	}

	@Then("the User is back at the Home Page")
	public void the_user_is_back_at_the_home_page() {
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Reimbursement Home Page"));
		
		assertEquals("Reimbursement Home Page", driver.getTitle());
	}

	@When("the User goes to Submit a New Request")
	public void the_user_goes_to_submit_a_new_request() {
	    rap.srSnrbutton.click();
	}


	@When("the User presses edit request")
	public void the_user_presses_edit_request() {
	    rap.srErbutton.click();
	    rap.srErbutton.click();
	    //there's an issue in my js that makes it need to be clicked twice.
	}

	@Then("the edit table is visible")
	public void the_edit_table_is_visible() {
	    
		assertTrue(rap.srNsline.isDisplayed());
	}

	int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);
	
	@When("the user fills in the edits and submits")
	public void the_user_fills_in_the_edits_and_submits() {
		rap.srNcline.sendKeys(Integer.toString(randomNum));
		rap.srSebutton.click();
	}

	@Then("the new request edits will show")
	public void the_new_request_edits_will_show() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.textToBePresentInElement(rap.srCost, Integer.toString(randomNum)));
		
		assertEquals(randomNum , Integer.parseInt(rap.srcostUpdated.getText()));
	}
	
//----------------------------- Finance Manager Main Page ------------------------------
	
	@Given("Admin is logged on")
	public void admin_is_logged_on() {
		driver.get("http://localhost:8081/loginPage.html");
		rap.usernameInput.sendKeys("admin");
	    rap.passwordInput.sendKeys("admin");
	    rap.signIn.click();
	    
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Manager Page"));
	}

	@When("Refresh is pressed")
	public void refresh_is_pressed() {
	    rap.mrefresh.click();
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(rap.mfirstId));
	}

	@Then("Request Table is populated")
	public void request_table_is_populated() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(rap.mfirstId));
		
		assertTrue(rap.mfirstId.isDisplayed());
	}

	@When("Employee Lookup is pressed")
	public void employee_lookup_is_pressed() {
	    rap.mlookup.click();
	}

	@Then("Admin is on Employee Lookup page")
	public void admin_is_on_employee_lookup_page() {
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Employee Lookup"));
		
		assertEquals("Employee Lookup", driver.getTitle());
	}

	@When("To Main Page is pressed")
	public void to_main_page_is_pressed() {
	    rap.mmainpg.click();
	}

	@Then("Admin is on main page")
	public void admin_is_on_main_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Reimbursement Home Page"));
		
		assertEquals("Reimbursement Home Page", driver.getTitle());
	}

	@When("First ID is clicked")
	public void first_id_is_clicked() {
	    rap.mfirstId.click();
	}

	@Then("Admin is on Request Management page")
	public void admin_is_on_request_management_page() {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Single Request Management"));
		
		assertEquals("Single Request Management", driver.getTitle());
	}
	
//-------------------------------- Admin Single Request View ------------------------
	
	@Given("Admin has selected ticket21")
	public void admin_has_selected_ticket21() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(rap.mt21));
		
	    rap.mt21.click();
	    
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.textToBePresentInElement(rap.mcstatus, "open"));
	}

	@When("status is changed to answered")
	public void status_is_changed_to_answered() {
	    Select stat = new Select(rap.mstSelector);
	    stat.selectByVisibleText("Answered");
	}

	@When("status update is pressed")
	public void status_update_is_pressed() {
	    rap.msUpdate.click();
	    new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.textToBePresentInElement(rap.mcstatus, "answered"));
	}

	@Then("new status can be seen")
	public void new_status_can_be_seen() {
	    assertEquals("answered", rap.mcstatus.getText());
	}

	@Then("the admin sets the status back to open")
	public void the_admin_sets_the_status_back_to_open() {
		Select stat = new Select(rap.mstSelector);
	    stat.selectByVisibleText("Open");
	    rap.msUpdate.click();
	}
	
//---------------------------- Employee Lookup Page ---------------------------------
	
	@Given("Admin selects employee lookup")
	public void admin_selects_employee_lookup() {
	    rap.mlookup.click();
	}

	@When("an invalid id is entered")
	public void an_invalid_id_is_entered() {
	    rap.midinput.sendKeys("2");
	}

	@When("submit is pressed")
	public void submit_is_pressed() {
	    rap.mSubmitLookup.click();
	}

	@Then("invalid id error appears")
	public void invalid_id_error_appears() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(rap.mLookupError));
		
		assertTrue(rap.mLookupError.isDisplayed());
	}

	@When("id for josh is entered")
	public void id_for_josh_is_entered() {
		rap.midinput.sendKeys("5");
	}

	@When("id21 is selected")
	public void id21_is_selected() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(rap.mLookup21));
		
		rap.mLookup21.click();
	}
}
