package com.github.anastasiia.smotritskaya.gdevet.city;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.github.anastasiia.smotritskaya.gdevet.pages.base.KazanBasePage;
import com.github.anastasiia.smotritskaya.gdevet.base.KazanBaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.github.anastasiia.smotritskaya.gdevet.config.TestConfig.KAZAN_MAIN_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.anastasiia.smotritskaya.gdevet.pages.factory.City.KAZAN;
import static com.github.anastasiia.smotritskaya.gdevet.pages.factory.PageFactory.createMainPage;

/**
 * Содержит тесты для главной страницы Казани
 * https://kazan.gde-vet.ru/
 */
@Epic("UI Tests for Veterinary Aggregator")
@Feature("Kazan")
@Story("Kazan main page")
public class KazanMainTest extends KazanBaseTest {
    @BeforeEach
    void setUp() {
        open(KAZAN_MAIN_URL);
        super.page = (KazanBasePage) createMainPage(KAZAN);
    }

    @Test
    @Disabled("CAPTCHA")
    void name() {
        assertEquals(KAZAN_MAIN_URL, url());
        page.logo_header.click();
    }
}
