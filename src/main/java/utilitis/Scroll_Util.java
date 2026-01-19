package utilitis;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scroll_Util {
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) BasePage.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

