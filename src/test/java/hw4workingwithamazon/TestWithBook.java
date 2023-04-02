package hw4workingwithamazon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.StyledEditorKit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestWithBook {

    private WebDriver browser;
    private WebDriverWait wait;

    private final String HOME_PAGE_URL = "http://www.amazon.de/";

    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By CONTINUE_BTN = By.xpath(".//input[@data-action-type = 'DISMISS']");
    private final By NAVIGATION_SHOP_MENU = By.xpath(".//div[@class = 'nav-progressive-content']/a");
    private final By BEST_SELLERS_CATEGORIES = By.xpath(".//div [@class = '_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf _p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL']/a");
    private final By LIST_OF_BOOKS = By.xpath(".//div[@class = 'a-cardui _cDEzb_grid-cell_1uMOS expandableGrid p13n-grid-content']");
    private final By BOOK_TO_OPEN_COMMENT_LINK = By.xpath(".//div[@class = 'a-icon-row']/a");
    private final By RATING_ONE = By.xpath(".//span[@class = 'a-size-small']");

    private final By STARS = By.xpath(".//span[@class = 'a-size-medium a-color-base']");
    private final By RATING_TWO = By.xpath(".//span[@class = 'a-size-base a-color-secondary']");
    private final By BOOK_REVIEW = By.xpath(".//div[@data-hook = 'cr-filter-info-review-rating-count']");

    private final By REVIEW_LIST = By.xpath(".//div[@data-hook = 'review']");
    private final By NEXT_PAGE_BTN = By.xpath(".//li[@class = 'a-last']/a");

    private final By BOOK_LINK = By.xpath(".//a[@data-hook = 'product-link']");
    private final By TEXT = By.xpath("//div[@class = \"a-expander-content a-expander-partial-collapse-content\"]");


    @BeforeEach
    public void openHomePage() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        browser = new ChromeDriver(options);
        //browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        browser.findElement(ACCEPT_COOKIES_BTN).click();
        browser.findElement(CONTINUE_BTN).click();
    }

    @Test
    public void selectionBook() {
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

        boolean isBookStarsAreEqual = false;
        for (WebElement book : books) {
            if (stars.contains(bookStars)) {
                isBookStarsAreEqual = true;
                break;
            }
        }
        Assertions.assertTrue(isBookStarsAreEqual, "Book stars not equal!");

        String bookRating = browser.findElement(RATING_TWO).getText();
        boolean isBookRatingisEqual = false;
        for (WebElement book : books) {
            if (bookRating.contains(rating)) {
                isBookRatingisEqual = true;
                break;
            }
        }
        Assertions.assertTrue(isBookRatingisEqual, "Book rating not equal!");

        String bookReview = browser.findElement(BOOK_REVIEW).getText();
        System.out.println(bookReview);

        List<WebElement> reviews = browser.findElements(REVIEW_LIST);
        String idFirstReview = reviews.get(0).getAttribute("id");
        try {
            browser.findElement(NEXT_PAGE_BTN).click();
        } catch (NoSuchElementException e) {
            System.out.println(reviews.size());
        }

        browser.findElement(BOOK_LINK).click();
        String text = browser.findElement(TEXT).getText().replaceAll("[\\p{Punct}\r\n]", "");
        String[] words = text.split(" ");
        HashMap <String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word,1);
            }
        }
        System.out.println(map.size());

    }
   @AfterEach
    public void closeBrowser() {
        browser.close();
    }
   }
