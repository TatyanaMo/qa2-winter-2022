package pageobject;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.*;

public class TicketsTestsOnPagesSecondVariant {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";

    private BaseFunc baseFunc = new BaseFunc();


    @Test
    public void successfulRegistrationTestSecondStyle () {

        FlightInfo flightInfo = new FlightInfo(true);

        baseFunc.openHomePageSecondVariant()
                .selectAirports(flightInfo.getDeparture(), flightInfo.getDestination())
                .fillInPassengerInfo(flightInfo)
                .checkPassengerData(flightInfo)
                .getPrice()
                .secondCheckPassengerData(flightInfo)
                .book()
                .selectSeat(flightInfo.getSeatNr())
                .checkIfSeatSelected(flightInfo.getSeatNr())
                .book()
                .checkIfSuccessMessageAppears();
    }
}
