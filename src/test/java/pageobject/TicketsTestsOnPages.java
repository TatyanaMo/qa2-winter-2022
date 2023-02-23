package pageobject;

import dev.failsafe.internal.util.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

public class TicketsTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest () {
        Passenger passenger = new Passenger("Barsjusha", "Kotovski");
        int seatNr = 27;
        //int seatNr = RandomUtils.nextInt(1, 35);

        FlightInfo flightInfo = new FlightInfo("RIX", "SVO", "fg123gg", 1,2,
                4,"14-05-2018", seatNr);
        flightInfo.setPassenger(passenger);

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getFromAirport(), "Airports 'From' not equals!");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getToAirport(), "Airports 'To' not equals!");
        infoPage.fillInPassengerInfo(flightInfo);
        infoPage.getPrice();

        FlightInfoPage flightInfoPage = new FlightInfoPage(baseFunc);
        Assertions.assertEquals(passenger.getFirstName(), flightInfoPage.getPassengerName(), "Name not equal!");
        Assertions.assertEquals(infoPage.getFromAirport(),flightInfoPage.getFromAirport2(),"Airports 'From' not equals!");
        Assertions.assertEquals(infoPage.getToAirport(), flightInfoPage.getToAirport2(), "Airports 'To' not equals!");
        Assertions.assertTrue(flightInfoPage.getPrice().length()>0, "Price not found");
        flightInfoPage.book();

        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(seatNr);
        int selectedSeat = seatSelectionPage.getSelectedSeatNr();
        Assertions.assertEquals(seatNr, selectedSeat, "Wrong seat selected!");
        seatSelectionPage.book();

        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(baseFunc);
        Assertions.assertTrue(registrationConfirmationPage.isSuccessfulRegistrationTextAppears(), "Wrong text on registration confirmation page!");

    }
}
