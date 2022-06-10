package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideDishModel {
    public void ClickMenuBtn(WebDriver driver, String name){
        driver.findElement(By.cssSelector(name)).click();
    }

    public void ClickSidesBtn(WebDriver driver, String name){
        driver.findElement(By.cssSelector(name)).click();
    }
}
