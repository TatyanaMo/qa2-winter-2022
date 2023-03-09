package pageobject.pagesForAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

public class BooksAmazonPage {

    private final By LIST_OF_BOOKS = By.xpath(".//div[@class = 'a-cardui _cDEzb_grid-cell_1uMOS expandableGrid p13n-grid-content']");
    private final By BOOK_TO_OPEN_COMMENT_LINK = By.xpath(".//div[@class = 'a-icon-row']/a");
    private final By RATING_ONE = By.xpath(".//span[@class = 'a-size-small']");

    private final By BOOK = By.id("3328602925");

    private BaseFunc baseFunc;
    public BooksAmazonPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getBook(int bookNr) {
        baseFunc.waifElementPresented(LIST_OF_BOOKS);
        return baseFunc.list(LIST_OF_BOOKS).get(bookNr);
    }

    public String getBookStars(int bookNr) {
        baseFunc.waifElementPresented(LIST_OF_BOOKS);
        return getBook(bookNr).findElement(BOOK_TO_OPEN_COMMENT_LINK).getAttribute("title").replaceAll(".0","");
    }

    public String getBookRating(int bookNr) {
        return getBook(bookNr).findElement(RATING_ONE).getText();
    }

    public void openBook (int bookNr) {
        getBook(bookNr).findElement(BOOK_TO_OPEN_COMMENT_LINK).click();
    }

    public void openBook1 () {
        baseFunc.findElement(BOOK).click();
    }
}
