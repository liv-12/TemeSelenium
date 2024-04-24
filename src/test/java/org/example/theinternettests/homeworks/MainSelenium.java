package org.example.theinternettests.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MainSelenium {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Find and click the "Add Element" button
        WebElement addElementButton = driver.findElement(By.xpath("//button[contains(text(), 'Add Element')]"));
        addElementButton.click();

        // Find the added element (the element with tag name "button")
        WebElement addedElement = driver.findElement(By.tagName("button"));

        // Verify that the added element is displayed
        if (addedElement.isDisplayed()) {
            System.out.println("Element added successfully.");
        } else {
            System.out.println("Failed to add element.");
        }

        // Find and click the delete button associated with the added element
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(), 'Delete')]"));
        deleteButton.click();

        // Verify that the added element has been deleted
        if (!isElementPresent(driver, By.tagName("button"))) {
            System.out.println("Element deleted successfully.");
        } else {
            System.out.println("Failed to delete element.");
        }

        // Close the browser
        //  driver.quit();
    }

    private static boolean isElementPresent(WebDriver driver, By button) {
        List<WebElement> lista = driver.findElements(button );
        return !lista.isEmpty();

    }


}
