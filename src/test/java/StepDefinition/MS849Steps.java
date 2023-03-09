package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS849Steps {
    WebDriver driver;
    @Given("Browser is opened")
    public void browser_is_opened() {
        driver = new ChromeDriver();
    }
    @When("user open the TDW Site")
    public void user_open_the_tdw_site() {
        driver.get("https://demowebshop.tricentis.com/");
    }
    @Then("website loads in less then {int} seconds")
    public void website_loads_in_less_then_seconds(Integer int1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img")));
        System.out.println("the Website sucessfully loaded in less then 3 seconds!");
        driver.close();
    }
}
