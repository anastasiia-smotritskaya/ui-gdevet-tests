package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.base.BasePage.*;
import static pages.base.BasePage.logo_header;

public class KazanBaseTest {
    @BeforeEach
    void setUp() {
        System.out.println("Setting up test...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--lang=en");

        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;
        Configuration.headless = false;

        open(KAZAN_MAIN_URL);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after test...");
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the logo, the Kazan main page should open")
    public void headerLogoTest() {
        logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the categories button, the categories page should open")
    public void headerCategoriesTest() {
        categories_header.click();
        assertEquals(KAZAN_MAIN_URL + CATEGORIES_URL, url());
        logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the comments button, the comments page should open")
    public void headerCommentsTest() {
        comments_header.click();
        assertEquals(KAZAN_MAIN_URL + COMMENTS_URL, url());
        logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the clinics button, the clinics page should open")
    public void headerClinicsTest() {
        vetkliniki_header.click();
        assertEquals(KAZAN_MAIN_URL + VETKLINIKI_URL, url());
        logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }
}
