package utilitis;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Util {

    public static void initDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.setDriver(driver);
    }

    public static void quitDriver() {
        WebDriver driver = BasePage.getDriver();
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                BasePage.removeDriver();
            }
        }
    }
}
