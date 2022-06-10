package com.accesshq.test;

import com.accesshq.model.LoginFieldModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginField {
    WebDriver driver;
    LoginFieldModel lfm = new LoginFieldModel();

    @BeforeEach
    public void Setup(){
        driver = new ChromeDriver();
        driver.get("https://d3eczsrdruv8hn.cloudfront.net/#/");
        driver.manage().window().maximize();

    }

    @Test
    public void ValidateErrorMessage(){
        lfm.ClickLoginBtn(driver, "div > a.nav-login-signup.v-btn");

        var loginBox = driver.findElement(By.cssSelector("#loginDialog > div > div > div"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(loginBox));

        driver.findElement(By.cssSelector("[aria-label=login]")).click();

        var alertMessage = driver.findElement(By.className("v-alert__content")).getText();

        Assertions.assertEquals("Your login was unsuccessful - please try again", alertMessage);

        lfm.ClickDismissBtn(driver, "div.v-card__text.pt-4 div > button");

        // Todo: verfiy alert is not present
    }

    @AfterEach
    public void Finsh(){
        //driver.quit();
    }
}
