package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerPage {
    private final WebDriver driver;
    @FindBy(id = "logout")
    private WebElement btnLogout;

    @FindBy(css = "button[class='ride-button my-button']")
    private WebElement btnOrderRide;


    public PassengerPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public boolean containsOrderRideButton() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(btnOrderRide)).isDisplayed();

    }

    public boolean containsUserLogoutButton() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(btnLogout)).isDisplayed();
    }

    public void logout(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(btnLogout)).click();
    }
}
