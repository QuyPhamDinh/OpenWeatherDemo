package base;

import cucumber.api.java.sl.In;
import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class OptionsManager {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("profile.default_content_settings.geolocation", 1);
//        options.setExperimentalOption("prefs", prefs);

//        HashMap<String, Integer> contentSettings = new HashMap<>();
//        contentSettings.put("geolocation",1);
//        HashMap<String, Object> profile = new HashMap<>();
//        profile.put("managed_default_content_settings",contentSettings);
//        HashMap<String, Object> pref = new HashMap<>();
//        pref.put("profile",profile);
//        options.setExperimentalOption("prefs", pref);

        return options;
    }
    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        return options;
    }
}
