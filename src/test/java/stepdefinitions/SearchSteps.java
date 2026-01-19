package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Home_Page;
import pages.Product_Page;
import pages.Result_Page;

public class SearchSteps {
    private Home_Page home;
    private Result_Page result;
    private Product_Page product;

    @Given("user is on home page")
    public void user_is_on_home_page() {
        home = new Home_Page();
        result = new Result_Page();
        product = new Product_Page();

        home.openSite("https://www.smartbazaar.co.uk/");
    }

    @When("user searches for {string}")
    public void user_searches_for(String searchKey) {
        home.searchFor(searchKey);
    }

    @And("user selects product {string}")
    public void user_selects_product(String productName) {
        result.selectProduct(productName);
    }

    @Then("product price should be {string}")
    public void product_price_should_be(String expectedPrice) {
        String actualPrice = product.getProductPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }
}
