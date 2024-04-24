import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PositiveLoginTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://the-internet.herokuapp.com/login");

        // Enter valid username and password
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Click the login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // Verify successful login
        WebElement successMessage = driver.findElement(By.id("flash"));
        if (successMessage.getText().contains("You logged into a secure area!")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        // Close the browser
        driver.quit();
    }
}
