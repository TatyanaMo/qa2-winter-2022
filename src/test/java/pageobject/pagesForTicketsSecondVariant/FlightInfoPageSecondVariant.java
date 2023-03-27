package pageobject.pagesForTicketsSecondVariant;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;


public class FlightInfoPageSecondVariant {

    private final By FLIGHT_INFO = By.xpath(".//div[@class = 'responsePrice']/span");
    private final By RESPONSE_TEXT = By.xpath(".//div[@class = 'responsePrice']");
    private final By BOOK_BTN = By.id("book2");

    private BaseFunc baseFunc;
    public FlightInfoPageSecondVariant(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getPassengerName() {
        baseFunc.waitForElementsCountToBe(FLIGHT_INFO, 3);
        String name  = baseFunc.list(FLIGHT_INFO).get(0).getText();
        return name.substring(0, name.length()-1);
    }
    public String getFromAirport2() {
        return baseFunc.list(FLIGHT_INFO).get(1).getText();
    }
    public String getToAirport2() {
        return baseFunc.list(FLIGHT_INFO).get(2).getText();
    }

    public String getPrice () {
        String text = baseFunc.getTextOfElement(RESPONSE_TEXT);
        return StringUtils.substringBetween(text,"for ", " EUR");
    }

    public SeatSelectionPageSecondVariant book() {
        baseFunc.click(BOOK_BTN);
        return new SeatSelectionPageSecondVariant (baseFunc);
    }

    public FlightInfoPageSecondVariant secondCheckPassengerData(FlightInfo expected) {
        Assertions.assertEquals(expected.getPassenger().getFirstName(), getPassengerName(), "Name not equal!");
        Assertions.assertEquals(expected.getDeparture(), getFromAirport2(),"Airports 'From' not equals!");
        Assertions.assertEquals(expected.getDestination(), getToAirport2(), "Airports 'To' not equals!");
        Assertions.assertTrue(getPrice().length()>0, "Price not found");
        return this;
    }
}
