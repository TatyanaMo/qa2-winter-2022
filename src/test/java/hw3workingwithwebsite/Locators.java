package hw3workingwithwebsite;

import org.openqa.selenium.By;

public class Locators {
// Start page
    private final By LOGO = By.xpath(".//div[@class = 'logo-cell']");
    private final By CURRENCY = By.id("currentCurrency");
    private final By LOG_IN = By.xpath(".//li[@class = 'navigation-item']");
    // also for LOG_IN: By.xpath(".//a[@data-label='Navigation']");

    private final By HOME_CAPTION = By.xpath(".//div[@class = 'home-caption']");
    // .//*[contains(text(),'No Hidden Costs')]  - po tekstu

    private final By PICK_UP_DATE_AND_TIME = By.xpath(".//div[@class = 'fake-field clearfix']");
    private final By DRIVER_RESIDENCE_COUNTRY = By.id("sb-country");
    private final By SEARCH_BTN = By.id("location-submit");
    private final By LEFT_REVIEW_NAVIGATION_BTN = By.xpath(".//div[@class = 'svg-slider-arrow']");
    private final By REVIEWS = By.xpath(".//div[@class='tp-widget-review']");
    private final By TEXT_BOX = By.xpath(".//div[@class = 'col-12'] ");
    // .//*[contains(text(),'We compare car rental prices, you save!')]  - po tekstu, togda nahodit 1 element

// search result page
    private final By GROUP_SMALL_CARS = By.xpath(".//div[@data-id = 'car-groups-small']");
    private final By CAR_TOP_FILTER_CONTROL_RIGHT_BTN = By.xpath(".//div[@style='visibility: visible;']");
    private final By SHOWING_CARS = By.xpath(".//span[@class='showing-cars']");
    private final By SORT_BY_DROP_DOWN = By.xpath(".//a[@class = 'dc-ui dropdown-toggle text-blue-500']");
    private final By AVAILABLE_BAGAGE_IN_CAR = By.xpath("//span[contains(text(),'1 bag')]");
    private final By SPECIAL_OFFERS = By.xpath(".//div[@class = 'flt-type']");
    private final By RENTAL_CONDITION_LINK = By.xpath(".//a[@data-title = 'Rental Conditions']");
    private final By VIEW_BTN = By.xpath(".//a[@class = 'btn btn-book submit click-on-car selected-car prevent-loading instant']");
    private final By AIR_SPECIFICATION_MIN_PRICE = By.xpath(".//span[@class = 'min-price']");
    // .//span[contains(text(), '€ 103.2')] - po tekstu

    private final By CAR_SPECIFICATION_FUEL_TYPE = By.xpath(".//label [@data-event-label = 'Gasoline']");
    // .//label[contains(@class, 'my-checkbox-label default filtering-event')]
    private final By NUMBER_OF_SEATS = By.xpath(".//label[@for= 'number-of-seats-seats-4']");
    private final By PREPAYMENT_TYPE = By.xpath(".//span[@class = 'dc-ui badge badge-medium badge-blue']");
    // .//span[@aria-describedby = 'qtip-10']" - togda nahodit toljko 1 element

    private final By CAR_RATING = By.xpath(".//div[@class = 'supplier-rating']");
    private final By RENTAL_COST_FOR_8_DAYS = By.xpath(".//div[@class = 'price-item-price-main']");
    // .//div[contains(text(), '€ 103.23')] - po tekstu


 //searching page
    private final By SEARCHING_ANIMATION = By.xpath(".//div[@class = 'lds-ellipsis v2']");
    private final By SEARCHING_TEXT = By.xpath(".//div[@class = 'mb-8 text-24 text-bold text-center']");
    private final By SEARCHING_ANOTHER_TEXT = By.xpath(".//div[@class = 'mb-24 text-center']");





}
