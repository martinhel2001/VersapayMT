package pages.ARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ARC_VerifyIdentityPage extends BasePage {
    public ARC_VerifyIdentityPage(WebDriver driver) {
        super(driver);
    }

    By challengeForm = By.id("challenge_with_security_question");
    By answerInput = By.id("security_question_response_answer");
    By signInButton = By.name("commit");

    public WebElement getChallengeForm() {
        return driver.findElement(challengeForm);
    }

    public void answerChallenge(String answer) {
        driver.findElement(answerInput).sendKeys(answer);
        driver.findElement(signInButton).click();
    }

}
