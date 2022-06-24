package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WebTestingPage {

    private static final SelenideElement GET_PRICES_BUTTON =  $x("//div[@data-id='6af27c21']//a");

    public static String getPricesButtonColor(){

        return GET_PRICES_BUTTON.getCssValue("background-color");
    }
}
