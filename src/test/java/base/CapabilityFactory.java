package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class CapabilityFactory {
    public Capabilities capabilities;
    public Capabilities getCapabilities (String browser) {

        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome" :
                capabilities = OptionsManager.getChromeOptions();
                break;
            case "firefox" :
                capabilities = OptionsManager.getFirefoxOptions();
                break;

            default:
                throw new IllegalArgumentException("The Capability of " + browser +" NOT Supported yet");
        }
        return capabilities;
    }
}
