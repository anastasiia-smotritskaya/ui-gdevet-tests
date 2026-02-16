package tests.base;

import org.junit.jupiter.api.*;
import pages.base.KazanBasePage;

import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Базовый абстрактный класс для ВСЕХ тестов, связанных с Казанью.
 * Содержит общие тесты для любой страницы Казани (главная, категории, и т.д.)
 */
public abstract class KazanBaseTest extends BaseTest {

    protected KazanBasePage page;

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the logo, the Kazan main page should open")
    public void headerLogoTest() {
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the categories button, the categories page should open")
    public void headerCategoriesTest() {
        page.categories_header.click();
        assertEquals(KAZAN_MAIN_URL + CATEGORIES_URL, url());
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the comments button, the comments page should open")
    public void headerCommentsTest() {
        page.comments_header.click();
        assertEquals(KAZAN_MAIN_URL + COMMENTS_URL, url());
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the clinics button, the clinics page should open")
    public void headerClinicsTest() {
        page.vetkliniki_header.click();
        assertEquals(KAZAN_MAIN_URL + VETKLINIKI_URL, url());
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }
}
