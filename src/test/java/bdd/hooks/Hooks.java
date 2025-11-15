package bdd.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bdd.utils.SettingsTestData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
