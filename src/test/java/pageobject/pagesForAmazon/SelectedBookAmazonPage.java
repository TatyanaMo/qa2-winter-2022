package pageobject.pagesForAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class SelectedBookAmazonPage {
    private final By STARS = By.xpath(".//span[@class = 'a-size-medium a-color-base']");
    private final By RATING_TWO = By.xpath(".//span[@class = 'a-size-base a-color-secondary']");
    private final By REVIEW_LIST = By.xpath(".//div[@data-hook = 'review']");
    private final By NEXT_PAGE_BTN = By.xpath(".//li[@class = 'a-last']/a");

    private BaseFunc baseFunc;
    public SelectedBookAmazonPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getSecondBookStars () {
        return baseFunc.findElement(STARS).getText();
    }

    public String getSecondBookRating () {
        return baseFunc.findElement(RATING_TWO).getText().replaceAll(" global ratings", "");
    }

    public int getReviews() {
        baseFunc.waitAllElementPresented(REVIEW_LIST);
        Integer review1 = baseFunc.list(REVIEW_LIST).size();
        //baseFunc.list(REVIEW_LIST).get(0).getAttribute("id");
            while (baseFunc.findElement(NEXT_PAGE_BTN).isEnabled()) {
                baseFunc.waitAllElementPresented(REVIEW_LIST);
                Integer reviewNextPage = baseFunc.list(REVIEW_LIST).size();
                baseFunc.findElement(NEXT_PAGE_BTN).click();
                return review1 + reviewNextPage;
            }
        return review1;
    }
}
