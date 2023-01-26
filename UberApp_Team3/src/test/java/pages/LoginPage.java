package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "confirmLogin")
    private WebElement btnLogin;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//p[text()='Already have an Account?']")
    private WebElement mainParagraph;

    @FindBy(id = "logout")
    private WebElement btnLogout;

    @FindBy(css = "span > a[href='/users']")
    private WebElement users;

    @FindBy(css = "div[role='alert']")
    private WebElement alert;

    public LoginPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public String getMainParagraphText(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(this.mainParagraph));

        return this.mainParagraph.getText();
    }

    public void login(String email, String password){

        setEmail(email);
        setPassword(password);
        btnLogin.click();
    }

    private void setEmail(String email){
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    private void setPassword(String password){
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public boolean isLoginInvalid(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(alert)).isDisplayed();
    }

}
