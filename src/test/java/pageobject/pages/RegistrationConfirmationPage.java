package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class RegistrationConfirmationPage {

    private BaseFunc baseFunc;
    public RegistrationConfirmationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By CONFIRMATION_TEXT = By.xpath(".//div[@class = 'finalTxt']");

    public String getConfirmationText() {
        baseFunc.waifElementPresented(CONFIRMATION_TEXT);
        return baseFunc.list(CONFIRMATION_TEXT).toString();
    }

}
