package com.github.anastasiia.smotritskaya.gdevet.pages.base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * Базовая страница - шапка и методы, которые будут нужны для любой страницы.
 * Локаторы и методы - public, так как либо так, либо геттеры.
 * Геттеры избыточны, но можно будет добавить при необходимости (доп. ожидание, логирование и пр.)
 * Локаторы не static, так как из-за этого могут возникнуть проблемы при параллельном запуске тестов
 */
public abstract class BasePage {
    // header
    public final SelenideElement logo_header =
            $$(".custom-logo").first();

    public final SelenideElement categories_header =
            $$(By.xpath("//a[text()='Ветеринарные услуги']")).first();

    public final SelenideElement comments_header =
            $$(By.xpath("//a[text()='Отзывы']")).first();

    public final SelenideElement vetkliniki_header =
            $$(By.xpath("//nav//a[text()='Ветклиники']")).first();

    public final SelenideElement login_header =
            $(By.xpath("//a[text()='Личный кабинет']"));

    public final SelenideElement login_window = $(By.className("modal"));

    public void blur() {
        actions().moveByOffset(0, 0).click().perform();
    }
}