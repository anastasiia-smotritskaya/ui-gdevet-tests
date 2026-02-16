package pages.base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Базовая абстрактная страница СПб, подвал и содержание отличается от Казани
 * https://spb.gde-vet.ru/
 */
public abstract class SPbBasePage extends BasePage {
    // footer

    public final SelenideElement logo_footer = $$(".custom-logo").get(2);
    public final SelenideElement categories_footer =
            $$(By.xpath("//a[text()='Ветеринарные услуги']")).get(2);
    public final SelenideElement comments_footer = $$(By.xpath("//a[text()='Отзывы']")).get(2);
    public final SelenideElement vetkliniki_footer =
            $$(By.xpath("//nav//a[text()='Ветклиники']")).get(2);
}
