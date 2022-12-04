package hw5workingwithflightticketswebsite;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.List;

public class ReservationTests {
    private WebDriver browser;
    private WebDriverWait wait;

    //private final String HOME_PAGE_URL = "http://www.qaguru.lv:8089/tickets/";

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
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));


        select(FROM, "MEL");
        String selectedOptionFrom = new Select(browser.findElement(FROM)).getFirstSelectedOption().getText();
        //System.out.println(selectedOptionFrom);

        select(TO, "CPT");
        String selectedOptionTo = new Select(browser.findElement(TO)).getFirstSelectedOption().getText();
       // System.out.println(selectedOptionTo);
        browser.findElement(GO_BTN).click();

        List<WebElement> destinations = browser.findElements(DESTINATIONS);
        String from = destinations.get(0).getText();
        String to = destinations.get(1).getText();
        Assertions.assertEquals(from, selectedOptionFrom, "Airports FROM not equals!");
        Assertions.assertEquals(to, selectedOptionTo, "Airports TO not equals!");

        type(NAME, "Barsjusha");
        String passengerName = browser.findElement(NAME).getAttribute("value");
        //System.out.println(passengerName);     //dlja proverki
        type(SURNAME, "Kotovski");
        type(DISCOUNT, "fg123gg");
        type(ADULTS, "1");
        type(CHILDREN, "0");
        type(BAG, "1");
        select(FLIGHT, "13");
        browser.findElement(GET_PRICE_BTN).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(FLIGHT_INFO));
        List <WebElement> flightInfo = browser.findElements(FLIGHT_INFO);
        //System.out.println("elementov v spiske" + flightInfo.size());   //dlja proverki
        String name = flightInfo.get(0).getText();
        String from2 = flightInfo.get(1).getText();
        String to2 = flightInfo.get(2).getText();

        //proverki:
        boolean isNameEqual = false;
        for (WebElement info : flightInfo) {
            if (name.contains(passengerName)) {
                isNameEqual = true;
                break;
            }
        }
        Assertions.assertTrue(isNameEqual,"Name not equal!" );
        Assertions.assertEquals(from2, from, "Airports FROM not equal!" );
        Assertions.assertEquals(to2, to, "Airports TO not equal!");
        String price = browser.findElement(RESPONSE_TEXT).getText();
        System.out.println(price); // kak to mozhno chastj teksta vivesti toljko ??

        browser.findElement(BOOK_BTN).click();

        List<WebElement> bookSeats = browser.findElements(SEATS);
        bookSeats.get(6);
        String seat = bookSeats.get(6).getText();
        //System.out.println("vibrannoe mesto: " + seat);   //dlja proverki
        bookSeats.get(6).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(BOOKED_SEAT));
        String bookedSeat = browser.findElement(BOOKED_SEAT).getText();

        boolean isSeatsEqual = false;
        for (WebElement passengerSeat : bookSeats) {
            if (bookedSeat.contains(seat)) {
                isSeatsEqual = true;
                break;
            }
        }
        Assertions.assertTrue(isSeatsEqual, "Seats not equal!");

        browser.findElement(BOOK_BTN_2).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(CONFIRMATION_TEXT));
        String text = browser.findElement(CONFIRMATION_TEXT).getText();
        System.out.println(text);

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
}
