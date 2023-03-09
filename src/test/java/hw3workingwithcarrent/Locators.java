package hw3workingwithcarrent;

import org.openqa.selenium.By;

public class Locators {

    private final By LOGO = By.xpath(".//div[@class = 'logo-cell']");
    private final By CURRENCY = By.id("currentCurrency");
    private final By LOG_IN = By.xpath(".//li[@class = 'navigation-item']");


    private final By HOME_CAPTION = By.xpath(".//div[@class = 'home-caption']");


    private final By PICK_UP_DATE_AND_TIME = By.xpath(".//div[@class = 'fake-field clearfix']");
    private final By DRIVER_RESIDENCE_COUNTRY = By.id("sb-country");
    private final By SEARCH_BTN = By.id("location-submit");
    private final By LEFT_REVIEW_NAVIGATION_BTN = By.xpath(".//div[@class = 'svg-slider-arrow']");
    private final By REVIEWS = By.xpath(".//div[@class='tp-widget-review']");
    private final By TEXT_BOX = By.xpath(".//div[@class = 'col-12'] ");


    private final By GROUP_SMALL_CARS = By.xpath(".//div[@data-id = 'car-groups-small']");
    private final By CAR_TOP_FILTER_CONTROL_RIGHT_BTN = By.xpath(".//div[@style='visibility: visible;']");
    private final By SHOWING_CARS = By.xpath(".//span[@class='showing-cars']");
    private final By SORT_BY_DROP_DOWN = By.xpath(".//a[@class = 'dc-ui dropdown-toggle text-blue-500']");
    private final By AVAILABLE_BAGAGE_IN_CAR = By.xpath("//span[contains(text(),'1 bag')]");
    private final By SPECIAL_OFFERS = By.xpath(".//div[@class = 'flt-type']");
    private final By RENTAL_CONDITION_LINK = By.xpath(".//a[@data-title = 'Rental Conditions']");
    private final By VIEW_BTN = By.xpath(".//a[@class = 'btn btn-book submit click-on-car selected-car prevent-loading instant']");
    private final By AIR_SPECIFICATION_MIN_PRICE = By.xpath(".//span[@class = 'min-price']");


    private final By CAR_SPECIFICATION_FUEL_TYPE = By.xpath(".//label [@data-event-label = 'Gasoline']");

    private final By NUMBER_OF_SEATS = By.xpath(".//label[@for= 'number-of-seats-seats-4']");
    private final By PREPAYMENT_TYPE = By.xpath(".//span[@class = 'dc-ui badge badge-medium badge-blue']");


    private final By CAR_RATING = By.xpath(".//div[@class = 'supplier-rating']");
    private final By RENTAL_COST_FOR_8_DAYS = By.xpath(".//div[@class = 'price-item-price-main']");


    private final By SEARCHING_ANIMATION = By.xpath(".//div[@class = 'lds-ellipsis v2']");
    private final By SEARCHING_TEXT = By.xpath(".//div[@class = 'mb-8 text-24 text-bold text-center']");
    private final By SEARCHING_ANOTHER_TEXT = By.xpath(".//div[@class = 'mb-24 text-center']");





}
