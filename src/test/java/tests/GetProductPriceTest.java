package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_Page;
import pages.Product_Page;
import pages.Result_Page;
import tests.dataprovider.SearchDataProvider;

public class GetProductPriceTest extends BaseTest{
    @Test(dataProvider = "productData" , dataProviderClass = SearchDataProvider.class)
    public void searchProductAndPrintPrice(String searchKey , String productName, String expectedPrice) {
        Home_Page homePage = new Home_Page();
        Result_Page resultPage = new Result_Page();
        Product_Page productPage = new Product_Page();

        homePage.openSite("https://www.smartbazaar.co.uk/");
//        homePage.closePopUp();
        homePage.searchFor(searchKey);

        resultPage.selectProduct(productName);

        String price = productPage.getProductPrice();
        Assert.assertEquals(price,expectedPrice);
    }
}
