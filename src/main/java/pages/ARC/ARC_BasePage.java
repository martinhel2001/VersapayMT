package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_BasePage extends BasePage {

    private By dashboardMenuOption = By.id("dashboard_navtab");
    private By customersMenuOption = By.id("customers_navtab");
    private By invoicesMenuOption = By.id("invoices_navtab");
    private By paymentsMenuOption = By.id("payments_navtab");
    private By activitiesMenuOption = By.id("events_navtab");
    private By documentsMenuOption = By.id("documents_navtab");

    public ARC_BasePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDashboardMenuOption() {
        return driver.findElement(dashboardMenuOption);
    }

    public ARC_CustomersPage goToCustomers(){
        driver.findElement(customersMenuOption).click();
        return new ARC_CustomersPage(driver);
    }

    public ARC_DashboardPage goToDashboard(){
        driver.findElement(dashboardMenuOption).click();
        return new ARC_DashboardPage(driver);
    }

    public ARC_ActivitiesPage goToActivities(){
        driver.findElement(activitiesMenuOption).click();
        return new ARC_ActivitiesPage(driver);
    }

    public ARC_DocumentsPage goToDocuments(){
        driver.findElement(documentsMenuOption).click();
        return new ARC_DocumentsPage(driver);
    }

    public ARC_InvoicesPage goToInvoices(){
        driver.findElement(invoicesMenuOption).click();
        return new ARC_InvoicesPage(driver);
    }

    public ARC_PaymentsPage goToPayments(){
        driver.findElement(paymentsMenuOption).click();
        return new ARC_PaymentsPage(driver);
    }
}
