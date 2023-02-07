package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriver driver2;

    @BeforeSuite
    public void initDriver(){

        // WINDOWS
//      System.setProperty("WebDriver.chrome.driver",
//                "C:\\Users\\pc\\Desktop\\GIT\\Uber_Team_3_Testing\\UberApp_Team3\\chromedriver.exe");
//      System.setProperty("webdriver.edge.driver", "C:\\Users\\pc\\Desktop\\GIT\\Uber_Team_3_Testing\\UberApp_Team3\\msedgedriver.exe");

        // MAC-OS
        System.setProperty("WebDriver.chrome.driver", "chromedriver");
        System.setProperty("webdriver.edge.driver", "msedgedriver");

        EdgeOptions options = new EdgeOptions();
        driver2 = new EdgeDriver(options);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }
}
