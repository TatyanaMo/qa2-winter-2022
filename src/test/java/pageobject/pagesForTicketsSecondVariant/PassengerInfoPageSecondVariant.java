package pageobject.pagesForTicketsSecondVariant;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.pages.FlightInfoPage;


public class PassengerInfoPageSecondVariant {
    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");

    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");

    private final By DESTINATIONS = By.xpath(".//span[@class = 'bTxt']");


    private BaseFunc baseFunc;
    public PassengerInfoPageSecondVariant(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getFromAirport() {
        return baseFunc.list(DESTINATIONS).get(0).getText();
    }
    public String getToAirport() {
        return baseFunc.list(DESTINATIONS).get(1).getText();
    }
    public PassengerInfoPageSecondVariant fillInPassengerInfo(FlightInfo flightInfo) {
        baseFunc.type(FIRST_NAME, flightInfo.getPassenger().getFirstName());
        baseFunc.type(LAST_NAME, flightInfo.getPassenger().getLastName());
        baseFunc.type(DISCOUNT, flightInfo.getDiscount());
        baseFunc.type(ADULTS, flightInfo.getAdultsCount());
        baseFunc.type(CHILDREN, flightInfo.getChildCount());
        baseFunc.type(BAG, flightInfo.getBagsCount());
        baseFunc.selectByText(FLIGHT, flightInfo.getFlightDate());
        return this;
    }

    public FlightInfoPageSecondVariant getPrice() {
        baseFunc.click(GET_PRICE_BTN);
        return new FlightInfoPageSecondVariant(baseFunc);
    }

    public PassengerInfoPageSecondVariant checkPassengerData(FlightInfo expected) {
        Assertions.assertEquals(expected.getDeparture(), getFromAirport(), "Airports 'From' not equals!");
        Assertions.assertEquals(expected.getDestination(), getToAirport(), "Airports 'To' not equals!");
        return this;
    }
}
