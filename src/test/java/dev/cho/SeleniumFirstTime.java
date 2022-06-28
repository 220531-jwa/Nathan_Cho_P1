package dev.cho;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirstTime
{
	public static void main(String[] args) {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		
		searchBar.sendKeys("mario" + Keys.ENTER);
		
		driver.quit();
	}
}
