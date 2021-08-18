package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_DocumentsPage extends ARC_BasePage {
    public ARC_DocumentsPage(WebDriver driver) {
        super(driver);
    }

    private By documentsTable = new By.ById("documents_index");

    public WebElement getDocumentsTable() {
        return driver.findElement(documentsTable);
    }
}
