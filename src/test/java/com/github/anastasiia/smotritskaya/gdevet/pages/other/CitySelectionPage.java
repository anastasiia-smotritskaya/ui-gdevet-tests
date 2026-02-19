package com.github.anastasiia.smotritskaya.gdevet.pages.other;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница с выборов города, не наследуется от BasePage, так как не содержит элементов,
 * характерных для остальных страниц
 * https://gde-vet.ru/
 */
public class CitySelectionPage {
    public final SelenideElement spb_button = $(byText("Санкт-Петербург"));
    public final SelenideElement kazan_button = $(byText("Казань"));

    public final SelenideElement policy_button =
            $(byText("Политика обработки персональных данных"));
    public final SelenideElement termsOfUse_button =
            $(byText("Пользовательское соглашение"));
}
