package com.github.anastasiia.smotritskaya.gdevet.other;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.github.anastasiia.smotritskaya.gdevet.pages.other.CitySelectionPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.github.anastasiia.smotritskaya.gdevet.config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI Tests for Veterinary Aggregator")
@Feature("Other")
@Story("City selection page")
public class CitySelectionTest {
    private final static CitySelectionPage citySelectionPage = new CitySelectionPage();

    @BeforeEach
    void setUp() {
        open(BASE_URL);
    }

    @Test
    @DisplayName("Clicking the SPb button should open the SPb main page")
    void spbButtonTest() {
        citySelectionPage.spb_button.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("Clicking the Kazan button should open the Kazan main page")
    void kazanButtonTest() {
        citySelectionPage.kazan_button.click();
        assertEquals(KAZAN_MAIN_URL, url());
    }

    @Test
    @DisplayName("Clicking the policy button should open the policy page")
    void policyButtonTest() {
        citySelectionPage.policy_button.click();
        assertEquals(SPB_MAIN_URL + POLICY_URL, url());
    }

    @Test
    @DisplayName("Clicking the terms of use button should open the terms of use page")
    void termsOfUseButtonTest() {
        citySelectionPage.termsOfUse_button.click();
        assertEquals(SPB_MAIN_URL + TERMS_OF_USE_URL, url());
    }
}
