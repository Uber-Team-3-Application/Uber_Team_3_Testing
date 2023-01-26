package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest{

    private final String ADMIN_EMAIL = "nikolaj@gmail.com";
    private final String ADMIN_PASSWORD = "Nikolaj123";


    private final String DRIVER_EMAIL = "marko@gmail.com";
    private final String DRIVER_PASSWORD = "Marko123";

    private final String PASSENGER_EMAIL = "markopreradovic@gmail.com";
    private final String PASSENGER_PASSWORD = "Marko123";

    @Test(testName = "Open Home Page", priority = 1)
    public void openHomePage(){
        HomePage page = new HomePage(driver);
        assertEquals("Reesen", page.getTitle());

        page.openLoginPage();
    }

    @Test(testName = "Login as Admin", priority = 2)
    public void loginAs_Admin(){
        LoginPage loginPage = new LoginPage(driver);
        assertEquals("Already have an Account?", loginPage.getMainParagraphText());

        loginPage.login(ADMIN_EMAIL, ADMIN_PASSWORD);

        AdminPage adminPage = new AdminPage(driver);
        assertTrue(adminPage.containsAdminNavbarElement());
        assertTrue(adminPage.containsUserLogoutButton());

        adminPage.logout();
        assertEquals("Already have an Account?", loginPage.getMainParagraphText());
    }

    @Test(testName = "Login as Passenger", priority = 2)
    public void loginAs_Passenger(){
        LoginPage loginPage = new LoginPage(driver);
        assertEquals("Already have an Account?", loginPage.getMainParagraphText());

        loginPage.login(PASSENGER_EMAIL, PASSENGER_PASSWORD);

        PassengerPage passengerPage = new PassengerPage(driver);
        assertTrue(passengerPage.containsOrderRideButton());
        assertTrue(passengerPage.containsUserLogoutButton());

        passengerPage.logout();
        assertEquals("Already have an Account?", loginPage.getMainParagraphText());

    }

    @Test(testName = "Login as Driver", priority = 2)
    public void loginAs_Driver(){
        LoginPage loginPage = new LoginPage(driver);
        assertEquals("Already have an Account?", loginPage.getMainParagraphText());

        loginPage.login(DRIVER_EMAIL, DRIVER_PASSWORD);


        DriverPage driverPage = new DriverPage(driver);
        assertTrue(driverPage.containsToggleActivity());
        assertTrue(driverPage.containsUserLogoutButton());

        driverPage.logout();
        assertEquals("Already have an Account?", loginPage.getMainParagraphText());


    }

    @Test(testName = "Try login with invalid data", priority = 2)
    public void loginWith_NonExistingData(){
        LoginPage loginPage = new LoginPage(driver);
        assertEquals("Already have an Account?", loginPage.getMainParagraphText());
        loginPage.login("blatruc@gmail.com", "lozinka123");
        assertTrue(loginPage.isLoginInvalid());

    }

}
