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
    private final By FOURTH_BOOK = By.id("p13n-asin-index-3");
    private final By FOURTH_BOOK_COMMENT_LINK = By.xpath(".//div[@class = 'a-icon-row']/a");

    private final By RATING_ONE = By.xpath(".//span[@class = 'a-icon-alt']");
   // private final By COMMENTS = By.xpath(".//span[@class = 'a-size-small']");

    private final By RATING_TWO = By.xpath(".//span[@class = 'a-size-medium a-color-base']");

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

        WebElement fourthBook = browser.findElement(FOURTH_BOOK);
            WebElement stars = fourthBook.findElement(RATING_ONE);
                System.out.println(stars.getText());

            //WebElement comments = fourthBook.findElement(COMMENTS);
            //System.out.println(comments);

            fourthBook.findElement(FOURTH_BOOK_COMMENT_LINK).click();

               String bookRating = browser.findElement(RATING_TWO).getText();
               System.out.println(bookRating);
    }
   }
