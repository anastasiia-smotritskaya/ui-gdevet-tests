package tests.city;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.base.SPbBasePage;
import tests.base.SPbBaseTest;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.SPB_MAIN_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.factory.City.SPB;
import static pages.factory.PageFactory.createMainPage;

/**
 * Содержит тесты для главной страницы СПб
 * https://spb.gde-vet.ru/
 */
public class SPbMainPageTest extends SPbBaseTest {

    @BeforeEach
    void setUp() {
        open(SPB_MAIN_URL);
        super.page = (SPbBasePage) createMainPage(SPB);
    }

    @Test
    void name() {
        assertEquals(SPB_MAIN_URL, url());
        page.logo_header.click();
    }
}
