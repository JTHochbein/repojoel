package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
@BeforeMethod
    public void setUp() {
        String browser = "edge";

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsC = new ChromeOptions();
                optionsC.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsF = new FirefoxOptions();
                optionsF.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions optionsE = new EdgeOptions();
                optionsE.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Ungültiger Browser-Name");
                return;
        }
        driver.get("https://demowebshop.tricentis.com");
    }
    @AfterMethod
    public void endTest() {
    driver.close();
    System.out.println("Test lief erfolgreich durch!");
    }
}
