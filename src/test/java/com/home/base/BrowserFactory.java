package com.home.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class BrowserFactory {

    public WebDriver createInstance(String browser){
        WebDriver driver = null;

        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(OptionsManager.getChromeOptions());
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
                break;

            default:
                throw new IllegalArgumentException("This driver " + browser +" NOT Supported yet");
        }
        return driver;
    }
}
