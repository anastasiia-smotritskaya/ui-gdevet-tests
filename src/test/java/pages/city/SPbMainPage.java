package pages.city;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.base.SPbBasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.ExpectedText.*;

/**
 * Главная страница СПБ, содержит элементы страницы, не считая header и footer
 * https://spb.gde-vet.ru/
 */
public class SPbMainPage extends SPbBasePage {
    public final SelenideElement allSPbClinics_par = $(byText(ALL_SPB_CLINICS_TEXT));
    public final SelenideElement contactingToClinic_par = $(byText(CONTACTING_TO_CLINIC_TEXT));
    public final SelenideElement searchForAClinic_par = $(byText(SEARCH_FOR_A_CLINIC_TEXT));
    public final SelenideElement clinicsOnTheMap_par = $(byText(CLINICS_ON_THE_MAP_TEXT));
    public final SelenideElement reviewsOfClinics_par = $(byText(REVIEWS_OF_CLINICS_TEXT));
    public final SelenideElement aboutProject_par = $(byText(ABOUT_PROJECT_TEXT));

    public final SelenideElement veterinary_button = $(byText("Список ветеринаров"));

    public final SelenideElement byDistrict = $(byText("По району"));
    public final SelenideElement byMetro = $(byText("По метро"));
    public final SelenideElement bySuburb = $(byText("По пригородам"));
    public final SelenideElement byServiceType = $(byText("по типу услуг"));

    public final ElementsCollection districts = $$(byXpath("(//*[@class='items-filter'])[1]//*[@href]"));
    public final ElementsCollection metro = $$(byXpath("(//*[@class='items-filter'])[2]//a"));
    public final ElementsCollection suburbs = $$(byXpath("(//*[@class='items-filter'])[3]//a"));
}
