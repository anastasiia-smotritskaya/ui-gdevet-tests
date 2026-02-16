package pages.base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static utils.ExpectedText.OFFER_KAZAN_TEXT;

/**
 * Базовая абстрактная страница Казани, подвал и содержание отличается от СПб
 * https://kazan.gde-vet.ru/
 */
public abstract class KazanBasePage extends BasePage {
    // footer
    public final SelenideElement offer_text = $(By.xpath(String.format("//*[contains(text(), '%s')]", OFFER_KAZAN_TEXT)));
    public final SelenideElement policy_button =
            $(withText("Политика обработки персональных данных"));
    public final SelenideElement termsOfUse_button =
            $(byText("Пользовательское соглашение"));
    public final SelenideElement cookieCLose_button = $(By.className("cookie-close"));

}
