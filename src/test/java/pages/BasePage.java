package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static int EXPLICIT_TIME = 4;
    By loadState = By.cssSelector("[aria-label='Loading']");

    protected WebDriver driver;

    public void sendKeys(WebElement e, CharSequence ...c){
        e.sendKeys(c);
        System.out.println("Sent keys: " + c[0]);
    }

    public void waitForLoadingFinish(){
        WebElement loadStateElement = waitPresence(loadState,2);
        if (loadStateElement != null){
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait3.until(ExpectedConditions.invisibilityOf(loadStateElement));
        }
    }


    public WebElement waitPresence(By by, long timeOutInSeconds) {
        System.out.println("Start Finding Element : " + by.toString());
        WebElement element = null;
        try {
            element = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds) ).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
            element = null;
        }
        return element;
    }

    public String getText(By locator){
        WebElement element = driver.findElement(locator);
        return  element.getText();
    }
}
