package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ARC_LoginPage extends BasePage {

    private By emailInput = By.id("user_email");
    private By passwordInput = By.id("user_password");
    private By signInButton = By.id("user_submit");


    public ARC_LoginPage(WebDriver driver, String url) {
        super(driver);
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    public void login(String userName, String password) {
        driver.findElement(emailInput).sendKeys(userName);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }


}
