package stepdefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceStepDefination {
	WebDriver driver;
	
		
		@Given("Open landing page")
		public void Open_landing_page() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/client");
		}

	@Given("^Enter the username (.+) and password (.+)$")
	public void enter_the_username_and_password(String username, String password) {

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(password);
		
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
		
		driver.findElement(By.id("login")).click();
	}

	@Then("User should be able to Login")
	public void user_should_be_able_to_login() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "Let's Shop");
		System.out.println("Cucumber file Run Pass: Title of the page - " + title);
	}
	
	
	
	@Given("^Enter the invalid username (.+) and password (.+)$")
	public void enter_the_invalid_username_and_password(String username, String password) {
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(password);
	}

	@When("Click on the sign button")
	public void click_on_the_sign_button() {
		driver.findElement(By.id("login")).click();;
	}

	@Then("^(.+) message is visible$")
	public void incorrect_email_or_password_message_is_visible_toast_container(String message) {
	    
		String errorMsg = driver.findElement(By.cssSelector("#toast-container")).getText();
		Assert.assertEquals(errorMsg, message);
		System.out.println("Error message: " + errorMsg);
	}
}

