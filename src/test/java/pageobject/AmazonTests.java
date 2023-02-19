package pageobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.pagesForAmazon.*;

public class AmazonTests {
    private final String HOME_PAGE_URL = "http://www.amazon.de/";

    private final String navigationShopMenuItem = "Best Sellers";
    private final String bestSellersCategory = "Books";
    private final Integer bookNr = 2;

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void selectionBook() {
        baseFunc.openUrl(HOME_PAGE_URL);

        HomePageAmazon homePageAmazon = new HomePageAmazon(baseFunc);
        homePageAmazon.acceptCookiesAndMessages();
        homePageAmazon.openNavigationShopMenuItem(navigationShopMenuItem);

        BestSellersAmazonPage bestSellersAmazonPage = new BestSellersAmazonPage(baseFunc);
        bestSellersAmazonPage.openBestSellersCategory(bestSellersCategory);

        BooksAmazonPage booksAmazonPage = new BooksAmazonPage(baseFunc);
        String bookStars = booksAmazonPage.getBookStars(bookNr);
        String bookRating = booksAmazonPage.getBookRating(bookNr);
        booksAmazonPage.openBook(bookNr);

        SelectedBookAmazonPage selectedBookAmazonPage = new SelectedBookAmazonPage(baseFunc);
        boolean isBookStarsAreEqual = false;
        if (bookStars.contains(selectedBookAmazonPage.getSecondBookStars())) {
            isBookStarsAreEqual = true;
        }
        Assertions.assertTrue(isBookStarsAreEqual, "Book stars not equal!");

        Assertions.assertEquals(bookRating,selectedBookAmazonPage.getSecondBookRating(),"Book rating not equal!");

        System.out.println(selectedBookAmazonPage.getReviews());

    }

    @Test
    public void countingWordsInText () {
        baseFunc.openUrl(HOME_PAGE_URL);

        HomePageAmazon homePageAmazon = new HomePageAmazon(baseFunc);
        homePageAmazon.acceptCookiesAndMessages();
        homePageAmazon.openNavigationShopMenuItem(navigationShopMenuItem);

        BestSellersAmazonPage bestSellersAmazonPage = new BestSellersAmazonPage(baseFunc);
        bestSellersAmazonPage.openBestSellersCategory(bestSellersCategory);

        BooksAmazonPage booksAmazonPage = new BooksAmazonPage(baseFunc);
        booksAmazonPage.openBook1();

        BookForHashMapAmazon bookForHashMapAmazon = new BookForHashMapAmazon(baseFunc);
        bookForHashMapAmazon.getWordsOfText().size();
        System.out.println(bookForHashMapAmazon.getWordsOfText().size());
    }
}
