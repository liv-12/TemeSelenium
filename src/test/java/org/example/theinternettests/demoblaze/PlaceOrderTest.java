package org.example.theinternettests.demoblaze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class PlaceOrderTest {
    /**
     * 1.Deschidem demoblaze.com
     * 2. Dam click pe priodusul Samsung Galaxy S6
     * 3.Apasam butonul Add to Cart
     * 4.Dam click pe butonul Cart
     * 5.Samsung Galaxy se afla in Cart
     * 6. click buton place order
     * 7. completez campurile nume si card de credit
     * 8. click buton purchase
     * 9. verificare mesajul "thank you for your purchase"
     * 10.confirmam comanda si dam ok
     */

    @Test
    public void test2() throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        /* Step 1: Deschidem demoblaze.com */
        driver.get("https://www.demoblaze.com/");

        //2. Dam click pe produsul Samsung Galaxy S6
        WebElement webElement = driver.findElement(By.xpath("//a[.='Samsung galaxy s6']"));
        webElement.click();

// 3.Apasam butonul Add to Cart
        WebElement webElement2 = driver.findElement(By.linkText("Add to cart"));
        webElement2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
// 4.Dam click pe butonul Cart
        WebElement webElementCart = driver.findElement(By.linkText("Cart"));
        webElementCart.click();
        // 5.Samsung Galaxy se afla in Cart
        WebElement webElementCartItem = driver.findElement(By.xpath("//td[.='Samsung galaxy s6']"));
        webElementCartItem.click();
        String nume = webElementCartItem.getText();
        if (!nume.equals("Samsung galaxy s6")) {
            throw new Exception("elementul nu a fost gasit in cos");
        }
//6. click buton place order
        WebElement webElementPlaceOrder = driver.findElement(By.xpath("//*[.='Place Order']"));
        webElementPlaceOrder.click();
//7. completez campurile nume si card de credit

        WebElement webElementNume = driver.findElement(By.id("name"));
        webElementNume.sendKeys("Livia Gherasim");
        WebElement webElementCard = driver.findElement(By.id("card"));
        webElementCard.sendKeys("565465654865554");
        WebElement webElementPurchase = driver.findElement(By.xpath("//*[.='Purchase']"));
        webElementPurchase.click();

        WebElement webElementMessage = driver.findElement(By.xpath("//*[.='Thank you for your purchase!']"));

        if (!webElementMessage.isDisplayed()) {
            throw new Exception("elementul Thank you for your purchase button wasn't found");
        }

        WebElement webElementOk = driver.findElement(By.xpath("//*[.='OK']"));
        webElementOk.click();
        WebElement webElementClose = driver.findElement(By.xpath("//*[@id='orderModal']//*[.='Close']"));
        webElementClose.click();
        WebElement webElementHome = driver.findElement(By.xpath("//*[contains(text(), 'Home')]"));
        webElementHome.click();

        // Close the browser
        // driver.quit();
    }


}
