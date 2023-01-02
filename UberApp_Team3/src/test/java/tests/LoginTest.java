package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.HomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BaseTest{

    @Test
    public void openHomePage(){
        HomePage page = new HomePage(driver);


    }

}
