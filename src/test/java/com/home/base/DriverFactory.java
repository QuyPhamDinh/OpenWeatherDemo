package com.home.base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory(){}
    private static DriverFactory instance = new DriverFactory();
    public static DriverFactory getInstance(){
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void closeBrower(){
        driver.get().close();
        driver.remove();
    }
}
