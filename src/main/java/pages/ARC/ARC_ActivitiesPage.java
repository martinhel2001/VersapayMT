package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_ActivitiesPage extends ARC_BasePage {
    public ARC_ActivitiesPage(WebDriver driver) {
        super(driver);
    }

    private By eventsTable = new By.ById("events");

    public WebElement getEventsTable() {
        return driver.findElement(eventsTable);
    }


}
