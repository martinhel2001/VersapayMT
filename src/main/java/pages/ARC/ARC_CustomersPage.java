package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_CustomersPage extends ARC_BasePage {
    public ARC_CustomersPage(WebDriver driver) {
        super(driver);
    }

    private By customerTable = new By.ById("customers");

    public WebElement getCustomerTable() {
        return driver.findElement(customerTable);
    }
}
