package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Steps {

    private WebDriver driver;

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("fa-sign-in")).click();
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_credentials_parameters(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.className("fa-sign-in")).click();
    }

    @When("I enter valid credentials data table")
    public void i_enter_valid_credentials_data_table(DataTable table) {
        List<String> loginForm = table.asList();

        driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
        driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
        driver.findElement(By.className("fa-sign-in")).click();
    }

    @Then("I should be taken to the Secure Area page")
    public void i_should_be_taken_to_the_Overview_page() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.className("icon-signout")).click();
    }
}
