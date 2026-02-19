package com.github.anastasiia.smotritskaya.gdevet.base;

import org.junit.jupiter.api.*;
import com.github.anastasiia.smotritskaya.gdevet.pages.base.KazanBasePage;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.github.anastasiia.smotritskaya.gdevet.config.TestConfig.*;
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
    void headerLogoTest() {
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the categories button, the categories page should open")
    void headerCategoriesTest() {
        page.categories_header.click();
        assertEquals(KAZAN_MAIN_URL + CATEGORIES_URL, url());
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the comments button, the comments page should open")
    void headerCommentsTest() {
        page.comments_header.click();
        assertEquals(KAZAN_MAIN_URL + COMMENTS_URL, url());
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("When you click on the clinics button, the clinics page should open")
    void headerClinicsTest() {
        page.vetkliniki_header.click();
        assertEquals(KAZAN_MAIN_URL + VETKLINIKI_URL, url());
        page.logo_header.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("Offer text should be visible in the footer")
    void offerTextTest() {
        page.offer_text.shouldBe(visible);
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("Clicking the policy button should open the policy page")
    void policyButtonTest() {
        page.cookieCLose_button.click();
        page.policy_button.shouldBe(clickable).click();
        assertEquals(KAZAN_MAIN_URL + POLICY_URL, url());
    }

    @Test
    @Disabled("CAPTCHA")
    @DisplayName("Clicking the terms of use button should open the terms of use page")
    void termsOfUseButtonTest() {
        page.cookieCLose_button.click();
        page.termsOfUse_button.click();
        assertEquals(KAZAN_MAIN_URL + TERMS_OF_USE_URL, url());
    }
}
