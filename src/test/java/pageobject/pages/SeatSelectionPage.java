package pageobject.pages;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class SeatSelectionPage {

    private final By SEATS = By.xpath(".//div[@class = 'seat']");
    private final By BOOKED_SEAT = By.xpath(".//div[@class='line']");
    private final By BOOK_BTN_2 = By.id("book3");


    private BaseFunc baseFunc;
    public SeatSelectionPage (BaseFunc baseFunc) {
    this.baseFunc = baseFunc;
    }

    public void selectSeat(int seatNr) {
        baseFunc.waitForElementsCountAtLeast(SEATS, 30);
        List<WebElement> seats = baseFunc.list(SEATS);

        boolean isSeatFound = false;
            for (WebElement we : seats) {
                if (Integer.parseInt(we.getText()) == seatNr) {
                    baseFunc.click(we);
                    isSeatFound = true;
                    break;
                }
            }

        Assertions.assertTrue(isSeatFound, "Seat Nr. " + seatNr + " isn't found!");
    }

    public int getSelectedSeatNr() {
     String selectedSeatInfo = baseFunc.getTextOfElement(BOOKED_SEAT);
     return Integer.parseInt(StringUtils.getDigits(selectedSeatInfo));
    }

    public void book () {
        baseFunc.click(BOOK_BTN_2);
    }
}
