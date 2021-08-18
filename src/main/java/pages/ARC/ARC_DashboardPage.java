package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_DashboardPage extends ARC_BasePage {

    public ARC_DashboardPage(WebDriver driver) {
        super(driver);
    }

    private By receivablesDashboard =By.id("receivables_dashboard");

    public WebElement getReceivablesDashboard() {
        return driver.findElement(receivablesDashboard);
    }
}
