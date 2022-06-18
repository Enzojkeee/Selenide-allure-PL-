package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;

public class PerfomanceLabPage {

    private final SelenideElement TESTING_SITE_LINK = $x("//a[@href='/website-testing']");
    private final SelenideElement SERVICES_AND_PRODUCTS = $x("//a[contains(text(), 'Услуги и продукты')]");
    private final SelenideElement CLOSE_BUTTON = $x("//button[@data-ats-popup='close']");
    private final SelenideElement GET_PRICES_BUTTON = $x("//h3[@class='LC20lb MBeuO DKV0Md']");
//    public void closePopupWindow(){
//        Alert alert = switchTo().alert();
//        alert.dismiss();
//    }

    public void goToTestingCitePage(){
        SERVICES_AND_PRODUCTS.click();
        SERVICES_AND_PRODUCTS.click();
        TESTING_SITE_LINK.click();
    }

    public void closeFrame() {
        sleep(10000);
        Selenide.switchTo().activeElement();
        CLOSE_BUTTON.click();
    }
}
