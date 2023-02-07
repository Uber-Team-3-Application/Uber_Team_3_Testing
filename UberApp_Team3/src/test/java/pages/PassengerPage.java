package pages;

import helper.Helper;
import org.openqa.selenium.*;
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

    @FindBy(id = "departure")
    private WebElement departureInput;

    @FindBy(id = "destination")
    private WebElement destinationInput;

    @FindBy(id = "selectVehicle")
    private WebElement selectVehicle;

    @FindBy(xpath = "//span[text()='STANDARD']")
    private WebElement standardVehicle;

    @FindBy(css = "button.my-button.ride-button")
    private WebElement btnRideDetails;

    @FindBy(css = "div.alert.alert-danger p")
    WebElement errorMessageElement;


    @FindBy(xpath = "//button[@type='button'][@class='ride-button my-button'][text()='Confirm']")
    private WebElement confirm;


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

    public void orderARideInvalidInput() {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnOrderRide)).click();
        scrollIntoView();
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnRideDetails)).click();
    }

    private void scrollIntoView() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnRideDetails);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnRideDetails));
    }

    public String getWarningText() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(this.errorMessageElement));
        return errorMessageElement.getText();
    }

    public void orderARide() {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnOrderRide)).click();
        scrollIntoView();

        departureInput.sendKeys("Radnicka 1");
        destinationInput.sendKeys("Radnicka 19");

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(selectVehicle)).click();

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(standardVehicle)).click();

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnRideDetails)).click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnRideDetails);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(confirm));

        Helper.takeScreenshoot(driver, "ride_details");
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(confirm)).click();
        Helper.takeScreenshoot(driver, "ride_ordered");
    }

    public void orderARideNoDriver() {
        try {
            orderARide();
        } catch(UnhandledAlertException  noe) {
            Helper.takeScreenshoot(driver, "no_driver_found");
            driver.switchTo().alert().accept();
        }
    }

    public void refresh() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
        driver.navigate().refresh();
    }
}
