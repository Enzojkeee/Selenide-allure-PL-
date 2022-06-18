package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleResultPage {

    private final SelenideElement resultTitles = $x("//h3[contains(text(), 'Перфоманс Лаб - Услуги по тестированию')]");

    public GoogleResultPage() {
    }

    public void goToPerfomancePage(){
        resultTitles.click();
    }
}
