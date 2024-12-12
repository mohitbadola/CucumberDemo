package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration; 

public class Steps {

    WebDriver driver;

    @Given("the user is on the opencart login page.")
    public void the_user_is_on_the_opencart_login_page() {

        driver = new ChromeDriver();
        driver.get("https://demo-opencart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String user, String pwd) {
     driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(user);
     driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
      driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("the user should be redirected to the Account Page")
    public void the_user_should_be_redirected_to_the_account_page() {
        boolean status = driver.findElement(By.xpath("//a[normalize-space()='Your Transactions']")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("the user should see My Account")
    public void the_user_should_see_my_account() {
        boolean welcomeTxt = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
        Assert.assertTrue(welcomeTxt);
        driver.quit();
    }


}
