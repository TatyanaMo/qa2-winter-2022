package hw3workingwithcarrent;

import com.sun.source.tree.IfTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FindLocationTest {

    private final String HOME_PAGE_URL = "http://www.discovercars.com/";
    private final String LOCATION_TO_OPEN = "Latvia";

    public final String expectedPickUpDate = "16-05-2023";
    public final String expectedDropOffDate = "11-06-2023";
    public final String pickUpTime = "12:00";
    public final String dropOffTime = "14:30";

    private final int pickUpDay = 25;
    private final String pickUpMonth = "November";
    private final String pickUpYear = "2023";
    private final int dropOffDay = 5;
    private final String dropOffMonth = "December";
    private final String dropOffYear = "2023";

    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By TOP_LOCATIONS = By.xpath(".//div[@class = 'tl-box']/a");
    private final By CAR_RENTAL_IN_LATVIA = By.xpath(".//h1[@class = 'home-h1 display-small']");

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



    private WebDriver browser;


    @BeforeEach
    public void openHomePageCheck () {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        browser.findElement(ACCEPT_COOKIES_BTN).click();
    }

    @Test
    public void findLocation() {
        List<WebElement> locations = browser.findElements(TOP_LOCATIONS);
        for (WebElement locationName : locations) {
            if (locationName.getText().equals(LOCATION_TO_OPEN)) {
                locationName.click();
                break;
            }
        }

        List <WebElement> title = browser.findElements(CAR_RENTAL_IN_LATVIA);
        boolean isCountrySelect = false;
        if (!title.isEmpty()) {
            isCountrySelect = true;
        }
        Assertions.assertTrue(isCountrySelect, "Country not Selected!");

    }

    @Test
    public void calendarTest () {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(PICK_UP_DATE));
        browser.findElement(PICK_UP_DATE).click();
        selectPickUpDate(expectedPickUpDate);

        wait.until(ExpectedConditions.presenceOfElementLocated(DROP_OFF_DATE));
        browser.findElement(DROP_OFF_DATE).click();
        selectDropOffDate(expectedDropOffDate);

        wait.until(ExpectedConditions.presenceOfElementLocated(PICK_UP_TIME)).click();
        getPickUpTime(TIME_SELECT, TIMES, pickUpTime);

        wait.until(ExpectedConditions.presenceOfElementLocated(DROP_TIME)).click();
        getDropOffTime(TIME_SELECT, TIMES, dropOffTime);

        }

        public void selectPickUpDate(String expectedPickUpDate) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate expectedLocalDate = LocalDate.parse(expectedPickUpDate, dtf);

            int expectedDay = expectedLocalDate.getDayOfMonth();
            int expectedMonth = expectedLocalDate.getMonthValue();
            int expectedYear = expectedLocalDate.getYear();

            String actualPickUpMonthText = browser.findElements(CALENDAR_MONTH).get(0).getText();
            int actualPickUpMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualPickUpMonthText).get(ChronoField.MONTH_OF_YEAR);

            String actualPickUpYearText = browser.findElements(CALENDAR_YEAR).get(1).getText();
            int actualPickUpYear = Integer.parseInt(actualPickUpYearText);

            while (!(expectedMonth==actualPickUpMonth && expectedYear==actualPickUpYear)) {
                browser.findElement(CALENDAR_NEXT_BTN).click();

                actualPickUpMonthText = browser.findElements(CALENDAR_MONTH).get(0).getText();
                actualPickUpMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualPickUpMonthText).get(ChronoField.MONTH_OF_YEAR);
                actualPickUpYearText = browser.findElements(CALENDAR_YEAR).get(1).getText();
                actualPickUpYear = Integer.parseInt(actualPickUpYearText);
            }
            try {
                List<WebElement> daySelected = browser.findElements(CALENDAR).get(0).findElements(CALENDAR_SELECT_DAY);
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

                String actualDropOffMonthText = browser.findElements(CALENDAR_MONTH).get(1).getText();
                int actualDropOffMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualDropOffMonthText).get(ChronoField.MONTH_OF_YEAR);

                String actualDropOffYearText = browser.findElements(CALENDAR_YEAR).get(1).getText();
                int actualDropOffYear = Integer.parseInt(actualDropOffYearText);

                while (!(expectedMonth==actualDropOffMonth && expectedYear==actualDropOffYear)) {
                    browser.findElement(CALENDAR_NEXT_BTN).click();

                    actualDropOffMonthText = browser.findElements(CALENDAR_MONTH).get(1).getText();
                    actualDropOffMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualDropOffMonthText).get(ChronoField.MONTH_OF_YEAR);
                    actualDropOffYearText = browser.findElements(CALENDAR_YEAR).get(1).getText();
                    actualDropOffYear = Integer.parseInt(actualDropOffYearText);
                }
                try {
                    List<WebElement> daySelected = browser.findElements(CALENDAR).get(1).findElements(CALENDAR_SELECT_DAY);
                    daySelected.get(expectedDay - 1).click();
                } catch (Exception e) {
                    System.out.println("Invalid date!" + ":" + expectedDay + expectedMonth);
                }
        }
        public void getPickUpTime(By locator, By locator2, String pickUpTime) {
            List <WebElement> timesToSelect = browser.findElements(locator);
            WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator2));
            List<WebElement> puTimes = timesToSelect.get(0).findElements(locator2);
            boolean isTimeSelected = false;
            for (WebElement time : puTimes) {
                if (time.getText().equals(pickUpTime)) {
                    time.click();
                    isTimeSelected = true;
                    break;
                }
            }
            Assertions.assertTrue(isTimeSelected,"Time not selected!");
        }

        public void getDropOffTime(By locator, By locator2, String dropOffTime) {
            List <WebElement> timesToSelect = browser.findElements(locator);
            WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator2));
            List<WebElement> puTimes = timesToSelect.get(1).findElements(locator2);
            boolean isTimeSelected = false;
            for (WebElement time : puTimes) {
                if (time.getText().equals(dropOffTime)) {
                    time.click();
                    isTimeSelected = true;
                    break;
                }
            }
            Assertions.assertTrue(isTimeSelected,"Time not selected!");

        }




    @Test
    public void calendarTest1 () {

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(PICK_UP_DATE));
        browser.findElement(PICK_UP_DATE).click();
        selectPickUpDateInCalendar(pickUpDay, pickUpMonth, pickUpYear);

        wait.until(ExpectedConditions.presenceOfElementLocated(DROP_OFF_DATE));
        browser.findElement(DROP_OFF_DATE).click();
        selectDropOffDateInCalendar(dropOffDay, dropOffMonth, dropOffYear);

    }

    public void selectPickUpDateInCalendar ( Integer selectDay, String selectMonth, String selectYear) {
        if (pickUpMonth.equals("February") && pickUpDay >29) {
            System.out.println("Invalid date!" + ":" + pickUpDay + pickUpMonth);
            return;
        }
        if (pickUpDay>31) {
            System.out.println("Invalid date!" + ":" + pickUpDay + pickUpMonth);
            return;
        }

        String month = browser.findElements(CALENDAR_MONTH).get(0).getText();
        String year = browser.findElements(CALENDAR_YEAR).get(1).getText();

        while (!(month.equals(pickUpMonth) && year.equals(pickUpYear))) {
            browser.findElement(CALENDAR_NEXT_BTN).click();

            month = browser.findElements(CALENDAR_MONTH).get(0).getText();
            year = browser.findElements(CALENDAR_YEAR).get(1).getText();
        }
        try {
            List<WebElement> daySelected = browser.findElements(CALENDAR).get(0).findElements(CALENDAR_SELECT_DAY);
            daySelected.get(pickUpDay - 1).click();
        } catch (Exception e) {
            System.out.println("Invalid date!" + ":" + pickUpDay + pickUpMonth);
        }

    }

    public void selectDropOffDateInCalendar ( Integer selectDay, String selectMonth, String selectYear) {
        if (dropOffMonth.equals("February") && dropOffDay >29) {
            System.out.println("Invalid date!" + ":" + dropOffDay + dropOffMonth);
            return;
        }
        if (dropOffDay>31) {
            System.out.println("Invalid date!" + ":" + dropOffDay + dropOffMonth);
            return;
        }

        String month = browser.findElements(CALENDAR_MONTH).get(1).getText();
        String year = browser.findElements(CALENDAR_YEAR).get(1).getText();

        while (!(month.equals(dropOffMonth) && year.equals(dropOffYear))) {
            browser.findElement(CALENDAR_NEXT_BTN).click();

            month = browser.findElements(CALENDAR_MONTH).get(1).getText();
            year = browser.findElements(CALENDAR_YEAR).get(1).getText();
        }
        try {
            List<WebElement> daySelected = browser.findElements(CALENDAR).get(1).findElements(CALENDAR_SELECT_DAY);
            daySelected.get(dropOffDay - 1).click();
        } catch (Exception e) {
            System.out.println("Invalid date!" + ":" + dropOffDay + dropOffMonth);
        }

    }

}
