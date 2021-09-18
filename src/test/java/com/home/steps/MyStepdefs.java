package com.home.steps;

import com.home.assertion.*;
import com.home.base.DriverFactory;

import com.home.context.Fruit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.asserts.SoftAssert;
import com.home.pages.HomePage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyStepdefs extends AbstractTestDefinition {
    private static Logger logger = LoggerFactory.getLogger(HomePage.class);
    SoftAssert softassert = new MySoftAssert();
    HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());

    @Autowired
    private Fruit fruit;
    private String searchedText;

    @Given("the defined browser opens up")
    public void theDefinedBrowserOpensUp() {
        System.out.println("Welcome Selenium with Open weather");
    }

    @Then("verify all")
    public void verifyAll() {
        softassert.assertAll();
    }

    @When("entering searched text as {string}")
    public void enteringSearchedTextAs(String searchedText) throws InterruptedException {
        this.searchedText = searchedText;
        homePage.inputSearchText(searchedText);

        homePage.clickSearch();
    }


    @When("clicking that suggestion")
    public void clickingThatSuggestion() throws InterruptedException {
        homePage.clickingOnSuggestion(1);
//        Thread.sleep(5000);
    }

    @Then("there is {int} suggestion")
    public void thereIsSuggestion(int count) {
        softassert.assertEquals(homePage.countSuggestion(this.searchedText), count);
    }

    @Then("detail weather of the location shown")
    public void detailWeatherOfTheLocationShown() {
        System.out.println("web result : " + homePage.getDateTimeResult());
        softassert.assertEquals(homePage.getDateResult(),getDate("MMM dd"));

        softassert.assertTrue(homePage.waitUntilCityNameStartWith(searchedText));

        softassert.assertTrue(homePage.isTemperatureDisplayed());
        logger.info(String.format("Fruit name is: %s",fruit.getName()));
    }

    private String getDate(String pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);


    }


}
