package org.example.theinternettests.homeworks.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NegativeLoginTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the login page
        driver.get("https://example.com/login");

        // Negative Test Cases for Login Authentication
        testIncorrectUsernameAndPassword(driver);
        testEmptyUsernameAndPassword(driver);
        testValidUsernameAndEmptyPassword(driver);
        testEmptyUsernameAndValidPassword();


        // Close the browser
        driver.quit();
    }

    private static void testEmptyUsernameAndValidPassword() {
    }

    private static void testValidUsernameAndEmptyPassword(WebDriver driver) {
    }

    // Negative Test Case: Attempt to log in with an incorrect username and password combination
    public static void testIncorrectUsernameAndPassword(WebDriver driver) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("incorrectUsername");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("incorrectPassword");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Verify error message or behavior
    }

    // Negative Test Case: Attempt to log in with empty username and password fields
    public static void testEmptyUsernameAndPassword(WebDriver driver) {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Verify error message or behavior
    }

}
