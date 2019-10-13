package Base;

import config.LocalConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    private static Logger log = Logger.getLogger(BaseClass.class);

    public  static WebDriver driver;
    private static final String url = LocalConfig.INSTANCE.getUrl();
    private static final String browser = LocalConfig.INSTANCE.getBrowser();

    @BeforeMethod(alwaysRun = true)
    public static void setUpDriver() {
        log.info("Setting up Web driver");
        initialize(browser, url);
    }

    public static WebDriver getWebdriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome": {
                log.info("Launching Chrome !!");
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                }
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                log.info("Launching Firefox !!");
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                }
                driver = new FirefoxDriver();
                break;
            }
            case "ie": {
                log.info("Launching Internet Explorer !!");
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
                options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
                if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver(options);
                }
                break;
            }
            default:
                log.warn("Browser input is Invalid");
                break;
        }
        return driver;
    }

    protected static void initialize(String browser, String baseUrl) {
        driver = getWebdriver(browser);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Quitting Driver");
        log.info("===============================================");
        driver.quit();
    }

}
