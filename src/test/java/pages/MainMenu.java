package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;


public class MainMenu {

    private SelenideElement AUTO_TESTING_LINK = $x("//*[@id='nav_top']//a[contains(text(),'Автоматизация')]");
    private SelenideElement SERVICES_AND_PRODUCTS = $("li#menu-item-317");

    @Step("Переход на страницу Тестирование сайта")
    public void goToWebsiteTestingPage(){
        Selenide.executeJavaScript("document.querySelector(\"[href='/website-testing']\").click()");
        closePreviousPage();
    }

    @Step("Переход на страницу автоматизированного тестирования")
    public void goToAutoTestingPage(){
        SERVICES_AND_PRODUCTS.hover();
        AUTO_TESTING_LINK.click();
    }

    //Закрытие страницы после перехода
    private void closePreviousPage(){
        switchTo().window(0);
        closeWindow();
        switchTo().window(0);
    }
}
