package tests.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CitySelectionPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitySelectionPageTest {
    private final static CitySelectionPage citySelectionPage = new CitySelectionPage();

    @BeforeEach
    void setUp() {
        open(BASE_URL);
    }

    @Test
    @DisplayName("Clicking the SPb button should open the SPb main page")
    public void spbButtonTest() {
        citySelectionPage.spbButton.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("Clicking the Kazan button should open the Kazan main page")
    public void kazanButtonTest() {
        citySelectionPage.kazanButton.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @DisplayName("Clicking the policy button should open the policy page")
    public void policyButtonTest() {
        citySelectionPage.policyButton.click();
        assertEquals(SPB_MAIN_URL + POLICY_URL, url());
    }

    @Test
    @DisplayName("Clicking the terms of use button should open the terms of use page")
    public void termsOfUseButtonTest() {
        citySelectionPage.termsOfUseButton.click();
        assertEquals(SPB_MAIN_URL + TERMS_OF_USE_URL, url());
    }
}
