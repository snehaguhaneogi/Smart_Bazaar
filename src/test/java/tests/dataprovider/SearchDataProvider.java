package tests.dataprovider;

import org.testng.annotations.DataProvider;
import utilitis.Excel_Reader;

public class SearchDataProvider {
    @DataProvider(name = "productData", parallel = true)
    public static Object[][] productData() {
        return Excel_Reader.getData("src/test/resources/testdata/SearchData.xlsx","Products");
    }
}
