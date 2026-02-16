package tests.city;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.base.KazanBasePage;
import tests.base.KazanBaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.KAZAN_MAIN_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.factory.City.KAZAN;
import static pages.factory.PageFactory.createMainPage;

/**
 * Содержит тесты для главной страницы Казани
 * https://kazan.gde-vet.ru/
 */
public class KazanMainPageTest extends KazanBaseTest {
    @BeforeEach
    void setUp() {
        open(KAZAN_MAIN_URL);
        super.page = (KazanBasePage) createMainPage(KAZAN);
    }

    @Test
    void name() {
        assertEquals(KAZAN_MAIN_URL, url());
        page.logo_header.click();
    }
}
