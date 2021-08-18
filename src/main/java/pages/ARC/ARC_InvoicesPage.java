package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_InvoicesPage extends ARC_BasePage {
    public ARC_InvoicesPage(WebDriver driver) {
        super(driver);
    }

    private By invoicesTable = new By.ById("invoices_index");

    public WebElement getInvoicesTable() {
        return driver.findElement(invoicesTable);
    }
}
