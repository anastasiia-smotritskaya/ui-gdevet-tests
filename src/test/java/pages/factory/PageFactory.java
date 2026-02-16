package pages.factory;

import pages.base.BasePage;
import pages.kazan.KazanMainPage;
import pages.spb.SPbMainPage;

import static utils.ErrorMessages.CITY_NOT_FOUND;

/**
 * Фабрика для "главных" страниц — там где есть различия по городам
 * Другие страницы (политика, соглашение) создаются напрямую
 */
public class PageFactory {
    public static BasePage createMainPage(City city) {
        switch (city) {
            case SPB -> {
                return new SPbMainPage();
            }
            case KAZAN -> {
                return new KazanMainPage();
            }
            default -> {
                throw new IllegalArgumentException(String.format(CITY_NOT_FOUND, city));
            }
        }
    }
}
