package bdd.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

import bdd.utils.SettingsTestData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        // WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Detect if running inside GitHub Actions (Linux CI)
        boolean isCI = System.getenv("GITHUB_ACTIONS") != null;

        if (isCI) {
            // System.out.println("Running in GitHub Actions - enabling headless mode");

            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");
        }
        // driver = new ChromeDriver();
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
