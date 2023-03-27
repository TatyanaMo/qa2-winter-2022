package pageobject.pagesForTicketsSecondVariant;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class SeatSelectionPageSecondVariant {

    private final By SEATS = By.xpath(".//div[@class = 'seat']");
    private final By BOOKED_SEAT = By.xpath(".//div[@class='line']");
    private final By BOOK_BTN_2 = By.id("book3");


    private BaseFunc baseFunc;
    public SeatSelectionPageSecondVariant(BaseFunc baseFunc) {
    this.baseFunc = baseFunc;
    }

    public SeatSelectionPageSecondVariant selectSeat(int seatNr) {
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
            return this;
    }

    public int getSelectedSeatNr() {
     String selectedSeatInfo = baseFunc.getTextOfElement(BOOKED_SEAT);
     return Integer.parseInt(StringUtils.getDigits(selectedSeatInfo));
    }

    public RegistrationConfirmationPageSecondVariant book () {
        baseFunc.click(BOOK_BTN_2);
        return new RegistrationConfirmationPageSecondVariant(baseFunc);
    }

    public SeatSelectionPageSecondVariant checkIfSeatSelected(int expectedSeatNumber) {
        Assertions.assertEquals(expectedSeatNumber, getSelectedSeatNr(), "Wrong seat selected!");
        return this;
    }
}
