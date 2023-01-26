package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void initDriver(){

        System.setProperty("WebDriver.chrome.driver",
                "C:\\Users\\pc\\Desktop\\GIT\\Uber_Team_3_Testing\\UberApp_Team3\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }
}
