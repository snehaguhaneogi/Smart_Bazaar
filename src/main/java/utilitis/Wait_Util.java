package utilitis;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait_Util {

    public static void waitForVisible(WebElement element) {
       WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(30));
       wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPresence(By locator) {
        new WebDriverWait(BasePage.getDriver(),Duration.ofSeconds(30)).until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }
}
