package Jenkins.simpletest;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;

        import static org.junit.Assert.assertTrue;

public class SimpleTest {

    private WebDriver driver;
    @Before
    public void SetUp(){
        System.setProperty("webdriver.chromedriver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-debaging-port=9222");
        driver = new ChromeDriver(options);
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
}