package base;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;


@CucumberOptions(monochrome = true, strict = true, dryRun = false)
public class BaseTest extends AbstractTestNGCucumberTests {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    BrowserFactory browserFactory = new BrowserFactory();
    public static String hubURL;
    public static String AUTURL;

    public static String GLOBAL_TEST_DATA_PATH;


    @BeforeTest(alwaysRun = true)
    @Parameters({ "hubURL", "auturl"})
    public static void loadHubURL(String hubURL, String auturl) {

        BaseTest.hubURL = hubURL;
        BaseTest.AUTURL = auturl;
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({ "browser","GlobalTestDataPath"})
    public void setUp(String browser, String GlobalTestDataPath) throws Exception {
        GLOBAL_TEST_DATA_PATH = GlobalTestDataPath;

        DriverFactory.getInstance().setDriver(browserFactory.createInstance(browser));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        logger.info("Maximizing Browser");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(600));
        driver.get(AUTURL);
    }

    @AfterClass(alwaysRun = true)
    public synchronized static void tearDown() {
        logger.debug("Quit appium driver after class");
        DriverFactory.getInstance().closeBrower();
    }

    @AfterSuite
    public void suitEnd() {
        logger.debug("After suite");
    }

    public static void takeScreenshot() {

        String pattern = "yyyy-MM-dd HH mm ss SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new java.util.Date());

        try {
            File scrFile = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            String screenShotFilePath = Paths.get("./test-output/screenshots/" + date + ".png").toAbsolutePath()
                    .normalize().toString();
            FileUtils.copyFile(scrFile, new File(screenShotFilePath));
            logger.debug("screenShotFilePath >> " + screenShotFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}