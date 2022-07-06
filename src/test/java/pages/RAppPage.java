package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RAppPage {
	
	private WebDriver driver;
	public static JavascriptExecutor js;
	
	public RAppPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		
	}
	
// ---------------------------- Login Page -------------------------
	@FindBy(id = "calink")
	public WebElement createAccount;
	
	@FindBy(id = "uname")
	public WebElement usernameInput;
	
	@FindBy(id = "pass")
	public WebElement passwordInput;
	
	@FindBy(xpath = "/html/body/main/form/button")
	public WebElement signIn;
	
	
// ---------------------------- Home Page --------------------------
	
	@FindBy(xpath = "/html/body/div/label[1]/button[1]")
	public WebElement viewRequests;
	
	@FindBy(xpath = "/html/body/div/label[1]/button[2]")
	public WebElement submitNewRequest;
	
	@FindBy(xpath = "/html/body/div/label[2]/button")
	public WebElement logOut;
	
	@FindBy(xpath = "//*[@id=\"loginError\"]")
	public WebElement loginError;
	
// --------------------------- View Requests --------------------------------
	@FindBy(xpath = "/html/body/button")
	public WebElement backToHome;
	
	@FindBy(id = "reqID")
	public WebElement reqIDinput;
	
	@FindBy(xpath ="/html/body/label/button")
	public WebElement viewMore;
	
	@FindBy(id ="reqError")
	public WebElement reqError;
	
// --------------------------- Submit New Request -----------------------------
	
	@FindBy(id ="subj")
	public WebElement nrsub;
	
	@FindBy(xpath ="//*[@id=\"evdate\"]")
	public WebElement nrdate;
	
	@FindBy(xpath ="//*[@id=\"cost\"]")
	public WebElement nrcost;
	
	@FindBy(xpath ="/html/body/div/button")
	public WebElement submitNewButton;
	
	@FindBy(xpath ="//*[@id=\"emptyFieldError\"]")
	public WebElement fieldErrorSubmit;
	
// ---------------------------- Single Request View -----------------------
	
	@FindBy(xpath = "/html/body/button[4]")
	public WebElement srVarbutton;
	
	@FindBy(xpath ="/html/body/button[5]")
	public WebElement srSnrbutton;
	
	@FindBy(xpath ="/html/body/button[3]")
	public WebElement srRthbutton;
	
	@FindBy(xpath ="//*[@id=\"editReqBut\"]")
	public WebElement srErbutton;
	
	@FindBy(xpath ="//*[@id=\"newSubject\"]")
	public WebElement srNsline;
	
	@FindBy(xpath="//*[@id=\"requestTable\"]/tbody/tr[8]/td")
	public WebElement srCost;
	
	@FindBy(xpath="//*[@id=\"submit\"]")
	public WebElement srSebutton;
	
	@FindBy(xpath="//*[@id=\"requestTable\"]/tbody/tr[8]/td")
	public WebElement srcostUpdated;
	
	@FindBy(xpath="//*[@id=\"newAmount\"]")
	public WebElement srNcline;
	
	
// ------------------------- Finance Manager Page -----------------------
	
//	@FindBy(xpath = "")
//	public WebElement ;
	
	@FindBy(xpath = "/html/body/button[1]")
	public WebElement mrefresh;
	
	@FindBy(xpath = "//*[@id=\"id1\"]")
	public WebElement mfirstId;
	
	@FindBy(xpath = "/html/body/button[2]")
	public WebElement mlookup;
	
	@FindBy(xpath = "/html/body/button[3]")
	public WebElement mmainpg;
	
// -------------------------- SR Manager Page ---------------------------
	
	@FindBy(xpath="//*[@id=\"id1\"]")
	public WebElement mt21;
	
	@FindBy(xpath="//*[@id=\"newStatus\"]")
	public WebElement mstSelector;
	
	@FindBy(xpath="/html/body/div/button")
	public WebElement msUpdate;
	
	@FindBy(xpath="//*[@id=\"requestTable\"]/tbody/tr[2]/td")
	public WebElement mcstatus;
	
// ------------------------- Employee Lookup -----------------------------	

	@FindBy(xpath="//*[@id=\"employeeNum\"]")
	public WebElement midinput;
	
	@FindBy(xpath="/html/body/label[1]/button")
	public WebElement mSubmitLookup;
	
	@FindBy(xpath="//*[@id=\"id1\"]")
	public WebElement mLookup21;
	
	@FindBy(xpath="//*[@id=\"notFound\"]/p/i")
	public WebElement mLookupError;
}
