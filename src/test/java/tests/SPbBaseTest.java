package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.base.BasePage.*;

public class SPbBaseTest {
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

        open(SPB_MAIN_URL);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after test...");
    }

    @Test
    @DisplayName("When you click on the header logo, the SPb main page should open")
    public void headerLogoTest() {
        logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header categories button, the categories page should open")
    public void headerCategoriesTest() {
        categories_header.click();
        assertEquals(SPB_MAIN_URL + CATEGORIES_URL, url());
        logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header comments button, the comments page should open")
    public void headerCommentsTest() {
        comments_header.click();
        assertEquals(SPB_MAIN_URL + COMMENTS_URL, url());
        logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header clinics button, the clinics page should open")
    public void headerClinicsTest() {
        vetkliniki_header.click();
        assertEquals(SPB_MAIN_URL + VETKLINIKI_URL, url());
        logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header clinics button, the clinics page should open")
    public void headerLoginTest() {
        login_window.shouldNotBe(visible);
        login_header.click();
        login_window.shouldBe(visible);
        blur();
        login_window.shouldNotBe(visible);
    }
}
