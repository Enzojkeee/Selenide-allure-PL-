package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class GooglePage {

    private final SelenideElement GOOGLE_SEARCH_TEXT_BOX = $x("//input[@name='q']");
    private final String PL_TEXT_VALUE = "performance lab";


    public GooglePage(String url) {
        Selenide.open(url);
    }

    public void searchPerfomanceLabPage() {
        GOOGLE_SEARCH_TEXT_BOX.setValue(PL_TEXT_VALUE);
        GOOGLE_SEARCH_TEXT_BOX.sendKeys(Keys.ENTER);
    }


}
