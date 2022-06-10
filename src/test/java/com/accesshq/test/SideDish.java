package com.accesshq.test;

import com.accesshq.model.SideDishModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SideDish {
    WebDriver driver;
    SideDishModel sdm = new SideDishModel();

    @BeforeEach
    public void Setup(){
        driver = new ChromeDriver();
        driver.get("https://d3eczsrdruv8hn.cloudfront.net/#/");
        driver.manage().window().maximize();
    }

    @Test
    public void LocateSideDish(){
        sdm.ClickMenuBtn(driver, "[aria-label=menu].v-btn");

        sdm.ClickSidesBtn(driver, "div.v-slide-group__wrapper > div > div:nth-child(3)");

        var classes = driver.findElements(By.className("layout px-3 row wrap"));
        for(var v : classes){
            if(v.findElement(By.className("flex mb-2 mt-5 xs12 sm6 md3 lg2")).findElement(By.className("ribbon ribbon-top-left")).getText() == "New"){
                Assertions.assertEquals("Korean Sticky Wings", v.findElement(By.className("name")).getText());
                Assertions.assertEquals("Korean Sticky Wings", v.findElement(By.tagName("img")).getText());
            }
        }
    }

    @AfterEach
    public void Finsh(){
        //driver.quit();
    }
}
