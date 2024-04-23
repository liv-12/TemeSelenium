package Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

public class SignUpTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        String s = System.setProperty("web driver.chrome.driver", "path_to_chromedriver/chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://the-internet.herokuapp.com/signup");

        // Generate a unique username using UUID
        String uniqueUsername = "user_" + UUID.randomUUID().toString().substring(0, 8);

        // Enter the unique username and other signup information
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(uniqueUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        WebElement confirmPasswordField = driver.findElement(By.id("confirm_password"));
        confirmPasswordField.sendKeys("password123");

        WebElement signUpButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();

        // Verify signup success message or redirect
        WebElement successMessage = driver.findElement(By.id("flash"));
        if (successMessage.getText().contains("You successfully signed up")) {
            System.out.println("SignUp Successful for username: " + uniqueUsername);
        } else {
            System.out.println("SignUp Failed");
        }

        // Close the browser
        driver.quit();
    }
}
