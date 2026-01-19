package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilitis.Driver_Util;

public class Hooks {
    @Before
    public void setUp() {
        Driver_Util.initDriver();
    }

    @After
    public void tearDown() {
        Driver_Util.quitDriver();
    }
}
