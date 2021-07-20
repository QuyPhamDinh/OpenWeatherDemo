package steps;

import assertion.MySoftAssert;
import base.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyStepdefs {
    private static Logger logger = LoggerFactory.getLogger(HomePage.class);
    SoftAssert softassert = new MySoftAssert();
    HomePage homePage = new HomePage(DriverFactory.getInstance().getDriver());

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
    }

    private String getDate(String pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
