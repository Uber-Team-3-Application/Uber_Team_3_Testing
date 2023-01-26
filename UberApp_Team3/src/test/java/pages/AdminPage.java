package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

    private final WebDriver driver;
    @FindBy(id = "logout")
    private WebElement btnLogout;

    @FindBy(css = "span > a[href='/users']")
    private WebElement users;


    public AdminPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public boolean containsAdminNavbarElement() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(users)).isDisplayed();

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
