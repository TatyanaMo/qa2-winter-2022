package pageobject.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

public class SeatSelectionPage {

    private final By SEATS = By.xpath(".//div[@class = 'seat']");
    private final By BOOKED_SEAT = By.xpath(".//div[@class='line']");
    //private Integer seatNr = 6;
    private final By BOOK_BTN_2 = By.id("book3");


    private BaseFunc baseFunc;
    public SeatSelectionPage (BaseFunc baseFunc) {
    this.baseFunc = baseFunc;
    }

    public WebElement getSeat(int seatNr) {
        baseFunc.waitForElementsCountAtLeast(SEATS, 15);
        return baseFunc.list(SEATS).get(seatNr-1);
    }
    public String getSelectedSeat() {
        String selectedSeatText = baseFunc.findElement(BOOKED_SEAT).getText();
        return StringUtils.right(selectedSeatText,1);
    }
    public void click () {
        baseFunc.click(BOOK_BTN_2);
    }
}
