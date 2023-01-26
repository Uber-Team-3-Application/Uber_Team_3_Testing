package pages;

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


    public DriverPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
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
