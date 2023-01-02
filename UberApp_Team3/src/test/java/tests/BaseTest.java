package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeAll
    public void initDriver(){

        System.setProperty("WebDriver.chrome.driver",
                "C:\\Users\\pc\\Desktop\\GIT\\Uber_Team_3_Testing\\UberApp_Team3\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterAll
    public void quitDriver(){
        driver.quit();
    }
}
