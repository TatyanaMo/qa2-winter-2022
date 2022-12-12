package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class FlightInfoPage {

    private final By FLIGHT_INFO = By.xpath(".//div[@class = 'responsePrice']/span");

    private BaseFunc baseFunc;
    public FlightInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

}
