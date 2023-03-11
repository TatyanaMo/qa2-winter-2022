package hw5workingwithflightticketswebsite;

import dev.failsafe.internal.util.Assert;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.List;

public class ReservationTests {
    private WebDriver browser;
    private WebDriverWait wait;

    private final String HOME_PAGE_URL = "http://www.qaguru.lv:8089/tickets/";

    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By DESTINATIONS = By.xpath(".//span[@class = 'bTxt']");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");
    private final By FLIGHT_INFO = By.xpath(".//div[@class = 'responsePrice']/span");
    private final By RESPONSE_TEXT = By.xpath(".//div[@class = 'responsePrice']");
    private final By BOOK_BTN = By.id("book2");

    private final By SEATS = By.xpath(".//div[@class = 'seat']");

    private final By BOOKED_SEAT = By.xpath(".//div[@class='line']");

    private final By BOOK_BTN_2 = By.id("book3");

    private final By CONFIRMATION_TEXT = By.xpath(".//div[@class = 'finalTxt']");

    @Test
    public void registrationCheck () {
        String firstName = "Barsjusha";
        String airportFrom = "MEL";
        String airportTo = "CPT";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        select(FROM, airportFrom);

        select(TO, airportTo);
        browser.findElement(GO_BTN).click();

        List<WebElement> destinations = browser.findElements(DESTINATIONS);
        String from = destinations.get(0).getText();
        String to = destinations.get(1).getText();
        Assertions.assertEquals(airportFrom, from, "Airports FROM not equals!");
        Assertions.assertEquals(airportTo, to, "Airports TO not equals!");

        type(NAME, firstName);
        type(SURNAME, "Kotovski");
        type(DISCOUNT, "fg123gg");
        type(ADULTS, "1");
        type(CHILDREN, "0");
        type(BAG, "1");
        select(FLIGHT, "13");
        browser.findElement(GET_PRICE_BTN).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(FLIGHT_INFO));
        List <WebElement> flightInfo = browser.findElements(FLIGHT_INFO);
        String name = flightInfo.get(0).getText();
        String name1 = StringUtils.substring(name, 0, name.length()-1);
        String from2 = flightInfo.get(1).getText();
        String to2 = flightInfo.get(2).getText();

        Assertions.assertEquals(name1,firstName, "Name not equal!" );
        Assertions.assertEquals(from2, from, "Airports FROM not equal!" );
        Assertions.assertEquals(to2, to, "Airports TO not equal!");

        String responseText = browser.findElement(RESPONSE_TEXT).getText();
        String price = StringUtils.substringBetween(responseText, "for", "EUR");

        boolean isPriceAvailable = false;
            if (responseText.contains(price)) {
                isPriceAvailable = true;
        }
        Assertions.assertTrue(isPriceAvailable, "No flight price!");

        browser.findElement(BOOK_BTN).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(SEATS));
        List<WebElement> bookSeats = browser.findElements(SEATS);
        bookSeats.get(6);
        String seat = bookSeats.get(6).getText();
        bookSeats.get(6).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(BOOKED_SEAT));
        String bookedSeat = browser.findElement(BOOKED_SEAT).getText();

        boolean isSeatsEqual = false;
        for (WebElement passengerSeat : bookSeats) {
            if (bookedSeat.contains(seat)) {
                isSeatsEqual = true;
            }
        }
        Assertions.assertTrue(isSeatsEqual, "Seats not equal!");

        browser.findElement(BOOK_BTN_2).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(CONFIRMATION_TEXT));
        List<WebElement>text = browser.findElements(CONFIRMATION_TEXT);
        boolean isReservationSucceed = false;
        if (!text.isEmpty()) {
            isReservationSucceed = true;
        }
        Assertions.assertTrue(isReservationSucceed,"reservation failed!");
    }

    private void select (By locator, String value) {
        WebElement airportSelect = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select selectRoute = new Select(airportSelect);
        selectRoute.selectByValue(value);
    }

    private void type (By locator, String text) {
        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        inputField.clear();
        inputField.sendKeys(text);
    }

        /*@AfterEach
    public void closeBrowser() {
        browser.close();
    }*/
}
