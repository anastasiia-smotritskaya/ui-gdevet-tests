package tests.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.base.SPbBasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Базовый абстрактный класс для ВСЕХ тестов, связанных с СПб.
 * Содержит общие тесты для любой страницы СПб (главная, категории, и т.д.)
 */
public abstract class SPbBaseTest extends BaseTest {

    protected SPbBasePage page;

    @Test
    @DisplayName("When you click on the header logo, the SPb main page should open")
    public void headerLogoTest() {
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header categories button, the categories page should open")
    public void headerCategoriesTest() {
        page.categories_header.click();
        assertEquals(SPB_MAIN_URL + CATEGORIES_URL, url());
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header comments button, the comments page should open")
    public void headerCommentsTest() {
        page.comments_header.click();
        assertEquals(SPB_MAIN_URL + COMMENTS_URL, url());
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header clinics button, the clinics page should open")
    public void headerClinicsTest() {
        page.vetkliniki_header.click();
        assertEquals(SPB_MAIN_URL + VETKLINIKI_URL, url());
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header clinics button, the clinics page should open")
    public void headerLoginTest() {
        page.login_window.shouldNotBe(visible);
        page.login_header.click();
        page.login_window.shouldBe(visible);
        page.blur();
        page.login_window.shouldNotBe(visible);
    }
}
