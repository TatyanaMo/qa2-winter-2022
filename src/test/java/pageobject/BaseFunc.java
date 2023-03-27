package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.pages.HomePage;
import pageobject.pagesForTicketsSecondVariant.HomePageSecondVariant;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        browser = new ChromeDriver(options);
        browser.manage().window().maximize();

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    public HomePageSecondVariant openHomePageSecondVariant() {
       openUrl("qaguru.lv:8089/tickets/");
       return new HomePageSecondVariant(this);
    }

    public void openUrl (String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

      browser.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click (WebElement we) {
        wait.until(ExpectedConditions.elementToBeClickable(we)).click();
    }

    public void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }

    public void selectByText (By locator, String text) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByVisibleText(text);
    }

    public void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }

    //etot metod pozvolit int peredelatj v string i zaispoljzovatj osnovnoj metod
    public void type (By locator, int text) {
        type(locator, String.valueOf(text));
    }

    public List<WebElement> list(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return browser.findElements(locator);
    }

    public WebElement findElement (By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getTextOfElement (By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    public void waitForElementsCountToBe(By locator, int count) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
    }

    public void waitForElementsCountAtLeast(By locator, int count) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, count));
    }
    public void waifElementPresented (By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitAllElementPresented (By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
