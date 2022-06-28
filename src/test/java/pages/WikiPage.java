package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {
	/* 
	 * This class represents the web page we will be automating
	 * This class is what we call a POM (Page Object Model) **not pom.xml** 
	 * 
	 * we will need an instance of our WebDriver
	 */
	
	private WebDriver driver;
	
	public WikiPage(WebDriver driver) {
		this.driver = driver;
		//next bit of code is working from the PageFactory.
		PageFactory.initElements(driver, this); //param 1: factory || param 2: the page to decorate
			
	}
	
	@FindBy(id = "js-link-box-en")
	public WebElement englishLink;
	
	@FindBy(xpath = "//*[@id=\"js-link-box-it\"]")
	public WebElement italianLink;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/a")
	public WebElement koreanLink;
}
