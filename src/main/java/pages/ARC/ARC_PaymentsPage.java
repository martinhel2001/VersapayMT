package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_PaymentsPage extends ARC_BasePage {
    public ARC_PaymentsPage(WebDriver driver) {
        super(driver);
    }

    private By paymentsTable = new By.ById("payments");

    public WebElement getPaymentsTable() {
        return driver.findElement(paymentsTable);
    }
}
