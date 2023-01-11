package pageobject.pagesForCarRent;

import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class SelectedLocationCarsPage {

    private final By CAR_RENTAL_IN_LATVIA = By.xpath(".//h1[@class = 'home-h1 display-small']");

    private BaseFunc baseFunc;
    public SelectedLocationCarsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        baseFunc.waifElementPresented(CAR_RENTAL_IN_LATVIA);
        return baseFunc.findElement(CAR_RENTAL_IN_LATVIA).toString();
    }
}
