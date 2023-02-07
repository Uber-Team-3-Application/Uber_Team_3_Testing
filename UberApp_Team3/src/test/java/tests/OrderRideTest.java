package tests;

import helper.Helper;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.DriverPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PassengerPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class OrderRideTest extends BaseTest{

    private final String DRIVER_EMAIL = "marko@gmail.com";
    private final String DRIVER_PASSWORD = "Marko123";

    private final String PASSENGER_EMAIL = "markopreradovic@gmail.com";
    private final String PASSENGER_PASSWORD = "Marko123";

    @Test(testName = "Open Home Page", priority = 1)
    public void openHomePage(){
        HomePage page = new HomePage(driver);
        assertEquals("Reesen", page.getTitle());

        page.openLoginPage();
        loginAs_Passenger();

       // orderARideInvalidInput();
        //orderARideNoDriver();
        loginAs_Driver();
         orderARide();
    }

    @Test(testName = "Order a ride", priority = 4)
    private void orderARide() {
        PassengerPage passengerPage = new PassengerPage(driver);
        passengerPage.orderARide();
    }

    @Test(testName = "Order a ride no driver", priority = 3)
    private void orderARideNoDriver() {
        PassengerPage passengerPage = new PassengerPage(driver);
        passengerPage.orderARideNoDriver();
        passengerPage.refresh();
    }
    @Test(testName = "Order a ride wrong input", priority = 2)
    private void orderARideInvalidInput() {
        PassengerPage passengerPage = new PassengerPage(driver);
        passengerPage.orderARideInvalidInput();
        assertEquals("Please enter valid data, and select a Vehicle type!", passengerPage.getWarningText());
        passengerPage.refresh();
    }

    public void loginAs_Passenger(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(PASSENGER_EMAIL, PASSENGER_PASSWORD);
    }

    public void loginAs_Driver(){
        driver2.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver2);
        loginPage.login(DRIVER_EMAIL, DRIVER_PASSWORD);
        driver2.manage().window().setPosition(new Point(-2000, 0));
    }
}
