package org.example.theinternettests.formauthentication;

import org.example.theinternettests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends BaseTest {

    @Test
    public void enterJustUserName() {
        driver.findElement(By.partialLinkText("Form Authentication")).click();
        driver.findElement(By.xpath("//input[@id='username']"))
                .sendKeys("SkillBrain");
        driver.findElement(By.tagName("button")).click();

        WebElement alert = driver.findElement(By.id("flash"));
        String invalidUserText = alert.getText().trim();
        Assert.assertEquals(invalidUserText, "Your username is invalid!\n×");
    }
}
