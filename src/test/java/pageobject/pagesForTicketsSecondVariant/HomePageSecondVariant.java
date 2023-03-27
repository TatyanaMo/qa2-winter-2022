package pageobject.pagesForTicketsSecondVariant;

import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.pages.PassengerInfoPage;

public class HomePageSecondVariant {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

    private BaseFunc baseFunc;
    public HomePageSecondVariant(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public PassengerInfoPageSecondVariant selectAirports(String from, String to) {
        baseFunc.select(FROM, from);
        baseFunc.select(TO,to);
        baseFunc.click(GO_BTN);
        return new PassengerInfoPageSecondVariant(baseFunc);
    }
}
