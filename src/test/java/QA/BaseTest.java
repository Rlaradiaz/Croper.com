package QA;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.croper.com");

        
        driver.manage().window().maximize();
        
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
