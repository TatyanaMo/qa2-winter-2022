package pageobject.pagesForAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class HomePageAmazon {

    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By CONTINUE_BTN = By.xpath(".//input[@data-action-type = 'DISMISS']");

    private final By NAVIGATION_SHOP_MENU = By.xpath(".//div[@class = 'nav-progressive-content']/a");

    private BaseFunc baseFunc;
    public HomePageAmazon(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookiesAndMessages() {
        baseFunc.findElement(ACCEPT_COOKIES_BTN).click();
        baseFunc.findElement(CONTINUE_BTN).click();
    }

    public void openNavigationShopMenuItem(String navigationShopMenuItem) {
        for (WebElement menuItem : baseFunc.list(NAVIGATION_SHOP_MENU)) {
            if (menuItem.getText().equals(navigationShopMenuItem)) {
                menuItem.click();
                break;
            }
        }
    }
}
