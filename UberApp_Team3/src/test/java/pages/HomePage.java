package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;
    private final String PAGE_URL = "http://localhost:4200";

    public HomePage(WebDriver driver){
        this.driver = driver;

        this.driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

}
