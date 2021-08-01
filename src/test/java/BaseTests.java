import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

public class BaseTests {

    protected Homepage homePage;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        options.addArguments("disable-infobars");
        options.addArguments("-incognito");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("https://open.spotify.com/");

        homePage = new HomePage(driver);
        homePage.clickCookies();
        System.out.println(driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
