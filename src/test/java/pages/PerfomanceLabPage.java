package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.*;

public class PerfomanceLabPage {

    private final SelenideElement TESTING_SITE_LINK = $x("//a[@href='/website-testing']");
    private final SelenideElement SERVICES_AND_PRODUCTS = $x("//a[contains(text(), 'Услуги и продукты')]");
    private final SelenideElement CLOSE_BUTTON = $x("//button[@data-ats-popup='close']");
    private final SelenideElement GET_PRICES_BUTTON = $x("[contains(text(),'Перфоманс Лаб - Услуги по тестированию']");

    public PerfomanceLabPage() throws AWTException {
        closePopupWindow();
    }


    public void closePopupWindow() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void openPerfomanceLabPage() throws AWTException {
        open("https://www.performance-lab.ru/");
        closePopupWindow();

    }

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
