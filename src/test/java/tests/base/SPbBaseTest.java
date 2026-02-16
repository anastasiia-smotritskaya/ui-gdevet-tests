package tests.base;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.base.SPbBasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Базовый абстрактный класс для ВСЕХ тестов, связанных с СПб.
 * Содержит общие тесты для любой страницы СПб (главная, категории, и т.д.)
 */
public abstract class SPbBaseTest extends BaseTest {

    protected SPbBasePage page;

    @Test
    @DisplayName("When you click on the header logo, the SPb main page should open")
    void headerLogoTest() {
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header categories button, the categories page should open")
    void headerCategoriesTest() {
        page.categories_header.click();
        assertEquals(SPB_MAIN_URL + CATEGORIES_URL, url());
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header comments button, the comments page should open")
    void headerCommentsTest() {
        page.comments_header.click();
        assertEquals(SPB_MAIN_URL + COMMENTS_URL, url());
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the header clinics button, the clinics page should open")
    void headerClinicsTest() {
        page.vetkliniki_header.click();
        assertEquals(SPB_MAIN_URL + VETKLINIKI_URL, url());
        page.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the login button, the login window should open")
    void loginTest() {
        page.login_window.shouldBe(hidden);
        page.login_header.click();
        page.login_window.shouldBe(visible);
        page.blur();
        page.login_window.shouldBe(hidden);
    }

    @Test
    @DisplayName("When you click on the footer logo, the SPb main page should open")
    void footerLogoTest() {
        page.logo_footer.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the footer categories button, the categories page should open")
    void footerCategoriesTest() {
        page.categories_footer.click();
        assertEquals(SPB_MAIN_URL + CATEGORIES_URL, url());
        page.logo_footer.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the footer comments button, the comments page should open")
    void footerCommentsTest() {
        page.comments_footer.click();
        assertEquals(SPB_MAIN_URL + COMMENTS_URL, url());
        page.logo_footer.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("When you click on the footer clinics button, the clinics page should open")
    void footerClinicsTest() {
        page.vetkliniki_footer.click();
        assertEquals(SPB_MAIN_URL + VETKLINIKI_URL, url());
        page.logo_footer.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("Offer text should be visible in the footer")
    void offerTextTest() {
        page.offer_text.shouldBe(visible);
    }

    @Test
    @DisplayName("When we click on the back-to-top button we should return to the top of the page")
    void backToTopTest() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");

        Number scrollPosition = executeJavaScript("return window.scrollY");
        assertTrue(scrollPosition.longValue() > 0);

        page.backToTop_button.shouldBe(clickable).click();

        Selenide.Wait().until(driver -> {
            Number currentScroll = executeJavaScript("return window.scrollY");
            return currentScroll.longValue() == 0;
        });

        Number finalScroll = executeJavaScript("return window.scrollY");
        assertEquals(0, finalScroll.longValue());
    }
}
