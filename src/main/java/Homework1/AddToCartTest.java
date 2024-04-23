import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the product page
        driver.get("https://example.com/product-page");

        // Find and click the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Wait for the page to load or for a confirmation message to appear
        // You can implement a wait here using WebDriverWait if needed

        // Verify if the product was successfully added to the cart
        WebElement cartMessage = driver.findElement(By.xpath("//div[@class='cart-message']"));
        if (cartMessage.getText().contains("Product successfully added to cart")) {
            System.out.println("Product added to cart successfully");
        } else {
            System.out.println("Failed to add product to cart");
        }

        // Close the browser
        driver.quit();
    }
}

