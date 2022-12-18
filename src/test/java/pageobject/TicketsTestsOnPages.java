package pageobject;

import dev.failsafe.internal.util.Assert;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageobject.model.Passenger;
import pageobject.pages.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

public class TicketsTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";
    private Integer seatNr = 6;

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest () {
        Passenger passenger = new Passenger("Kompot", "Tatjanovich", "ghgh12hd", 1,
                2,4,"16-05-2018");


        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFromAirport(), "Airports 'From' not equals!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getToAirport(), "Airports 'To' not equals!");
        infoPage.fillInPassengerInfo(passenger);

        FlightInfoPage flightInfoPage = new FlightInfoPage(baseFunc);
        Assertions.assertEquals(passenger.getFirstName(), flightInfoPage.getPassengerName(), "Name not equal!");
        Assertions.assertEquals(infoPage.getFromAirport(),flightInfoPage.getFromAirport2(),"Airports 'From' not equals!");
        Assertions.assertEquals(infoPage.getToAirport(), flightInfoPage.getToAirport2(), "Airports 'To' not equals!");
        Assertions.assertTrue(flightInfoPage.getPrice().length()>0, "Price not found");
        flightInfoPage.click();

        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.getSeat(seatNr).click();
        Assertions.assertEquals(seatNr.toString(), seatSelectionPage.getSelectedSeat(), "Seat number not equals!");
        seatSelectionPage.click();

        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(baseFunc);
        boolean isReservationSucceed = false;
        if (!registrationConfirmationPage.getConfirmationText().isEmpty()) {
            isReservationSucceed = true;
        }
        Assertions.assertTrue(isReservationSucceed,"reservation failed!");
    }
}
