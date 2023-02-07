package pages;

import helper.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverPage {

    private final WebDriver driver;
    @FindBy(id = "logout")
    private WebElement btnLogout;

    @FindBy(id = "mat-mdc-slide-toggle-1-label")
    private WebElement toggleActivity;

    @FindBy(className = "confirmation-button")
    private WebElement btnAcceptRide;

    @FindBy(xpath = "//button[text()='START RIDE']")
    private WebElement btnStartRide;

    @FindBy(xpath = "//button[text()='FINISH RIDE']")
    private WebElement btnFinishRide;

    public DriverPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptRide() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnAcceptRide);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnAcceptRide));

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnAcceptRide)).click();
        Helper.takeScreenshoot(driver, "ride_accept");
    }


    public void startRide() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnStartRide);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnStartRide));
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnStartRide)).click();
        Helper.takeScreenshoot(driver, "ride_start");
    }

    public void endRide() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnFinishRide);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnFinishRide));

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(btnFinishRide)).click();
        Helper.takeScreenshoot(driver, "ride_end");
    }


    public boolean containsToggleActivity() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(toggleActivity)).isDisplayed();

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
