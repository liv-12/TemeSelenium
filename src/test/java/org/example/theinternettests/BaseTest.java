package org.example.theinternettests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected ChromeDriver driver;
    public static String URL;

    @BeforeClass
    public static void setupURL(){
        URL = "https://the-internet.herokuapp.com";
    }

    @BeforeMethod
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterMethod
    public void closeBrowser() {
        //driver.quit();
    }
}
