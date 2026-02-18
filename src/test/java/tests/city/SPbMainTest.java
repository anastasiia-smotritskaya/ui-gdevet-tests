package tests.city;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.city.SPbMainPage;
import pages.city.SPbVetklinikiPage;
import tests.base.SPbBaseTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.WebDriverRunner.url;
import static config.TestConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.factory.City.SPB;
import static pages.factory.PageFactory.createMainPage;
import static pages.factory.PageFactory.createVetklinikiPage;

/**
 * Содержит тесты для главной страницы СПб
 * https://spb.gde-vet.ru/
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Epic("UI Tests for Veterinary Aggregator")
@Feature("SPb")
@Story("SPb main page")
public class SPbMainTest extends SPbBaseTest {

    private SPbMainPage spbMainPage;
    private SPbVetklinikiPage sPbVetklinikiPage;

    private static final int NUMBER_OF_DISTRICTS = 22;
    private static final Map<String, String> districtsMap = new HashMap<>();
    private static final List<String> districtsList = new ArrayList<>();

    private static final int NUMBER_OF_METRO_STATIONS = 69;
    private static final Map<String, String> metroMap = new HashMap<>();
    private static final List<String> metroList = new ArrayList<>();

    private static final int NUMBER_OF_SUBURBS = 27;
    private static final Map<String, String> suburbsMap = new HashMap<>();
    private static final List<String> suburbsList = new ArrayList<>();

    {
        districtsMap.put("Адмиралтейский район", ADMIRALTEYSKIY_RAYON_URL);
        districtsMap.put("Гатчинский район", GATCHINSKIY_RAYON);
        districtsMap.put("Центральный район", TSENTRALNYY_RAYON);

        districtsList.addAll(districtsMap.keySet());

        metroMap.put("Автово", AVTOVO);
        metroMap.put("Электросила", ELEKTROSILA);
        metroMap.put("Проспект Просвещения", PROSPEKT_PROSVESCHENIYA);

        metroList.addAll(metroMap.keySet());

        suburbsMap.put("Всеволожск", VSEVOLOZHSK);
        suburbsMap.put("Шлиссельбург", SHLISSELBURG);
        suburbsMap.put("Сосновый бор", SOSNOVYY_BOR);

        suburbsList.addAll(suburbsMap.keySet());
    }

    @BeforeEach
    void setUp() {
        spbMainPage = (SPbMainPage) createMainPage(SPB);
        super.page = (SPbMainPage) createMainPage(SPB);
        open(SPB_MAIN_URL);
    }

    @Test
    @DisplayName("The SPbMainPage should contain the main paragraphs")
    void paragraphsTest() {
        spbMainPage.allSPbClinics_par.shouldBe(visible);
        spbMainPage.contactingToClinic_par.shouldBe(visible);
        spbMainPage.searchForAClinic_par.shouldBe(visible);
        spbMainPage.clinicsOnTheMap_par.shouldBe(visible);
        spbMainPage.reviewsOfClinics_par.shouldBe(visible);
        spbMainPage.aboutProject_par.shouldBe(visible);
    }

    @Test
    @DisplayName("When you click on the list of veterinarians button, the veterinarians page should open")
    void veterinariansTest() {
        spbMainPage.veterinary_button.click();
        assertEquals(SPB_MAIN_URL + VETERINARY_URL, url());
        spbMainPage.logo_header.click();
        assertEquals(SPB_MAIN_URL, url());
    }

    @Test
    @DisplayName("The search for a clinic paragraph should contain the main filtration types ")
    void searchForAClinicFiltrationTypesTest() {
        spbMainPage.byDistrict.shouldHave(cssClass("active"));
        spbMainPage.byMetro.shouldNotHave(cssClass("active"));
        spbMainPage.bySuburb.shouldNotHave(cssClass("active"));
        spbMainPage.byServiceType.shouldNotHave(cssClass("active"));
    }

    @Test
    @DisplayName("The number of districts must correspond to the specified number")
    void byDistrictTest() {
        spbMainPage.byDistrict.shouldHave(cssClass("active"));
        spbMainPage.byMetro.shouldNotHave(cssClass("active"));
        spbMainPage.bySuburb.shouldNotHave(cssClass("active"));
        spbMainPage.byServiceType.shouldNotHave(cssClass("active"));

        assertEquals(NUMBER_OF_DISTRICTS, spbMainPage.districts.size());
        assertTrue(spbMainPage.districts.texts().containsAll(districtsList));
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @DisplayName("Clicking on a button for a specific district should open a page with a list of clinics in that district")
    @MethodSource("districtsDataProvider")
    void districtUrlTest(String district, String DISTRICT_URL) {
        sPbVetklinikiPage = (SPbVetklinikiPage) createVetklinikiPage(SPB);

        spbMainPage.districts.findBy(text(district)).click();

        assertEquals(SPB_MAIN_URL + VETKLINIKI_URL + DISTRICT_URL, url());
        sPbVetklinikiPage.rajon_checkbox
                .findBy(attribute("data-value", DISTRICT_URL.replace("/", "")))
                .shouldBe(checked);
    }

    private Stream<Arguments> districtsDataProvider() {
        return districtsMap.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

    @Test
    @DisplayName("The number of metro stations must correspond to the specified number")
    void byMetroTest() {
        spbMainPage.byMetro.click();

        spbMainPage.byDistrict.shouldNotHave(cssClass("active"));
        spbMainPage.byMetro.shouldHave(cssClass("active"));
        spbMainPage.bySuburb.shouldNotHave(cssClass("active"));
        spbMainPage.byServiceType.shouldNotHave(cssClass("active"));

        assertEquals(NUMBER_OF_METRO_STATIONS, spbMainPage.metro.size());
        assertTrue(spbMainPage.metro.texts().containsAll(metroList));
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @DisplayName("Clicking on a button for a specific metro station should open a page " +
            "with a list of clinics in that metro station")
    @MethodSource("metroDataProvider")
    void metroUrlTest(String metro, String METRO_URL) {
        sPbVetklinikiPage = (SPbVetklinikiPage) createVetklinikiPage(SPB);

        spbMainPage.byMetro.click();
        spbMainPage.metro.findBy(text(metro)).click();

        assertEquals(SPB_MAIN_URL + VETKLINIKI_URL + METRO_URL, url());
        sPbVetklinikiPage.metro_checkbox
                .findBy(attribute("data-value", METRO_URL.replace("/", "")))
                .shouldBe(checked);
    }

    private Stream<Arguments> metroDataProvider() {
        return metroMap.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

    @Test
    @DisplayName("The number of suburbs must correspond to the specified number")
    void bySuburbTest() {
        spbMainPage.bySuburb.click();

        spbMainPage.byDistrict.shouldNotHave(cssClass("active"));
        spbMainPage.byMetro.shouldNotHave(cssClass("active"));
        spbMainPage.bySuburb.shouldHave(cssClass("active"));
        spbMainPage.byServiceType.shouldNotHave(cssClass("active"));

        assertEquals(NUMBER_OF_SUBURBS, spbMainPage.suburbs.size());
        assertTrue(spbMainPage.suburbs.texts().containsAll(suburbsList));
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @DisplayName("Clicking on a button for a specific suburb should open a page " +
            "with a list of clinics in that suburb")
    @MethodSource("suburbsDataProvider")
    void suburbsUrlTest(String suburb, String SUBURB_URL) {
        sPbVetklinikiPage = (SPbVetklinikiPage) createVetklinikiPage(SPB);

        spbMainPage.bySuburb.click();
        spbMainPage.suburbs.findBy(text(suburb)).click();

        assertEquals(SPB_MAIN_URL + VETKLINIKI_URL + SUBURB_URL, url());
        sPbVetklinikiPage.prigorod_radiobutton
                .findBy(attribute("data-value", SUBURB_URL.replace("/", "")))
                .shouldBe(checked);
    }

    private Stream<Arguments> suburbsDataProvider() {
        return suburbsMap.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }
}
