package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFieldModel {

    public void ClickLoginBtn(WebDriver driver, String name){
        driver.findElement(By.cssSelector(name)).click();
    }

    public void ClickDismissBtn(WebDriver driver, String name){
        driver.findElement(By.cssSelector(name)).click();
    }
}