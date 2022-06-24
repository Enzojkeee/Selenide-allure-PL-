package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class GooglePage {

    private SelenideElement GOOGLE_SEARCH_TEXT_BOX = $x("//input[@name='q']");

    @Step("Переход на страницу Google")
    public void openGoogle(String url) {
        Selenide.open(url);
    }

    @Step("Search on Google")
    public void Search(String searchValue) {
        GOOGLE_SEARCH_TEXT_BOX.setValue(searchValue);
        GOOGLE_SEARCH_TEXT_BOX.sendKeys(Keys.ENTER);
    }

    @Step("Click selected result")
    public void clickResult(String result) {
        $x("//h3[contains(text(), '" + result + "')]").click();


    }
}
