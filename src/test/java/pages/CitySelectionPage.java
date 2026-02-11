package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CitySelectionPage {
    public final SelenideElement spbButton = $(byText("Санкт-Петербург"));
    public final SelenideElement kazanButton = $(byText("Казань"));

    public final SelenideElement policyButton =
            $(byText("Политика обработки персональных данных"));
    public final SelenideElement termsOfUseButton =
            $(byText("Пользовательское соглашение"));
}
