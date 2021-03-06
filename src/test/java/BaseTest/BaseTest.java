package BaseTest;

import baseMain.TestsConfigReader;
import baseMain.UserPropertiesReader;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Listeners(utils.Listeners.TestListener.class)

public class BaseTest {

    public static WebDriver driver;
    public String supplierUsername;
    public String supplierPassword;
    public WebDriverWait wait ;
    public Logger log = Logger.getLogger(BaseTest.class.getName());
    public TestsConfigReader testsConfig = new TestsConfigReader();
//    static ExtentTest test;
//    static ExtentReports report;



    public void initializeDriver(boolean isResponsive)
    {
        String[] browsers =
                //{
                //"CHROME",
                //"FIREFOX",
                //"EDGE"
                (String[]) testsConfig.getBrowsers().split(",");
        //};

        int idx = new Random().nextInt(browsers.length);
        String browser = (browsers [idx]);
        System.out.println("Browser used for the test: "+browser);


        // CHROME
        if (browser.equals("CHROME")) {
            WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().clearResolutionCache();
            //WebDriverManager.chromedriver().version("83").setup();
            ChromeOptions options = new ChromeOptions();

            if (isResponsive) {
                Map<String, Object> deviceMetrics = new HashMap<>();
                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
            } else {
                options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
                options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
            }

            options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770

            // SI QUEREMOS CORRERLO EN MODO HEADLESS   - BEGIN
//            options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
            // SI QUEREMOS CORRERLO EN MODO HEADLESS   - END

            driver = new ChromeDriver(options);
        }

        // FIREFOX
        if (browser.equals("FIREFOX")) {
            WebDriverManager.firefoxdriver().clearResolutionCache();
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();

            if (isResponsive) {
                Map<String, Object> deviceMetrics = new HashMap<>();
                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
                //options.setExperimentalOption("mobileEmulation", mobileEmulation);
            } else {
                options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
                options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
            }
            driver = new FirefoxDriver(options);
        }

        // EDGE
        if (browser.equals("EDGE")) {
            WebDriverManager.edgedriver().clearResolutionCache();
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();

            if (isResponsive) {
                Map<String, Object> deviceMetrics = new HashMap<>();
                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
                //options.setExperimentalOption("mobileEmulation", mobileEmulation);
            } else {
                //options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
                //options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
            }
            driver = new EdgeDriver(options);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (isResponsive) driver.manage().window().setSize(new Dimension(375, 812));
        wait = new WebDriverWait(driver,20);

    }

    protected void takeScreenshot(String methodName){
        File screenshot = null;
        try {
            screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            log.info("Screenshot taken");
        } catch (WebDriverException e) {
            log.info("Exception while taking screenshot");
            e.printStackTrace();
        }

        //Copy the file to a location and use try catch block to handle exception
        String timestamp = ZonedDateTime
                .now( ZoneId.systemDefault() )
                .format( DateTimeFormatter.ofPattern( "uuuu.MM.dd.HH.mm.ss" ) );
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Automation\\"+methodName+"_"+timestamp+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeSuite
    public void setSupplierUser(){
        UserPropertiesReader userReader = new UserPropertiesReader("EnnisFabrics");
        supplierUsername = userReader.getUsername();
        supplierPassword = userReader.getPassword();
    }

    @BeforeSuite
    public static void Setup() {
        // loading log4j.xml file
        DOMConfigurator.configure("log4j.xml");
    }







}
