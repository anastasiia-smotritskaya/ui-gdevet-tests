package com.github.anastasiia.smotritskaya.gdevet.pages.city;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.anastasiia.smotritskaya.gdevet.pages.base.SPbBasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Лучшие ветеринарные клиники в СПб
 * https://spb.gde-vet.ru/vetkliniki/
 */
public class SPbVetklinikiPage extends SPbBasePage {
    public final SelenideElement rajon_filter = $(".filter-rajon");
    public final SelenideElement metro_filter = $(".filter-metro");
    public final SelenideElement prigorod_filter = $(".filter-prigorod");
    public final SelenideElement uslugi_filter = $(".filter-uslugi");

    public final ElementsCollection rajon_checkbox = $$(".filter-rajon input");
    public final ElementsCollection metro_checkbox = $$(".filter-metro input");
    public final ElementsCollection prigorod_radiobutton = $$(".filter-prigorod input");
    public final ElementsCollection uslugi_checkbox = $$(".filter-uslugi .nonleaf");
}
