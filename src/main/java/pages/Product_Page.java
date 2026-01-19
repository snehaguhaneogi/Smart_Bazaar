package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitis.Wait_Util;

public class Product_Page extends BasePage {

    private final WebDriver driver;

    @FindBy(xpath = "//p[@class='price']/span/bdi")
    private WebElement priceText;

    public Product_Page() {
        this.driver = BasePage.getDriver();
        PageFactory.initElements(driver,this);
    }

    public String getProductPrice() {
        Wait_Util.waitForVisible(priceText);
        return priceText.getText();
    }
}
