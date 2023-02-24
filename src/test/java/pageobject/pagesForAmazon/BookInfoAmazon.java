package pageobject.pagesForAmazon;

import org.openqa.selenium.By;
import pageobject.BaseFunc;

import java.util.HashMap;
import java.util.Map;

public class BookInfoAmazon {
    private final By TEXT = By.xpath("//div[@class=\"a-expander-content a-expander-partial-collapse-content\"]");

    private BaseFunc baseFunc;
    public BookInfoAmazon(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Map getWordsOfText () {
        String text = baseFunc.getTextOfElement(TEXT).replaceAll("[\\p{Punct}\r\n]", "");
        String[] words = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word,1);
            }
        }return map;
    }
}
