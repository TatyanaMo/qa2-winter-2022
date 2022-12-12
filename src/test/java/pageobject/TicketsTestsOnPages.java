package pageobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageobject.pages.FlightInfoPage;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

public class TicketsTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";

    private final String NAME = "Barsjusha";
    private final String SURNAME = "Kotovski";
    private final String DISCOUNT = "fg123gg";
    private final String ADULTS = "1";
    private final String CHILD = "0";
    private final String BAG = "1";
    private final String FLIGHT_DATE = "13";


    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest () {
        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        String from2 = infoPage.getFromAirport();
        String to2 = infoPage.getToAirport();
        Assertions.assertEquals(FROM_AIRPORT, from2, "Airports 'From' not equals!");
        Assertions.assertEquals(TO_AIRPORT, to2, "Airports 'To' not equals!");
        infoPage.passengerInfo(NAME, SURNAME, DISCOUNT, ADULTS, CHILD, BAG, FLIGHT_DATE);
    }
}
