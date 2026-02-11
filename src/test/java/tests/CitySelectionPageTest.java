package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CitySelectionPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitySelectionPageTest {
    private final static CitySelectionPage citySelectionPage = new CitySelectionPage();

    @Test
    @DisplayName("Clicking the SPb button should open the SPb main page")
    public void spbButtonTest() {
        open(BASE_URL);
        citySelectionPage.spbButton.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("Clicking the Kazan button should open the Kazan main page")
    public void kazanButtonTest() {
        open(BASE_URL);
        citySelectionPage.kazanButton.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @DisplayName("Clicking the policy button should open the Kazan main page")
    public void policyButtonTest() {
        open(BASE_URL);
        citySelectionPage.policyButton.click();
        assertEquals(SPB_MAIN_URL + POLICY_URL, url());
    }

    @Test
    @DisplayName("Clicking the terms of use button should open the Kazan main page")
    public void termsOfUseButtonTest() {
        open(BASE_URL);
        citySelectionPage.termsOfUseButton.click();
        assertEquals(SPB_MAIN_URL + TERMS_OF_USE_URL, url());
    }
}
