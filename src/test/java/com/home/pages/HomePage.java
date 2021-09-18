package com.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class HomePage extends BasePage {

    @FindBy(css = "[placeholder='Search city']")
    protected WebElement searchInput;

    @FindBy(xpath = ".//button[text()='Search']")
    protected WebElement searchButton;

    List<WebElement> suggestions;
    By dateTime = By.xpath(".//div/span[@data-v-3e6e9f12 and @class='orange-text']");
    By city = By.xpath(".//div/h2[@data-v-3e6e9f12]");
    By temperature = By.cssSelector("span.heading");


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputSearchText(String searchedText) {

        waitForLoadingFinish();
        sendKeys(searchInput, searchedText);
    }

    public void clickSearch(){
        searchButton.click();
    }

    public int countSuggestion(String searchText){
        By noSuggestion = By.xpath(".//span[contains(text(),'"+ searchText +"')]");
        waitPresence(noSuggestion,EXPLICIT_TIME);
        suggestions = driver.findElements(noSuggestion);
        System.out.println("noSuggestion : " + suggestions.size());
        return suggestions.size();
    }

    public void clickingOnSuggestion(int order){
        if(order>suggestions.size())
            throw new IllegalArgumentException("clicking on the " + order + "rd element which is over range" );

        suggestions.get(order-1).click();
    }

    public String getDateTimeResult(){
        return getText(dateTime);
    }

    private String getFirstElement(String text){
        return text.split(",")[0];
    }

    public String getDateResult(){
        return getFirstElement(getDateTimeResult());
    }

    public String getCityAndCountry(){
        return getText(city);
    }

    public String getCity(){
        return getFirstElement(getCityAndCountry());
    }

    public Boolean waitUntilCityNameStartWith(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIME));
        String pattern = "^" + name +"\\W";
        Pattern startWith = Pattern.compile(pattern);
        return wait.until(ExpectedConditions.textMatches(city, startWith));
    }

    public boolean isTemperatureDisplayed(){
        WebElement element = driver.findElement(temperature);
        return element.isDisplayed();
    }

}
