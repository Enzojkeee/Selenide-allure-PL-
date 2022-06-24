package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.*;

public class PerfomanceLabPage {

    private final SelenideElement TESTING_SITE_LINK = $x("//a[@href='/website-testing']");
    private final SelenideElement SERVICES_AND_PRODUCTS = $x("//a[contains(text(), 'Услуги и продукты')]");
    private final SelenideElement CLOSE_BUTTON = $x("//button[@data-ats-popup='close']");
    private final SelenideElement GET_PRICES_BUTTON = $x("[contains(text(),'Перфоманс Лаб - Услуги по тестированию']");

    public PerfomanceLabPage() {
        closePopupWindow();
    }

    //Закрытие баннера
    public void closePopupWindow() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Step("Open PL page")
    public void openPerfomanceLabPage() {
        open("https://www.performance-lab.ru/");
        closePopupWindow();

    }
}
