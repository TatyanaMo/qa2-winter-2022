package pageobject;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.pagesForCarRent.HomePageCars;
import pageobject.pagesForCarRent.SelectedLocationCarsPage;

public class CarRentTests {

    private final String HOME_PAGE_URL = "http://www.discovercars.com/";
    private final String LocationToOpen = "Latvia";

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void FindLocationTestOnPages () {
        baseFunc.openUrl(HOME_PAGE_URL);

        HomePageCars homePageCars = new HomePageCars(baseFunc);
        homePageCars.acceptCookies();
        homePageCars.getLocation(LocationToOpen);

        SelectedLocationCarsPage selectedLocationCarsPage = new SelectedLocationCarsPage(baseFunc);
        boolean isCountrySelect = false;
        if (!selectedLocationCarsPage.getTitle().isEmpty()) {
            isCountrySelect = true;
        }
        Assertions.assertTrue(isCountrySelect, "Country not Selected!");
    }
}