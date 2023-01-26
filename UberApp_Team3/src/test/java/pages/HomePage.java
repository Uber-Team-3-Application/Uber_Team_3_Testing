package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final String PAGE_URL = "http://localhost:4200";

    @FindBy(id = "login")
    WebElement btnLogin;

    public HomePage(WebDriver driver){
        this.driver = driver;

        this.driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return this.driver.getTitle();
    }
    public void openLoginPage(){
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.visibilityOf(btnLogin)
        ).click();

    }
}
