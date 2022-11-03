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
    private final String CAR_RENTAL_IN_LATVIA_TEXT = "Car Rental in Latvia";

    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By TOP_LOCATIONS = By.xpath(".//div[@class = 'tl-box']/a");
    private final By CAR_RENTAL_IN_LATVIA = By.xpath(".//h1[@class = 'home-h1 display-small']");
    private WebDriver browser;

//BeforeEach - to chto budet povtorjatsja pered kazhdim testom (open browser->open website->maximize window->accept cookies)
    @BeforeEach
    public void before () {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        browser.findElement(ACCEPT_COOKIES_BTN).click();
    }

    @Test
    public void findLocationLatvia() {
        List<WebElement> locations = browser.findElements(TOP_LOCATIONS);
//ispoljzuju flag, chtobi ponjatj, nashel li on nuzhnuju location (Latvia).false - ne nashel, true- nashel/ BEZ flaga, pishet "Test pased"? no element ne nahodit
        boolean flag = false;
        for (WebElement locationName : locations) {
            if (locationName.getText().equals(LOCATION_TO_OPEN)) {
                flag = true;
                locationName.click();
                break;
            }
        }
 //Assertion - proverka testa. Proverjaem flag (true ili false - esli false, to "location not found")
        Assertions.assertTrue(flag, "location not found");

        browser.findElement(CAR_RENTAL_IN_LATVIA).getText().equals(CAR_RENTAL_IN_LATVIA_TEXT);
        System.out.println(CAR_RENTAL_IN_LATVIA_TEXT);

    }
}
