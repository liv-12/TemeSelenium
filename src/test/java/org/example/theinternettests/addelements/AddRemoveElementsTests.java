package org.example.theinternettests.addelements;

import org.example.theinternettests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class AddRemoveElementsTests extends BaseTest {

    @Test
    public void testAddElement() {
        /*WebElement webElement = driver.findElement(
                By.linkText("Add/Remove Elements"));*/
        /*WebElement webElement = driver.findElement(
                By.partialLinkText("Add/Remove"));*/
        /*WebElement webElement = driver.findElement(
                By.xpath("//a[@href='/add_remove_elements/']"));*/
        /*WebElement webElement = driver.findElement(
                By.xpath("//a[.='Add/Remove Elements']"));*/
        /*WebElement webElement = driver.findElement(
                By.xpath("//a[contains(text(), 'Add/Remove')]"));*/
        /*WebElement webElement = driver.findElement(
                By.xpath("//a[text()='Add/Remove Elements']"));*/
        WebElement webElement = driver.findElement(By.cssSelector("a[href='/add_remove_elements/']"));
        webElement.click();
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        // WebElement addButton = driver.findElement(By.tagName("button"));
        addButton.click();
        WebElement delete = driver.findElement(By.className("added-manually"));
        String deleteText = delete.getText();
        Assert.assertEquals(deleteText, "Delete", "Verificam ca exista buton cu textul Delete");
    }

    @Test
    public void testAddElementsAndGetSize() {
        WebElement webElement = driver.findElement(By.cssSelector("a[href='/add_remove_elements/']"));
        webElement.click();

        Random random = new Random();
        int numarAleator = random.nextInt(2, 12);
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < numarAleator; i++) {
            addButton.click();
        }

        List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(deleteButtons.size(), numarAleator);
    }

    @Test
    public void testAddElementAndDeleteOne() throws InterruptedException {
        WebElement webElement = driver.findElement(By.cssSelector("a[href='/add_remove_elements/']"));
        webElement.click();

        Random random = new Random();
        int numarAleator = random.nextInt(2, 12);
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < numarAleator; i++) {
            addButton.click();
        }

        //Thread.sleep(500);
        List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));
        //Thread.sleep(500);
        deleteButtons.get(0).click();
        deleteButtons = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(deleteButtons.size(), numarAleator - 1);
    }


}
