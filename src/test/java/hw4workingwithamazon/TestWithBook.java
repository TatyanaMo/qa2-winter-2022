package hw4workingwithamazon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.StyledEditorKit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestWithBook {

    private WebDriver browser;
    private WebDriverWait wait;

    private final String HOME_PAGE_URL = "http://www.amazon.de/";

    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By CONTINUE_BTN = By.xpath(".//input[@data-action-type = 'DISMISS']");
    private final By NAVIGATION_SHOP_MENU = By.xpath(".//div[@class = 'nav-progressive-content']/a");
    private final By BEST_SELLERS_CATEGORIES = By.xpath(".//div [@class = '_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf _p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL']/a");
    private final By LIST_OF_BOOKS = By.xpath(".//div[@class =  'a-cardui _cDEzb_grid-cell_1uMOS p13n-grid-content']");
    private final By BOOK_TO_OPEN_COMMENT_LINK = By.xpath(".//div[@class = 'a-icon-row']/a");
    private final By RATING_ONE = By.xpath(".//span[@class = 'a-size-small']");

    private final By STARS = By.xpath(".//span[@class = 'a-size-medium a-color-base']");
    private final By RATING_TWO = By.xpath(".//span[@class = 'a-size-base a-color-secondary']");
    private final By BOOK_REVIEW = By.xpath(".//div[@data-hook = 'cr-filter-info-review-rating-count']");

    private final By REVIEW_LIST = By.xpath(".//div[@data-hook = 'review']");
    private final By NEXT_PAGE_BTN = By.xpath(".//li[@class = 'a-last']/a");

    @BeforeEach
    public void openHomePage() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        browser.findElement(ACCEPT_COOKIES_BTN).click();
        browser.findElement(CONTINUE_BTN).click();
    }

    @Test
    public void selectionBook() {
        //Test Data
        String navigationShopMenuItem = "Best Sellers";
        String bestSellersCategory = "Books";

        List<WebElement> navigationShopMenuItems = browser.findElements(NAVIGATION_SHOP_MENU);
        for (WebElement menuItem : navigationShopMenuItems) {
            if (menuItem.getText().equals(navigationShopMenuItem)) {
                menuItem.click();
                break;
            }
        }
        List<WebElement> bestSellersCategories = browser.findElements(BEST_SELLERS_CATEGORIES);
        for (WebElement category : bestSellersCategories) {
            if (category.getText().equals(bestSellersCategory)) {
                category.click();
                break;
            }
        }
        List<WebElement> books = browser.findElements(LIST_OF_BOOKS);
        books.get(3);
        String stars = books.get(3).findElement(BOOK_TO_OPEN_COMMENT_LINK).getAttribute("title");
        System.out.println(stars);

        String rating = books.get(3).findElement(RATING_ONE).getText();
        System.out.println("rating" + " " + rating);

        books.get(3).findElement(BOOK_TO_OPEN_COMMENT_LINK).click();

        String bookStars = browser.findElement(STARS).getText();
        System.out.println("book stars are equal: " + stars.contains(bookStars));   // sravnivaet tekst po chastichnomu sovpadeniju

        String bookRating = browser.findElement(RATING_TWO).getText();
        System.out.println("book rating is equal: " + bookRating.contains(rating)); // sravnivaet tekst po chastichnomu sovpadeniju

        String bookReview = browser.findElement(BOOK_REVIEW).getText();
        System.out.println(bookReview);

        List<WebElement> reviews = browser.findElements(REVIEW_LIST);
        String idFirstReview = reviews.get(0).getAttribute("id");
        try {
            browser.findElement(NEXT_PAGE_BTN).click();
        } catch (NoSuchElementException e) {
            System.out.println(reviews.size());
        }
        while (browser.findElement(NEXT_PAGE_BTN).isEnabled()) {
            wait = new WebDriverWait(browser, Duration.ofSeconds(10));
            List<WebElement> reviewNextPage = new ArrayList<>(browser.findElements(REVIEW_LIST));
            for (WebElement reviewNextPageId: reviewNextPage) {
                System.out.println(reviewNextPageId.getAttribute("id")); // v konsole vidno chto id ne menjajutsja na stranicah, a dolzhni menjatsja
            }
            //List<WebElement> reviewNextPage = browser.findElements(REVIEW_LIST);
            String nextPageIdFirstReview = reviewNextPage.get(0).getAttribute("id");
            if (idFirstReview.equals(nextPageIdFirstReview)) {
                wait = new WebDriverWait(browser, Duration.ofSeconds(10));
                System.out.println("if " + reviews.size());
            } else {
                reviews.addAll(reviewNextPage);
                System.out.println("else " + reviews.size());
            }
            browser.findElement(NEXT_PAGE_BTN).click();
        }
    }
    /*@AfterEach
    public void closeBrowser() {
        browser.close();
    }*/
   }
