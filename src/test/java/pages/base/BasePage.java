package pages.base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * Базовая страница, указать шапку, подвал и методы, которые будут нужны для любой страницы
 */
public abstract class BasePage {
    public static final SelenideElement logo_header = $$(".custom-logo").get(1);
    public static final SelenideElement categories_header =
            $$(By.xpath("//a[text()='Ветеринарные услуги']")).get(1);
    public static final SelenideElement comments_header = $$(By.xpath("//a[text()='Отзывы']")).get(1);
    public static final SelenideElement vetkliniki_header =
            $$(By.xpath("//nav//a[text()='Ветклиники']")).get(1);
    public static final SelenideElement login_header = $(By.xpath("//a[text()='Личный кабинет']"));
    public static final SelenideElement login_window = $(By.className("modal"));

    public static void blur() {
        actions().moveByOffset(0, 0).click().perform();
    }
}