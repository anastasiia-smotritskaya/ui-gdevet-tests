package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница с выборов города, не наследуется от BasePage, так как не содержит элементов,
 * характерных для остальных страниц
 * https://gde-vet.ru/
 */
public class CitySelectionPage {
    public final SelenideElement spbButton = $(byText("Санкт-Петербург"));
    public final SelenideElement kazanButton = $(byText("Казань"));

    public final SelenideElement policyButton =
            $(byText("Политика обработки персональных данных"));
    public final SelenideElement termsOfUseButton =
            $(byText("Пользовательское соглашение"));
}
