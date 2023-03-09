package pageobject.pagesForCarRent;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BaseFunc;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;

public class HomePageCars {

    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By TOP_LOCATIONS = By.xpath(".//div[@class = 'tl-box']/a");

    private final By PICK_UP_DATE = By.id("pick-date-ui");
    private final By DROP_OFF_DATE = By.id("drop-date-ui");
    private final By CALENDAR_MONTH = By.xpath(".//span[@class = 'ui-datepicker-month']");
    private final By CALENDAR_YEAR = By.xpath(".//span[@class = 'ui-datepicker-year']");
    private final By CALENDAR = By.xpath(".//table[@class = 'ui-datepicker-calendar']");
    private final By CALENDAR_NEXT_BTN = By.xpath(".//span[@class = 'ui-icon ui-icon-circle-triangle-e']");
    private final By CALENDAR_SELECT_DAY = By.xpath(".//td[@data-handler='selectDay']/a");

    private final By PICK_UP_TIME = By.id("pick_time_chosen");
    private final By TIME_SELECT = By.xpath(".//ul[@class = 'chosen-results']");
    private final By TIMES = By.xpath(".//li[@class = 'active-result']");

    private final By DROP_TIME = By.id("drop_time_chosen");

    private BaseFunc baseFunc;
    public HomePageCars(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies () {
        baseFunc.findElement(ACCEPT_COOKIES_BTN).click();
    }

    public void getLocation (String locationToOpen) {
        for (WebElement locationName : baseFunc.list(TOP_LOCATIONS)) {
            if (locationName.getText().equals(locationToOpen));
            locationName.click();
            break;
        }
    }

    public void getPickUpDate () {
        baseFunc.waifElementPresented(PICK_UP_DATE);
        baseFunc.findElement(PICK_UP_DATE).click();
    }
    public void getDropOffDate () {
        baseFunc.waifElementPresented(DROP_OFF_DATE);
        baseFunc.findElement(DROP_OFF_DATE).click();
    }

    public void selectPickUpDate(String expectedPickUpDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate expectedLocalDate = LocalDate.parse(expectedPickUpDate, dtf);

        int expectedDay = expectedLocalDate.getDayOfMonth();
        int expectedMonth = expectedLocalDate.getMonthValue();
        int expectedYear = expectedLocalDate.getYear();

        String actualPickUpMonthText = baseFunc.list(CALENDAR_MONTH).get(0).getText();
        int actualPickUpMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualPickUpMonthText).get(ChronoField.MONTH_OF_YEAR);

        String actualPickUpYearText = baseFunc.list(CALENDAR_YEAR).get(1).getText();
        int actualPickUpYear = Integer.parseInt(actualPickUpYearText);

        while (!(expectedMonth==actualPickUpMonth && expectedYear==actualPickUpYear)) {
            baseFunc.findElement(CALENDAR_NEXT_BTN).click();

            actualPickUpMonthText = baseFunc.list(CALENDAR_MONTH).get(0).getText();
            actualPickUpMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualPickUpMonthText).get(ChronoField.MONTH_OF_YEAR);
            actualPickUpYearText = baseFunc.list(CALENDAR_YEAR).get(1).getText();
            actualPickUpYear = Integer.parseInt(actualPickUpYearText);
        }
        try {
            List<WebElement> daySelected = baseFunc.list(CALENDAR).get(0).findElements(CALENDAR_SELECT_DAY);
            daySelected.get(expectedDay - 1).click();
        } catch (Exception e) {
            System.out.println("Invalid date!" + ":" + expectedDay + expectedMonth);
        }
    }

    public void selectDropOffDate (String expectedDropOffDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate expectedLocalDate = LocalDate.parse(expectedDropOffDate, dtf);

        int expectedDay = expectedLocalDate.getDayOfMonth();
        int expectedMonth = expectedLocalDate.getMonthValue();
        int expectedYear = expectedLocalDate.getYear();

        String actualDropOffMonthText = baseFunc.list(CALENDAR_MONTH).get(1).getText();
        int actualDropOffMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualDropOffMonthText).get(ChronoField.MONTH_OF_YEAR);

        String actualDropOffYearText = baseFunc.list(CALENDAR_YEAR).get(1).getText();
        int actualDropOffYear = Integer.parseInt(actualDropOffYearText);

        while (!(expectedMonth==actualDropOffMonth && expectedYear==actualDropOffYear)) {
            baseFunc.findElement(CALENDAR_NEXT_BTN).click();

            actualDropOffMonthText = baseFunc.list(CALENDAR_MONTH).get(1).getText();
            actualDropOffMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualDropOffMonthText).get(ChronoField.MONTH_OF_YEAR);
            actualDropOffYearText = baseFunc.list(CALENDAR_YEAR).get(1).getText();
            actualDropOffYear = Integer.parseInt(actualDropOffYearText);
        }
        try {
            List<WebElement> daySelected = baseFunc.list(CALENDAR).get(1).findElements(CALENDAR_SELECT_DAY);
            daySelected.get(expectedDay - 1).click();
        } catch (Exception e) {
            System.out.println("Invalid date!" + ":" + expectedDay + expectedMonth);
        }
    }

    public void getPickUpTime(String pickUpTime) {
        baseFunc.findElement(PICK_UP_TIME).click();
        baseFunc.waifElementPresented(TIME_SELECT);
        List <WebElement> timesToSelect = baseFunc.list(TIME_SELECT).get(0).findElements(TIMES);
        boolean isTimeSelected = false;
        for (WebElement time : timesToSelect) {
            if (time.getText().equals(pickUpTime)) {
                time.click();
                isTimeSelected = true;
                break;
            }
        }
        Assertions.assertTrue(isTimeSelected,"Time not selected!");
    }

    public void getDropOffTime(String dropOffTime) {
        baseFunc.findElement(DROP_TIME).click();
        baseFunc.waifElementPresented(TIME_SELECT);
        List <WebElement> timesToSelect = baseFunc.list(TIME_SELECT).get(1).findElements(TIMES);
        boolean isTimeSelected = false;
        for (WebElement time : timesToSelect) {
            if (time.getText().equals(dropOffTime)) {
                time.click();
                isTimeSelected = true;
                break;
            }
        }
        Assertions.assertTrue(isTimeSelected,"Time not selected!");

    }

}
