package pageobject.pagesForCarRent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

public class HomePageCars {

    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By TOP_LOCATIONS = By.xpath(".//div[@class = 'tl-box']/a");

    private BaseFunc baseFunc;
    public HomePageCars(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies () {
        baseFunc.findElement(ACCEPT_COOKIES_BTN).click();
    }

    public void getLocation (String locationToOpen) {
        for (WebElement locationName : baseFunc.list(TOP_LOCATIONS)){
            if (locationName.getText().equals(locationToOpen));
            locationName.click();
            break;
        }
    }
}
