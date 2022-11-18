package hw4workingwithamazon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public class TestWithBook {

    private WebDriver browser;
    private WebDriverWait wait;

    private final String HOME_PAGE_URL = "http://www.amazon.de/";
    private final String NAVIGATION_SHOP_MENU_ITEM = "Best Sellers";
    private final String BEST_SELLERS_CATEGORY = "Books";

    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By INNER_BTN = By.xpath(".//span[@class = 'a-button-inner']");
    private final By NAVIGATION_SHOP_MENU = By.xpath(".//div[@class = 'nav-progressive-content']/a");
    private final By BEST_SELLERS_CATEGORIES = By.xpath(".//div [@class = '_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf _p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL']/a");
    private final By LIST_OF_BOOKS = By.xpath(".//div[@class =  'a-cardui _cDEzb_grid-cell_1uMOS p13n-grid-content']");
    private final By BOOK_TO_OPEN_COMMENT_LINK = By.xpath(".//div[@class = 'a-icon-row']/a");
    private final By RATING_ONE = By.xpath(".//span[@class = 'a-size-small']");

    private final By STARS = By.xpath(".//span[@class = 'a-size-medium a-color-base']");
    private final By RATING_TWO = By.xpath(".//span[@class = 'a-size-base a-color-secondary']");
    private final By BOOK_REVIEW = By.xpath(".//div[@data-hook = 'cr-filter-info-review-rating-count']");

    @Test
    public void openHomePage() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> shippingCountryCheckBtns = browser.findElements(INNER_BTN);
        for (WebElement btn : shippingCountryCheckBtns) {
            if (btn.getText().equals("CONTINUE")) {
                btn.click();
                break;
            }
        }
        List<WebElement> navigationShopMenuItems = browser.findElements(NAVIGATION_SHOP_MENU);
            for (WebElement menuItem : navigationShopMenuItems) {
                if (menuItem.getText().equals(NAVIGATION_SHOP_MENU_ITEM)) {
                    menuItem.click();
                    break;
                }
            }

        List<WebElement> bestSellersCategories = browser.findElements(BEST_SELLERS_CATEGORIES);
            for (WebElement category : bestSellersCategories) {
                if (category.getText().equals(BEST_SELLERS_CATEGORY)) {
                    category.click();
                    break;
                }
            }
        List<WebElement> books = browser.findElements(LIST_OF_BOOKS);
            books.get(3);
                String stars = books.get(3).findElement(BOOK_TO_OPEN_COMMENT_LINK).getAttribute("title");
                System.out.println(stars);

                WebElement rating = books.get(3).findElement(RATING_ONE);
                System.out.println("rating" + " " + rating.getText());

                books.get(3).findElement(BOOK_TO_OPEN_COMMENT_LINK).click();

                String bookStars = browser.findElement(STARS).getText();
// System.out.println(stars.equals(bookStars));  // esli bil bi odinakovij tekst, mozhno bilo bi ispoljzovatj etot metod
                System.out.println(bookStars +" " + "stars");

                String bookRating = browser.findElement(RATING_TWO).getText();
                System.out.println(bookRating);

                    String bookReview = browser.findElement(BOOK_REVIEW).getText();
                    System.out.println(bookReview);
    }
   }
