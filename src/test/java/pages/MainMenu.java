package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class MainMenu {

    private static final SelenideElement AUTO_TESTING_LINK = $x("//*[@id='nav_top']//a[contains(text(),'Автоматизация')]");
    private static final SelenideElement SERVICES_AND_PRODUCTS = $("li#menu-item-317");

    public static void goToWebsiteTestingPage(){
        Selenide.executeJavaScript("document.querySelector(\"[href='/website-testing']\").click()");
        closePreviousPage();
    }

    public static void goToAutoTestingPage(){
        SERVICES_AND_PRODUCTS.hover();
        AUTO_TESTING_LINK.click();
//        closePreviousPage();
    }

    //Закрытие страницы после перехода
    private static void closePreviousPage(){
        switchTo().window(0);
        closeWindow();
        switchTo().window(0);
    }
}
