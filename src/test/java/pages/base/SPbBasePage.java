package pages.base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SPbBasePage extends BasePage {
    public static final SelenideElement logo_footer = $$(".custom-logo").get(2);
    public static final SelenideElement categories_footer =
            $$(By.xpath("//a[text()='Ветеринарные услуги']")).get(2);
    public static final SelenideElement comments_footer = $$(By.xpath("//a[text()='Отзывы']")).get(2);
    public static final SelenideElement vetkliniki_footer =
            $$(By.xpath("//nav//a[text()='Ветклиники']")).get(2);
}
