package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class GooglePage {

    private final SelenideElement GOOGLE_SEARCH_TEXT_BOX = $x("//input[@name='q']");


    public GooglePage(String url) {
        Selenide.open(url);
    }

    public void Search(String searchValue) {
        GOOGLE_SEARCH_TEXT_BOX.setValue(searchValue);
        GOOGLE_SEARCH_TEXT_BOX.sendKeys(Keys.ENTER);
    }

    public void clickResult(String result) {
        $x("//h3[contains(text(), '"+result +"')]").click();


    }
}
