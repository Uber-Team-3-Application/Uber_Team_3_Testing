package pages;

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

    @FindBy(id = "acceptRide")
    private WebElement btnAcceptRide;

    @FindBy(xpath = "//button[@class='startRidebtn'][@ng-reflect-click='startRide()']")
    private WebElement btnStartRide;

    @FindBy(xpath = "//button[@class='startRidebtn' and @ng-reflect-click='finishRide()']")
    private WebElement btnFinishRide;

    public DriverPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptRide() {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnAcceptRide)).click();
    }


    public void startRide() {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnStartRide)).click();
    }

    public void endRide() {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(btnFinishRide)).click();
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
