package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilitis.Scroll_Util;
import utilitis.Wait_Util;

import java.util.List;

public class Result_Page extends BasePage {

    private final WebDriver driver;

//    @FindBy(xpath = "//main[@id='main']/ul/li")
    private By productItems = By.xpath("//main[@id='main']/ul/li");
    private By productName = By.tagName("h2");


    public Result_Page() {
        this.driver = BasePage.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void selectProduct(String expectedName) {
        try {
            Wait_Util.waitForPresence(productItems);
            List<WebElement> items = driver.findElements(productItems);
            for (WebElement item : items) {
                WebElement nameElement = item.findElement(productName);
                Wait_Util.waitForVisible(nameElement);
                String actualName = nameElement.getText().trim();
                if (actualName.equalsIgnoreCase(expectedName)) {
                    Scroll_Util.scrollToElement(item);
                    Wait_Util.waitForClickable(item);
                    item.click();
                    return;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Product not found :" +expectedName);
        }
    }
}

