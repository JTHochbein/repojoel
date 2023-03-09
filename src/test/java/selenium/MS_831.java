package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Test(priority = 1)
public class MS_831 extends BaseTest{

    public void MS831() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p/a")));

        driver.get("https://demowebshop.tricentis.com/cell-phones");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p/a")));

        driver.get("https://demowebshop.tricentis.com/apparel-shoes");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/p/a")));

        driver.get("https://demowebshop.tricentis.com/cart");

        WebElement preis1Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[6]/span[2]"));
        String preis1Text = preis1Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis1Price = Double.parseDouble(preis1Text)/100.0;

        WebElement preis2Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[6]/span[2]"));
        String preis2Text = preis2Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis2Price = Double.parseDouble(preis2Text)/100.0;

        WebElement preis3Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[3]/td[6]/span[2]"));
        String preis3Text = preis3Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis3Price = Double.parseDouble(preis3Text)/100.0;

        double gesamtpreis = (preis1Price + preis2Price + preis3Price);
        System.out.println("GESAMTPREIS: " + gesamtpreis);

        Thread.sleep(2000);

    }
}
