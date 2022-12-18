package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;
import pageobject.model.Passenger;

import java.util.List;

public class PassengerInfoPage {
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
    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getFromAirport() {
        return baseFunc.list(DESTINATIONS).get(0).getText();
    }
    public String getToAirport() {
        return baseFunc.list(DESTINATIONS).get(1).getText();
    }
    public void fillInPassengerInfo(Passenger passenger) {
        baseFunc.type(FIRST_NAME, passenger.getFirstName());
        baseFunc.type(LAST_NAME, passenger.getLastName());
        baseFunc.type(DISCOUNT, passenger.getDiscount());
        baseFunc.type(ADULTS, passenger.getPeopleCount());
        baseFunc.type(CHILDREN, passenger.getChildCount());
        baseFunc.type(BAG, passenger.getBagCount());
        baseFunc.selectByText(FLIGHT, passenger.getDate());

        baseFunc.click(GET_PRICE_BTN);
    }
}
