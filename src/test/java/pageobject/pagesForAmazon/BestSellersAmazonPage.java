package pageobject.pagesForAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class BestSellersAmazonPage {

    private final By BEST_SELLERS_CATEGORIES = By.xpath(".//div [@class = '_p13n-zg-nav-tree-all_style_zg-" +
            "browse-item__1rdKf _p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL']/a");

    private BaseFunc baseFunc;
    public BestSellersAmazonPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openBestSellersCategory(String bestSellersCategory) {
        for (WebElement category : baseFunc.list(BEST_SELLERS_CATEGORIES)) {
            if (category.getText().equals(bestSellersCategory)) {
                category.click();
                break;
            }
        }
    }

}
