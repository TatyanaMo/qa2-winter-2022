package pageobject.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class FlightInfoPage {

    private final By FLIGHT_INFO = By.xpath(".//div[@class = 'responsePrice']/span");
    private final By RESPONSE_TEXT = By.xpath(".//div[@class = 'responsePrice']");
    private final By BOOK_BTN = By.id("book2");

    private BaseFunc baseFunc;
    public FlightInfoPage(BaseFunc baseFunc) {
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

    public void book() {
        baseFunc.click(BOOK_BTN);
    }
}
