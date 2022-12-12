package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

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
    private final By BOOK_BTN = By.id("book2");

    private BaseFunc baseFunc;
    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    //Spisok:
    public String getFromAirport() {
        baseFunc.list(DESTINATIONS).get(0).getText();
        return getFromAirport();
    }
    public String getToAirport() {
        baseFunc.list(DESTINATIONS).get(1).getText();
        return getToAirport();
    }
    public void passengerInfo (String name, String surname, String discount, String adults, String children, String bag, String date) {
        baseFunc.type(FIRST_NAME, name);
        baseFunc.type(LAST_NAME, surname);
        baseFunc.type(DISCOUNT, discount);
        baseFunc.type(ADULTS, adults);
        baseFunc.type(CHILDREN, children);
        baseFunc.type(BAG, bag);
        baseFunc.select(FLIGHT,date);
        baseFunc.click(GET_PRICE_BTN);
        baseFunc.click(BOOK_BTN);
    }



}
