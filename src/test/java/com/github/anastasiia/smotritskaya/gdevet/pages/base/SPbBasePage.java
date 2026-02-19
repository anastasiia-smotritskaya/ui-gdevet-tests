package com.github.anastasiia.smotritskaya.gdevet.pages.base;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import com.github.anastasiia.smotritskaya.gdevet.utils.ExpectedText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Базовая абстрактная страница СПб, подвал и содержание отличается от Казани
 * https://spb.gde-vet.ru/
 */
public abstract class SPbBasePage extends BasePage {
    // footer
    public final SelenideElement logo_footer = $$(".custom-logo").last();
    public final SelenideElement categories_footer =
            $$(By.xpath("//a[text()='Ветеринарные услуги']")).last();
    public final SelenideElement comments_footer = $$(By.xpath("//a[text()='Отзывы']")).last();
    public final SelenideElement vetkliniki_footer =
            $$(By.xpath("//nav//a[text()='Ветклиники']")).last();

    public final SelenideElement offer_text = $(new ByText(ExpectedText.OFFER_SPB_TEXT));
    public final SelenideElement backToTop_button = $("#backtotop");
}
