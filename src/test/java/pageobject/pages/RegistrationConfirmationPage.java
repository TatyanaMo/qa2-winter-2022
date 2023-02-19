package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class RegistrationConfirmationPage {

    private final String TEXT = "Thank You for flying with us!";
    private final By CONFIRMATION_TEXT = By.xpath(".//div[@class = 'finalTxt']");
    private BaseFunc baseFunc;

    public RegistrationConfirmationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isSuccessfulRegistrationTextAppears() {
        String textOnPage = baseFunc.getTextOfElement(CONFIRMATION_TEXT);
        return textOnPage.equals(TEXT);
    }

}
