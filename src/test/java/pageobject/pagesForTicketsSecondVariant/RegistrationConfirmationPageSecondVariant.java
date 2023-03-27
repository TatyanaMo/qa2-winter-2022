package pageobject.pagesForTicketsSecondVariant;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pageobject.BaseFunc;

import java.security.PublicKey;

public class RegistrationConfirmationPageSecondVariant {

    private final String TEXT = "Thank You for flying with us!";
    private final By CONFIRMATION_TEXT = By.xpath(".//div[@class = 'finalTxt']");
    private BaseFunc baseFunc;

    public RegistrationConfirmationPageSecondVariant(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isSuccessfulRegistrationTextAppears() {
        String textOnPage = baseFunc.getTextOfElement(CONFIRMATION_TEXT);
        return textOnPage.equals(TEXT);
    }

    public RegistrationConfirmationPageSecondVariant checkIfSuccessMessageAppears() {
        Assertions.assertTrue(isSuccessfulRegistrationTextAppears(), "Wrong text on registration confirmation page!");
        return this;
    }

}
