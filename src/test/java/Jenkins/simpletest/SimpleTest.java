package Jenkins.simpletest;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeDriverService;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.remote.DesiredCapabilities;

        import java.io.File;

        import static org.junit.Assert.assertTrue;

public class SimpleTest {

    private WebDriver driver;
    @Before
    public void SetUp(){
        loadChromedriver();

    }
    @After
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void getTitle() throws InterruptedException{
        driver.navigate().to("https://www.pravda.com.ua/");
        Thread.sleep(2000);
        String title = driver.getTitle();
        assertTrue(title.contains("Українська правда"));
    }
    private void loadChromedriver(){
        System.setProperty("webdriver.chromedriver", "chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");

        this.driver = new ChromeDriver(options);

    }
}
