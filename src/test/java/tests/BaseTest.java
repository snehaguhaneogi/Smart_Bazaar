package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilitis.Driver_Util;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Driver_Util.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver_Util.quitDriver();
    }
}
