package hw3workingwithwebsite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FindLocationTest {
//vinesla testovie dannie (peremennie) na urovenj classa, za ramki testa)
    private final String HOME_PAGE_URL = "http://www.discovercars.com/";
    private final String LOCATION_TO_OPEN = "Latvia";

    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By TOP_LOCATIONS = By.xpath(".//div[@class = 'tl-box']/a");
    private final By CAR_RENTAL_IN_LATVIA = By.xpath(".//h1[@class = 'home-h1 display-small']");
    private WebDriver browser;

//BeforeEach - to chto budet povtorjatsja pered kazhdim testom (open browser->open website->maximize window->accept cookies)

    @BeforeEach
    public void openHomePageCheck () {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        browser.findElement(ACCEPT_COOKIES_BTN).click();
    }

    @Test
    public void findLocation() {
        List<WebElement> locations = browser.findElements(TOP_LOCATIONS);
        for (WebElement locationName : locations) {
            if (locationName.getText().equals(LOCATION_TO_OPEN)) {
                locationName.click();
                break;
            }
        }

        String title = browser.findElement(CAR_RENTAL_IN_LATVIA).getText();
        System.out.println(title);
    }
}
