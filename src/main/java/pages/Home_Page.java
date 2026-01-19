package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitis.Wait_Util;

public class Home_Page extends BasePage {

    private final WebDriver driver;
    @FindBy(xpath = "//div[@class='brave_popup__close__button']")
    private WebElement popUp;

    @FindBy(xpath = "//input[@name='s']")
    private WebElement searchBox;

    public Home_Page() {
        this.driver = BasePage.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void closePopUp() {
        Wait_Util.waitForClickable(popUp);
        popUp.click();
    }

    public void searchFor(String item) {
        Wait_Util.waitForVisible(searchBox);
        searchBox.sendKeys(item, Keys.ENTER);
    }
}
