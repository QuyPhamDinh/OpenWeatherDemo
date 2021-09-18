package com.home.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);
    public static int EXPLICIT_TIME = 4;
    By loadState = By.cssSelector("[aria-label='Loading']");

    protected WebDriver driver;

    public void sendKeys(WebElement e, CharSequence ...c){
        e.sendKeys(c);
        logger.info("Sent keys: " + c[0]);
    }

    public void waitForLoadingFinish(){
        WebElement loadStateElement = waitPresence(loadState,2);
        if (loadStateElement != null){
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait3.until(ExpectedConditions.invisibilityOf(loadStateElement));
        }
    }


    public WebElement waitPresence(By by, long timeOutInSeconds) {
        logger.info("Start Finding Element : " + by.toString());
        WebElement element = null;
        try {
            element = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds) ).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            logger.info(e.getMessage());
            element = null;
        }
        return element;
    }

    public String getText(By locator){
        WebElement element = driver.findElement(locator);
        return  element.getText();
    }
}
